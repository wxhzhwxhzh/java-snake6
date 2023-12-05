package com.zetcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import com.zetcode.MyUtil.Config;
import com.zetcode.MyUtil.DynamicTextDraw;
import com.zetcode.MyUtil.Location;
import com.zetcode.MyUtil.MyFont;
import com.zetcode.MyUtil.Sound;
import com.zetcode.MyUtil.TextPool;

public class ApplePool {

    // 存储所有苹果的列表
    public static ArrayList<Apple> apples = new ArrayList<>();
    public static final int MaxPoolLength = 500;
    public static boolean shouldShowInfo=false;
    public static int[]  head={0,0};

    // 初始化ApplePool，填充苹果池
    static {
        for (int i = 0; i < MaxPoolLength; i++) {
            apples.add(new Apple().reset());
        }

        // 添加一个拥有超级能力的苹果
        Apple theOne = new Apple();
        theOne.isVisible=true;
        theOne.setImg(Config.AppleImg1);
        apples.add(theOne);

        SuperApple theSuperONe=new SuperApple(); 
        theSuperONe.isVisible=true;       
        apples.add(theSuperONe);


        
    }



    // 向苹果池中添加一个苹果
    public static void add(int x, int y) {
        for (Apple apple : apples) {
            if (!apple.isVisible) {
                apple.x = x;
                apple.y = y;
                apple.isVisible = true;
                break;
            }
        }
    }

    // 从苹果池中移除一个苹果
    public static void sub(int x, int y) {
        for (Apple apple : apples) {
            if (apple.isVisible && apple.x == x && apple.y == y) {
                apple.reset();
                break;
            }
        }
    }

    // 绘制所有苹果
    public static void drawBody(Graphics g, ImageObserver thisofclass) {
        for (Apple apple : apples) {
            if (apple.isVisible ) {
                apple.drawBody(g, thisofclass);
            }
        }
    }

    // 获取拥有超级能力的苹果
    public static Apple getTheSuperApple() {
        for (Apple apple : apples) {
            if (apple instanceof SuperApple) {
                return apple;
            }
        }
        return null;
    }

    // 获取所有苹果的位置信息
    public static ArrayList<Location> getAllAppleLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.isVisible) {
                locations.add(new Location(apple.x, apple.y));
            }
        }
        return locations;
    }



    // 获取所有苹果信息
    public static String AllAppleInfo() {
        int i = 0;
        for (Apple apple : apples) {
            if (apple.shouldShow()) {
                i++;
            }
        }
        return " Apples:" + i;
    }

    // 检查蛇是否吃到了苹果
    public static void checkAppleSnake(SnakePool sp) {
        for (Snake s : sp.snakes) {
            for (Apple a : apples) {
                if (s.isVisible && a.isVisible && s.x[0]==a.x && s.y[0]==a.y  ) {
                    Sound.play(Config.EatPill);
                    head = a.head();
                    shouldShowInfo = true;
                    // TextPool.add(" Apple eaten ("+a.x+"," +a.y+")", a.x, a.y,Color.red);
                    Font f=new Font(MyFont.getRandomFontFace(), Font.ITALIC, 15);
                    TextPool.add(new DynamicTextDraw().content("Eaten apple ("+a.x+"," +a.y+")").pos(a.x, a.y).setColor(Color.ORANGE).setFont(f));

                    a.reset();
                    s.ToGrow();
                }
            }
        }
    }

    
    public static ArrayList<Apple> ALLVisibleApples() {
        ArrayList<Apple> VS = new ArrayList<>();
        for (Apple app : apples) {
            if (app.isVisible) {
                VS.add(app);
            }
        }
        return VS;
    }

   


}
