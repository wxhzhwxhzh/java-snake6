package com.zetcode.MyUtil;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;

import javax.sound.sampled.*;

import com.zetcode.Snake;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.net.UnknownHostException;
import jmp123.demo.MiniPlayer;
import jmp123.output.Audio;;

public class Tools implements Runnable{
    
    public Tools(){
        // Music.playMP3File("src/resources/qingyinyue.wav");
        }

    public void run(){
        System.out.println("背景音乐播放路径："+Config.BGM2);
        Tools.playMP3File(Config.BGM2);
    }

    public static void play(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
            audioLine.open(format);

            audioLine.start();

            int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
            byte[] buffer = new byte[bufferSize];

            int bytesRead = 0;
            while ((bytesRead = audioStream.read(buffer)) != -1) {
                audioLine.write(buffer, 0, bytesRead);
            }

            audioLine.drain();
            audioLine.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void  test(){
        System.out.println("6655");
    }

    public static String get_packagePath() {
        String currentDirectory = System.getProperty("user.dir");
        // String dir=currentDirectory+"123";
        System.out.println(currentDirectory);
        return currentDirectory;
    }
    
    public static String getCurrentDateTime() {
        // 创建一个日期对象来表示当前的日期和时间
        Date currentDate = new Date();

        // 创建一个 SimpleDateFormat 对象，指定日期和时间的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 使用 SimpleDateFormat 格式化日期对象，并返回格式化后的字符串
        return dateFormat.format(currentDate);
    }

    
     public static int generateRandomNumber() {
        Random random = new Random();
        int min = 1;
        int max = 25;
        // 使用nextInt方法生成范围在[min, max]之间的随机数
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
     public static int getRandomNumber(int min,int max) {
        Random random = new Random();

        // 使用nextInt方法生成范围在[min, max]之间的随机数
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }


     public static int generateRandomNumber10() {
        Random random = new Random();
        int min = 5;
        int max = 35;
        // 使用nextInt方法生成范围在[min, max]之间的随机数
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber*10;
    }
     public static int generateAINumber(int a,int b,int c,int d) {

        int randomNumber = 5;
        if(a<c)randomNumber=1;
        if(a>c)randomNumber=2;
        if(b<d)randomNumber=3;
        if(b>d)randomNumber=4;
        

        return randomNumber;
    }

    public static String getIPAddress() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            
            return localhost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }


    

    /**
     * 得到指定的区间的随机数
     * @param filePath   文件路径     * 
     * @return void
     */
    public static void playMP3File(String filePath) {
        try {          
            
            MiniPlayer player=new MiniPlayer(new Audio());
            player.open(filePath);
            player.run();            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getRandomSnake() {
        String[] snakes = {
            "青木犀蛇", "珊瑚蛇", "基纳巴鲁喷毒眼镜蛇",
            "黑曼巴", "树蝰", "美国响尾蛇",
            "棕榈蟒蛇", "管蛇", "王蛇",
            "毒蝰蛇", "绿树蚺", "眼镜王蛇",
            "菱背水蛇", "哥伦比亚虎纹蛇", "短吻鳄蛇",
            "腹斑蛇", "巴西箭头蛇", "非洲角腹蛇",
            "窗帘舌蛇", "南美异毛蛇", "锦蛇",
            "印度眼镜蛇", "卡普雷拉蛇", "摇铃蛇",
            "织金黑眶蛇", "云南竹叶青蛇", "亚洲水蛇"
        };
    
        Random random = new Random();
        int index = random.nextInt(snakes.length);
    
        return snakes[index];
    }

    public static String getRandomConstellation() {
        String[] constellations = {
                "角木蛟", "亢金龙", "氐土貉", "房日兔", "心月狐", "尾火虎", "箕水豹",
                "井木犴", "鬼金羊", "柳土獐", "星日马", "张月鹿", "翼火蛇", "轸水蚓",
                "奎木狼", "娄金狗", "胃土雉", "昴日鸡", "毕月乌", "觜火猴", "参水猿",
                "斗木獬", "牛金牛", "女土蝠", "虚日鼠", "危月燕", "室火猪", "壁水貐"
        };

        Random random = new Random();
        int index = random.nextInt(constellations.length);

        return constellations[index];
    }

    public static String[] getRandomConstellations(int n) {
        if (n > 28) {
            throw new IllegalArgumentException("n cannot be greater than 28");
        }

        String[] constellations = {
            "角木蛟", "亢金龙", "氐土貉", "房日兔", "心月狐", "尾火虎", "箕水豹",
            "井木犴", "鬼金羊", "柳土獐", "星日马", "张月鹿", "翼火蛇", "轸水蚓",
            "奎木狼", "娄金狗", "胃土雉", "昴日鸡", "毕月乌", "觜火猴", "参水猿",
            "斗木獬", "牛金牛", "女土蝠", "虚日鼠", "危月燕", "室火猪", "壁水貐"
        };

        Random random = new Random();
        ArrayList<String> selectedConstellations = new ArrayList<>();

        while (selectedConstellations.size() < n) {
            int index = random.nextInt(constellations.length);

            if (!selectedConstellations.contains(constellations[index])) {
                selectedConstellations.add(constellations[index]);
            }
        }

        return selectedConstellations.toArray(new String[0]);
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true; // 存在重复元素
            }
            set.add(num);
        }
        return false; // 不存在重复元素
    }

    public static String generateRandomName() {
        Random random = new Random();
        String name = Config.NAMES[random.nextInt(Config.NAMES.length)];
        String modify =Config.NIKE_NAMES[random.nextInt(Config.NIKE_NAMES.length)];
        return modify + "*" + name;
    }
    public static String[] generateRandomNamePool(int n) {
        ArrayList<String> pool=new ArrayList<>();
        for(int i=0;i<n;i++){

            Random random = new Random();
            String name = Config.NAMES[random.nextInt(Config.NAMES.length)];
            String modify =Config.NIKE_NAMES[random.nextInt(Config.NIKE_NAMES.length)];
            
            pool.add(modify + "的" + name);
        }
        return pool.toArray(new String[0]);

    }

    public static ArrayList<Location> findCommonElements(ArrayList<Location> list1, ArrayList<Location> list2) {
        // 创建一个集合来存储相同的元素
        Set<Location> commonElements = new HashSet<>(list1);

        // 创建一个新的列表来存储结果
        ArrayList<Location> result = new ArrayList<>();

        // 遍历第二个列表，并检查是否存在于集合中，如果是，则添加到结果列表中
        for (Location location : list2) {
            if (commonElements.contains(location)) {
                result.add(location);
            }
        }

        return result;
    }

    public static String selectRandomString(String... strings) {
        // 检查是否有参数传入
        if (strings.length == 0) {
            return null; // 如果没有参数，返回null
        }

        // 创建一个随机数生成器
        Random random = new Random();

        // 生成一个随机的索引，范围在参数数组的长度之内
        int randomIndex = random.nextInt(strings.length);

        // 返回随机选择的元素
        return strings[randomIndex];
    }


    public static final Image createImage(String path){
        return Toolkit.getDefaultToolkit().createImage(path);
    }


    public static String[] scanMp3Files(String folderPath) {
        File folder = new File(folderPath);
        List<String> mp3FilesList = new ArrayList<>();

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".mp3")) {
                        mp3FilesList.add(file.getName());
                    }
                }
            }
        }

        // 将 List 转换为数组
        String[] mp3FilesArray = mp3FilesList.toArray(new String[0]);

        return mp3FilesArray;
    }


    // public static <T> T getRandomElement(List<T> list) {
    //     if (list == null || list.isEmpty()) {
    //         return null; // 防止空列表或空指针异常
    //     }

    //     Random random = new Random();
    //     int randomIndex = random.nextInt(list.size()); // 生成一个随机索引

    //     return list.get(randomIndex); // 返回随机元素
    // }

    
    public static <T> T getRandomElement(T[] array) {
        if (array == null || array.length == 0) {
            return null; // 防止空数组或空指针异常
        }

        Random random = new Random();
        int randomIndex = random.nextInt(array.length); // 生成一个随机索引

        return array[randomIndex]; // 返回随机元素
    }

    public static String RandomSoundPath(){
        return Config.Soun2_PATH+getRandomElement(Config.BGM_Group);
    }

    public static Snake getRandomSnake(List<Snake> snakes) {
                Random random = new Random();
        int randomIndex = random.nextInt(snakes.size()); // 生成一个随机索引

        return snakes.get(randomIndex); // 返回随机元素
    }

    public static Color getRandomColor() {
        Color[] colorArray = new Color[8];
        colorArray[0] = Color.RED;
        colorArray[1] = Color.GREEN;
        colorArray[2] = Color.BLUE;
        colorArray[3] = Color.YELLOW;
        colorArray[4] = Color.ORANGE;
        colorArray[5] = Color.PINK;
        colorArray[6] = Color.MAGENTA;
        colorArray[7] = Color.CYAN;

        Random random = new Random();
        int index = random.nextInt(colorArray.length); // 生成随机索引
        return colorArray[index]; // 返回随机颜色

       
    }


    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false; // 空字符串不是数字
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false; // 只要有一个字符不是数字，就不是纯数字
            }
        }
        return true;
    }

      /**
     * 暂停当前线程指定的时间长度。
     *
     * @param milliseconds 暂停的时间长度（以毫秒为单位）
     */
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



// ⣿⣿⣿⠟⠛⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢋⣩⣉⢻
// ⣿⣿⣿⠀⣿⣶⣕⣈⠹⠿⠿⠿⠿⠟⠛⣛⢋⣰⠣⣿⣿⠀⣿
// ⣿⣿⣿⡀⣿⣿⣿⣧⢻⣿⣶⣷⣿⣿⣿⣿⣿⣿⠿⠶⡝⠀⣿
// ⣿⣿⣿⣷⠘⣿⣿⣿⢏⣿⣿⣋⣀⣈⣻⣿⣿⣷⣤⣤⣿⡐⢿
// ⣿⣿⣿⣿⣆⢩⣝⣫⣾⣿⣿⣿⣿⡟⠿⠿⠦⠀⠸⠿⣻⣿⡄⢻
// ⣿⣿⣿⣿⣿⡄⢻⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣾⣿⣿⣿⣿⠇⣼
// ⣿⣿⣿⣿⣿⣿⡄⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣰
// ⣿⣿⣿⣿⣿⣿⠇⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢀⣿
// ⣿⣿⣿⣿⣿⠏⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿
// ⣿⣿⣿⣿⠟⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿
// ⣿⣿⣿⠋⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⣿
// ⣿⣿⠋⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸

// .⠄⠄⣿⣿⣿⣿⠘⡿⢛⣿⣿⣿⣿⣿⣧⢻⣿⣿⠃⠸⣿⣿⣿⠄⠄⠄⠄⠄
// ⠄⠄⣿⣿⣿⣿⢀⠼⣛⣛⣭⢭⣟⣛⣛⣛⠿⠿⢆⡠⢿⣿⣿⠄⠄⠄⠄⠄
// ⠄⠄⠸⣿⣿⢣⢶⣟⣿⣖⣿⣷⣻⣮⡿⣽⣿⣻⣖⣶⣤⣭⡉⠄⠄⠄⠄⠄
// ⠄⠄⠄⢹⠣⣛⣣⣭⣭⣭⣁⡛⠻⢽⣿⣿⣿⣿⢻⣿⣿⣿⣽⡧⡄⠄⠄⠄
// ⠄⠄⠄⠄⣼⣿⣿⣿⣿⣿⣿⣿⣿⣶⣌⡛⢿⣽⢘⣿⣷⣿⡻⠏⣛⣀⠄⠄
// ⠄⠄⠄⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠙⡅⣿⠚⣡⣴⣿⣿⣿⡆⠄
// ⠄⠄⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠄⣱⣾⣿⣿⣿⣿⣿⣿⠄
// ⠄⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⣿⠄
// ⠄⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠣⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄
// ⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠑⣿⣮⣝⣛⠿⠿⣿⣿⣿⣿⠄
// ⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⠄⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠄
       


}