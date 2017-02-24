package com.example.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joesn.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by joesn on 2017/1/22.
 * 这是需求Listview的自定义适配器
 * 获取布局容器LayoutInflater，通过LayoutInflater.from(Context).inflater(Layout,null),获取view
 * 通过getView() return view; 返回布局
 */

public class NeedAdapter extends BaseAdapter {

    public NeedAdapter(List<Map<String,Object>> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public final class ViewHolder{
        public View needTopLine;
        public TextView read;
        public ImageView userImage;
        public TextView userName;
        public TextView needPrice;
        public TextView needPlace;
        public TextView needDate;

    }
    private ViewHolder holder;
    private Context context;
    private List<Map<String,Object>> list;
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.need_home_info,null);
            holder = new ViewHolder();
            holder.needTopLine = (View) view.findViewById(R.id.needTopLine);
            holder.read = (TextView) view.findViewById(R.id.needRead);
            holder.needPrice = (TextView) view.findViewById(R.id.needPrice);
            holder.needPlace = (TextView) view.findViewById(R.id.needPlace);
            holder.needDate = (TextView) view.findViewById(R.id.needDate);
            holder.userImage = (ImageView) view.findViewById(R.id.needUserImage);
            holder.userName = (TextView) view.findViewById(R.id.needUserName);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //设置第一个item的上布局线不显示
        if(position==0)
        {
            holder.needTopLine.setVisibility(View.GONE);
        }
        holder.read.setText("阅读量:"+"90000");
        holder.needPrice.setText("200/次");
        holder.needPlace.setText("华软");
        Drawable place = context.getResources().getDrawable(R.drawable.pin);
        place.setBounds(0,0,45,45);
        holder.needPlace.setCompoundDrawables(place,null,null,null);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        holder.needDate.setText(format.format(new Date()));
        Drawable date = context.getResources().getDrawable(R.drawable.date);
        date.setBounds(0,0,45,45);
        holder.needDate.setCompoundDrawables(date,null,null,null);

        holder.userImage.setBackgroundResource(R.drawable.moon);

        holder.userName.setText("Jopen");
        return view;
    }


}
