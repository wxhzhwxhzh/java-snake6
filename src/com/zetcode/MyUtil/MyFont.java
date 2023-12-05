package com.zetcode.MyUtil;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;

public class MyFont {
    // 获取本地图形环境
    public static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    // 获取所有可用字体名称
    public static String[] fontNames = ge.getAvailableFontFamilyNames();
    // 获取所有字体对象
    public static Font[] allFonts = ge.getAllFonts();

    // 定义一个静态List存储所有支持中文的字体名称
    static List<String> allCNFontsNames = Arrays.asList(MyFont.allFonts) // 将MyFont类中的所有字体名称转换为List集合
            .stream() // 将List转换为Stream
            .filter(f -> f.canDisplay('中')) // 过滤出所有能够显示“中”字的字体
            .map(f -> f.getName()) // 将字体对象转换为字体名称
            .distinct() // 去重，去掉重复的字体名称
            .collect(Collectors.toList()); // 将Stream转换为List

    // 静态块，输出所有支持中文的字体名称
    static {
        allCNFontsNames.forEach(t -> System.out.print(" >>" + t)); // 遍历List，输出所有支持中文的字体名称
    }

    // 获取随机字体名称
    public static String getRandomFontFace() {
        return fontNames[RandomNumber(fontNames.length)];
    }

    // 获取随机中文字体名称
    public static String getRandomFontFaceOfCN() {
        // 将HashSet转换为ArrayList，然后获取随机元素
        return allCNFontsNames.get(RandomNumber(allCNFontsNames.size()));
    }

    // 生成指定范围内的随机数
    public static int RandomNumber(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }
}
