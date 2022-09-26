package main.java.org.lykj;

import java.util.HashMap;

public class CountStrNumber {
    public static void main(String[] args) {
        Counter("我是你妈妈");
    }

    public static void Counter(String str) {

        final char[] array = str.toCharArray();
        //创建一个map用于存值
        HashMap<Character, Integer> map = new HashMap<>();
        //遍历字符串 put到map里面
        for (char c : array) {
            Integer count = map.get(c);
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
        System.out.printf(String.valueOf(map));

    }
}
