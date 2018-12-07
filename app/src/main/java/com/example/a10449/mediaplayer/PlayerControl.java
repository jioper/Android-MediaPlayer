package com.example.a10449.mediaplayer;

public interface PlayerControl {
    //传递UI接口
    void RegisterViewController(PlayerViewControl viewControl);
    //取消接口通知的注册
    void unRegisterViewController();
    //播放
    void play();
    //暂停
    void pasuse();
    //继续
    void resume();
    //停止
    void stop();
    //设置播放进度
    void seekTo(int seek);
}
