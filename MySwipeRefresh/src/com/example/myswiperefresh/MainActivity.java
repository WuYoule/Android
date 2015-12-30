package com.example.myswiperefresh;



import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity implements OnRefreshListener{
	private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mRandomTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        
        mRandomTextView = (TextView) findViewById(R.id.random);
    }

	@Override
	public void onRefresh() {
		 mSwipeRefreshLayout.setRefreshing(true);

	        (new Handler()).postDelayed(new Runnable() {
	            @Override
	            public void run() {
	               
	                mSwipeRefreshLayout.setRefreshing(false);
	              
	                int i = (int)(Math.random()*100+1); 
	                mRandomTextView.setText(String.valueOf(i));
	            }
	        }, 3000);
		
	}
}
