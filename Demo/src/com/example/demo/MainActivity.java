package com.example.demo;


import com.example.ui.BottomLayout;
import com.example.ui.BottomLayout.ICallbackListener;
import com.example.ui.HomeFragment;
import com.example.ui.LocationFragment;
import com.example.ui.SearchFragment;
import com.example.ui.SelectFragment;
import com.example.ui.SettingFragment;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends FragmentActivity {

	BottomLayout bottomLayout;
	ViewPager parentViewPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
       
        init();
    }


    private void init() {
	
    	bottomLayout=(BottomLayout) findViewById(R.id.mybottomlayout);
		parentViewPager=(ViewPager) findViewById(R.id.parentViewPage);
		parentViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
		
		
		
		//点击 bottom 时 viewpager 跟着切换
		setOnClick();
		
		
		//viewpager 滑动设置监听 当 viewpager滑动是 bottom 也要跟着切换
		parentViewPager.setOnPageChangeListener(new pageListener());
	}

    private class pageListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
		
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
			
		}

		@Override
		public void onPageSelected(int position) {
		
			bottomLayout.initPic(position);
			
		}
    	
    }
    
    private void setOnClick() {

    	bottomLayout.setOnCallbackListener(new callBack());
		
	}
  private class callBack implements ICallbackListener{

	@Override
	public void click(int id) {
		switch (id)
        {
            case R.id.hometab:
                parentViewPager.setCurrentItem(0);
                break;
            case R.id.selecttab:
            	parentViewPager.setCurrentItem(1);
                break;
            case R.id.searchtab:
            	parentViewPager.setCurrentItem(2);
                break;
            case R.id.locationtab:
            	parentViewPager.setCurrentItem(3);
                break;
            case R.id.settingtab:
            	parentViewPager.setCurrentItem(4);
                break;
        }
		
	}
	  
	  
  }

	private class MyFragmentAdapter extends FragmentPagerAdapter{

		public MyFragmentAdapter(FragmentManager fm) {
			super(fm);
			
		}

		@Override
		public Fragment getItem(int position) {
			
			Fragment fragment = null;
		    switch (position) {
			case 0:
				fragment= new HomeFragment();
				return fragment;
			case 1:
				fragment=  new SelectFragment();
				return fragment;
			case 2:
				fragment=  new SearchFragment();
				return fragment;
			case 3:
				fragment= new LocationFragment();
				return fragment;
			case 4:
				fragment=  new SettingFragment();
				return fragment;
			
			}
		    return null;
		    
			
		}

		@Override
		public int getCount() {
		
			return 5;
		}
    	
    	
    } 

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
