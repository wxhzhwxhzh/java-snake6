package com.zetcode.MyUtil;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen {
    private static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();

    // public  Screen() {
    //     Toolkit toolkit = Toolkit.getDefaultToolkit();
    //     screenSize = toolkit.getScreenSize();
    // }
    private static  int roundToNearestTen(int number) {
        return Math.round(number / 10.0f) * 10;
    }

    public static int getWidth() {
        
        return roundToNearestTen(screenSize.width/10*7);
    }

    public  static  int getHeight() {
        return roundToNearestTen(screenSize.height/10*7);
    }
}

