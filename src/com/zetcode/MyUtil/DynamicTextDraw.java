package com.zetcode.MyUtil;

public class DynamicTextDraw  extends  TextDraw {
    public int  move=0;
    {delay=50;
    }


    @Override
    public void draw() {
        if (delay > 0) {
            Config.g.setColor(this.c);
            Config.g.setFont(this.f);
            Config.g.drawString(this.content, positionX, positionY-move);

            delay--;
            move++;
            if (isForever) delay++;
        }

    }


    
}
