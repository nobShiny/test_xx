package com.zte.topsky.disaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.disaster.adapter.DisasterControlGirdViewAdapter;
import com.zte.topsky.home.bean.GridCutItem;
import com.zte.topsky.home.customui.homeScrollView.ControlScrollView;
import com.zte.topsky.home.customui.homeScrollView.DragGridView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/11/30 10:44.
 */

public class DisasterMessageMainActivity extends BaseActivity {

    @BindView(R.id.grid_view)
    DragGridView gridView;
    @BindView(R.id.scroller_view)
    ControlScrollView scroller;
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;

    private ArrayList<GridCutItem> mDatas = new ArrayList<>();
    private DisasterControlGirdViewAdapter mAdapter;

    private String[][] gridDatas = {{"汛情摘要", ""},
            {"实时雨情", ""},
            {"卫星云图", ""},
            {"江河水情", ""},
            {"水库水情", ""},
            {"紧急联系", ""},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_disaster_message);
        addActivity(this);
        tvTitleText.setText("防汛信息");
        scroller.smoothScrollTo(0, 0);
        mDatas.clear();
        for (int i = 0; i < gridDatas.length; i++) {
            GridCutItem gridCutItem = new GridCutItem(gridDatas[i][0], gridDatas[i][1]);
            mDatas.add(gridCutItem);
        }
        initFunctionArea();
    }

    private void initFunctionArea() {
        mAdapter = new DisasterControlGirdViewAdapter(this, mDatas, gridView);
        gridView.setAdapter(mAdapter);
        scroller.setScrollState(new ControlScrollView.ScrollState() {
            @Override
            public void stopTouch() {
                gridView.stopDrag();
            }

            @Override
            public void isCanDrag(boolean isCanDrag) {
                gridView.setCanDrag(isCanDrag);
            }
        });

        gridView.setOnDragStartListener(new DragGridView.OnDragStartListener() {
            @Override
            public void onDragStart() {
                scroller.requestDisallowInterceptTouchEvent(true);
                scroller.setInControl(false);
            }
        });
        gridView.setOnDragEndListener(new DragGridView.OnDragEndListener() {
            @Override
            public void onDragEnd() {
                scroller.requestDisallowInterceptTouchEvent(false);
                scroller.setInControl(true);
                gridView.postInvalidate();
            }
        });

//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(DisasterMessageMainActivity.this, "开发中...", Toast.LENGTH_SHORT).show();
//            }
//        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent summary_intent = new Intent(DisasterMessageMainActivity.this, SummaryActivity.class);
                        startActivity(summary_intent);
                        break;
                    case 1:
                        Intent rain_intent = new Intent(DisasterMessageMainActivity.this, RainActivity.class);
                        startActivity(rain_intent);
                        break;
                    case 2:
                        Intent clouds_intent = new Intent(DisasterMessageMainActivity.this, CloudsActivity.class);
                        startActivity(clouds_intent);
                        break;
                    case 3:
                        Intent river_intent = new Intent(DisasterMessageMainActivity.this, RiverActivity.class);
                        startActivity(river_intent);
                        break;
                    case 4:
                        Intent reservoir_intent = new Intent(DisasterMessageMainActivity.this, ReservoirActivity.class);
                        startActivity(reservoir_intent);
                        break;
                    case 5:
                        Intent emergency_intent = new Intent(DisasterMessageMainActivity.this, EmergencyActivity.class);
                        startActivity(emergency_intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }


}
