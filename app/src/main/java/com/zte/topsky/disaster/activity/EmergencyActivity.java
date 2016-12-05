package com.zte.topsky.disaster.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.disaster.bean.ContractList;
import com.zte.topsky.disaster.util.CallUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/12/2 16:08.
 */
public class EmergencyActivity extends BaseActivity {


    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    @BindView(R.id.rl_contract_list)
    RecyclerView rlContractList;

    private List<ContractList> mList;
    private CommonAdapter<String> mAdapter;
    private String mNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_disaster_emergency);
        addActivity(this);
        tvTitleText.setText("紧急联系");
        initView();
    }

    private void initView() {
        mList = textMesaageData();
        rlContractList.setLayoutManager(new LinearLayoutManager(this));
//        rlContractList.addItemDecoration(null);
        mAdapter = new CommonAdapter(this, R.layout.item_emergency_contract, mList) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                if (position%2==0) {
                    holder.setBackgroundColor(R.id.ll_item,EmergencyActivity.this.getResources().
                            getColor(R.color.emergency_item_background_light_color));
                }else{
                    holder.setBackgroundColor(R.id.ll_item,EmergencyActivity.this.getResources().
                            getColor(R.color.emergency_item_background_dark_color));
                }
                holder.setText(R.id.tv_emergency_name, mList.get(position).getName());
                holder.setText(R.id.tv_emergency_duties, mList.get(position).getDuties());
                holder.setText(R.id.tv_emergency_number, mList.get(position).getPhoneNumber());
            }
        };
        rlContractList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                //TODO 加入打电话的弹窗
                mNumber = mList.get(position).getPhoneNumber();
                if (ContextCompat.checkSelfPermission(EmergencyActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(EmergencyActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);
                } else {
                    CallUtil.callTo(EmergencyActivity.this, mNumber);
                }

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

    }

    private List<ContractList> textMesaageData() {
        mList = new ArrayList<>();
        ContractList con1 = new ContractList("曹会", "13913665800", "防汛总指挥");
        ContractList con2 = new ContractList("蔡润新", "15810130622", "防汛总指挥");
        ContractList con3 = new ContractList("吕继峰", "13583241560", "应急指挥");
        ContractList con4 = new ContractList("田刚", "13666581736", "XX水库负责人");
        ContractList con5 = new ContractList("王玮", "15377125356", "XX水文站负责人");
        ContractList con6 = new ContractList("沈建宏", "15951934710", "XX监测点负责人");
        ContractList con7 = new ContractList("张拥军", "13705812889", "XX监测点负责人");
        mList.add(con1);
        mList.add(con2);
        mList.add(con3);
        mList.add(con4);
        mList.add(con5);
        mList.add(con6);
        mList.add(con7);

        return mList;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallUtil.callTo(this, mNumber);
            } else {
                Toast.makeText(EmergencyActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
