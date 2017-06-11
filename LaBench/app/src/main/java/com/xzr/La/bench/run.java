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
	boolean bb=false;
	int b;
	
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
        setContentView(R.layout.run);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		sp=getSharedPreferences("main",0);
		se=sp.edit();
		new halder().start();
		}
		public class halder extends Thread{
			public void run(){
			
				Log.i("info","haldered");
				bb=false;
				
				new fdb().start();
				new timer().run();
				bb=false;
				
				new zsb().start();
				new timer2().run();
				b=0;
				
				for(int i=1;i<=10;i++){
					new fdmb().start();
				}
				new timerm().run();
				b=0;
				
				for(int i=1;i<=10;i++){
					new zsmb().start();
				}
				new timerm2().run();
				bb=false;
				new io().start();
				new iotimer().run();
				runOnUiThread(new Runnable(){
						public void run(){
							AVObject a=new AVObject("score");
							a.put("brand",android.os.Build.BRAND);
							a.put("model",android.os.Build.MODEL);
							a.put("android",android.os.Build.VERSION.RELEASE);
							
							a.put("sf",sp.getInt("fds",0));
						
							a.put("si",sp.getInt("zss",0));
							
							a.put("mf",sp.getInt("fdms",0));
						
							a.put("mi",sp.getInt("zsms",0));
							
							a.put("io",sp.getInt("io",0));
							int z=sp.getInt("fds",0)+sp.getInt("zss",0)*7+sp.getInt("fdms",0)+sp.getInt("zsms",0)+sp.getInt("io",0)*10;
							
							a.put("all",z);
							a.saveInBackground(new SaveCallback() {
									@Override
									public void done(AVException e) {
										if(e != null){
											Toast.makeText(getApplicationContext(),"上传到数据库失败",Toast.LENGTH_SHORT).show();
										}
									}
								});
							startActivity(new Intent(getApplicationContext(),result.class));
							
							
							finish();

	
						}
					});
			}

			public class iotimer extends Thread{
				public void run(){
					long time=0;
					while(true){
						if(bb){
							double ti=(double)time/1000;
							double speed=250/ti;
							double ls=speed*10;
							se.putInt("io",(int)ls);
							se.commit();
							File f=new File("/mnt/sdcard/test");
							f.delete();
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
				BufferedReader b=new BufferedReader(new InputStreamReader(p.getInputStream()));
				b.readLine();
				bb=true;
			}
			catch (IOException e)
			{}

		}
	}
	public class fdb extends Thread{
		

		public void run(){
			
			double k2=Math.random()*10+1;
			double t2=Math.random()*10+1;
			
			for(long i=0;i<1000000000;i++){
					
				k2=k2+1/Math.sqrt(t2);
				t2=t2+1;
}
			System.out.println(k2);
			System.out.println(t2);
			bb=true;
			Log.i("info","stopped");

		}
	}
	public class fdmb extends Thread{


		public void run(){
			
			double k2=Math.random()*10+1;
			double t2=Math.random()*10+1;

			for(long i=0;i<100000000;i++){

				k2=k2+1/Math.sqrt(t2);
				t2=t2+1;
			}
			System.out.println(k2);
			System.out.println(t2);
			b++;
			Log.i("info",k2+"");
			Log.i("info",t2+"");
		}
	}
	public class zsb extends Thread{
		public void run(){
			
			long k=(long)(Math.random()*10+1);
			long t=(long)(Math.random()*10+1);
			long s=0;
			for(long i=0;i<1000000000;i++){
				if(s<-50000000){
					s=s+k+t;
				}
				else{
				if(s>50000000){
					s=s-k-t;
				}
				else{
					s=s+k-t;
				}
			}
			
			}
			System.out.println(k);
			System.out.println(t);
			System.out.println(s);
			bb=true;
		}
	}
	public class zsmb extends Thread{
		public void run(){
			
			long k=(long)(Math.random()*10+1);
			long t=(long)(Math.random()*10+1);
		    long s=0;
			
			for(long i=0;i<100000000;i++){
				if(s<-50000000){
					s=s+k+t;
				}
				else{
					if(s>50000000){
						s=s-k-t;
					}
					else{
						s=s+k-t;
					}
				}

			}
			System.out.println(k);
			System.out.println(t);
			System.out.println(s);
			Log.i("info",k+"");
			Log.i("info",t+"");
			Log.i("info",s+"");
			b++;
		}
	}
	public class timer extends Thread{
		public void run(){
			
		long time=0;
		while(true){
			try
			{
				Thread.sleep(1);
			}
			catch (InterruptedException e)
			{}
			if(bb){
				se.putInt("fds",(int)(60000/((double)time/1000)));
				se.commit();
				break;
			}
			
			time++;
		}

		}
	}
	public class timer2 extends Thread{
		public void run(){

			long time=0;
			while(true){
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{}
				if(bb){
					se.putInt("zss",(int)(50000/((double)time/1000)));
					se.commit();
					break;
				}

				time++;
			}

		}
	}
	public class timerm extends Thread{
		public void run(){

			long time=0;
			while(true){
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{}
				if(b==10){
					se.putInt("fdms",(int)(60000/((double)time/1000)));
					se.commit();
					break;
				}

				time++;
			}

		}
	}
	public class timerm2 extends Thread{
		public void run(){

			long time=0;
			while(true){
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{}
				if(b==10){
					se.putInt("zsms",(int)(50000/((double)time/1000)));
					se.commit();
					break;
				}

				time++;
			}

		}
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
