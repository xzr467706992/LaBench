package com.xzr.La.bench;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import com.avos.avoscloud.*;
import java.io.*;

public class run extends Activity
{
	SharedPreferences sp;
	SharedPreferences.Editor se;
	boolean b=false;
	ProgressBar pp;
	int score;
	double c1=0;
	boolean bb=false;
	double p1=0;
	double n1;
	int c2=0;
	int p2=0;
	int n2;
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
	public void clear(){
		score=0;
		b=false;
	}
	public void stopall(){
		runOnUiThread(new Runnable(){
			public void run(){
				startActivity(new Intent(getApplicationContext(),result.class));
				finish();
			}
		});
	}
	@Override
	
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.run);

		pp=(ProgressBar)findViewById(R.id.runProgressBar1);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		sp=getSharedPreferences("main",0);
		se=sp.edit();
		new handler().start();
		}
		public class handler extends Thread{
			public void run(){
				clear();
				pp.incrementSecondaryProgressBy(1);
				new fdb().start();
				new timer().run();
				se.putInt("fds",score);
				se.commit();
				pp.incrementProgressBy(1);
				pp.incrementSecondaryProgressBy(1);
				clear();
				new zsb().start();
				new timer().run();
				se.putInt("zss",score);
				se.commit();
				pp.incrementProgressBy(1);
				pp.incrementSecondaryProgressBy(1);
				clear();
				for(int i=1;i<=10;i++){
					new fdb().start();
				}
				new timer().run();
				se.putInt("fdms",score);
				se.commit();
				pp.incrementProgressBy(1);
				pp.incrementSecondaryProgressBy(1);
				clear();
				for(int i=1;i<=10;i++){
					new zsb().start();
				}
				new timer().run();
				se.putInt("zsms",score);
				se.commit();
				pp.incrementProgressBy(1);
				
				clear();
				new io().start();
				new iotimer().run();
				save();
				stopall();
			}
		}
		public class timer extends Thread{
			public void run(){
				try
				{
					Thread.sleep(10000);
				}
				catch (InterruptedException e)
				{}
				b=true;
			}
		}
		
	public class fdb extends Thread{
		public void run(){
			double p;
			double q;
			double k;
			double i;
			double r;
			double m;
			double n;
			double o;
			double mi=0;
			double cache=0;
			while(!b){
				p=Math.random()*88+1;
				q=Math.random()*100+500;
				for(int z=0;z<=8000;z++){
					k=Math.pow(p,9);
					i=Math.pow(q,1/9);
					r=p*q;
					m=Math.sin(p*Math.PI/180);
					n=Math.cos(p*Math.PI/180);
					o=Math.tan(p*Math.PI/180);


					mi=p+q*m+k-i*n+o;

				}
				cache=cache+mi;
				score++;

			}
		}
	}
		public class zsb extends Thread{
			public void run(){
				
				int p;
				int q;
				int k;
				int i;
				int r;
				int m;
				int n;
				int o;
				int mi=0;
				int cache=0;
				while(!b){
					p=(int)Math.random()*88+1;
					q=(int)Math.random()*100+500;
					for(int z=0;z<=8000;z++){
						k=(int) Math.pow(p,9);
						i=(int) Math.pow(q,1/9);
						r=p*q;
						m=(int) Math.sin(p*Math.PI/180);
						n=(int) Math.cos(p*Math.PI/180);
						o=(int) Math.tan(p*Math.PI/180);


						mi=p+q*m+k-i*n+o;

					}
					cache=cache+mi;
					score++;

				}
			}
		}
		public void save(){
			AVObject todo = AVObject.createWithoutData("zqyj", "5951fc40fe88c2005fa71aaf");
			todo.fetchInBackground(new GetCallback<AVObject>() {
					@Override
					public void done(AVObject avObject,AVException ge){
						if(ge==null){
							int z=(sp.getInt("fds",0)+sp.getInt("zss",0))*4+sp.getInt("fdms",0)+sp.getInt("zsms",0)+(sp.getInt("io",0))*2;
							if(avObject.getInt("no1")<z){
								avObject.put("no5",avObject.getInt("no4"));
								avObject.put("no5_model",avObject.getString("no4_model"));
								avObject.put("no5_brand",avObject.getString("no4_brand"));
								
								avObject.put("no4",avObject.getInt("no3"));
								avObject.put("no4_model",avObject.getString("no3_model"));
								avObject.put("no4_brand",avObject.getString("no3_brand"));
								
								avObject.put("no3",avObject.getInt("no2"));
								avObject.put("no3_model",avObject.getString("no2_model"));
								avObject.put("no3_brand",avObject.getString("no2_brand"));
								
								avObject.put("no2",avObject.getInt("no1"));
								avObject.put("no2_model",avObject.getString("no1_model"));
								avObject.put("no2_brand",avObject.getString("no1_brand"));
								
								avObject.put("no1",z);
								avObject.put("no1_model",android.os.Build.MODEL);
								avObject.put("no1_brand",android.os.Build.BRAND);
								
								avObject.saveInBackground();
							}
							else{
								if(avObject.getInt("no2")<z){
									avObject.put("no5",avObject.getInt("no4"));
									avObject.put("no5_model",avObject.getString("no4_model"));
									avObject.put("no5_brand",avObject.getString("no4_brand"));
									
									avObject.put("no4",avObject.getInt("no3"));
									avObject.put("no4_model",avObject.getString("no3_model"));
									avObject.put("no4_brand",avObject.getString("no3_brand"));
									
									avObject.put("no3",avObject.getInt("no2"));
									avObject.put("no3_model",avObject.getString("no2_model"));
									avObject.put("no3_brand",avObject.getString("no2_brand"));
									
									avObject.put("no2",z);
									avObject.put("no2_model",android.os.Build.MODEL);
									avObject.put("no2_brand",android.os.Build.BRAND);
									
									avObject.saveInBackground();
								}
								else{
									if(avObject.getInt("no3")<z){
										avObject.put("no5",avObject.getInt("no4"));
										avObject.put("no5_model",avObject.getString("no4_model"));
										avObject.put("no5_brand",avObject.getString("no4_brand"));
										
										avObject.put("no4",avObject.getInt("no3"));
										avObject.put("no4_model",avObject.getString("no3_model"));
										avObject.put("no4_brand",avObject.getString("no3_brand"));
										avObject.put("no3",z);
										avObject.put("no3_model",android.os.Build.MODEL);
										avObject.put("no3_brand",android.os.Build.BRAND);
										
										avObject.saveInBackground();
									}
									else{
										if(avObject.getInt("no4")<z){
											avObject.put("no5",avObject.getInt("no4"));
											avObject.put("no5_model",avObject.getString("no4_model"));
											avObject.put("no5_brand",avObject.getString("no4_brand"));
											
											avObject.put("no4",z);
											avObject.put("no4_model",android.os.Build.MODEL);
											avObject.put("no4_brand",android.os.Build.BRAND);

											avObject.saveInBackground();
										}
										else{
											if(avObject.getInt("no5")<z){
												
												avObject.put("no5",z);
												avObject.put("no5_model",android.os.Build.MODEL);
												avObject.put("no5_brand",android.os.Build.BRAND);

												avObject.saveInBackground();
											}
										}
									}
								}
							}
						}
						}
						});
						AVObject a=new AVObject("score_r5");
						a.put("brand",android.os.Build.BRAND);
						a.put("model",android.os.Build.MODEL);
						a.put("android",android.os.Build.VERSION.RELEASE);

						a.put("fds",sp.getInt("fds",0));

						a.put("zss",sp.getInt("zss",0));

						a.put("fdms",sp.getInt("fdms",0));

						a.put("zsms",sp.getInt("zsms",0));

						a.put("io",sp.getInt("io",0));
			        
						int z=(sp.getInt("fds",0)+sp.getInt("zss",0))*4+sp.getInt("fdms",0)+sp.getInt("zsms",0)+(sp.getInt("io",0))*2;
			
						a.put("result",z);
						a.saveInBackground(new SaveCallback() {
								@Override
								public void done(AVException e) {
									if(e != null){
										Toast.makeText(getApplicationContext(),"上传到数据库失败",Toast.LENGTH_SHORT).show();
									}
								}
							});
		
		}
	public class iotimer extends Thread{
		public void run(){
			long time=0;
			while(true){
				if(b){
					double ti=(double)time/1000;
					double speed=250/ti;
					double ls=speed*10;
					File f=new File("/mnt/sdcard/test");
					if(!f.exists()||ls>5000){
					    se.putInt("io",0);
						se.commit();
					}
					else{
						se.putInt("io",(int)ls);
						se.commit();

						f.delete();
					}
					break;
				}
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{}
				time++;
			}
		}
	}
			
	public class io extends Thread{
		public void run(){
			try
			{
				java.lang.Process p=Runtime.getRuntime().exec("dd if=/dev/zero of=/mnt/sdcard/test bs=1024 count=256000");
				BufferedReader j=new BufferedReader(new InputStreamReader(p.getInputStream()));
				j.readLine();
				b=true;
			}
			catch (IOException e)
			{}

		}
	}

	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		Toast.makeText(getApplicationContext(),"结束跑分",Toast.LENGTH_SHORT).show();
		android.os.Process.killProcess(android.os.Process.myPid());   //获取PID 
		 System.exit(0);  
		startActivity(new Intent(getApplicationContext(),MainActivity.class));
	}
		
		}
