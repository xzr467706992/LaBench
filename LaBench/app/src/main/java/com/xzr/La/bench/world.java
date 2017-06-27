package com.xzr.La.bench;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;
import android.util.*;
import java.io.*;
import com.avos.avoscloud.*;

public class world extends Activity
{
	
	ListView list;
	int[] score=new int[10];
	String[] device=new String[10];
	List<HashMap<String,String>> builder;
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
			case android.R.id.home:
				super.onBackPressed();
				break;

			default:
				break;
		}
    	return super.onOptionsItemSelected(item);
    }
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.initing);
		builder=new ArrayList<HashMap<String,String>>();
		getActionBar().setDisplayHomeAsUpEnabled(true);
		AVObject todo = AVObject.createWithoutData("zqyj", "5951f958570c357d06c129a8");
		todo.fetchInBackground(new GetCallback<AVObject>() {
				@Override
				public void done(AVObject avObject,AVException ge){
					if(ge==null){
						for(int i=1 ;i<=5;i++){
							score[i]=avObject.getInt("no"+i);
							device[i]=avObject.getString("no"+i+"_brand")+" "+avObject.getString("no"+i+"_model");
							
						}
						
						}
					refresh();
						}
						});
	}
	public void refresh(){
		setContentView(R.layout.world);
		list=(ListView)findViewById(R.id.worldListView1);
		HashMap<String,String> m1=new HashMap<String,String>();
		m1.put("no","No.1");
		m1.put("score",score[1]+"");
		m1.put("device",device[1]+"");
		builder.add(m1);
		
		HashMap<String,String> m2=new HashMap<String,String>();
		m2.put("no","No.2");
		m2.put("score",score[2]+"");
		m2.put("device",device[2]+"");
		builder.add(m2);
		
		HashMap<String,String> m3=new HashMap<String,String>();
		m3.put("no","No.3");
		m3.put("score",score[3]+"");
		m3.put("device",device[3]+"");
		builder.add(m3);
		
		HashMap<String,String> m4=new HashMap<String,String>();
		m4.put("no","No.4");
		m4.put("score",score[4]+"");
		m4.put("device",device[4]+"");
		builder.add(m4);
		
		HashMap<String,String> m5=new HashMap<String,String>();
		m5.put("no","No.5");
		m5.put("score",score[5]+"");
		m5.put("device",device[5]+"");
		builder.add(m5);
		SimpleAdapter a=new SimpleAdapter(this,builder,R.layout.wl,new String[]{"no","score","device"},new int[]{R.id.no,R.id.score,R.id.device});
		list.setAdapter(a);
		OnItemClickListener mItemClickListener = new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
				
			}
		};
		list.setOnItemClickListener(mItemClickListener);
	}
	}
