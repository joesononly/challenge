package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.joesn.myapplication.R;

import java.util.List;
import java.util.Map;

/**
 * Created by joesn on 2017/2/21.
 */

public class DingdanAdapter extends BaseAdapter {
    private List<Map<String,Object>> dates;
    private Context context;
    private Handler handler;
    public DingdanAdapter(List<Map<String,Object>> dates, Context context){
        this.dates = dates;
        this.context = context;

    }
    @Override
    public int getCount() {
        return dates.size();
    }

    @Override
    public Object getItem(int position) {
        return dates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if(convertView==null) {
            handler = new Handler();
            convertView = LayoutInflater.from(context).inflate(R.layout.dingdan_item, null);
            handler.dingdan = (TextView) convertView.findViewById(R.id.dingdan);
            handler.dingdanType = (TextView) convertView.findViewById(R.id.dingdan_type);
            handler.username = (TextView) convertView.findViewById(R.id.dingdan_username);
            handler.worker = (TextView) convertView.findViewById(R.id.dingdan_worker);
            handler.pay = (Button) convertView.findViewById(R.id.dingdan_pay);
            handler.money = (TextView) convertView.findViewById(R.id.dingdan_money);
            convertView.setTag(handler);
        }else {
            handler = (Handler) convertView.getTag();
        }
        handler.dingdan.setText("订单号:"+(String)dates.get(i).get("dingdan"));
        handler.dingdanType.setText("类型:"+(String)dates.get(i).get("dingdanType"));
        handler.username.setText((String)dates.get(i).get("username"));
        handler.worker.setText((String)dates.get(i).get("worker"));
        handler.money.setText("金额:￥"+(String)dates.get(i).get("money"));
        handler.pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //支付按钮点击事件
            }
        });

        return convertView;
    }

    class Handler{
        private TextView dingdan;
        private TextView dingdanType;
        private TextView username;
        private TextView worker;
        private TextView money;
        private Button pay;
    }
}
