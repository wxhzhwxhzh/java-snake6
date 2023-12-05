package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.zetcode.MyUtil.Config;
import com.zetcode.MyUtil.DrawText;
import com.zetcode.MyUtil.TextFactory;
import com.zetcode.MyUtil.Sound;
import com.zetcode.MyUtil.TextPool;
import com.zetcode.MyUtil.Tools;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = Config.B_WIDTH;
    private final int B_HEIGHT = Config.B_HEIGHT;
    private static String ip = Tools.getIPAddress();
    
    
    private int dots;
    
    private boolean inGame = true;
    private boolean isPaused = false;
    private boolean isHeld = false;
    private boolean AIMode = false;
    private int HeartBeat=0;

    // 自定义成员变量
    private Timer timer = new Timer(Config.DELAY, this);
    private DrawText D = new DrawText();
     
    
    // 复杂的成员变量
    private SnakePool snakesPool = new SnakePool();
    private SuperEnemySnake PlayerSnake = (SuperEnemySnake) snakesPool.getTheSuperSnake();
    ApplePool applePool = new ApplePool();
    Head tou = new Head();
    Apple appleOne = ApplePool.getTheSuperApple();  
    
    
    
   


    //构造函数
    public Board() {
        initBoard();
    }
    
    // 初始化游戏面板
    private void initBoard() {
        // 添加键盘监听器到玩家一（playerOne）
        addKeyListener(PlayerSnake);
        // 添加键盘监听器到匿名的 TAdapter 对象
        addKeyListener(new TAdapter());
        // 设置背景颜色为黑色
        setBackground(Color.black);

        // 设置焦点可聚焦，以便于接收键盘事件
        setFocusable(true);
        // 设置首选尺寸为指定的宽度和高度
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        // 初始化游戏,进行游戏重绘
        timer.start();


        //新线程 开启Board扫描服务
        new Thread(new BoardService()).start();

        

    }


    //组件重绘
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);

        // 把gg进行升级处理，字体平滑
        Graphics2D g = (Graphics2D) gg;
        Config.g = g;

        // setBackground(g);

        // Graphics2D gg = (Graphics2D) g;
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setPaint(Config.gradient);
        Font font = new Font(Config.RandomFont, Font.BOLD, 40);
        g.setFont(font);

        // g.drawString(Config.Title, getWidth()/2-200, 50);
        doDrawing(g);
        showTime(g);
        TextPool.draw();

    }


    
    // 绘制游戏面板
    private void doDrawing(Graphics g) {
        if (inGame) {

            snakesPool.drawBody(g, this);
            ApplePool.drawBody(g, this);

      

            if (AIMode) {
                PlayerSnake.AIMode(appleOne);
            }
            if (Config.shouldShowWarning) {
                showWarningInfo(g);
            }


            if (isHeld) {
                showStatus(g);
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            // do  something!!
        }
    }

//--------------------------------------------------------------------------------

    //游戏运行信息
    private String getBoardStatus() {
        StringBuilder status = new StringBuilder();
        status.append(Tools.getCurrentDateTime() + "--" + Board.ip );
        status.append("--Difficulty:" + timer.getDelay() + "--Auto-pathfinding:" + this.AIMode);
        status.append("--"+ApplePool.AllAppleInfo() + "--"+snakesPool.AllSnakesInfo());
        status.append("--Font name:"+Config.RandomFontFace);
        status.append("--Player name:"+PlayerSnake.name);
        return status.toString();
    }
    
    
   
    private String showTime(Graphics2D g) {

        String msg = this.getBoardStatus();
        TextFactory.StatusBarText.content(msg).pos(10, B_HEIGHT - 5);

        return msg;
    }
    
    
    
    //动态屏显信息
    private void showWarningInfo(Graphics g) {
        D.brush(g).content(Config.WorldSpeach).font("楷体", 20).position(30, getHeight() / 2);
        D.draw();

    }

    
    // 显示状态信息
    private Board showStatus(Graphics g) {
 
        int i=0;   
        D.brush(g).font("黑体");

        for (String s : Config.GameInfo) {
            D.content(s).position(getWidth()/2, B_HEIGHT-100-20*i).draw();
            i++;
            
        }
          
        return this;
    }

    private String SwitchToString(Boolean b) {
        if (b)
            return "开启";
        else
            return "关闭";
    }
    
   
    //界面重绘
    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            ApplePool.checkAppleSnake( snakesPool);



            if (!isPaused && !Config.isPaused) {                
                snakesPool.move();
            }

            if (dots == 250) {
                isPaused = true;
            }
        }

        this.HeartBeat+=1;
        repaint();
        
    }

    //键盘控制类
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
    
            //空格键 暂停背景音乐和游戏运行
            if (key == KeyEvent.VK_SPACE) {
                isPaused = !isPaused;
                TextFactory.PauseText.delay=TextFactory.PauseText.delay*-1;
                TextFactory.HelpText.delay=TextFactory.HelpText.delay*-1;
                System.out.println(PlayerSnake.x[0]+" -蛇--"+PlayerSnake.y[0]);
                System.out.println(appleOne.x+" -苹果--"+appleOne.y);
                
                if(isPaused){
                    Sound.play(Config.Waza);
                    Config.group.suspend();//暂停
                    
                }else{
                    Config.group.resume();//恢复
                }
                
            }
            if (key == KeyEvent.VK_A) {
                AIMode=!AIMode;
                Sound.play(Config.DogBarks);
                                
                TextFactory.KeyText.content("智能寻路 --"+SwitchToString(AIMode)).pos( getWidth()/2-100, getHeight()/2-200).delay(50);

            }
    
            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }

    
            if (key == KeyEvent.VK_H) {
                isHeld = !isHeld;
            }
        }
    
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
    
            if (key == KeyEvent.VK_H) {
                // isHeld = false;
            }
            if (key == KeyEvent.VK_E) {
                try {
                    snakesPool.add();
                } catch (CloneNotSupportedException e1) {
                    
                    e1.printStackTrace();
                }
            }
            if (key == KeyEvent.VK_F ) {
                int i=timer.getDelay()-25;
                if(i<=5){i=5;}  //设置最快速上限
                timer.setDelay(i);
                Sound.play(Config.DogBarks);
                // TextPool.add("游戏加速", getWidth()/2-100, getHeight()/2-200,30);
                TextFactory.KeyText.content("游戏加速 --"+i).delay(50);
            }
            
            if (key == KeyEvent.VK_F && e.isShiftDown()) {
                timer.setDelay(timer.getDelay()+50);
            }
        }
        
       
        
    }


    // 内部Board服务类
    private class BoardService implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (Config.shouldShowWarning ) {
                    HeartBeat=0;
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                    }
                    Config.shouldShowWarning = false;
                                        
                }
                if (ApplePool.shouldShowInfo ) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                    }
                    ApplePool.shouldShowInfo = false;                    
                }

                if(HeartBeat>=2000){HeartBeat=0;}

                

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}

