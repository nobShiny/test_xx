package com.zte.topsky.pay.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zte.topsky.R;

import butterknife.ButterKnife;

/**
 * Created by NobShiny
 * on 2016/9/28 15:34.
 */

public class PayRecordFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.pay_record_page_fragment, null);
        ButterKnife.bind(this,layout);
        return layout;
    }
}
