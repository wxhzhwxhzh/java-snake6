package com.zetcode.MyUtil;

import java.awt.Color;

public class SuperTextDraw extends TextDraw {
    {
        isForever = true;
        content="456";
        c1 = Color.red;
        c2 = Color.gray;
    }
   


    @Override
    public void draw() {

        Config.g.setFont(this.f);

        int y = 0;
        for (String s : content.split("--")) {
            Config.g.setColor(this.c);
            Config.g.drawString(s, positionX + y, positionY);
            y = y + s.length() * 10;

            if (c == c1) {
                c = c2;
            } else {
                c = c1;
            }

        }

        c=c1;

    }





}
