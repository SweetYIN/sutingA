package com.example.yinshengnan.suting_a.sn.uiActivity;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.yinshengnan.suting_a.R;
import com.example.yinshengnan.suting_a.sn.adapter.MyDeviceRecyclerViewAdapter;
import com.example.yinshengnan.suting_a.sn.bean.Request.LockFormRequest;
import com.example.yinshengnan.suting_a.sn.bean.Responds.ChangeStateResetResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.DelectPsRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.callback.ClickCallback;
import com.example.yinshengnan.suting_a.sn.network.ApiNet;
import com.example.yinshengnan.suting_a.sn.network.ResponseService;
import com.example.yinshengnan.suting_a.sn.sharePreference.MyPreference;
import com.ttlock.bl.sdk.api.TTLockAPI;
import com.ttlock.bl.sdk.callback.TTLockCallback;
import com.ttlock.bl.sdk.entity.DeviceInfo;
import com.ttlock.bl.sdk.entity.Error;
import com.ttlock.bl.sdk.entity.LockData;
import com.ttlock.bl.sdk.scanner.ExtendedBluetoothDevice;
import com.ttlock.bl.sdk.util.LogUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class ConnectDeviceActivity extends BaseActivity implements View.OnClickListener {

    private String TAG = "ConnectDeviceActivity";


    private ImageButton scanIB;
    private RecyclerView recyclerView;
    private List<ExtendedBluetoothDevice> devices = new ArrayList<>();
    private MyDeviceRecyclerViewAdapter myDeviceRecyclerViewAdapter;
    private TTLockAPI ttLockAPI;

    private DelectPsRoomSearchListResponses.LockViewListBean.LockBeanX.DataBean lockData;
    private int uid;



    /**
     * 1 代表绑定锁，2代表重置密码
     */
    private String Type ;

    private int bindid;
    private DelectPsRoomSearchListResponses roomSearchResponses;


    private String lockName;
    private String password;
    private  int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_device);
        Type = getIntent().getStringExtra("type");
        if ("1".equals(Type)){

        bindid = getIntent().getIntExtra("ID",0);
        }else if ("2".equals(Type)){
            roomSearchResponses = (DelectPsRoomSearchListResponses)getIntent().getSerializableExtra("roomSearchResponses");

        }
        Log.e(TAG,"Type ="+Type);
        initView();
        initAdapter();
        initToken();
        initBle();
        uid = MyPreference.getOpenid(this, MyPreference.OPEN_ID);

    }



    private void initToken() {
        if ("access_token".equals(MyPreference.ACCESS_TOKEN)){
            requestToken();
//            syncData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttLockAPI.stopBTDeviceScan();
        ttLockAPI.disconnect();
    }

    private void initAdapter() {
        //设置布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myDeviceRecyclerViewAdapter = new MyDeviceRecyclerViewAdapter(this,Type,devices);
        myDeviceRecyclerViewAdapter.setClickCallback(itemClickCallback);
        recyclerView.setAdapter(myDeviceRecyclerViewAdapter);

    }

    private void initView() {
        scanIB = (ImageButton) findViewById(R.id.ib_scanDevice);
        scanIB.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.device_rl);

    }

    private void initEnableBle(){
        ttLockAPI.requestBleEnable(this);
        ttLockAPI.startBleService(this);

    }

    private void initBle() {
        ttLockAPI = new TTLockAPI(this,ttLockCallback);
        initEnableBle();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ib_scanDevice:
                scanBle();
                break;
        }

    }

    private void scanBle() {

        if(requestPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {

            ttLockAPI.startBTDeviceScan();
        }else{
            toast("权限没有打开");
        }
    }

    private void ConnectBle(int position,String name) {
        lockName = name;
        showProgressDialog();
        ttLockAPI.connect(devices.get(position));
    }
    /**
     * update scan device
     * @param extendedBluetoothDevice
     */

    public void updateDevice(ExtendedBluetoothDevice extendedBluetoothDevice) {
        for(int i = 0; i < devices.size() ;i++) {
            if(devices.contains(extendedBluetoothDevice)) {

                return;
            }
        }
        if ("2".equals(Type)){
                if (extendedBluetoothDevice.getAddress().equals(roomSearchResponses.getLockViewList().get(i).getLock().getData().getLockMac())){
                    Log.e(TAG,"\ni ="+extendedBluetoothDevice.getAddress());
                    devices.add(extendedBluetoothDevice);
                    if (i < roomSearchResponses.getLockViewList().size()){
                        i++;
                    }
                    if (i == roomSearchResponses.getLockViewList().size()){
                    }

                }


        }else{
            if (extendedBluetoothDevice.isSettingMode()){
                devices.add(extendedBluetoothDevice);
            }

        }


        showBle();

    }

    private void showBle(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//
                myDeviceRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

    private int positionId;
    private int electricQuantity;
    private Long timeStamp;
    private ClickCallback itemClickCallback = new ClickCallback() {
        @Override
        public void ItemOnClick(View v, int position) {

        }

        @Override
        public void OnItemClick(View view, int position) {
            ttLockAPI.stopBTDeviceScan();
            Log.e(TAG,"position = "+position);

//            ttLockAPI.resetLock();
            if ("1".equals(Type)){
            startAlertDialog("请输入锁的别名","取消","确定",position);
//            ttLockAPI.connect(devices.get(position));
            }else if("2".equals(Type)){
                showProgressDialog();
                positionId = position;
                password = roomSearchResponses.getLockViewList().get(position).getKeyboardPwd();
                lockData = roomSearchResponses.getLockViewList().get(position).getLock().getData();
                Log.e(TAG,"position = "+roomSearchResponses.getLockViewList().get(position).getLock().getData().getLockMac());
                ttLockAPI.connect(roomSearchResponses.getLockViewList().get(position).getLock().getData().getLockMac());
            }
        }

        @Override
        public void OnItemLongClick(View view, int position) {

        }
    };



    private TTLockCallback ttLockCallback = new TTLockCallback() {
       @Override
       public void onFoundDevice(ExtendedBluetoothDevice extendedBluetoothDevice) {

//           Log.e(TAG,"onFoundDevice = "+extendedBluetoothDevice.getAddress());
           updateDevice(extendedBluetoothDevice);

       }

       @Override
       public void onDeviceConnected(ExtendedBluetoothDevice extendedBluetoothDevice) {
           cancelProgressDialog();
           Log.e(TAG,"onDeviceConnected = "+extendedBluetoothDevice.toString());
            if ("1".equals(Type)){
                ttLockAPI.lockInitialize(extendedBluetoothDevice);
            }else if("2".equals(Type)){
                //TODO 删除密码
//                Key curKey = keys.get(0);

//                ttLockAPI.resetKeyboardPassword(null, uid, lockResponsesBean.getData().getLockVersion(), lockResponsesBean.getData().getAdminPwd(), lockResponsesBean.getData().getLockKey(), lockResponsesBean.getData().getLockFlagPos(), lockResponsesBean.getData().getAesKeyStr());
                Log.e(TAG,"deleteOneKeyboardPassword = " +"\nuid = "+uid+" \n lockData.getData().getLockVersion() ="+lockData.getLockVersion()
                    +"\nlockData.getData().getAdminPwd() = "+lockData.getAdminPwd()+"\n lockData.getData().getLockKey()="+lockData.getLockKey()
                +"\nlockData.getData().getLockFlagPos() = "+lockData.getLockFlagPos()+"\npassword ="+password
                +"\nlockData.getData().getAesKeyStr() ="+lockData.getAesKeyStr());


                ttLockAPI.deleteOneKeyboardPassword(extendedBluetoothDevice,uid,lockData.getLockVersion(),
                        lockData.getAdminPwd(),lockData.getLockKey(),
                        lockData.getLockFlagPos(),3,password,lockData.getAesKeyStr());

               // 测试
//               ttLockAPI.getLockTime(extendedBluetoothDevice, lockData.getLockVersion(),lockData.getAesKeyStr(), lockData.getTimezoneRawOffset());

            }



       }

       @Override
       public void onDeviceDisconnected(ExtendedBluetoothDevice extendedBluetoothDevice) {

       }

       @Override
       public void onGetLockVersion(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, int i2, int i3, int i4, Error error) {

       }

       @Override
       public void onLockInitialize(ExtendedBluetoothDevice extendedBluetoothDevice, final LockData lockData, Error error) {

           Log.e(TAG,"onLockInitialize"+extendedBluetoothDevice.getAddress()+"\n = error"+error);


           if(error == Error.SUCCESS) {
               Log.e(TAG,"lockData ="+lockData);

               final String lockDataJson = lockData.toJson();
               LockFormRequest lockFormRequest = new LockFormRequest();
               lockFormRequest.setData(lockData);
               lockFormRequest.setName(lockName);
               Log.e(TAG,"lockDataJson ="+lockDataJson);
               bindLock(bindid, lockFormRequest);

           } else {
               //失败
               cancelProgressDialog();
               toast(error.getErrorMsg());
           }



       }

       @Override
       public void onResetEKey(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onSetLockName(ExtendedBluetoothDevice extendedBluetoothDevice, String s, Error error) {

       }

       @Override
       public void onSetAdminKeyboardPassword(ExtendedBluetoothDevice extendedBluetoothDevice, String s, Error error) {

       }

       @Override
       public void onSetDeletePassword(ExtendedBluetoothDevice extendedBluetoothDevice, String s, Error error) {

       }

       @Override
       public void onUnlock(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, long l, Error error) {

       }

       @Override
       public void onSetLockTime(ExtendedBluetoothDevice extendedBluetoothDevice, Error error) {
           Log.e(TAG,"onSetLockTime = "+error);
           if (error == Error.SUCCESS){
               Log.e(TAG,"onSetLockTime");
               ttLockAPI.getLockTime(extendedBluetoothDevice, lockData.getLockVersion(),lockData.getAesKeyStr(), lockData.getTimezoneRawOffset());
//               toast("时间校准成功");
           }else{
               toast("时间校准失败" +error.getErrorMsg());
           }

       }

       @Override
       public void onGetLockTime(ExtendedBluetoothDevice extendedBluetoothDevice, long l, Error error) {
           Log.e(TAG,"onSetLockTime = "+error);
           if (error == Error.SUCCESS){
               timeStamp = l;
               Log.e(TAG,"timeStamp = "+timeStamp);
               ttLockAPI.getElectricQuantity(extendedBluetoothDevice, lockData.getLockVersion(),lockData.getAesKeyStr());
//               toast("获取当前时间成功");
           }else{
               toast("获取锁时间失败" +error.getErrorMsg()) ;
           }

       }

       @Override
       public void onResetKeyboardPassword(ExtendedBluetoothDevice extendedBluetoothDevice, String s, long l, Error error) {

       }

       @Override
       public void onSetMaxNumberOfKeyboardPassword(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onResetKeyboardPasswordProgress(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onResetLock(ExtendedBluetoothDevice extendedBluetoothDevice, Error error) {

       }

       @Override
       public void onAddKeyboardPassword(ExtendedBluetoothDevice extendedBluetoothDevice, int i, String s, long l, long l1, Error error) {

       }

       @Override
       public void onModifyKeyboardPassword(ExtendedBluetoothDevice extendedBluetoothDevice, int i, String s, String s1, Error error) {

       }

       @Override
       public void onDeleteOneKeyboardPassword(ExtendedBluetoothDevice extendedBluetoothDevice, int i, String s, Error error) {
           Log.e(TAG,"onDeleteOneKeyboardPassword"+error+"\ns");
           if (error == Error.SUCCESS){
//               //TODO 向后台传传重置密码和时间
               Log.e(TAG,"devices"+extendedBluetoothDevice.getAddress());
               ttLockAPI.setLockTime(extendedBluetoothDevice, uid, lockData.getLockVersion(), lockData.getLockKey(), System.currentTimeMillis(), lockData.getLockFlagPos(),
                       lockData.getAesKeyStr(), lockData.getTimezoneRawOffset());
//

//
           }else{
               toast("删除设备密码失败" +error.getErrorMsg());
           }
       }

       @Override
       public void onDeleteAllKeyboardPassword(ExtendedBluetoothDevice extendedBluetoothDevice, Error error) {

       }

       @Override
       public void onGetOperateLog(ExtendedBluetoothDevice extendedBluetoothDevice, String s, Error error) {

       }

       @Override
       public void onSearchDeviceFeature(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, Error error) {

       }

       @Override
       public void onAddICCard(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, long l, Error error) {

       }

       @Override
       public void onModifyICCardPeriod(ExtendedBluetoothDevice extendedBluetoothDevice, int i, long l, long l1, long l2, Error error) {

       }

       @Override
       public void onDeleteICCard(ExtendedBluetoothDevice extendedBluetoothDevice, int i, long l, Error error) {

       }

       @Override
       public void onClearICCard(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onSetWristbandKeyToLock(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onSetWristbandKeyToDev(Error error) {

       }

       @Override
       public void onSetWristbandKeyRssi(Error error) {

       }

       @Override
       public void onAddFingerPrint(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, long l, Error error) {

       }

       @Override
       public void onAddFingerPrint(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, long l, int i2, Error error) {

       }

       @Override
       public void onFingerPrintCollection(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onFingerPrintCollection(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, int i2, Error error) {

       }

       @Override
       public void onModifyFingerPrintPeriod(ExtendedBluetoothDevice extendedBluetoothDevice, int i, long l, long l1, long l2, Error error) {

       }

       @Override
       public void onDeleteFingerPrint(ExtendedBluetoothDevice extendedBluetoothDevice, int i, long l, Error error) {

       }

       @Override
       public void onClearFingerPrint(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onSearchAutoLockTime(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, int i2, int i3, Error error) {

       }

       @Override
       public void onModifyAutoLockTime(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, Error error) {

       }

       @Override
       public void onReadDeviceInfo(ExtendedBluetoothDevice extendedBluetoothDevice, DeviceInfo deviceInfo, Error error) {

       }

       @Override
       public void onEnterDFUMode(ExtendedBluetoothDevice extendedBluetoothDevice, Error error) {

       }

       @Override
       public void onGetLockSwitchState(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, Error error) {

       }

       @Override
       public void onLock(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, int i2, long l, Error error) {

       }

       @Override
       public void onScreenPasscodeOperate(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, Error error) {

       }

       @Override
       public void onRecoveryData(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onSearchICCard(ExtendedBluetoothDevice extendedBluetoothDevice, int i, String s, Error error) {

       }

       @Override
       public void onSearchFingerPrint(ExtendedBluetoothDevice extendedBluetoothDevice, int i, String s, Error error) {

       }

       @Override
       public void onSearchPasscode(ExtendedBluetoothDevice extendedBluetoothDevice, String s, Error error) {

       }

       @Override
       public void onSearchPasscodeParam(ExtendedBluetoothDevice extendedBluetoothDevice, int i, String s, long l, Error error) {

       }

       @Override
       public void onOperateRemoteUnlockSwitch(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, int i2, int i3, Error error) {

       }

       @Override
       public void onGetElectricQuantity(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {
           Log.e(TAG,"onSetLockTime = "+error);
           if (error == Error.SUCCESS){

               electricQuantity = i;
               Log.e(TAG,"electricQuantity = "+electricQuantity);
               //TODO 获取电量
               DeletePassword();


           }else{
               toast("获取电量失败" + error.getErrorMsg());
           }

       }

       @Override
       public void onOperateAudioSwitch(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, int i2, Error error) {

       }

       @Override
       public void onOperateRemoteControl(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, int i2, Error error) {

       }

       @Override
       public void onOperateDoorSensorLocking(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, int i2, Error error) {

       }

       @Override
       public void onGetDoorSensorState(ExtendedBluetoothDevice extendedBluetoothDevice, int i, int i1, Error error) {

       }

       @Override
       public void onSetNBServer(ExtendedBluetoothDevice extendedBluetoothDevice, int i, Error error) {

       }

       @Override
       public void onGetAdminKeyboardPassword(ExtendedBluetoothDevice extendedBluetoothDevice, int i, String s, Error error) {

       }
   };




    private void requestToken(){
        if("access_token".equals(MyPreference.ACCESS_TOKEN)){
            new AsyncTask<Void, Integer, String>() {

                @Override
                protected String doInBackground(Void... params) {
                    return ResponseService.auth("rubik_user ", "123456");
                }

                @Override
                protected void onPostExecute(String json) {
                    String msg = "授权成功";
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        if(jsonObject.has("errcode")) {
                            msg = jsonObject.getString("description");
                        } else {
                            String access_token = jsonObject.getString("access_token");
                            String openid = jsonObject.getString("openid");
                            LogUtil.e("access_token = "+access_token);
                            MyPreference.putStr(ConnectDeviceActivity.this, MyPreference.ACCESS_TOKEN, access_token);
                            MyPreference.putStr(ConnectDeviceActivity.this, MyPreference.OPEN_ID, openid);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    toast(msg);
                }
            }.execute();
        }

    }


    /**
     * 绑定锁
     */

    private void bindLock(final int id, LockFormRequest lockData) {

        ApiNet apiNet = new ApiNet();
        apiNet.ApiBindForApp(id,lockData)
                .subscribe(new Observer<ChangeStateResetResponses>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChangeStateResetResponses value) {
                        cancelProgressDialog();
                        if (value.getCode() == 200){

                            toast("绑定锁成功");
                            finish();
                        }else{
                            cancelProgressDialog();
                            toast("绑定锁失败 \n"+value.toString());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        cancelProgressDialog();
                        toast("绑定锁异常 = "+e.getMessage());
                        finish();

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    /**
     * 上传修改密码
     * @param
     */

    private void DeletePassword(){

        ApiNet apiNet = new ApiNet();
        apiNet.ApiDeletePs(roomSearchResponses.getRoomView().getId(),
                roomSearchResponses.getLockViewList().get(positionId).getKeyboardPwdId(),
                electricQuantity,timeStamp)
                .subscribe(new Observer<ChangeStateResetResponses>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChangeStateResetResponses value) {
                        cancelProgressDialog();
                        Log.e(TAG,"value= " +value.getCode());
                        if ( value.getCode() == 200){
                            devices.remove(positionId);
                            roomSearchResponses.getLockViewList().remove(positionId);
                            ttLockAPI.disconnect();
                            toast("删除密码成功");
                            Log.e(TAG,"devices.size() = " +devices.size());
                            if (devices.size() == 0){
                                showBle();
                                ChangeRoomState();
                            }
                            else{
                                showBle();
                            }
                        }else{
                            ttLockAPI.disconnect();
                            toast("删除密码失败 "+value.getCode());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        cancelProgressDialog();
                        ttLockAPI.disconnect();
                        toast("删除密码异常 "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    private void ChangeRoomState(){
        ApiNet apiNet = new ApiNet();
        apiNet.ApiChangeRoomState(roomSearchResponses.getRoomView().getId())
                .subscribe(new Observer<ChangeStateResetResponses>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChangeStateResetResponses value) {
                        if (value.getCode() == 200){
                                finish();
                            toast("状态改变成功");
                        }else{
                            ttLockAPI.disconnect();
                            toast("状态改变失败 "+value.getCode());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        toast("状态改变异常 "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private  void startAlertDialog(String title, String negative, String positive, final int position){

        final EditText inputServer = new EditText(this);
        AlertDialog.Builder  builder  = new AlertDialog.Builder(this);
        builder.setTitle(title).setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                .setNegativeButton(negative, null);
        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                    inputServer.getText().toString();
                    ConnectBle(position,inputServer.getText().toString());


            }


        });
        builder.show();
    }


}
