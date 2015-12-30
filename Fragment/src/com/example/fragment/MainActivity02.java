package com.example.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/*
 * Fragment使用java代码的
 */
public class MainActivity02 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main02);
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.add(R.id.top_zhanwei, new TopFragment());
		fragmentTransaction.add(R.id.bottom_zhanwei, new BottomFragment());
	    fragmentTransaction.commit();
	}
}
