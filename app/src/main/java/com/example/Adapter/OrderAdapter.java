package com.example.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joesn.myapplication.R;

import java.util.List;
import java.util.Map;

/*
  * @date  :2017/2/7
  * @author:joesn
  * @description:OrderActivity中的RecyclerView适配器
  * @vesion:
*/
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyHoler> {
    private Context context;
    private List<Map<String,Object>> dates;
    public OrderAdapter(Context context,List<Map<String,Object>> dates) {
        this.context = context;
        this.dates = dates;
    }
    @Override
    /*
     * @description:设置RecyclerView的Item布局
     * @param [parent, viewType]
    */
    public MyHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHoler holer = new MyHoler(LayoutInflater.from(context).inflate(R.layout.order_time_item,parent,false));
        return holer;
    }

    @Override
    /*
     * @description: 为holder中的控件设置数据
     * @param [holder, position]
    */
    public void onBindViewHolder(MyHoler holder, int position) {
        holder.orderSchedule.setText((String) dates.get(position).get("talk"));
    }

    @Override
    /*
     * @description: 返回item的总数
     * @param []
    */
    public int getItemCount() {
        return dates.size();
    }
    /*
      * @date  :2017/2/7
      * @author:joesn
      * @description:控件的持有者
      * @vesion:
    */
    class MyHoler extends RecyclerView.ViewHolder{
        public TextView orderSchedule;
        public MyHoler(View itemView) {
            super(itemView);
            orderSchedule =(TextView) itemView.findViewById(R.id.orderSchedule);
        }
    }
}

