package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joesn.myapplication.R;

import java.util.List;
import java.util.Map;

/**
 * Created by joesn on 2017/1/29.
 */

public class NeedConsultationAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> list;
    private Holder holder;
    public NeedConsultationAdapter(Context context, List<Map<String,Object>> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(R.layout.need_comment_item,null);
            holder.needMinUserImage = (ImageView) view.findViewById(R.id.needMinUserImage);
            holder.needUserProblem = (TextView) view.findViewById(R.id.needUserProblem);
            holder.businessAnswer = (TextView) view.findViewById(R.id.businessAnswer);
            view.setTag(holder);
        }else {
            holder =(Holder) view.getTag();
        }
        holder.needMinUserImage.setBackgroundResource((int) list.get(position).get("userImage"));
        holder.needUserProblem.setText((String) list.get(position).get("useProblem"));
        holder.businessAnswer.setText((String) list.get(position).get("businessAnswer"));
        return view;
    }

    class Holder{
        public ImageView needMinUserImage;
        public TextView needUserProblem;
        public TextView businessAnswer;
    }

}
