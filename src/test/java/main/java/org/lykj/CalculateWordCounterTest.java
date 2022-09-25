package main.java.org.lykj;

import org.junit.jupiter.api.Test;

class CalculateWordCounterTest {

    @Test
    void calculateWordCount() {
        final CalculateWordCounter counter = new CalculateWordCounter();
        //测试使用Character工具类实现字符串统计
        final String s1 = counter.calculateWordWithInterUtils("sdas123陈显富发WDDDD").toString();
        //测试使用正则表达式实现字符串统计
        final String s2 = counter.calculateWordCount("sdas123陈显**fsd发WDDDD").toString();
        System.out.printf(s1);
        System.out.printf(s2);
    }
}