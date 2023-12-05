package com.zetcode.MyUtil;

import java.awt.Color;

public class TextFactory {

    // 状态栏 静态变量
    public static TextDraw StatusBarText = new TextDraw();
    static {
        StatusBarText.fontSize(15).FontFace(Config.RandomFontFace).setForever(true).setBold(true);

        StatusBarText.finishConfig();
    }

    // 按键信息 静态变量
    public static TextDraw KeyText = new ColorTextDraw();
    static {
        KeyText.fontSize(20).FontFace("宋体").setBold(true).delay(50);
        KeyText.pos(Config.B_WIDTH/2-200,Config.B_HEIGHT-200);
        KeyText.content(".");
        KeyText.config("宋体  blue  30 delay:800 ");
        KeyText.finishConfig();
    }

    // 暂停信息
    public static TextDraw PauseText = new TextDraw();
    static {
        PauseText.fontSize(25).FontFace("宋体").setVisible(true).setBold(true);
        PauseText.content("GAME PAUSE!  -"+ Config.RandomFontFace).setColor(Color.blue).pos(Config.B_WIDTH / 2 - 100, Config.B_HEIGHT / 2 - 100)
                .finishConfig();
        PauseText.delay = -1;
        PauseText.isForever = true;
    }

    // 帮助信息
    public static TextDraw HelpText = new TextDraw();
    static {
        HelpText.fontSize(15).FontFace("楷体").setVisible(true).setBold(true);
        HelpText.content(Config.Help).setColor(Color.green).pos(100, 400).finishConfig();
        HelpText.delay = -1;
        HelpText.isForever = true;
    }




    // 简单工厂设计模式
    public static TextDraw getRandomText() {
        TextDraw td = new TextDraw();

        return td;
    }

    public static TextDraw getText(int x, int y, String s) {
        TextDraw td = new TextDraw();
        td.content(s).pos(x, y).fontSize(20).setVisible(true).delay(40);
        td.fontFace="微软雅黑";
        td.finishConfig();
        return td;
    }
    public static TextDraw getText2(int x, int y, String s) {
        TextDraw td = new TextDraw();
        td.content(s).pos(x, y).fontSize(20).setVisible(true).delay(40).Color("red");
        td.fontFace="微软雅黑";
        td.finishConfig();
        return td;
    }

    // 标题
    public static TextDraw getTitleText() {
        TextDraw ShowTitle = new SuperTextDraw();
        ShowTitle.content(" 蛇 了 个 蛇 "+Config.RandomFontFaceCN).pos(Config.B_WIDTH / 2 - 200, 50).fontSize(40);
        ShowTitle.setVisible(true).delay(30).FontFace(Config.RandomFontFaceCN);
        ShowTitle.finishConfig();
        return ShowTitle;
    }




}
