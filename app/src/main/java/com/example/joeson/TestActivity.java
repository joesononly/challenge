package com.example.joeson;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.Adapter.NeedConsultationAdapter;
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
 * Created by joesn on 2017/1/22.
 */
@EActivity(R.layout.test)
public class TestActivity extends Activity {
    @ViewById(R.id.needName)
    TextView needName;
    @ViewById(R.id.needPrice)
    TextView needPrice;
    @ViewById(R.id.needRead)
    TextView needRead;
    @ViewById(R.id.needPlace)
    TextView needPlace;
    @ViewById(R.id.needDate)
    TextView needDate;
    @ViewById
    ImageView needUserImage;
    @ViewById
    TextView needUserName;
    @ViewById
    TextView needCommentInfo;
    @ViewById(R.id.userNeed)
    ListView userNeed;
    private NeedConsultationAdapter adapter;
    private List<Map<String,Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @AfterViews
    public void init(){
        //需求名
        needName.setText("活动logo和纪念品");
        //价格
        needPrice.setText("300/次");
        //阅读量
        needRead.setText("300000");
        //地点
        needPlace.setText("华软");
        //具体信息
        needCommentInfo.setText("现在需要会活动logo设计和纪念品设计的，\n" +
                "        工作地点不限\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        /*
        * 设置地点与时间前的标志图片
        * */
        Drawable place = getResources().getDrawable(R.drawable.pin);
        place.setBounds(0,0,45,45);
        needPlace.setCompoundDrawables(place,null,null,null);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //时间
        needDate.setText(format.format(new Date()));
        Drawable date = getResources().getDrawable(R.drawable.date);
        date.setBounds(0,0,45,45);
        needDate.setCompoundDrawables(date,null,null,null);
        /*
        * userImage：用户头像
        * userProlem：用户问题
        * busunessAnswer：商家答复
        *
        * */
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userImage",R.drawable.moon);
        map.put("useProblem","具体要怎样做");
        map.put("businessAnswer","上面介绍有写的");

        list = new ArrayList<Map<String,Object>>();
        list.add(map);
        adapter = new NeedConsultationAdapter(this,list);
        userNeed.setAdapter(adapter);
    }
}
