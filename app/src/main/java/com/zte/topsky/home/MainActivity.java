package com.zte.topsky.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.home.adapter.AppFragmentAdapter;
import com.zte.topsky.home.customui.bottomLayout.MainBottomTabLayout;
import com.zte.topsky.home.fragment.HomeFragment;
import com.zte.topsky.home.fragment.MessagesFragment;
import com.zte.topsky.home.fragment.MineFragment;
import com.zte.topsky.home.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity /*implements NewsFragment.DataListener*/ {

    private Context mContext;
    private long mPressedTime = 0;
    private AppFragmentAdapter mAdapter;

    private List<Fragment> fragmentList = new ArrayList<>();

    @BindView(R.id.main_bottom_tablayout)
    MainBottomTabLayout mTabLayout;
    @BindView(R.id.tab_pager)
    ViewPager mPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
        setSupportActionBar(toolbar);
        mContext = this.getApplicationContext();
        addActivity(this);
        if (savedInstanceState == null) {
            initView();
            initFragment();
        }
    }

    private void initView() {
        toolbar.setTitle("asdasd");
    }

    private void initFragment() {
        fragmentList.add(HomeFragment.newInstance(mContext));
        fragmentList.add(MessagesFragment.newInstance(mContext));
        fragmentList.add(NewsFragment.newInstance(mContext));
        fragmentList.add(MineFragment.newInstance(mContext));
        mAdapter = new AppFragmentAdapter(mContext, getSupportFragmentManager(), fragmentList);
        mPager.setAdapter(mAdapter);
//        mTabLayout = (MainBottomTabLayout) findViewById(R.id.main_bottom_tablayout);
        mTabLayout.setViewPager(mPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            AppExit(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();//获取第一次按键时间
        if ((mNowTime - mPressedTime) > 2000) {//比较两次按键时间差
            Toast.makeText(this, "再次点击退出程序", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        } else {//退出程序
            this.finish();
            System.exit(0);
        }
    }
}