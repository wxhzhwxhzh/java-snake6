package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SnakeWindow extends JFrame implements Runnable {


    

    private void initiWindow() {

        add(new Board());

        setResizable(false);
        pack();

        setVisible(true);
        setTitle("SnakeWindow  蛇了个蛇");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {

        EventQueue.invokeLater(
                () -> {
                    SnakeWindow ex = new SnakeWindow();
                    ex.initiWindow();

                });

    }

}
