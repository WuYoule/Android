package com.example.ui;



import com.example.demo.R;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BottomLayout extends LinearLayout {
	RelativeLayout homeLayout;
	RelativeLayout selectLayout;
	RelativeLayout searchLayout;
	RelativeLayout locationLayout;
	RelativeLayout settingLayout;
	LayoutInflater inflater;

	public BottomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	private void initView() {
		inflater = LayoutInflater.from(getContext());
		View view = inflater.inflate(R.layout.layout_bottom, this);
		findView(view);
		//��ʼ�� bottom ���ǻҵĵ�
		initData();
		//�������
		setOnClick();
	}

	private void setOnClick() {
		homeLayout.setOnClickListener(new listener());
		locationLayout.setOnClickListener(new listener());
		selectLayout.setOnClickListener(new listener());
		searchLayout.setOnClickListener(new listener());
		settingLayout.setOnClickListener(new listener());

	}


	
//-------���ڻش���-------------------------
	public   interface  ICallbackListener{
        public void  click(int id);
    }
    ICallbackListener callbackListener=null;
    public  void setOnCallbackListener(ICallbackListener cbl){
        this.callbackListener=cbl;
    }
//----------------------------------------  
    
	private class listener implements OnClickListener {

		@Override
		public void onClick(View v) {
		
			Log.i("��־-BottomLayout",v.getId()+"");
			
			switch (v.getId()) {
			case R.id.hometab:
                  initPic(0);
				break;

			case R.id.selecttab:
				  initPic(1);
				break;
			case R.id.searchtab:
				  initPic(2);
				break;
			case R.id.locationtab:
				  initPic(3);
				break;
			case R.id.settingtab:
				  initPic(4);
				break;

			}
			  //�ش� ����� ID
		    callbackListener.click(v.getId());


		}

		

	}

	public void initPic(int i) {
		switch (i) {
		case 0:
			   homeLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_home_down);
               TextView tv01= (TextView) homeLayout.findViewById(R.id.bottom_item_tv);
               tv01.setText("��ҳ");
               tv01.setTextColor(Color.BLUE);

               selectLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_manage);
               TextView tv02= (TextView) selectLayout.findViewById(R.id.bottom_item_tv);
               tv02.setText("ѡ��");
               tv02.setTextColor(Color.WHITE);


               searchLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_search);
               TextView tv03= (TextView) searchLayout.findViewById(R.id.bottom_item_tv);
               tv03.setText("����");
               tv03.setTextColor(Color.WHITE);

               locationLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_find);
               TextView tv04= (TextView) locationLayout.findViewById(R.id.bottom_item_tv);
               tv04.setText("����");
               tv04.setTextColor(Color.WHITE);

               settingLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_more);
               TextView tv05= (TextView) settingLayout.findViewById(R.id.bottom_item_tv);
               tv05.setText("����");
               tv05.setTextColor(Color.WHITE);
			break;

		case 1:
               homeLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_home);
               TextView tv11= (TextView) homeLayout.findViewById(R.id.bottom_item_tv);
               tv11.setText("��ҳ");
               tv11.setTextColor(Color.WHITE);

               selectLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_manage_down);
               TextView tv12= (TextView) selectLayout.findViewById(R.id.bottom_item_tv);
               tv12.setText("ѡ��");
               tv12.setTextColor(Color.BLUE);


               searchLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_search);
               TextView tv13= (TextView) searchLayout.findViewById(R.id.bottom_item_tv);
               tv13.setText("����");
               tv13.setTextColor(Color.WHITE);

               locationLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_find);
               TextView tv14= (TextView) locationLayout.findViewById(R.id.bottom_item_tv);
               tv14.setText("����");
               tv14.setTextColor(Color.WHITE);

               settingLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_more);
               TextView tv15= (TextView) settingLayout.findViewById(R.id.bottom_item_tv);
               tv15.setText("����");
               tv15.setTextColor(Color.WHITE);
               break;
           case 2:
               homeLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_home);
               TextView tv21= (TextView) homeLayout.findViewById(R.id.bottom_item_tv);
               tv21.setText("��ҳ");
               tv21.setTextColor(Color.WHITE);

               selectLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_manage);
               TextView tv22= (TextView) selectLayout.findViewById(R.id.bottom_item_tv);
               tv22.setText("ѡ��");
               tv22.setTextColor(Color.WHITE);


               searchLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_search_down);
               TextView tv23= (TextView) searchLayout.findViewById(R.id.bottom_item_tv);
               tv23.setText("����");
               tv23.setTextColor(Color.BLUE);

               locationLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_find);
               TextView tv24= (TextView) locationLayout.findViewById(R.id.bottom_item_tv);
               tv24.setText("����");
               tv24.setTextColor(Color.WHITE);

               settingLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_more);
               TextView tv25= (TextView) settingLayout.findViewById(R.id.bottom_item_tv);
               tv25.setText("����");
               tv25.setTextColor(Color.WHITE);
               break;
           case 3:
               homeLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_home);
               TextView tv31= (TextView) homeLayout.findViewById(R.id.bottom_item_tv);
               tv31.setText("��ҳ");
               tv31.setTextColor(Color.WHITE);

               selectLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_manage);
               TextView tv32= (TextView) selectLayout.findViewById(R.id.bottom_item_tv);
               tv32.setText("ѡ��");
               tv32.setTextColor(Color.WHITE);


               searchLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_search);
               TextView tv33= (TextView) searchLayout.findViewById(R.id.bottom_item_tv);
               tv33.setText("����");
               tv33.setTextColor(Color.WHITE);

               locationLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_find_down);
               TextView tv34= (TextView) locationLayout.findViewById(R.id.bottom_item_tv);
               tv34.setText("����");
               tv34.setTextColor(Color.BLUE);

               settingLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_more);
               TextView tv35= (TextView) settingLayout.findViewById(R.id.bottom_item_tv);
               tv35.setText("����");
               tv35.setTextColor(Color.WHITE);
               break;
           case 4:
               homeLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_home);
               TextView tv41= (TextView) homeLayout.findViewById(R.id.bottom_item_tv);
               tv41.setText("��ҳ");
               tv41.setTextColor(Color.WHITE);

               selectLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_manage);
               TextView tv42= (TextView) selectLayout.findViewById(R.id.bottom_item_tv);
               tv42.setText("ѡ��");
               tv42.setTextColor(Color.WHITE);


               searchLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_search);
               TextView tv43= (TextView) searchLayout.findViewById(R.id.bottom_item_tv);
               tv43.setText("����");
               tv43.setTextColor(Color.WHITE);

               locationLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_find);
               TextView tv44= (TextView) locationLayout.findViewById(R.id.bottom_item_tv);
               tv44.setText("����");
               tv44.setTextColor(Color.WHITE);

               settingLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(R.drawable.image_tabbar_button_more_down);
               TextView tv45= (TextView) settingLayout.findViewById(R.id.bottom_item_tv);
               tv45.setText("����");
               tv45.setTextColor(Color.BLUE);
               break;
		}
		
	}
	
	private void initData() {
		homeLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(
				R.drawable.image_tabbar_button_home);
		TextView tv01 = (TextView) homeLayout.findViewById(R.id.bottom_item_tv);
		tv01.setText("��ҳ");
		tv01.setTextColor(Color.WHITE);

		selectLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(
				R.drawable.image_tabbar_button_manage);
		TextView tv02 = (TextView) selectLayout
				.findViewById(R.id.bottom_item_tv);
		tv02.setText("ѡ��");
		tv02.setTextColor(Color.WHITE);

		searchLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(
				R.drawable.image_tabbar_button_search);
		TextView tv03 = (TextView) searchLayout
				.findViewById(R.id.bottom_item_tv);
		tv03.setText("����");
		tv03.setTextColor(Color.WHITE);

		locationLayout.findViewById(R.id.bottom_item_img)
				.setBackgroundResource(R.drawable.image_tabbar_button_find);
		TextView tv04 = (TextView) locationLayout
				.findViewById(R.id.bottom_item_tv);
		tv04.setText("����");
		tv04.setTextColor(Color.WHITE);

		settingLayout.findViewById(R.id.bottom_item_img).setBackgroundResource(
				R.drawable.image_tabbar_button_more);
		TextView tv05 = (TextView) settingLayout
				.findViewById(R.id.bottom_item_tv);
		tv05.setText("����");
		tv05.setTextColor(Color.WHITE);

	}

	private void findView(View view) {
		homeLayout = (RelativeLayout) view.findViewById(R.id.hometab);
		searchLayout = (RelativeLayout) view.findViewById(R.id.searchtab);
		selectLayout = (RelativeLayout) view.findViewById(R.id.selecttab);
		locationLayout = (RelativeLayout) view.findViewById(R.id.locationtab);
		settingLayout = (RelativeLayout) view.findViewById(R.id.settingtab);

	}

}
