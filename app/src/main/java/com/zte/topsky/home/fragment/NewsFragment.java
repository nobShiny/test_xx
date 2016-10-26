
package com.zte.topsky.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;
import com.zte.topsky.common.utils.DividerItemDecoration;
import com.zte.topsky.news.activity.NewActivity;
import com.zte.topsky.news.bean.News;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wuyexiong on 4/25/15.
 */
public class NewsFragment extends BaseFragment {
    private static final String KEY_CONTENT = "NewsFragment";
    private String mContent = "???";
    private static Context mContext;
    @BindView(R.id.rl_news_list)
    RecyclerView rlNewsList;

    private CommonAdapter<String> mAdapter;
    private List<News> mList;


    public static NewsFragment newInstance(Context context) {
        NewsFragment fragment = new NewsFragment();
        mContext = context;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_news, null);
        ButterKnife.bind(this,layout);
        initView(layout);
        return layout;
    }

    private void initView(View layout) {
        mList = textData();
        rlNewsList.setLayoutManager(new LinearLayoutManager(mContext));
        rlNewsList.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new CommonAdapter(mContext, R.layout.item_news, mList) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                holder.setText(R.id.tv_news_title, mList.get(position).getTitle());
                holder.setText(R.id.tv_news_time, mList.get(position).getTime());
            }
        };
        rlNewsList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent intent = new Intent(mContext, NewActivity.class);
                intent.putExtra("url",mList.get(position).getUrl());
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

    }

    private List textData() {
        mList = new ArrayList<>();
        News news1 = new News();
        news1.setTitle("黄河上中游部分地区遭遇强降雨 各地全力做好防汛抗洪工作");
        news1.setTime("2016-09-27");
        news1.setUrl("http://mp.weixin.qq.com/s?__biz=MzIwNjUyNTY5NA==&mid=100000054&idx=2&sn=ac16f6b621e297b17dae7b6b252f258d&scene=18#wechat_redirect");
        mList.add(news1);

        News news2 = new News();
        news2.setTitle("第七届中瑞水管理高层对话会在京召开");
        news2.setTime("2016-09-01");
        news2.setUrl("http://mp.weixin.qq.com/s?__biz=MzIwNjUyNTY5NA==&mid=100000054&idx=1&sn=5aaf13d209ea904e41ef80ae502d226e&scene=18#wechat_redirect");
        mList.add(news2);

        News news3 = new News();
        news3.setTitle("水利部召开2016年第6次中央水利投资计划执行月调度会商会议");
        news3.setTime("2016-08-05");
        news3.setUrl("http://mp.weixin.qq.com/s?__biz=MzIwNjUyNTY5NA==&mid=100000031&idx=1&sn=0bafa35a3a44cfeda90ba5d37db64c3e&scene=18#wechat_redirect");
        mList.add(news3);

        News news4 = new News();
        news4.setTitle("农业综合开发今年要做哪些事？");
        news4.setTime("2016-08-05");
        news4.setUrl("http://mp.weixin.qq.com/s?__biz=MzIwNjUyNTY5NA==&mid=100000031&idx=2&sn=05d417db76ae601775745ce4fe77b239&scene=18#wechat_redirect");
        mList.add(news4);

        News news5 = new News();
        news5.setTitle("图解《农田水利条例》核心要点 ");
        news5.setTime("2016-08-04");
        news5.setUrl("http://mp.weixin.qq.com/s?__biz=MzIwNjUyNTY5NA==&mid=100000031&idx=4&sn=87c4f3884e7842a1b73c0241887f8199&scene=18#wechat_redirect");
        mList.add(news5);

        News news6 = new News();
        news6.setTitle("四部委联合发文稳步推进农业水价综合改革");
        news6.setTime("2016-07-29");
        news6.setUrl("http://mp.weixin.qq.com/s?__biz=MzIwNjUyNTY5NA==&mid=100000031&idx=5&sn=8950fc1a7bb5dc4b65a9375275bcb458&scene=18#wechat_redirect");
        mList.add(news6);

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

    //    public interface DataListener {
//        void sendURL(String url);
//    }


}
