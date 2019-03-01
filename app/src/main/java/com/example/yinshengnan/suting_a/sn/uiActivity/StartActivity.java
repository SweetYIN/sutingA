package com.example.yinshengnan.suting_a.sn.uiActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;


import com.example.yinshengnan.suting_a.R;
import com.example.yinshengnan.suting_a.sn.adapter.MyFragmentAdapter;
import com.example.yinshengnan.suting_a.sn.callback.TabBadgeClickCallback;
import com.example.yinshengnan.suting_a.sn.customView.BadgeView;
import com.example.yinshengnan.suting_a.sn.fragment.HouseFragment;
import com.example.yinshengnan.suting_a.sn.fragment.PasswordFragment;

import java.util.ArrayList;
import java.util.List;



public class StartActivity extends AppCompatActivity implements View.OnClickListener,TabBadgeClickCallback {

    private static final String TAG = "StartActivity";
    //fragment 的列表
    private  List<Fragment> fragments = new ArrayList<Fragment>();
    //tabLayout 标题的列表
    private  ArrayList<String>  tabList = new ArrayList<String>();
    //
    private List<Integer> mBadgeCountList = new ArrayList<Integer>();

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyFragmentAdapter myFragmentAdapter;

    private List<BadgeView> mBadgeViews;

    private Button btnAdd,btnPeople;

    private SearchView searchView;

    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initFragment();
        initTabList();
        badgeList();
        initView();
    }
    private void initFragment() {
        HouseFragment houseFragment = new HouseFragment();
        PasswordFragment passwordFragment = new PasswordFragment();
        fragments.add(houseFragment);
        fragments.add(passwordFragment);
    }
    private void initTabList(){
        tabList.add("查房");
        tabList.add("删除密码");
    }
    private void badgeList(){
        mBadgeCountList.add(0);
        mBadgeCountList.add(0);
    }

    private void initView() {
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        btnPeople = (Button) findViewById(R.id.btn_people);
        btnPeople.setOnClickListener(this);
        viewPager = (ViewPager) findViewById(R.id.vp_content);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        searchView = (SearchView) findViewById(R.id.sv_search);
        searchView.setOnQueryTextListener(onQueryTextListener);
        myFragmentAdapter = new MyFragmentAdapter(this,getSupportFragmentManager(),
                fragments,
                tabList);
        myFragmentAdapter.setmBadgeCountList(mBadgeCountList);
        viewPager.setAdapter(myFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

//        initBadgeViews();
        setUpTabBadge();

    }



    private void initBadgeViews() {
        if (mBadgeViews == null) {
            mBadgeViews = new ArrayList<BadgeView>();
            for (int i = 0; i < fragments.size(); i++) {
                BadgeView tmp = new BadgeView(this);
                tmp.setBadgeMargin(0, 6, 10, 0);
                tmp.setTextSize(10);
                mBadgeViews.add(tmp);
            }
        }
    }

    /**
     * 设置Tablayout上的标题的角标
     */
    private void setUpTabBadge() {
        // 1. 最简单
//        for (int i = 0; i < fragments.size(); i++) {
//            mBadgeViews.get(i).setTargetView(((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i));
//            mBadgeViews.get(i).setText(formatBadgeNumber(mBadgeCountList.get(i)));
//        }

        // 2. 最实用
        for (int i = 0; i < fragments.size(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            // 更新Badge前,先remove原来的customView,否则Badge无法更新
            View customView = tab.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(customView);
                }
            }
            // 更新CustomView
            tab.setCustomView(myFragmentAdapter.getTabItemView(i));
        }
        // 需加上以下代码,不然会出现更新Tab角标后,选中的Tab字体颜色不是选中状态的颜色
        tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getCustomView().setSelected(true);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                Intent intent = new Intent(this,HouseResourceActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_people:
                Intent userIntent = new Intent(this,UserActivity.class);
                startActivity(userIntent);
                break;
        }
    }

    private SearchView.OnQueryTextListener onQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            if (TextUtils.isEmpty(query)){
                Toast.makeText(StartActivity.this, "请输入查找内容！", Toast.LENGTH_SHORT).show();
            }else{
                //TODO REQUEST HTTP
                Log.e(TAG,"query ="+query);
                openActivity(query);
            }
            return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };


    private void openActivity( String query){
        Intent intent = new Intent(this,CheckHouseResultActivity.class);
        intent.putExtra("query",query);
        startActivity(intent);
    }

    @Override
    public void onData(int type, int count) {
        Log.e(TAG, "type = " + type + "count = " + count);
        if (count == 0){
            mBadgeCountList.set(type,0);
            setUpTabBadge();
        }else{
            mBadgeCountList.set(type,count);
            setUpTabBadge();
        }

    }

    private void toast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }

}
