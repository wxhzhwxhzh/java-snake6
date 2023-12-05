package com.zetcode.MyUtil;

import java.awt.Color;

public class ColorTextDraw extends TextDraw {

    {
        isForever = false;
        delay = 60;
        content = "456 --789";
        c1 = Color.red;
        c2 = Color.black;
    }

    @Override
    public void draw() {  //写两次 覆盖模式

        Config.g.setFont(this.f);


        content=content.replace("--", "  ");
        String content2=content.split(" ")[0];

        if (delay > 0) {

            
            if(delay%8<4){
                Config.g.setColor(this.c1);
                Config.g.drawString(content, positionX, positionY);                
            }
            
            Config.g.setColor(this.c1);
            Config.g.drawString(content2, positionX, positionY);


            delay--;
            if (isForever)
                delay++;
        }

    }



    // 空格转换
    private String toSpace(String input) { 
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isChineseCharacter(c)) {
                st.append("  ");
            } else {
                st.append("  ");
            }
        }

        return st.toString();
    }
    
    private static boolean isChineseCharacter(char c) {
        // 判断是否为中文字符的逻辑，这里简化为判断字符的 Unicode 编码范围
        // 根据实际情况可能需要更复杂的判断逻辑
        return (c >= 0x4E00 && c <= 0x9FFF) || (c >= 0x3400 && c <= 0x4DBF);
    }

}
