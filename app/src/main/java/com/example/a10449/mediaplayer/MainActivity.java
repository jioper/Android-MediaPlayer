package com.example.a10449.mediaplayer;

import android.media.CamcorderProfile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar mSeekBar;
    private Button mClose;
    private Button mplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //设置相关事件
        initEvent();
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
                //静止
            }
        });
        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //播放或者暂停
            }
        });
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭按钮被点击
            }
        });
    }
    private void initView(){
        mSeekBar=(SeekBar)this.findViewById(R.id.seek_bar);
        mplay=(Button)this.findViewById(R.id.play_btn);
        mClose=(Button)this.findViewById(R.id.close_btn);

    }
}
