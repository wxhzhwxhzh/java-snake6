package com.zetcode.MyUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

//游戏音效  https://sc.chinaz.com/yinxiao/WangZhanYingYong.html

public class Config {
    
    public static final int B_WIDTH = Screen.getWidth();
    public static final int B_HEIGHT = Screen.getHeight();
    public static final int DOT_SIZE = 10;
    public static final int ALL_DOTS = 900;
    public static final int RAND_POS_x = B_WIDTH/10-1;
    public static final int RAND_POS_y = B_HEIGHT/10-1;
    public static final int DELAY = 250;
    public static final int EnemyMaxNumber = 10;
    public static final int ENEMY_BORN_INTERVAL=5000;
    public  static  int  Countor=0;
    public static  boolean  isPaused=false;

    //文本
    public static ArrayList<String> GameInfo = new ArrayList<>();

    public  static String  WorldSpeach="  ";
    public  static boolean  shouldShowWarning=false;
    public  static  final String Title="----蛇  了  个   蛇----";

    //线程
    public static Thread testtThread;
    public  static ThreadGroup group = new ThreadGroup("Mythreads");

    //音乐
    public static final String BGM_PATH="resources/BGM/";
    public static final String Res_PATH="./resources/";
    public static final String Soun2_PATH="./resources/sound2/";
    public static final String[]  BGM_Group=Tools.scanMp3Files(Soun2_PATH);
     

    public static  String  BGM=BGM_PATH+"snake.mp3";
    public static String  BGM2=BGM_PATH+"FC功夫.mp3";

    public static final String Crash="resources/crash.mp3";
    public static final String DogBarks="resources/goujiao.mp3";
    public static final String EatPill="resources/sound/eat-pill.mp3";
    public static final String EatGhost="resources/sound/ghost-eaten.mp3";
    public static final String Waza="resources/sound/waza.mp3";

    //字体
    public static  String RandomFont="汉标高清锐毛";
    public static  Font SmallFont = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
    public static  Font HugeFont = new Font("楷体", Font.PLAIN, 30);
    public static  Font MediumFont = new Font("楷体", Font.PLAIN, 20);
    public static String  RandomFontFace=MyFont.getRandomFontFace();
    public static String  RandomFontFaceCN=MyFont.getRandomFontFaceOfCN();
    
    
    public static  Font[] Fonts={HugeFont,MediumFont,SmallFont};

    public static   GradientPaint gradient = new GradientPaint(100, 0, Color.RED, 800, 100, Color.BLUE);

    //颜色
    public static Color Green=Color.green;
    //画笔
    public static  Graphics g;
    

    //图片
    public static String  AppleImg=Res_PATH+"apple.png";
    public static String  AppleImg1=Res_PATH+"apple1.png";
    public static String  SuperApplePath=Res_PATH+"SuperApple.png";

    public static final Image NormalAppleImg = Tools.createImage(Res_PATH+"apple.png");
    public static final Image SuperAppleImg = Tools.createImage("resources/SuperApple.gif");

    public static final String up = "resources/up.gif";
    public static final String down = "resources/down.gif";
    public static final String left = "resources/left.gif";
    public static final String right = "resources/right.gif";
    public static final String tail1 = "resources/tail.gif";

    public static final Image bodyImg = Tools.createImage("resources/dot.png");
    public static final Image bodyImg2 =Tools.createImage("resources/dot2.png");
    public static final Image bodyImg3 =Tools.createImage("resources/dot3.png");
    public static final Image BackGroundImg = Tools.createImage("resources/bg4.jpg");
    public static final Image BackGroundImg2 = Tools.createImage("resources/bg5.jpg");
    public static final Image BackGroundImg3 = Tools.createImage("resources/bg6.jpg");

    //随机函数     
    public static  int EnemyNumber=1;
    public static int x=Tools.generateRandomNumber10();
    public static int y=Tools.generateRandomNumber10();


    public static String[] help = { "Space:        暂停",
                                    "E:          增加敌人 ",
                                    "H:     隐藏或显示信息",
                                    "shift+f/f:     增加或减慢速度",
                                    "蛇头碰到自己的身体 -1，碰到别人的身体 直接死亡"
                                    };


    public static  String Help="ESc 键- 退出\r\n  H 键-隐藏或显示信息  Space键-  暂停\n shift+f/f: 增加或减慢速度 ";



    public static final String[] NAMES = {
        "贝蕾亚", "纳亚菲利", "米利欧", "奎桑提", "尼菈",
        "卑尔维斯", "烈娜塔·戈拉斯克", "泽丽", "薇古丝", "阿克尚",
        "格温", "佛耶戈", "芮尔", "萨勒芬妮", "莎弥拉",
        "永恩", "莉莉娅", "瑟提", "厄斐琉斯", "赛娜",
        "奇亚娜", "悠米", "塞拉斯", "妮蔻", "派克",
        "卡莎", "佐伊", "奥恩", "凯隐", "霞",
        "洛", "卡蜜尔", "艾翁", "克烈", "塔莉垭",
        "奥瑞利安·索尔", "烬", "俄洛伊", "千珏", "塔姆·肯奇",
        "艾克", "巴德", "雷克塞", "卡莉丝塔", "阿兹尔",
        "纳尔", "布隆", "维克兹", "亚索", "金克丝",
        "卢锡安", "亚托克斯", "丽桑卓", "扎克", "奎因",
        "锤石", "蔚", "娜美", "劫", "伊莉丝",
        "卡兹克", "辛德拉", "雷恩加尔", "黛安娜", "婕拉",
        "杰斯", "德莱文", "德莱厄斯", "韦鲁斯", "赫卡里姆",
        "璐璐", "菲奥娜", "诺提勒斯", "吉格斯", "瑟庄妮",
        "维克托", "阿狸", "沃利贝尔", "菲兹", "希瓦娜",
        "格雷福斯", "泽拉斯", "锐雯", "泰隆", "斯卡纳",
        "孙悟空", "蕾欧娜", "约里克", "奥莉安娜", "薇恩",
        "兰博", "布兰德", "李青", "魔腾", "嘉文四世",
        "茂凯", "卡尔玛", "雷克顿", "凯特琳", "卡西奥佩娅",
        "特朗德尔", "艾瑞莉娅", "乐芙兰", "拉克丝", "斯维因",
        "娑娜", "厄运小姐", "厄加特", "加里奥", "弗拉基米尔",
        "赵信", "克格莫", "奥拉夫", "玛尔扎哈", "阿卡丽",
        "盖伦", "凯南", "慎", "伊泽瑞尔", "莫德凯撒",
        "古拉加斯", "潘森", "波比", "奈德丽", "乌迪尔",
        "黑默丁格", "萨科", "内瑟斯", "卡特琳娜", "库奇", "蒙多", "墨菲特", "迦娜",
        "布里茨", "普朗克", "塔里克", "卡萨丁", "维迦",
        "艾尼维亚", "拉莫斯", "阿木木", "科加斯", "卡尔萨斯",
        "图奇", "伊芙琳", "泰达米尔", "基兰", "辛吉德",
        "莫甘娜", "贾克斯", "赛恩", "崔丝塔娜", "沃里克",
        "易", "瑞兹", "索拉卡", "努努", "费德提克",
        "凯尔", "提莫", "希维尔", "崔斯特", "阿利斯塔",
        "艾希", "安妮"};

    public static final String[] NIKE_NAMES = {
        "狂厄蔷薇", "百裂冥犬", "明烛", "纳祖芒荣耀", "不羁之悦",
        "虚空女皇", "炼金男爵", "祖安花火", "愁云使者", "影哨",
        "灵罗娃娃", "破败之王", "镕铁少女", "星籁歌姬", "沙漠玫瑰",
        "封魔剑魂", "含羞蓓蕾", "腕豪", "残月之肃", "涤魂圣枪",
        "元素女皇", "魔法猫咪", "解脱者", "万花通灵", "血港鬼影",
        "虚空之女", "暮光星灵", "山隐之焰", "影流之镰", "逆羽",
        "幻翎", "青钢影", "翠神", "暴怒骑士", "岩雀",
        "铸星龙王", "戏命师", "海兽祭司", "永猎双子", "河流之王",
        "时间刺客", "星界游神", "虚空遁地兽", "复仇之矛", "沙漠皇帝",
        "迷失之牙", "弗雷尔卓德之心", "虚空之眼", "疾风剑豪", "暴走萝莉",
        "圣枪游侠", "暗裔剑魔", "冰霜女巫", "生化魔人", "德玛西亚之翼",
        "魂锁典狱长", "皮城执法官", "唤潮鲛姬", "影流之主", "蜘蛛女皇",
        "虚空掠夺者", "暗黑元首", "傲之追猎者", "皎月女神", "荆棘之兴",
        "未来守护者", "荣耀行刑官", "诺克萨斯之手", "惩戒之箭", "战争之影",
        "仙灵女巫", "无双剑姬", "深海泰坦", "爆破鬼才", "北地之怒",
        "机械先驱", "九尾妖狐", "不灭狂雷", "潮汐海灵", "龙血武姬",
        "法外狂徒", "远古巫灵", "放逐之刃", "刀锋之影", "水晶先锋",
        "齐天大圣", "曙光女神", "牧魂人", "发条魔灵", "暗夜猎手",
        "机械公敌", "复仇焰魂", "盲僧", "永恒梦魇", "德玛西亚皇子",
        "扭曲树精", "天启者", "荒漠屠夫", "皮城女警", "魔蛇之拥",
        "巨魔之王", "刀锋舞者", "诡术妖姬", "光辉女郎", "诺克萨斯统领",
        "琴瑟仙女", "赏金猎人", "无畏战车", "正义巨像", "猩红收割者",
        "德邦总管", "深渊巨口", "狂战士", "虚空先知", "离群之刺",
        "阿卡丽", "盖伦", "凯南", "慎", "探险家",
        "伊泽瑞尔", "莫德凯撒", "古拉加斯", "潘森", "波比",
        "奈德丽", "乌迪尔", "黑默丁格", "萨科", "内瑟斯",
        "卡特琳娜", "库奇", "蒙多", "墨菲特", "迦娜",
        "布里茨", "普朗克", "塔里克", "卡萨丁", "维迦",
        "艾尼维亚", "拉莫斯", "阿木木", "科加斯", "卡尔萨斯",
        "图奇", "伊芙琳", "泰达米尔", "基兰", "辛吉德",
        "莫甘娜", "贾克斯", "赛恩", "崔丝塔娜", "沃里克",
        "易", "瑞兹", "索拉卡", "努努", "费德提克",
        "凯尔", "提莫", "希维尔", "崔斯特", "阿利斯塔",
        "艾希", "安妮"
    };



    public static final String[] MODIFIY2 = {
            "可爱","傻傻","萌萌","羞羞","笨笨","呆呆","美丽","聪明","伶俐","狡猾",
            "胖乎乎","粉嫩嫩","白胖胖","漂亮","可爱","聪明","懂事","乖巧","淘气",
            "淘气","顽劣","调皮","顽皮","天真","可爱","无邪","单纯","纯洁","无暇",
            "纯真","稚气","温润","好奇"
    };



}
