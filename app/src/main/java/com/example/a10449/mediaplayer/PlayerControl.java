package com.example.a10449.mediaplayer;

public interface PlayerControl {
    //传递UI接口
    void RegisterViewController(PlayerViewControl viewControl);
    //取消接口通知的注册
    void unRegisterViewController();
    void play();
    void pasuse();
    void resume();
    void stop();
    void seekTo(int seek);
}
