package com.example.fragmentlinkactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {

   private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox=(CheckBox) findViewById(R.id.chk_married);
//        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                //在Activity中访问Activity
//				MyFragment fragment=(MyFragment) getFragmentManager().findFragmentById(R.id.fragment_bottom);
//				TextView tv=	(TextView) fragment.getView().findViewById(R.id.fragment_tv);
//				if (checkBox.isChecked()) {
//					
//					tv.setText(fragment.getPersonName()+"已婚");
//				}
//				else{
//					
//					tv.setText(fragment.getPersonName()+"未婚");
//				
//				}
//				
//			}
//		});
    }


   
    
}
