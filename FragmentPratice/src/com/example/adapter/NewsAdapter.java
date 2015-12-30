package com.example.adapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.entity.News;
import com.example.fragmentpratice.R;


public class NewsAdapter extends ArrayAdapter<News>{

	private int resourceId;
	
	public NewsAdapter(Context context, int textViewResourceId,
			List<News> objects) {
		super(context, textViewResourceId, objects);
		resourceId=textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		News news=getItem(position);
		View view;
		if (convertView==null) {
			view=LayoutInflater.from(getContext()).inflate(resourceId, null);
			
		}
		else{
			view=convertView;
		}
		TextView titleTextView=(TextView) view.findViewById(R.id.news_title);
		titleTextView.setText(news.getTitle());
		return view;
	}

	
	
	

}
