package com.example.ui;

import java.util.ArrayList;




import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

public class AdViewPager extends ViewPager {
	 @Override
	protected void onDraw(Canvas arg0) {
		// TODO Auto-generated method stub
		super.onDraw(arg0);
		
	}

	//事件分发 防止父控件也滑动
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
	    getParent().requestDisallowInterceptTouchEvent(true);
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public AdViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		
	}

	

	

}
