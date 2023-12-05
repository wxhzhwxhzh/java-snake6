package com.zetcode;

import com.zetcode.MyUtil.Config;
import com.zetcode.MyUtil.Sound;
import com.zetcode.MyUtil.TextFactory;
import com.zetcode.MyUtil.TextPool;
import com.zetcode.MyUtil.Tools;

public class EnermySnakeFactory {
    private static  EnemySnake protoTypeSnake=new EnemySnake();

   //原型 设计模式
    public static  EnemySnake getInstanceSnake() throws CloneNotSupportedException{
        EnemySnake clone=protoTypeSnake.clone();
        extraStep(clone);
        return clone;
    }
    //简单工厂设计模式
    public static  EnemySnake getRandomSnake() {
        EnemySnake  es=new EnemySnake();
        es.reborn();
        es.rename();
        extraStep(es);
        return es;
    }



    private static void extraStep(Snake s) {
        String info = s.name + " --加入了队列 " + Tools.getCurrentDateTime();
        System.out.println(info);

        
        TextPool.TP.add(TextFactory.getText(s.x[0],s.y[0], info));
        TextPool.TP.add(TextFactory.getText(s.x[0],s.y[0], s.name).Color("red"));
        
        Config.GameInfo.add(0, info);
        Sound.play(Tools.RandomSoundPath());

    }


}
