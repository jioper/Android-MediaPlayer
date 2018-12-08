package com.example.a10449.mediaplayer;

public interface PlayerControl {
    //播放状态
     int PLAY_STATE_PLAY=1;
     int PLAY_STATE_PAUSE=2;
     int PLAY_STATE_STOP=3;
    //传递UI接口
    void registerViewController(PlayerViewControl viewControl);

    //取消接口通知的注册
    void unRegisterViewController();

    //播放
    void playorpause();

    //停止
    void stop();

    //设置播放进度
    void seekTo(int seek);


}
