package com.zetcode;
import java.awt.Image;
import javax.swing.ImageIcon;

import com.zetcode.MyUtil.Config;

public class Head {


    public String headDirection="up";
    private ImageIcon h1 = new ImageIcon(Config.up);
    private ImageIcon h2 = new ImageIcon(Config.down);
    private ImageIcon h3 = new ImageIcon(Config.right);
    private ImageIcon h4 = new ImageIcon(Config.left);
    private ImageIcon t1 = new ImageIcon(Config.tail1);
    private  Image head=h1.getImage();
    public Image tail=t1.getImage();
    



    public Image loadImages(boolean a, boolean b,boolean c, boolean d) {
        if(a) return h1.getImage();
        if(b) return h2.getImage();
        if(c) return h3.getImage();
        if(d) return h4.getImage();
        return head;

    }
}
