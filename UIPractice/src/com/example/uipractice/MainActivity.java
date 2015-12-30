package com.example.uipractice;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.MsgAdapter;
import com.example.entity.Msg;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView msgListView;
	private EditText inputEditText;
	private Button sendButton;
	private MsgAdapter adapter;
	private List<Msg> msgList = new ArrayList<Msg>(); 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();//初始化消息数据
        Log.i("Main", msgList.size()+"");
        adapter=new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
        msgListView=(ListView) findViewById(R.id.msg_list_view);
        inputEditText=(EditText) findViewById(R.id.input_text);
        sendButton=(Button) findViewById(R.id.send);
        
        msgListView.setAdapter(adapter);
        sendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String contentString=inputEditText.getText().toString();
				if (!"".equals(contentString)) {
					Msg msg=new Msg(contentString, Msg.TYPE_SEND);
					msgList.add(msg);
					adapter.notifyDataSetChanged();
					msgListView.setSelection(msgList.size());
					inputEditText.setText("");
				}
				
			}
		});
        
    }


    private void initMsgs() {
    	 Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED); 
         msgList.add(msg1); 
         Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SEND); 
         msgList.add(msg2); 
         Msg msg3=new Msg("ThisisTom.Nicetalkingtoyou.",Msg.TYPE_RECEIVED); 
         msgList.add(msg3); 
		
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
