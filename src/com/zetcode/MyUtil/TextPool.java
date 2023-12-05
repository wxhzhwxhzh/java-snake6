package com.zetcode.MyUtil;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class TextPool {
    public static ArrayList<TextDraw> TP = new ArrayList<>();
    
    static TextDraw ShowTitle = new SuperTextDraw();

    static {
        

        
        TextPool.add(TextFactory.getTitleText());
        TextPool.add(TextFactory.HelpText);
        TextPool.add(TextFactory.PauseText);
        TextPool.add(TextFactory.StatusBarText);
        TextPool.add(TextFactory.KeyText);
        // TP.forEach(t->System.out.println(t.fontFace));
        
   
    }

    public static void add(String c, int x, int y) {

        TP.add(new TextDraw().content(c).pos(x, y).setVisible(true).finishConfig());
        scan();

    }
    public static void add(String s, int x,int y, Color c) {

        TP.add(new TextDraw().content(s).pos(x, y).setVisible(true).setColor(c).finishConfig());
        scan();

    }

    // public static void add(String c, int x, int y, int size) {

    //     TP.add(new TextDraw().content(c).pos(x, y).setVisible(true).fontSize(size).finishConfig());
    //     scan();
    // }
    public static void add(TextDraw td) {

        TP.add(td);
        // scan();
    }



    private static void scan() {
        if (TP.size() > 20) {
            for(int i=0 ;i<10;i++){
                if(!(TP.get(i).isForever)){
                    TP.remove(i);
                }

            }
            // List<DrawTextObj> subList = TP.subList(0, 3);
            // TP.removeAll(subList);
            
            TextPool.printMySelf();

        }
    }

    private static void printMySelf() {

        TP.stream().forEach(t->System.out.println("当前对象内容是： "+t.content));
        System.out.println("当前textpool的长度是 " + TP.size());

    }

    public static void draw() {

        TP.forEach(t -> { if (t.delay > 0)  t.draw(); });
    }

}
