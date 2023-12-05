package com.zetcode;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;



import com.zetcode.MyUtil.Config;
import com.zetcode.MyUtil.Location;
import com.zetcode.MyUtil.Sound;
import com.zetcode.MyUtil.TextPool;
import com.zetcode.MyUtil.Tools;

public class SnakePool {
    public String[] namepool;
    public List<Snake> snakes = new ArrayList<>();
    private final int ENEMY_MAX_COUNT = Config.EnemyMaxNumber;
    protected SuperEnemySnake Sep=new SuperEnemySnake();
    

    public SnakePool() {
        // 初始化名字池
        int n = 15;
        this.namepool = Tools.generateRandomNamePool(n);

        // 向SnakePool添加普通敌方Snake


        for (int i = 0; i < 1; i++) {
            snakes.add(EnermySnakeFactory.getRandomSnake());
            
        }


  


        snakes.add( Sep);

        // // 开启一个新的线程循环检测蛇的数量
        new Thread(new EnemySnakeProducer()).start();
    }

    // 添加新蛇
    public void add() throws CloneNotSupportedException {
        snakes.add(EnermySnakeFactory.getInstanceSnake());


    }


    public ArrayList<Snake> ALLVisibleSnakes() {
        ArrayList<Snake> VS = new ArrayList<>();
        for (Snake snake : snakes) {
            if (snake.isVisible) {
                VS.add(snake);
            }
        }
        return VS;
    }
    public ArrayList<Snake> UnVisibleSnakes() {
        ArrayList<Snake> VS = new ArrayList<>();
        for (Snake snake : snakes) {
            if (!snake.isVisible) {
                VS.add(snake);
            }
        }
        return VS;
    }

    public int countVisible() {
        int c = 0;
        for (Snake snake : snakes) {
            if (snake.isVisible)
                c++;

        }
        return c;
    }

    // 移除蛇
    public void rm() {
        for (Snake s : snakes) {
            if (s.isVisible) {
                String info = s.name + " 被踢出了队列 " + Tools.getCurrentDateTime();
                System.out.println(info);
                Config.GameInfo.add(0, info);
                System.out.println("“长度- ”" + snakes.size());
                s.isVisible = false;
                break;
            }
        }
    }

    // 绘制蛇身体
    public void drawBody(Graphics g, ImageObserver thisofclass) {
        for (Snake s : snakes) {
            if (s.isVisible ) {
                s.drawBody(g, thisofclass);
            }
        }
    }

    // 移动所有蛇
    public void move() {
        for (Snake s : snakes) {
            if (s.isVisible) {
                s.move();
                s.checkCollision(Sep);

                
            }
        }
    }

    // 获取所有蛇的头部位置
    public ArrayList<Location> AllHead() {
        ArrayList<Location> list = new ArrayList<Location>();
        for (Snake s : snakes) {
            if (s.isVisible) {
                list.add(s.headLocation());
            }
        }
        return list;
    }

    // 获取拥有特殊能力的蛇
    public Snake getTheSuperSnake() {
        for (Snake s : snakes) {
            if (s instanceof SuperEnemySnake) {
                return s;
            }
        }
        
        return Sep;
    }

    // 获取当前存活蛇的数量
    private int NumberOfAlivedSnakes() {
        int i = 0;
        for (Snake snake : snakes) {
            if (snake.shouldShow()) {
                i++;
            }
        }
        return i;
    }

    // 获取所有蛇信息
    public String AllSnakesInfo() {
        return "Snakes:" + this.NumberOfAlivedSnakes();
    }


    private class EnemySnakeProducer implements Runnable {

        private int countVisible() {
            int c = 0;
            for (Snake s : snakes) {
                if (s.isVisible)
                    c++;

            }
            return c;
        }

        @Override
        public void run() {
            while (true) {
                if (this.countVisible() < 5) {
                    
                    try {
                        snakes.add(EnermySnakeFactory.getInstanceSnake());
                    } catch (CloneNotSupportedException e) {

                        e.printStackTrace();
                    }

                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 只有在游戏run状态下才创建敌人坦克

            }
        }
    }


    
}
