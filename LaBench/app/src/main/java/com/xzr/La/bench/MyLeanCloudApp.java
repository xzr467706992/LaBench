package com.xzr.La.bench;
import android.app.*;
import com.avos.avoscloud.*;

public class MyLeanCloudApp extends Application
{
	@Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"iEjSB6Ty50VQOSKnaroP63Xc-gzGzoHsz","qjJBNdnMrLBj0zncaw74aAcI");
    }
}
