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
	TextView t;
	TextView t2;
	TextView t3;
	TextView t4;
	TextView t5;
	TextView t6;
	SharedPreferences sp;
	SharedPreferences.Editor se;

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
        setContentView(R.layout.result);

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	}
