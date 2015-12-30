package com.example.fragmentlinkactivity;

import java.lang.annotation.Retention;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyFragment extends Fragment {

	
	private String personName="jack";
	Button button;
	CheckBox checkBox;
	TextView textView;
	
	public String getPersonName() {
		return personName;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view= inflater.inflate(R.layout.fragment_bottom, container,false);
		button=(Button) view.findViewById(R.id.fragment_btn);
		textView=(TextView) view.findViewById(R.id.fragment_tv);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				                   //��Fragment�з����丸Activity
			checkBox=	(CheckBox) getActivity().findViewById(R.id.chk_married);
			if (checkBox.isChecked()) {
				textView.setText("�ѻ�");
			}
			else{
				textView.setText("δ��");
				
			}
				
			}
		});
		
		return view;
	}
	
}
