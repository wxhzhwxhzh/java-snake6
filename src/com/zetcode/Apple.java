package com.zetcode;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

import com.zetcode.MyUtil.Config;

public class Apple {

    int x;
    int y;
    boolean isVisible=false;
    // boolean hasSuperPower=false;
    ImageIcon iia = new ImageIcon(Config.AppleImg);
    Image AppleImg = Config.NormalAppleImg;



    public Apple(){
        reborn();
    }

    public Apple(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void setImg(String img){
        this.AppleImg=new  ImageIcon(img).getImage();
    }
    


    public void drawBody(Graphics g, ImageObserver thisofclass) {
        g.drawImage(this.AppleImg, this.x, this.y, thisofclass);
    }
    

    public void reborn() {

        int r = (int) (Math.random() * Config.RAND_POS_x);
        x = ((r * Config.DOT_SIZE));

        r = (int) (Math.random() * Config.RAND_POS_y);
        y = ((r * Config.DOT_SIZE));
        // System.out.println(" "+this.x+" "+this.y);
        
    }

    public Apple  reset(){
        this.x=-1;
        this.y=-1;
        this.isVisible=false;
        return this;
    }

    
    public String Stautus(){
        return " apple:"+this.x+","+this.y+" ";
    }
    public int[] head() {
        int[] result = {this.x, this.y};
        return result;
    }
 
    public String headToString() {
        return Integer.toString(x) + Integer.toString(y);
    }

    public  int[]  zuobiao(){
        int[]  a={this.x,this.y};
        // int[]  b={this.x,this.y};
        // boolean areEqual = Arrays.equals(a,a);
        return a;
    }


    public boolean shouldShow(){
        return this.isVisible ;
    };
}
