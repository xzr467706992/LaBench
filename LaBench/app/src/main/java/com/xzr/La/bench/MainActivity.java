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


public class MainActivity extends Activity 
{
	AlertDialog dia;
	View result;
	TextView t1;
	SharedPreferences sp;
	SharedPreferences.Editor se;
	boolean bb;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		t1=(TextView)findViewById(R.id.mainTextView1);
		AVObject todo = AVObject.createWithoutData("info", "593cf4b3da2f6000671fcff3");
        todo.fetchInBackground(new GetCallback<AVObject>() {
				@Override
				public void done(AVObject avObject,AVException ge) {
					if(ge==null){
						t1.setText(avObject.getString("gg"));
					}
					else{
					    t1.setText("获取公告失败");
						
					}
					}
					});
}




public void start(View v){
	startActivity(new Intent(getApplicationContext(),run.class));
	
}
public void history(View v){
	startActivity(new Intent(getApplicationContext(),result.class));
}
public void about(View v){
	new AlertDialog.Builder(this)
		.setTitle("关于")
		.setMessage("作者:酷安@xzr46770692 \n 这是一个为你的设备进行性能测试的工具。免费。无交易。只为你提供更准确的评测。")
		.setNegativeButton("评分/更新",new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface ddd,int which){
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW);
					//参数是应用程序的包名
					intent.setData(Uri.parse("market://details?id=" + getPackageName()));
					//通过隐式意图激活activity
					startActivity(intent);
				} catch (ActivityNotFoundException e) {
					Toast.makeText(getApplicationContext(), "抱歉，你没有安装应用市场", Toast.LENGTH_LONG).show();
				}
}})
		.create()
		.show();
}
public void best(View v){
	Toast.makeText(getApplicationContext(),"此功能将在我收集到足够数据后开启",Toast.LENGTH_SHORT).show();
}

}
