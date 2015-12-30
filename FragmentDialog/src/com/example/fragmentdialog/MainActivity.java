package com.example.fragmentdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {
    final String TAG="MainActivity";
	RadioGroup radioGroup;
	Button button;
	WqyDialogFragment wqyDialogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);
        button=(Button) findViewById(R.id.crate);
       
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 int resId=radioGroup.getCheckedRadioButtonId();
				 switch (resId) {
					case R.id.alertdialog:
						wqyDialogFragment.getInstance(R.id.alertdialog).show(getFragmentManager(), "提示");;
						
						break;
					case R.id.datedialog:
						wqyDialogFragment.getInstance(R.id.datedialog).show(getFragmentManager(), "");
						break;
					case R.id.timedialog:
						wqyDialogFragment.getInstance(R.id.timedialog).show(getFragmentManager(), "");
						break;
					default:
						break;
					}
				
			}
		});
       
//        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(RadioGroup group, int checkedId) {
//				switch (checkedId) {
//				case R.id.alertdialog:
//					
//				DialogFragment newFragment=	wqyDialogFragment.getInstance(R.id.alertdialog);
//				newFragment.show(getFragmentManager(), "提示");
//					
//					break;
//				case R.id.datedialog:
//					
//					wqyDialogFragment.getInstance(R.id.datedialog).show(getFragmentManager(), "");
//					break;
//				case R.id.timedialog:
//					
//					wqyDialogFragment.getInstance(R.id.timedialog).show(getFragmentManager(), "");
//					break;
//				default:
//					break;
//				}
//				
//			}
//		});
    }

   
    
}
