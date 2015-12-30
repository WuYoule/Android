package com.example.ui;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;




import com.example.demo.R;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeFragment extends Fragment {

	Timer timer;
	TimerTask timetask;

	AdViewPager adViewPager;
	MyGridView myGridView;

	ArrayList<View> bitmap = new ArrayList<View>();
	ArrayList<GridEntity> gridData = new ArrayList<GridEntity>();

	int index = 0;// ��ǰҳ���λ��

	ImageView img1;
	ImageView img2;
	ImageView img3;
	ImageView img4;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.home_fragment, container, false);
		findView(view);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();

	}

	private void init() {

		// ///////////////////////����ֲ�ͼ////////////////////////////////////////////////
		// ��������
		initAdData();
		// �����viewpager�������
		adViewPager.setAdapter(new MyViewPageradapter());

		// ���viewpager��������
		adViewPager.setOnPageChangeListener(new MyViewPagerChangeLister());

		// ���viewpager�Զ�ѭ������
		setPageFromTime(4000);
		// ///////////////////////����ֲ�ͼ////////////////////////////////////////////////

		// ��GridView������
		initGridData();
		// ��GridView����������
		myGridView.setAdapter(new GridViewAdapter(getActivity()));
	}

	// GridView ������
	private class GridViewAdapter extends BaseAdapter {

		Context context;
		LayoutInflater inflater;

		public GridViewAdapter(Context context) {
                 this.context=context;
                 inflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return gridData.size();
		}

		@Override
		public Object getItem(int postison) {
			// TODO Auto-generated method stub
			return gridData.get(postison);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			ViewHolder viewHolder;
			if (convertView==null) {
				convertView=inflater.inflate(R.layout.gridview_item, null);
				viewHolder=new ViewHolder();
				viewHolder.img=(ImageView) convertView.findViewById(R.id.gridview_img);
				viewHolder.text=(TextView) convertView.findViewById(R.id.gridview_tv);
				convertView.setTag(viewHolder);
				
			}
			else{
				viewHolder=(ViewHolder) convertView.getTag();
			}
			viewHolder.img.setBackgroundResource(gridData.get(position).getImg());
			viewHolder.text.setText(gridData.get(position).getIntroduce());
			return convertView;
			
		}

	}
	 static class ViewHolder{
		 ImageView img;
		 TextView text;
	 }
	
	// ��GridView������
	private void initGridData() {
		for (int i = 0; i < 10; i++) {
			GridEntity hg = new GridEntity();
			hg.setImg(R.drawable.img3);
			hg.setIntroduce("��ͨ" + i);
			gridData.add(hg);
		}
	}

	// GridView ʵ����
	class GridEntity {
		public GridEntity() {
			super();

		}

		public GridEntity(int img, String introduce) {
			super();
			this.img = img;
			this.introduce = introduce;
		}

		private int img;// ����ͼƬ
		private String introduce;// ����

		public int getImg() {
			return img;
		}

		public void setImg(int img) {
			this.img = img;
		}

		public String getIntroduce() {
			return introduce;
		}

		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}

	}

	// ///////////////////////����ֲ�ͼ////////////////////////////////////////////////
	// ���viewpager��������
	private class MyViewPagerChangeLister implements
			ViewPager.OnPageChangeListener {
		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {

		}

		@Override
		public void onPageSelected(int position) {
			// Log.i("index", position+"");
			index = position;

			if (index == 4) {
				index = 0;
			}
			// adViewPager.setCurrentItem(index);
			Bundle bundle = new Bundle();
			bundle.putInt("index", index);
			Message msg = new Message();
			msg.setData(bundle);
			msg.what = 100;
			handler.sendMessage(msg);

		}

		@Override
		public void onPageScrollStateChanged(int state) {
			Log.i("onPageScrollStateChanged", "before" + index);

		}
	}

	// ������Ϣ
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 100:
				int i = msg.getData().getInt("index");
				// Log.i("handler", i+"");
				adViewPager.setCurrentItem(i);
				changePageControl(i);
				break;
			}
		}
	};

	// ���ѭ������
	public void setPageFromTime(int delayTime) {
		timer = new Timer();
		timetask = new TimerTask() {
			@Override
			public void run() {
				// ҵ���߼�
				Log.i("before", index + "");
				Bundle bundle = new Bundle();
				bundle.putInt("index", index);
				Message msg = new Message();
				msg.setData(bundle);
				msg.what = 100;
				handler.sendMessage(msg);

				index++;
				Log.i("after", index + "");
				if (index == 4) {
					index = 0;
				}
			}
		};
		timer.schedule(timetask, 1000, delayTime);

	}

	// ���viewpager������
	private class MyViewPageradapter extends PagerAdapter {
		@Override
		public int getCount() {
			// Log.i("��־", String.valueOf(bitmap.size()));
			return bitmap.size();
			// return Integer.MAX_VALUE;

		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

			((ViewPager) container).removeView(bitmap.get(position));
			// ((ViewPager)container).removeView(bitmap.get(position %
			// bitmap.size()));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			((ViewPager) container).addView(bitmap.get(position));
			return bitmap.get(position);

			// ((ViewPager)container).addView(bitmap.get(position %
			// bitmap.size()), 0);
			// return bitmap.get(position % bitmap.size());
		}
	}

	// ��������
	private void initAdData() {

		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.ad_viewpager_item, null);
		view.findViewById(R.id.adImg).setBackgroundResource(R.drawable.img1);
		bitmap.add(view);

		LayoutInflater inflater2 = getActivity().getLayoutInflater();
		View view2 = inflater2.inflate(R.layout.ad_viewpager_item, null);
		view2.findViewById(R.id.adImg).setBackgroundResource(R.drawable.img2);
		bitmap.add(view2);

		LayoutInflater inflater3 = getActivity().getLayoutInflater();
		View view3 = inflater3.inflate(R.layout.ad_viewpager_item, null);
		view3.findViewById(R.id.adImg).setBackgroundResource(R.drawable.img3);
		bitmap.add(view3);

		LayoutInflater inflater4 = getActivity().getLayoutInflater();
		View view4 = inflater4.inflate(R.layout.ad_viewpager_item, null);
		view4.findViewById(R.id.adImg).setBackgroundResource(R.drawable.img4);
		bitmap.add(view4);

	}

	// ///////////////////////����ֲ�ͼ////////////////////////////////////////////////

	private void changePageControl(int i) {
		switch (i) {// ���� ����� ��
		case 0:
			img1.setBackgroundResource(R.drawable.point_selected);
			img2.setBackgroundResource(R.drawable.point_normal);
			img3.setBackgroundResource(R.drawable.point_normal);
			img4.setBackgroundResource(R.drawable.point_normal);
			break;
		case 1:
			img1.setBackgroundResource(R.drawable.point_normal);
			img2.setBackgroundResource(R.drawable.point_selected);
			img3.setBackgroundResource(R.drawable.point_normal);
			img4.setBackgroundResource(R.drawable.point_normal);
			break;
		case 2:
			img1.setBackgroundResource(R.drawable.point_normal);
			img2.setBackgroundResource(R.drawable.point_normal);
			img3.setBackgroundResource(R.drawable.point_selected);
			img4.setBackgroundResource(R.drawable.point_normal);
			break;
		case 3:
			img1.setBackgroundResource(R.drawable.point_normal);
			img2.setBackgroundResource(R.drawable.point_normal);
			img3.setBackgroundResource(R.drawable.point_normal);
			img4.setBackgroundResource(R.drawable.point_selected);
			break;
		}

	}

	// �ҿؼ�
	private void findView(View view) {
		adViewPager = (AdViewPager) view.findViewById(R.id.adViewpager);
		myGridView = (MyGridView) view.findViewById(R.id.myGridView);
		img1 = (ImageView) view.findViewById(R.id.img1);
		img2 = (ImageView) view.findViewById(R.id.img2);
		img3 = (ImageView) view.findViewById(R.id.img3);
		img4 = (ImageView) view.findViewById(R.id.img4);

	}

}
