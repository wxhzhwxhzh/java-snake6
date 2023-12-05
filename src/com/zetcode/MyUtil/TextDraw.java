package com.zetcode.MyUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * TextDraw类用于在图形界面上绘制文本。
 */
public class TextDraw implements Cloneable {
    protected Font f; // 字体对象
    public Graphics g = Config.g; // 图形对象
    public Color c1 = Color.orange;
    public Color c2 = Color.gray;
    public Color c = this.c1;
    public int fontSize = 12;
    protected int positionX = 100;
    protected int positionY = 100;
    public String fontFace = "楷体";

    public String content = "123";
    public Boolean isVisible = false;
    public Boolean shouldCreateThread = true;
    public int positionYAdjust = 0;
    public int delay = 50;

    private static String[] ColorPool = { "red", "blue", "gray", "yellow" };
    private ArrayList<String> cp = new ArrayList<>(Arrays.asList(ColorPool));

    private static String CP = "red  blue  gray  yellow";

    public boolean isBold = false;
    public boolean isForever = false;
    public boolean isMultiLine = false;

    /**
     * 返回一个使用指定字体的Font对象。
     *
     * @return Font对象
     */
    private Font Font() {
        if (isBold)
            return new Font(this.fontFace, Font.BOLD, this.fontSize);
        return new Font(this.fontFace, Font.PLAIN, this.fontSize);
    }

    /**
     * 设置文本的字体。
     *
     * @param f 要设置的字体
     * @return TextDraw对象
     */
    public TextDraw setFont(Font f) {
        this.f = f;
        return this;
    }

    /**
     * 根据配置字符串进行模糊匹配。
     *
     * @param s 配置字符串
     * @return TextDraw对象
     */
    public TextDraw config(String s) {
        for (String t : s.split(" ")) {
            if (t.contains("体"))
                this.FontFace(t);
            if (cp.contains(t))
                this.Color(t);
            if (Tools.isNumeric(t))
                this.fontSize = Integer.valueOf(t);
            if (t.contains("delay"))
                this.delay(Integer.valueOf(t.split(":")[1]));
        }
        return this;
    }

    /**
     * 设置文本属性，包括Graphics对象、颜色、字体、位置和延迟。
     *
     * @param g         Graphics对象
     * @param c         颜色
     * @param fontface  字体
     * @param x         X坐标
     * @param y         Y坐标
     * @param delaytime 延迟时间
     * @return TextDraw对象
     */
    public TextDraw set(Graphics g, String c, String fontface, int x, int y, int delaytime) {
        this.brush(g).Color(c).FontFace(fontface).pos(x, y).delay(delaytime);
        return this;
    }

    /**
     * 设置Graphics对象。
     *
     * @param g Graphics对象
     * @return TextDraw对象
     */
    public TextDraw brush(Graphics g) {
        this.g = g;
        return this;
    }

    /**
     * 设置文本颜色。
     *
     * @param c 颜色字符串
     * @return TextDraw对象
     */
    public TextDraw Color(String c) {
        if (c.equals("red"))
            this.c = Color.red;
        if (c.equals("blue"))
            this.c = Color.blue;
        if (c.equals("cyan"))
            this.c = Color.cyan;
        return this;
    }

    /**
     * 设置字体大小。
     *
     * @param fontSize 字体大小
     * @return TextDraw对象
     */
    public TextDraw fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * 设置文本颜色。
     *
     * @param c 颜色对象
     * @return TextDraw对象
     */
    public TextDraw setColor(Color c) {
        this.c = c;
        return this;
    }

    /**
     * 设置文本位置。
     *
     * @param x X坐标
     * @param y Y坐标
     * @return TextDraw对象
     */
    public TextDraw pos(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        return this;
    }

    /**
     * 设置字体。
     *
     * @param fontFace 字体名称
     * @return TextDraw对象
     */
    public TextDraw FontFace(String fontFace) {
        this.fontFace = fontFace;
        return this;
    }

    /**
     * 设置文本内容。
     *
     * @param c 文本内容
     * @return TextDraw对象
     */
    public TextDraw content(String c) {
        this.content = c;
        return this;
    }

    /**
     * 设置延迟时间。
     *
     * @param delayTime 延迟时间
     * @return TextDraw对象
     */
    public TextDraw delay(int delayTime) {
        this.delay = delayTime;
        return this;
    }

    /**
     * 设置文本可见性。
     *
     * @param b 是否可见
     * @return TextDraw对象
     */
    public TextDraw setVisible(boolean b) {
        this.isVisible = b;
        return this;
    }

    /**
     * 设置是否永久显示文本。
     *
     * @param b 是否永久显示
     * @return TextDraw对象
     */
    public TextDraw setForever(boolean b) {
        this.isForever = b;
        return this;
    }

    /**
     * 设置文本是否加粗。
     *
     * @param b 是否加粗
     * @return TextDraw对象
     */
    public TextDraw setBold(boolean b) {
        this.isBold = b;
        return this;
    }

    /**
     * 完成文本的配置，根据属性生成Font对象。
     *
     * @return TextDraw对象
     */
    public TextDraw finishConfig() {
        this.f = this.Font();
        return this;
    }

    /**
     * 绘制文本，根据延迟时间渐进显示文本。
     */
    public void draw() {
        if (delay > 0) {
            Config.g.setColor(this.c);
            Config.g.setFont(this.f);
            Config.g.drawString(this.content, positionX, positionY);
            delay--;

            
            
            if (isForever)
                delay++;
        }
    }

    @Override
    public TextDraw clone() throws CloneNotSupportedException {
        TextDraw clonedText = (TextDraw) super.clone();

        // 对于数组类型的成员变量需要进行深拷贝

        return clonedText;
    }
}
