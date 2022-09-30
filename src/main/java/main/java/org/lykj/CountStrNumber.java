package main.java.org.lykj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 任意输入一段字符串，输出每个字符出现的次数
 */
public class CountStrNumber {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String s = scanner.next();
        Counter(s);
    }

    public static void Counter(String str) {

        //转换为char类型的数组
        final char[] array = str.toCharArray();
        //创建一个map用于存值
        HashMap<Character, Integer> map = new HashMap<>();
        //遍历字符串 put到map里面
        for (char c : array) {
            Integer count = map.get(c);
            //get(key) 返回一个 value 1
            //如果count(KEY)是空就说明这个值是新值 直接put
            if (count == null) map.put(c, 1);
                //如果count不等于null那就说明map里有这个值
                // 直接count++然后把值put进去
                // 因为map key 有唯一性所以说key(count)会指向同一个对象 只是value++
            else {
                count++;
                map.put(c, count);
            }
        }
        for (Map.Entry<Character, Integer> i : map.entrySet())
            System.out.println(" 字符 " + i.getKey() +  "出现了" + i.getValue() + "次");

    }
}
