package com.zte.topsky.home.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by NobShiny
 * on 2016/9/19 11:16.
 */
public class AppFragmentAdapter extends FragmentPagerAdapter {

    protected static final String[] CONTENT = new String[]{"This", "Is", "A", "Test"};
//    private int mCount = ONTENT.length;
    private Context mContext;
    private List<Fragment> mList;

    public AppFragmentAdapter(Context context, FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return AppFragmentAdapter.CONTENT[position % CONTENT.length];
    }

//    public void setCount(int count) {
//        if (count > 0 && count <= 10) {
//            mCount = count;
//            notifyDataSetChanged();
//        }
//    }
}
