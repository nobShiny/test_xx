package com.zte.topsky.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.mine.fragment.SettingFragment;

/**
 * Created by NobShiny
 * on 2016/9/23 15:26.
 */

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SettingFragment settingFragment = new SettingFragment();
        getFragmentManager().beginTransaction()
                .add(android.R.id.content,settingFragment)
                .commit();
    }
}
