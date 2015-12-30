package com.example.fragmentpratice;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.NewsAdapter;
import com.example.entity.News;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NewsTitleFragment extends Fragment implements OnItemClickListener{

	
	private ListView newsTitleListView;
	 private List<News> newsList;
	 private  NewsAdapter adapter;
	 private boolean isTwoPane;
	
	
	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
		newsList=getNews();
		 adapter=new NewsAdapter(activity, R.layout.news_item, newsList); 
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.news_title_frag, container,false);
		 newsTitleListView = (ListView)view.findViewById(R.id.news_title_list_view); 
		 newsTitleListView.setAdapter(adapter);
		 newsTitleListView.setOnItemClickListener(this); 
	     return view; 
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		 if (getActivity().findViewById(R.id.news_content_layout)!=null){ 

	            isTwoPane = true; // �����ҵ�news_content_layout����ʱ��Ϊ˫ҳģʽ 
	        }else { 

	            isTwoPane = false; // �Ҳ���news_content_layout����ʱ��Ϊ��ҳģʽ 
	        } 
	}

	
	

	   
	
	private List<News> getNews() {
		   List<News> newsList = new ArrayList<News>(); 
		   News news1 = new News(); 

           news1.setTitle("����1"); 
           news1.setContent("����1��College freshmen will soon learn to live with a roommate,adjusttoanewsocialsceneandsurviveless-than-stellar dininghallfood.Studentswithlearningdisabilitieswillfacethese transitions while also grappling with a few more hurdles."); 
           newsList.add(news1); 

           News news2 = new News(); 
           news2.setTitle("����2"); 
           news2.setContent("����2China'sXiaomihaspoached akeyGoogleexecutive involvedinthetechgiant'sAndroidphones,inamove seenasacoup for the rapidly growing Chinese smartphone maker."); 
           newsList.add(news2); 

           return newsList; 
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		News news = newsList.get(position); 
		 if (isTwoPane) { 
	            // �����˫ҳģʽ����ˢ��NewsContentFragment�е����� 

	            NewsContentFragment newsContentFragment= (NewsContentFragment) 
	                    getFragmentManager().findFragmentById(R.id.news_content_fragment); 
	            newsContentFragment.refresh(news.getTitle(),news.getContent()); 

	        }else { 
	            // ����ǵ�ҳģʽ����ֱ������NewsContentActivity 

	            NewsContentActivity.actionStart(getActivity(), news.getTitle(), 
	news.getContent()); 

	        } 
	}

}
