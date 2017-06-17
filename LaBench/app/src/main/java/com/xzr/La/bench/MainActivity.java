package com.xzr.La.bench;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.lang.*;
import java.io.*;
import android.net.*;
import android.content.*;
import android.content.pm.*;
import android.content.pm.PackageManager.*;
import java.util.concurrent.*;
import java.util.*;
import android.graphics.*;
import android.content.res.*;
import android.util.*;
import com.avos.avoscloud.*;
import android.widget.AdapterView.*;


public class MainActivity extends Activity 
{
	AlertDialog about;
	AlertDialog dia;
	AlertDialog jz;
	View result;
	TextView t1;
	int code=0;
	String url;
	SharedPreferences sp;
	SharedPreferences.Editor se;
	boolean bb;
	String gg="获取公告失败";
	String ggt="公告";
	ListView list;
	List<HashMap<String,String>> builder;
	public long getVersionCode(){
        PackageManager manager = getPackageManager();//获取包管理器
        try {
            //通过当前的包名获取包的信息
            PackageInfo info = manager.getPackageInfo(getPackageName(),0);//获取包对象信息
            return  info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initing);
		
		builder=new ArrayList<HashMap<String,String>>();
		AVObject todo = AVObject.createWithoutData("info", "593cf4b3da2f6000671fcff3");
        todo.fetchInBackground(new GetCallback<AVObject>() {
				@Override
				public void done(AVObject avObject,AVException ge) {
					setContentView(R.layout.main);
					list=(ListView)findViewById(R.id.mainListView1);
					if(ge==null){
						
						gg=avObject.getString("gg");
						ggt=avObject.getString("ggt");
						code=avObject.getInt("update_code");
						url=avObject.getString("update_url");
					}
					refresh();
					}
					});
}


public void refresh(){
	about=new AlertDialog.Builder(this)
		.setTitle("关于")
		.setMessage("作者:酷安@xzr46770692 \n 这是一个为你的设备进行性能测试的工具。免费。无交易。只为你提供更准确的评测。")
		.setNegativeButton("吼吼吼",null)
		.create();
	jz=new AlertDialog.Builder(this)
		.setTitle("捐赠")
		.setMessage("这不是必要的，开发只是我的业余爱好。捐赠采用不留名方式，原因是我没时间处理那么多的名字。并且，即使你捐赠了，由于我要上学，我也不能保证这个软件能经常得到更新。如果你确定要捐赠，触摸以下按钮。")
		.setNeutralButton("算了",null)
		.setNegativeButton("支付宝",new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface d1,int d2){
				try{
					new File("/mnt/sdcard/Pictures").mkdirs();
					File file=new File("/mnt/sdcard/Pictures/捐赠_支付宝.png");
					InputStream ins = getResources().openRawResource(R.drawable.zfb);// 通过raw得到数据资源  
					//  开始读入
					FileOutputStream fos = new FileOutputStream(file);  
					// 开始写出
					byte[] buffer = new byte[8192];  
					int count = 0;// 循环写出  
					while ((count = ins.read(buffer)) > 0) {  
						fos.write(buffer, 0, count);  
					}  
					Toast.makeText(getApplicationContext(),"二维码已输出到/sdcard/Pictures 捐赠方式:支付宝扫一扫>从相册选取二维码 ",Toast.LENGTH_LONG).show();
					fos.close();// 关闭流  
					ins.close();  
				}
				catch(Exception e){
					Toast.makeText(getApplicationContext(),"你可能干了一些坏事",Toast.LENGTH_SHORT).show();
				}
				
			}
		})
		.setPositiveButton("微信",new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface d1,int d2){
				try{
					new File("/mnt/sdcard/Pictures").mkdirs();
					File file=new File("/mnt/sdcard/Pictures/捐赠_微信.png");
					InputStream ins = getResources().openRawResource(R.drawable.wx);// 通过raw得到数据资源  
					//  开始读入
					FileOutputStream fos = new FileOutputStream(file);  
					// 开始写出
					byte[] buffer = new byte[8192];  
					int count = 0;// 循环写出  
					while ((count = ins.read(buffer)) > 0) {  
						fos.write(buffer, 0, count);  
					}  
					Toast.makeText(getApplicationContext(),"二维码已输出到/sdcard/Pictures 捐赠方式:微信扫一扫>从相册选取二维码 ",Toast.LENGTH_LONG).show();
					fos.close();// 关闭流  
					ins.close();  
				}
				catch(Exception e){
					Toast.makeText(getApplicationContext(),"你可能干了一些坏事",Toast.LENGTH_SHORT).show();
				}

			}
		})
		.create();
	HashMap<String,String> map1=new HashMap<String,String>();
	map1.put("title",ggt);
	map1.put("subtitle",gg);
	builder.add(map1);
	HashMap<String,String> map2=new HashMap<String,String>();
	map2.put("title","测试");
	map2.put("subtitle","触摸来开始测试设备的性能");
	builder.add(map2);
	HashMap<String,String> map3=new HashMap<String,String>();
	map3.put("title","上次测试的结果");
	map3.put("subtitle","查看上次测试的结果");
	builder.add(map3);
	HashMap<String,String> map4=new HashMap<String,String>();
	map4.put("title","最强硬件");
	map4.put("subtitle","查看一些极为先进的设备");
	builder.add(map4);
	HashMap<String,String> map5=new HashMap<String,String>();
	map5.put("title","更新");
	if(getVersionCode()<code){
		map5.put("subtitle","发现新版本，触摸此处下载");
		new AlertDialog.Builder(this)
		.setTitle("新的更新！")
		.setMessage("触摸页面下方的“更新”来下载")
		.setPositiveButton("好的",null)
		.setCancelable(false)
		.create()
		.show();
	}
	else{
		map5.put("subtitle","已是最新版本");
	}
	
	builder.add(map5);
	HashMap<String,String> map6=new HashMap<String,String>();
	map6.put("title","评分");
	map6.put("subtitle","跳转到应用商店为本应用评分");
	builder.add(map6);
	HashMap<String,String> map7=new HashMap<String,String>();
	map7.put("title","关于");
	map7.put("subtitle","关于这个应用程序");
	builder.add(map7);
	HashMap<String,String> map8=new HashMap<String,String>();
	map8.put("title","捐赠");
	map8.put("subtitle","不留名捐赠，支持开发。");
	builder.add(map8);
	SimpleAdapter a=new SimpleAdapter(this,builder,R.layout.list,new String[]{"title","subtitle"},new int[]{R.id.title,R.id.subtitle});
	list.setAdapter(a);
	OnItemClickListener mItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
			if(arg2==1){
				startActivity(new Intent(getApplicationContext(),run.class));
			}
			if(arg2==2){
				startActivity(new Intent(getApplicationContext(),history.class));
			}
			if(arg2==3){
				startActivity(new Intent(getApplicationContext(),world.class));
			}
			if(arg2==4){
				if(getVersionCode()<code){
				Intent intent = new Intent();        
				intent.setAction("android.intent.action.VIEW");    
				Uri content_url = Uri.parse(url);   
				intent.setData(content_url);  
				startActivity(intent);
				}
				}
				if(arg2==5){
					try {
						Intent intent = new Intent(Intent.ACTION_VIEW);
						//参数是应用程序的包名
						intent.setData(Uri.parse("market://details?id=" + getPackageName()));
						//通过隐式意图激活activity
						startActivity(intent);
					} catch (ActivityNotFoundException e) {
						Toast.makeText(getApplicationContext(), "抱歉，你没有安装应用市场", Toast.LENGTH_LONG).show();
					}
				}
				if(arg2==6){
					
						about.show();
				}
				if(arg2==7){
					jz.show();
				}
			}
		
	};

	list.setOnItemClickListener(mItemClickListener);
}





}
