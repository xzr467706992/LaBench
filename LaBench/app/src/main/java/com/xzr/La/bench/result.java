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
import android.content.pm.*;

public class result extends Activity
{
	TextView t;
	TextView t2;
	TextView t3;
	TextView t4;
	TextView t5;
	TextView t6;
	TextView t7;
	TextView t8;
	TextView t9;
	SharedPreferences sp;
	SharedPreferences.Editor se;
	

	public String getVersion() {
		String version = null;
		try {
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			version = info.versionName;

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return version;
	}
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
			case android.R.id.home:
				android.os.Process.killProcess(android.os.Process.myPid());   //获取PID 
				System.exit(0);  
				startActivity(new Intent(getApplicationContext(),MainActivity.class));
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
        setContentView(R.layout.result);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		t=(TextView)findViewById(R.id.resultTextView1);
		t2=(TextView)findViewById(R.id.resultTextView2);
		t3=(TextView)findViewById(R.id.resultTextView3);
		t4=(TextView)findViewById(R.id.resultTextView4);
		t5=(TextView)findViewById(R.id.resultTextView5);
		t6=(TextView)findViewById(R.id.resultTextView6);
		t7=(TextView)findViewById(R.id.resultTextView7);
		t8=(TextView)findViewById(R.id.resultTextView8);
		t9=(TextView)findViewById(R.id.resultTextView9);
		t8.setText("机型："+android.os.Build.BRAND+" "+android.os.Build.MODEL);
		t9.setText("Android："+android.os.Build.VERSION.RELEASE);
		t7.setText("v"+getVersion());
		sp=getSharedPreferences("main",0);
		se=sp.edit();
		
	
		
		t.setText(sp.getInt("fds",0)+"");
		
		t2.setText(sp.getInt("zss",0)+"");
		
		t3.setText(sp.getInt("fdms",0)+"");
		
		t4.setText(sp.getInt("zsms",0)+"");
		
		t5.setText(sp.getInt("io",0)+"");
		int z=(sp.getInt("fds",0)+sp.getInt("zss",0))*4+sp.getInt("fdms",0)+sp.getInt("zsms",0)+(sp.getInt("io",0))*2;
		
				t6.setText(z+"");
		
		
	}

	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		super.onBackPressed();
		android.os.Process.killProcess(android.os.Process.myPid());   //获取PID 
		System.exit(0);  
		startActivity(new Intent(getApplicationContext(),MainActivity.class));
	}
		
		
		}
		
