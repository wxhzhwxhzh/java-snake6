package com.zetcode;

// import java.awt.Image;
import com.zetcode.MyUtil.Config;
import com.zetcode.MyUtil.Tools;

// import javax.swing.ImageIcon;

public class EnemySnake extends Snake implements Cloneable {
    private int init_y = Tools.generateRandomNumber10();
    private int init_x = Tools.generateRandomNumber10();

    {
        this.body = Config.bodyImg2;
    } // 初始化块

    public EnemySnake() {
        for (int z = 0; z < dots; z++) {
            x[z] = init_x;
            y[z] = init_y;
        }
    }

    public boolean inBody(int x, int y) {
        for (int i = 1; i < dots; i++) {
            if (this.x[i] == x && this.y[i] == y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public EnemySnake clone() throws CloneNotSupportedException {
        EnemySnake clonedSnake = (EnemySnake) super.clone();

        // 对于数组类型的成员变量需要进行深拷贝
        clonedSnake.x = this.x.clone();
        clonedSnake.y = this.y.clone();
        clonedSnake.reborn();
        clonedSnake.rename();

        return clonedSnake;
    }
}
