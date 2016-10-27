package com.zte.topsky.pay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;
import com.zte.topsky.common.utils.DividerItemDecoration;
import com.zte.topsky.pay.bean.PayRecord;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/9/28 15:34.
 */

public class PayRecordFragment extends BaseFragment {

    @BindView(R.id.rl_pay_record)
    RecyclerView rlPayRecord;
    @BindView(R.id.iv_back)
    ImageView ivBack;

    private CommonAdapter<String> mAdapter;
    private List<PayRecord> mList;

    private static Context mContext;

    public static PayRecordFragment newInstance(Context context) {
        PayRecordFragment fragment = new PayRecordFragment();
        mContext = context;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.pay_record_page_fragment, null);

        ButterKnife.bind(this, layout);
        mList = getTestData();
        mAdapter = new CommonAdapter(mContext, R.layout.item_pay_record, mList) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                holder.setText(R.id.tv_pay_record_date, mList.get(position).getDate());
                holder.setText(R.id.tv_pay_record_amount, mList.get(position).getAmount());
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }
        };
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        rlPayRecord.setLayoutManager(new LinearLayoutManager(mContext));
        rlPayRecord.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        rlPayRecord.setAdapter(mAdapter);


        return layout;
    }

    @Override
    protected int getlayoutId() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void lazyLoadData() {

    }


    public List getTestData() {
        mList = new ArrayList<>();
        PayRecord bean1 = new PayRecord();
        bean1.setDate("2016.1.10");
        bean1.setAmount("180元");
        PayRecord bean2 = new PayRecord();
        bean2.setDate("2016.3.10");
        bean2.setAmount("120元");
        PayRecord bean3 = new PayRecord();
        bean3.setDate("2016.5.10");
        bean3.setAmount("180元");
        PayRecord bean4 = new PayRecord();
        bean4.setDate("2016.8.10");
        bean4.setAmount("80元");
        PayRecord bean5 = new PayRecord();
        bean5.setDate("2016.9.10");
        bean5.setAmount("100元");

        mList.add(bean2);
        mList.add(bean1);
        mList.add(bean3);
        mList.add(bean4);
        mList.add(bean5);
        return mList;
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        getFragmentManager().popBackStack();
    }
}
