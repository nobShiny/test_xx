package com.zte.topsky.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;
import com.zte.topsky.common.utils.DividerItemDecoration;
import com.zte.topsky.message.bean.Messages;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nobShiny.
 */
public class MessagesFragment extends BaseFragment {
    private static final String KEY_CONTENT = "MessagesFragment";
    private static Context mContext;

    @BindView(R.id.rl_messages_list)
    RecyclerView rlMessagesList;

    private CommonAdapter<String> mAdapter;
    private List<Messages> mList;

    public static MessagesFragment newInstance(Context context) {
        MessagesFragment fragment = new MessagesFragment();
        mContext = context;
        return fragment;
    }

    private String mContent = "???";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_messages, null);
        ButterKnife.bind(this, layout);
        initView(layout);
        return layout;
    }

    private void initView(View layout) {
        mList = textMesaageData();
        rlMessagesList.setLayoutManager(new LinearLayoutManager(mContext));
        rlMessagesList.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new CommonAdapter(mContext, R.layout.item_messages, mList) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                holder.setText(R.id.tv_message_tltle, mList.get(position).getMessageTitle());
                holder.setText(R.id.tv_message_content, mList.get(position).getMessageContent());
                holder.setVisible(R.id.iv_isRead,true);
            }
        };
        rlMessagesList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

                Toast.makeText(mContext, "第"+position+"条已读", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private List<Messages> textMesaageData() {
        mList = new ArrayList<>();
        Messages m1 = new Messages("充值信息：","您于2016年9月25日充值水费，金额共计400元。",false);
        Messages m2 = new Messages("灌溉提示：","距离您上次灌溉已经34天？",false);
        Messages m3 = new Messages("系统信息：","截止至2016年9月19日，系统没有检测到异常。",false);
        Messages m4 = new Messages("预警信息：","土壤水分过低，请及时浇水！",false);
        Messages m5 = new Messages("天气信息：","明天会有短时间暴雨，请及时防范。",false);
        Messages m6 = new Messages("充值信息：","您于2016年7月25日充值水费，金额共计400元。",false);
        mList.add(m1);
        mList.add(m2);
        mList.add(m3);
        mList.add(m4);
        mList.add(m5);
        mList.add(m6);
        return mList;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
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

    @Override
    public void onPause() {
        super.onPause();
    }
}
