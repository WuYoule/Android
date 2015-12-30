package com.example.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity03 extends Activity {

	
	Button replaceButton;
	Button removeButton;
	TopFragment topFragment;
	BottomFragment bottomFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main03);
		removeButton=(Button) findViewById(R.id.remove);
		replaceButton=(Button) findViewById(R.id.replace);
		
		topFragment=new TopFragment();
		getFragmentManager().beginTransaction().add(R.id.zhanwei_container, topFragment).commit();
		
		bottomFragment=new BottomFragment();
		replaceButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			    getFragmentManager()
			    .beginTransaction()
			    .replace(R.id.zhanwei_container, bottomFragment)
			    .addToBackStack(null)//点击返回键 可以返回替换之前的状态
			    .commit();
				
			}
		});
		
		removeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getFragmentManager().beginTransaction().remove(topFragment).commit();
				
			}
		});
	}
}
