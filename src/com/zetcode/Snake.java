package com.zetcode;

import javax.swing.JPanel;

import com.zetcode.MyUtil.Config;
import com.zetcode.MyUtil.TextDraw;
import com.zetcode.MyUtil.Location;
import com.zetcode.MyUtil.Sound;
import com.zetcode.MyUtil.Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;



public  abstract class  Snake extends JPanel{

    private final int ALL_DOTS = Config.ALL_DOTS;
    public  int x[] = new int[ALL_DOTS];
    public  int y[] = new int[ALL_DOTS];
    private  int DOT_SIZE = Config.DOT_SIZE;
    protected boolean upDirection = false;
    protected boolean downDirection = true;
    protected boolean leftDirection = false;
    protected boolean rightDirection = false;
    protected boolean  isAlive=true;
    protected boolean isVisible=false;
    protected boolean  isStatic=false;
    protected int  Step=1;
    // protected boolean hasSuperPower=false;


    public String RunInfo="";
    public boolean shouldShowEatSelfInfo=false;
    public Location EatSelfInfo= new Location(0,0);
    // public int[]  EatSelfInfo={0,0};

    
    Font font = new Font(Font.DIALOG, Font.PLAIN, 12); // 创建字体对象，指定字体样式和大小
    
    public int dots = 15;
    private Head tou = new Head();
    public int info = Tools.generateRandomNumber();
    public String name = Tools.generateRandomName();
    int AiDirection = Tools.generateRandomNumber();
    
    Image body1 = Config.bodyImg;
    Image body2 = Config.bodyImg2;
    Image body = body1;
    
    
    public Snake() {
        for (int z = 0; z < dots; z++) {
            x[z] = Config.x - z * 10;
            y[z] = Config.y;
        }
        //开启扫描服务
        new Thread(new SnakeService()).start();
  
    }


    protected  void reset(){
        this.dots=8;
        this.isVisible=false;
        for (int i:this.x) {
            i=i*-1;            
        }
        for (int i:this.y) {
            i=i*-1;            
        }        
    }

    protected void  reduce(){
        this.dots=this.dots-2;
        if(dots<=5){
            reset();
        }
    }

    protected void reborn() {
        this.dots = 16;
        this.isVisible = true;
       
        
        
        int xx=Tools.getRandomNumber(0,Config.B_WIDTH/10)*10;
        int yy=Tools.getRandomNumber(0,Config.B_HEIGHT/10)*10;
        for (int i = 0; i < dots; i++) {
            x[i] =xx; 
            y[i] =yy ;

        }

    }
    

    public void  rename(){
        this.name=Tools.generateRandomName();
    }

    public void  stop(){
         isStatic=true;
    }



    public boolean checkCollision(EnemySnake s) {
        if (this.isVisible && s.inBody(this.x[0], this.y[0])) {
            this.stop();
            this.TransformIntoAppeles();
            Config.WorldSpeach = this.name + "--碰撞检测到了--" + s.name + "-- is dead!!";
            Config.shouldShowWarning = true;


            return true;
        } else {
            return false;
        }

    }

    public void  TransformIntoAppeles(){
        for(int i=1;i<dots;i++){
            ApplePool.add(x[i], y[i]);

        }
        this.reset();

    }



    protected void  ChangeBodyColor(){
        if(this.body==this.body1){
            this.body=body2;
        }
        if(this.body==this.body2){
            this.body=body1;
        }
    }

    public boolean shouldShow() {
        if(this.isVisible ){
            return true;
        }
        return false;
    }


    






    public void drawBody(Graphics g, ImageObserver thisofclass) {

        Image img;

        for (int z = 0; z < dots; z++) {
            img = this.body;
            if (z == 0 && isAlive)
                img = tou.loadImages(upDirection, downDirection, rightDirection, leftDirection);
            if (!isAlive)
                img = Config.NormalAppleImg;

            g.drawImage(img, x[z], y[z], thisofclass);

        }

        drawName(g, thisofclass);
        drawInfo(g);

    }


    private void drawInfo(Graphics g) {
        if (EatSelfInfo.showDraw) {
            g.setFont(Config.MediumFont);
            g.setColor(Color.cyan);
            String info=EatSelfInfo.toString() + this.name + " 吃了自己的身体";
            g.drawString(info, EatSelfInfo.x, EatSelfInfo.y);

        }

    }

    public int[] bodyX() {
        int[] x = new int[dots];
        for (int i = 1; i < dots; i++) {
            x[i] = this.x[i];
        }
        return x;
    }

    public int[] bodyY() {
        int[] y = new int[dots];
        for (int i = 1; i < dots; i++) {
            y[i] = this.y[i];
        }
        return y;
    }

    public  void  eatCheck(Snake  s){
        if(this!=s){
            for(int i =1;i<s.dots;i++){
                if( s.x[i]==this.x[0] && s.y[i]==this.y[0]){
                    s.ToLoseWeight();
                    this.ToGrow();
                    String  info1=this.name+" --咬到了 "+s.name;
                    Config.GameInfo.add(0,info1);
                    break;
                }

            }
        }
    }
    public  void  eatenCheck(Snake  s){
        if(this!=s){
            for(int i =1;i<this.dots;i++){
                if( this.x[i]==s.x[0] && s.y[i]==s.y[0]){
                    this.ToLoseWeight();
                    s.ToGrow();
                    String  info1=s.name+" --咬到了 "+this.name;
                    Config.GameInfo.add(0,info1);
                    break;
                }

            }
        }
    }


    
    public void drawName(Graphics g, ImageObserver thisofclass) {
        g.setColor(Color.white);
        g.setFont(font); // 设置当前绘图上下文的字体
        

        g.drawString(this.name+this.zuobiao2(), x[0], y[0]);
    }

    private String zuobiao2(){

        
        return "("+x[0]+","+y[0]+")";
    }
    
    public void move() {
        if (isAlive &&  !isStatic) {

            for (int z = dots; z > 0; z--) {
                x[z] = x[(z - 1)];
                y[z] = y[(z - 1)];

            }

            if (leftDirection) {
                x[0] -= DOT_SIZE;
            }

            if (rightDirection) {
                x[0] += DOT_SIZE;
            }

            if (upDirection) {
                y[0] -= DOT_SIZE;
            }

            if (downDirection) {
                y[0] += DOT_SIZE;
            }
            this.checkCollision();
            this.ChangeDirection();
        }
        this.isDead();
       

    }



    void ChangeDirection() {

        int key = Tools.generateRandomNumber();

        if ((key == 1) && (!rightDirection)) {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == 2) && (!leftDirection)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == 3) && (!downDirection)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
        }
        if ((key == 4) && (!upDirection)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
        }

    }
    
    public void ToGrow() {
        dots++;
    }

    public void ToLoseWeight() {
        if (dots <= 0) {
            isAlive = false;
        } else {
            dots--;
        }
    }
    
    public int lenth() {
        return dots;
    }
    
    
    
    private void checkCollision() {
        if (y[0] >= Config.B_HEIGHT) {
            y[0] = 0;
            // inGame = false;
        }
    
        if (y[0] < 0) {
            y[0] = Config.B_HEIGHT;
            // inGame = false;
        }
    
        if (x[0] >= Config.B_WIDTH) {
            x[0] = 0;
            // inGame = false;
        }
    
        if (x[0] < 0) {
            x[0] = Config.B_WIDTH;
            // inGame = false;
        }
    }
    
    public int[] head() {
        int[] result = { this.x[0], this.y[0] };
        return result;
    }
    public Location headLocation() {
        // int[] result = { this.x[0], this.y[0] };
        // return result;
        return new Location(this.x[0], this.y[0]);
    }
    
    public String getStatus() {
        String changdu = "changdu: " + dots;
        String status = this.name + " " + changdu;
        return status;
    }
    


    public String headToString() {
        return Integer.toString(x[0]) + Integer.toString(y[0]);
    }

    public void isDead() {
        if (isAlive) {

            for (int i = 1; i < dots - 1; i++) {
                if (x[i] == x[0] && y[i] == y[0]) {
                    RunInfo = this.name + " 吃到了自己的身体 " + Tools.getCurrentDateTime();

                    System.out.println(info);

                    Config.GameInfo.add(0, RunInfo);
                    Config.WorldSpeach = RunInfo;
                    Config.shouldShowWarning = true;

                    this.ToLoseWeight();
                    ApplePool.add(x[i + 1], y[i + 1]);

                    EatSelfInfo.x = x[i + 1] + 10;
                    EatSelfInfo.y = y[i + 1] - 10;
                    EatSelfInfo.showDraw = true;

                    Sound.play(Config.EatGhost);
                    reduce();
                    ChangeBodyColor();
                    break;

                }
            }
        }

    }

 
    


    private class SnakeService implements Runnable {


        @Override
        public void run() {
            while (true) {
                if (EatSelfInfo.showDraw) {
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    EatSelfInfo.showDraw = false;

                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    
}