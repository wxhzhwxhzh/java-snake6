package com.zetcode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.zetcode.MyUtil.Config;

public class SuperEnemySnake extends EnemySnake implements ActionListener, KeyListener {

    // @Override
    // void ChangeDirection() {
    // }
    {        
        this.isVisible = true;
        this.body=Config.bodyImg3;
    }

    @Override
    public void reduce(){
        
    }
    
    @Override
    public void ChangeDirection(){

    }

    @Override
    public boolean checkCollision(EnemySnake s) {
        if (this.isVisible && s.inBody(this.x[0], this.y[0])) {

            Config.WorldSpeach = this.name + "--碰撞检测到了--" + s.name ;
            Config.shouldShowWarning = true;
            this.reduce();
            return true;
        } else {
            return false;
        }

    }




    public void  AIMode(Apple a){
        if (this.x[0]<a.x && !leftDirection) {
             // 向右方向
             rightDirection = true;
             leftDirection = false;
             upDirection = false;
             downDirection = false;
         } else if (this.x[0]>a.x && !rightDirection) {
             // 向左方向
             rightDirection = false;
             leftDirection = true;
             upDirection = false;
             downDirection = false;
         } else if (this.y[0]>a.y && !downDirection) {
             // 向上方向
             rightDirection = false;
             leftDirection = false;
             upDirection = true;
             downDirection = false;
         } else if (this.y[0]<a.y && !upDirection) {
             // 向下方向
             rightDirection = false;
             leftDirection = false;
             upDirection = false;
             downDirection = true;
         }
 
     }  
 
 
     @Override
     public void actionPerformed(ActionEvent e) {
         // 实现 ActionListener 接口中的方法
         System.out.println("Button clicked!");
     }
 
     
     @Override
     public void keyPressed(KeyEvent e) {
 
         int keyCode = e.getKeyCode();
         // 实现 KeyListener 接口中的方法
         if (keyCode == KeyEvent.VK_RIGHT && !leftDirection) {
             // 向右方向
             rightDirection = true;
             leftDirection = false;
             upDirection = false;
             downDirection = false;
         } else if (keyCode == KeyEvent.VK_LEFT && !rightDirection) {
             // 向左方向
             rightDirection = false;
             leftDirection = true;
             upDirection = false;
             downDirection = false;
         } else if (keyCode == KeyEvent.VK_UP && !downDirection) {
             // 向上方向
             rightDirection = false;
             leftDirection = false;
             upDirection = true;
             downDirection = false;
         } else if (keyCode == KeyEvent.VK_DOWN && !upDirection) {
             // 向下方向
             rightDirection = false;
             leftDirection = false;
             upDirection = false;
             downDirection = true;
         }
 
 
     }
     
   
 
     @Override
     public void keyTyped(KeyEvent e) {
         // 实现 KeyListener 接口中的方法
         // char keyChar = e.getKeyChar();
         // System.out.println("Key Typed: " + keyChar);
     }
     @Override
     public void keyReleased(KeyEvent e) {
         // 实现 KeyListener 接口中的方法
         // int keyCode = e.getKeyCode();
         // System.out.println("Key Released: " + keyCode);
     }
 

}
