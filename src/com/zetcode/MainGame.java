package com.zetcode;

import com.zetcode.MyUtil.Config;
import com.zetcode.MyUtil.Sound;
import com.zetcode.MyUtil.Tools;

public class MainGame {
    public static void main(String[] args) {

        if (args != null && args.length > 0) {

            Config.EnemyNumber = Integer.parseInt(args[0]);// 访问和处理 args 数组
        }

        // thread.start();
        new Thread(new SnakeWindow()).start();

        String oneBGM = Tools.selectRandomString(Config.BGM, Config.BGM2);
        System.out.println("背景音乐 -- " + oneBGM);

        Sound sound = new Sound(oneBGM);
        // Config.testtThread=sound;

        Config.testtThread = Sound.play(sound);

    }
}
