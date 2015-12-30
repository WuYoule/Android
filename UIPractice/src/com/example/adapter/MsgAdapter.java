package com.example.adapter;

import java.util.List;

import com.example.entity.Msg;


import com.example.uipractice.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {

	private int resourceId;
	View view;
	
	public MsgAdapter(Context context, int textViewResourceId,
			List<Msg> objects) {
		super(context, textViewResourceId, objects);
		Log.i("UI", textViewResourceId+"");
		resourceId=textViewResourceId;
		
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("ui_position", position+"");
		Msg msg=getItem(position);
		Log.i("ui_position", msg.getContent()+"");
		View view;
		ViewHolder viewHolder;
		if (convertView==null) {
			view=LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder=new ViewHolder();
			viewHolder.leftLinearLayout=(LinearLayout) view.findViewById(R.id.left_layout);
			viewHolder.rightLinearLayout=(LinearLayout) view.findViewById(R.id.right_layout);
			viewHolder.leftMsg=(TextView) view.findViewById(R.id.left_msg);
			viewHolder.rightMsg=(TextView) view.findViewById(R.id.right_msg);
			view.setTag(viewHolder);
			
		}
		else{
			view=convertView;
			viewHolder=(ViewHolder) view.getTag();
			
		}
		if (msg.getType()==Msg.TYPE_RECEIVED) {
			viewHolder.leftLinearLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLinearLayout.setVisibility(View.GONE); 
            viewHolder.leftMsg.setText(msg.getContent()); 
			
		}else if(msg.getType() == Msg.TYPE_SEND) { 
            // 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏 

            viewHolder.rightLinearLayout.setVisibility(View.VISIBLE); 
            viewHolder.leftLinearLayout.setVisibility(View.GONE); 

            viewHolder.rightMsg.setText(msg.getContent()); 
        } 
		return view;
	}
	
	class ViewHolder{
		LinearLayout leftLinearLayout;
		LinearLayout rightLinearLayout;
		TextView leftMsg;
		TextView rightMsg;
		
	}

}
