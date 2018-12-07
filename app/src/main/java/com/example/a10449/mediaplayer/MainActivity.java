package com.example.a10449.mediaplayer;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.CamcorderProfile;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SeekBar mSeekBar;
    private Button mClose;
    private Button mplay;
    private PlayerConnection mPlayerConnection;
    private PlayerControl mPlayerConntrol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //设置相关事件
        initEvent();
        //开启服务
        initService();
        //绑定服务
        initBindService();
    }
//开启服务
    private void initService() {
        Log.d(TAG,"initService");
        startService(new Intent(this,PlayerService.class));
    }
//绑定服务
    private void initBindService() {
        Log.d(TAG,"initBindService");
        Intent intent=new Intent(this,PlayerService.class);
        if(mPlayerConnection==null)
        {
            mPlayerConnection=new PlayerConnection();
        }
        bindService(intent, (ServiceConnection) mPlayerConnection,BIND_AUTO_CREATE);
    }
    private class PlayerConnection implements ServiceConnection{
        public void onServiceConnected(ComponentName name,IBinder service){
            Log.d(TAG,"onServiceConnected-->"+service);
            PlayerControl playerControl=(PlayerControl) service;
        }
        public void onServiceDisconnected(ComponentName name){
            Log.d(TAG,"onServiceDisconnected");
            mPlayerConntrol=null;
        }


    }
    private void initEvent(){
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //进度条发生改变
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //手触摸
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //停止拖动
                int touchProgress=seekBar.getProgress();
                Log.d(TAG,"touchProgress-->"+touchProgress);
                if (mPlayerConntrol != null) {
                    mPlayerConntrol.seekTo(touchProgress);
                }
            }
        });
        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //播放或者暂停
                if(mPlayerConntrol!=null) {
                    mPlayerConntrol.playorpause();
                }
            }
        });
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭按钮被点击
                if(mPlayerConntrol!=null) {
                    mPlayerConntrol.stop();
                }
            }
        });
    }
    private void initView(){
        mSeekBar=(SeekBar)this.findViewById(R.id.seek_bar);
        mplay=(Button)this.findViewById(R.id.play_btn);
        mClose=(Button)this.findViewById(R.id.close_btn);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayerConnection != null) {
            Log.d(TAG,"unbind service-->onDestroy");
            unbindService(mPlayerConnection);
        }
    }
}
