package com.example.joeson;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import com.example.Adapter.DingdanAdapter;
import com.example.joesn.myapplication.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joesn on 2017/2/21.
 */
@EActivity(R.layout.dingdan)
public class dingdanActivity extends Activity {
    @ViewById
    ListView dingdanItem;
    private DingdanAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
    @AfterViews
    public void init(){
        List<Map<String,Object>> dates = new ArrayList<Map<String,Object>>();
        for (int i =0;i<5;i++)
        {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("dingdan","2017221A4");
            map.put("dingdanType","设计");
            map.put("username","Joeson");
            map.put("worker","Stranger");
            map.put("money","200");
            dates.add(map);
        }
        adapter = new DingdanAdapter(dates,this.getApplicationContext());
        dingdanItem.setAdapter(adapter);
    }
}
