package com.zte.topsky.mine.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.zte.topsky.R;

public class SettingFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 加载xml资源文件
        addPreferencesFromResource(R.xml.setting);
    }
}