package com.zetcode.MyUtil;

import java.util.ArrayList;

public class Sound implements Runnable {

    private ArrayList<String> paths = new ArrayList<>();

    // 通过新线程播放声音
    public static void play(String... s) {

        new Thread(new Sound(s)).start();

    }
    
    public static Thread play(Sound s) {
        
        Thread aa;
        aa=new Thread(Config.group,s);
        
        aa.start();
        
        return aa;

    }

    // 构造函数的重载，接受声音文件路径参数
    public Sound(String... n) {
        for (String string : n) {
            this.paths.add(string);
        }
    }

    // 默认构造函数，使用默认配置的背景音乐路径
    public Sound() {
        this.paths.add(Config.BGM);
    }

    // 设置声音路径，支持链式调用
    public Sound setPath(String n) {
        this.paths.clear(); // 清空已有路径
        this.paths.add(n);
        return this;
    }

    // 添加声音路径，支持链式调用
    public Sound addPath(String n) {
        this.paths.add(n);
        return this;
    }

    // run方法重写，用于播放声音
    @Override
    public void run() {
        for (String p : paths) {
            Tools.playMP3File(p);
        }
        return;
    }
}
