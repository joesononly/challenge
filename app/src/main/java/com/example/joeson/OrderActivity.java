package com.example.joeson;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Adapter.OrderAdapter;
import com.example.joesn.myapplication.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joesn on 2017/2/6.
 * 本页面为订单时间轴页面用来显示订单的具体进度
 */
@EActivity(R.layout.order)
public class OrderActivity extends Activity {
    /*
    * 设计订单中的具体信息
    * master 雇主头像
    * orderUserName 雇主名字
    * orderUseTime 估计用时
    * orderStarTime 开始时间
    * OrderImage 工作者头像
    * orderWorkerName 工作者名字
    * orderPlace 订单地方
    * orderCost 费用
    * */
    @ViewById
    ImageView master;
    @ViewById
    TextView orderUserName;
    @ViewById
    TextView orderUseTime;
    @ViewById
    TextView orderStarTime;

//    ImageView orderImage;
    @ViewById
    TextView orderWorkerName;
    @ViewById
    TextView orderPlace;
    @ViewById
    TextView orderCost;

    @ViewById
    RecyclerView id_recyclerview;
    private List<Map<String,Object>> dates;
    @AfterViews
    public void init(){
        dates = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("talk","活动开始时间："+new SimpleDateFormat("yy-MM-dd").format(new Date()));

        Map<String,Object> allComment = new HashMap<String,Object>();
        allComment.put("talk","具体图片已发送到您的邮箱中，请确认xxxxxxxxxxxx" +
                "xxxxxxxxxxxxx" +
                "xxxxxxxxx" +
                "xxxxxxxxx" +
                "xxx");

        dates.add(map);
        dates.add(allComment);
        //步骤一：设置布局管理器
        id_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        //步骤二：设置adapter
        id_recyclerview.setAdapter(new OrderAdapter(this,dates));
        //步骤三：设置Item增加、移除动画
        //id_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //步骤四：添加分割线
        //id_recyclerview.addItemDecoration(new DividerItemDecoration(
        //        getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
    }


}
