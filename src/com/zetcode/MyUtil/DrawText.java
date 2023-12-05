package com.zetcode.MyUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 用于绘制不同样式和颜色文本的实用类。
 */
public class DrawText {
    public Font f;// 字体对象
    public Graphics g;// 图形对象

    public Color c1 = Color.white;// 颜色1
    public Color c2 = Color.red;// 颜色2
    public Color c = c2;// 当前颜色，默认为颜色2
    public String s = "123";// 文本内容，默认为"123"
    public int x = 0;// 文本左上角x坐标，默认为0
    public int y = 0;// 文本左上角y坐标，默认为0

    /**
     * 设置要绘制的文本内容。
     * 
     * @param s 文本内容。
     * @return 更新后的DrawText对象。
     */
    public DrawText content(String s) {
        this.s = s;
        return this;
    }

    /**
     * 设置用于绘制的图形对象。
     * 
     * @param g 图形对象。
     * @return 更新后的DrawText对象。
     */
    public DrawText brush(Graphics g) {
        this.g = g;
        return this;
    }

    /**
     * 设置文本将绘制的位置。
     * 
     * @param x x坐标。
     * @param y y坐标。
     * @return 更新后的DrawText对象。
     */
    public DrawText position(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * 设置文本的字体样式，字号默认为15。
     * 
     * @param f 字体样式。
     * @return 更新后的DrawText对象。
     */
    public DrawText font(String f) {
        this.f = new Font(f, Font.PLAIN, 15);
        return this;
    }

    /**
     * 设置文本的字体样式和字号。
     * 
     * @param f 字体样式。
     * @param i 字号。
     * @return 更新后的DrawText对象。
     */
    public DrawText font(String f, int i) {
        this.f = new Font(f, Font.PLAIN, i);
        return this;
    }

    /**
     * 设置文本的字体样式、字号和粗体选项。
     * 
     * @param f 字体样式。
     * @param i 字号。
     * @param B true表示启用粗体样式，false表示不启用。
     * @return 更新后的DrawText对象。
     */
    public DrawText font(String f, int i, boolean B) {
        this.f = new Font(f, Font.PLAIN, i);
        if (B) {// 如果需要粗体
            this.f = new Font(f, Font.BOLD, i);// 使用粗体样式
        }
        return this;
    }

    /**
     * 在指定位置上绘制文本。
     */
    public void draw() {
        int GrowthAmount = 0;

        g.setFont(Config.SmallFont);// 先设置小字体
        for (String string : s.split("--")) {// 处理出换行符"--"分隔的多行文本
            this.ChangeColor();// 切换颜色
            g.setColor(this.c);// 设置颜色
            g.setFont(this.f);// 设置字体样式
            g.drawString(string + " ", x + GrowthAmount, y);// 绘制文本，GrowthAmount表示多行文本的x偏移量
            GrowthAmount += g.getFontMetrics().stringWidth(string);// 更新偏移量
        }
        this.c = this.c1;// 绘制完毕后将颜色设为颜色1
    }

    /**
     * 切换当前颜色为对立的颜色。
     */
    private void ChangeColor() {
        if (c == c1) {// 如果当前颜色为颜色1
            this.c = this.c2;// 切换为颜色2
        } else {// 否则
            this.c = this.c1;// 切换为颜色1
        }
    }
}
