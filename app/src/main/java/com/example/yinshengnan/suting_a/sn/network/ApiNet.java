package com.example.yinshengnan.suting_a.sn.network;


import android.util.Log;

import com.example.yinshengnan.suting_a.sn.bean.Request.LockFormRequest;
import com.example.yinshengnan.suting_a.sn.bean.Responds.BindRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.ChangeStateResetResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.CheckRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.DelectPsRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.LoginResponsesBean;
import com.example.yinshengnan.suting_a.sn.bean.Responds.UserInfoResponses;
import com.ttlock.bl.sdk.entity.LockData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by jl on 2019/1/10.
 */

public class ApiNet extends BaseNet{
    private String TAG = "ApiNet";
    private NetInterface mNetInterface;
    public ApiNet() {
        mNetInterface = BaseRetrofit.getInstance().create(NetInterface.class);
    }


    /**登录**/
    public Observable<LoginResponsesBean> ApiLogin(String Authorization,
                                                   String name, String pas){
        return observe(mNetInterface.Login(HttpUrlConfig.Login,
                Authorization,
                 name,pas,"password","all"))
                .map(new Function<LoginResponsesBean, LoginResponsesBean>() {
                    @Override
                    public LoginResponsesBean apply(LoginResponsesBean loginResponsesBean) throws Exception {
                        return loginResponsesBean;
                    }
                });
    }

    /**未绑定房间列表**/
    public Observable<List<BindRoomSearchListResponses>> ApiRoomSearch(){
        return observe(mNetInterface.RoomSearch())
                .map(new Function<List<BindRoomSearchListResponses>, List<BindRoomSearchListResponses>>() {
                    @Override
                    public List<BindRoomSearchListResponses> apply(List<BindRoomSearchListResponses> roomSearchResponses) throws Exception {
                        return roomSearchResponses;
                    }
                });

    }

    /**绑定锁**/
    public Observable<ChangeStateResetResponses> ApiBindForApp(int id, LockFormRequest data){
        return observe(mNetInterface.BindForApp(HttpUrlConfig.Room+id+HttpUrlConfig.BindForApp,data))
                .map(new Function<ChangeStateResetResponses, ChangeStateResetResponses>() {
                    @Override
                    public ChangeStateResetResponses apply(ChangeStateResetResponses changeStateResetResponses) throws Exception {
                        return changeStateResetResponses;
                    }
                });
    }

    /**查房房间列表**/
    public Observable<List<CheckRoomSearchListResponses>> ApiCheckRoomSearch(){
        return observe(mNetInterface.CheckRoomSearch())
                .map(new Function<List<CheckRoomSearchListResponses>, List<CheckRoomSearchListResponses>>() {
                    @Override
                    public List<CheckRoomSearchListResponses> apply(List<CheckRoomSearchListResponses> checkRoomSearchListResponses) throws Exception {
                        return checkRoomSearchListResponses;
                    }
                });

    }



    /**查房**/
    public Observable<ChangeStateResetResponses> ApiChangeStateCheck(int roomId){
        return observe(mNetInterface.CheckRoom(HttpUrlConfig.Room+roomId+ HttpUrlConfig.ChangeStateCheck))
                .map(new Function<ChangeStateResetResponses, ChangeStateResetResponses>() {
                    @Override
                    public ChangeStateResetResponses apply(ChangeStateResetResponses changeStateResetResponses) throws Exception {
                        return changeStateResetResponses;
                    }
                });
    }

    /**删除密码房间列表**/
    public Observable<List<DelectPsRoomSearchListResponses>> ApiDeletePasswordRoomSearch(){
        return observe(mNetInterface.DeletePasswordRoomSearch())
                .map(new Function<List<DelectPsRoomSearchListResponses>, List<DelectPsRoomSearchListResponses>>() {
                    @Override
                    public List<DelectPsRoomSearchListResponses> apply(List<DelectPsRoomSearchListResponses> roomSearchResponses) throws Exception {
                        return roomSearchResponses;
                    }
                });

    }

    /**删除密码**/
    public Observable<ChangeStateResetResponses> ApiDeletePs(int roomId,int keyboardPwdId,
                                                             int electricQuantity,
                                                             Long timeStamp){
        return observe(mNetInterface.DeletePassword(HttpUrlConfig.DeletePassword+roomId,keyboardPwdId,electricQuantity,timeStamp))
                .map(new Function<ChangeStateResetResponses, ChangeStateResetResponses>() {
                    @Override
                    public ChangeStateResetResponses apply(ChangeStateResetResponses changeStateResetResponses) throws Exception {
                        return changeStateResetResponses;
                    }
                });
    }

    /**改变房间状态**/
    public Observable<ChangeStateResetResponses> ApiChangeRoomState(int roomId){
        return observe(mNetInterface.ChangeRoomState(HttpUrlConfig.Room+roomId+HttpUrlConfig.CheckRoomState)
                .map(new Function<ChangeStateResetResponses, ChangeStateResetResponses>() {
                    @Override
                    public ChangeStateResetResponses apply(ChangeStateResetResponses changeStateResetResponses) throws Exception {
                        return changeStateResetResponses;
                    }
                }));

    }


    /**用户信息**/
    public Observable<UserInfoResponses> ApiUserInfo(){
        return observe(mNetInterface.UserInfo()
                .map(new Function<UserInfoResponses, UserInfoResponses>() {
                    @Override
                    public UserInfoResponses apply(UserInfoResponses userInfoResponses) throws Exception {
                        return userInfoResponses;
                    }
                }));
    }

    /**修改用户密码**/
    public Observable<String> ApiModifyPassword(String account,String password){
        return observe(mNetInterface.ModifyPassword(HttpUrlConfig.modifyPassword,account,password))
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s;
                    }
                });
    }
    /**用户信息**/
    public Observable<ChangeStateResetResponses> ApiBackLogin(){
        return observe(mNetInterface.BackLogin()
                .map(new Function<ChangeStateResetResponses, ChangeStateResetResponses>() {
                    @Override
                    public ChangeStateResetResponses apply(ChangeStateResetResponses ChangeStateResetResponses) throws Exception {
                        return ChangeStateResetResponses;
                    }
                }));
    }

}
