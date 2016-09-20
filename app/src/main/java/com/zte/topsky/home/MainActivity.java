package com.zte.topsky.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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

public class MainActivity extends BaseActivity {


    private Context mContext;
    private AppFragmentAdapter mAdapter;
    private ViewPager mPager;
    private MainBottomTabLayout mTabLayout;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this.getApplicationContext();
        addActivity(this);
        if (savedInstanceState == null) {
            initView();
            initFragment();
        }
    }

    private void initView() {

    }

    private void initFragment() {
        fragmentList.add(HomeFragment.newInstance(mContext));
        fragmentList.add(MessagesFragment.newInstance(mContext));
        fragmentList.add(NewsFragment.newInstance(mContext));
        fragmentList.add(MineFragment.newInstance(mContext));
        mAdapter = new AppFragmentAdapter(mContext,getSupportFragmentManager(),fragmentList);
        mPager = (ViewPager) findViewById(R.id.tab_pager);
        mPager.setAdapter(mAdapter);
        mTabLayout = (MainBottomTabLayout) findViewById(R.id.main_bottom_tablayout);
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

}