package main.java.org.lykj;

public class FourDigitsSum {
    public static int sum(int num){
        // 1234 / 1000
        // 千位的值(num/1000) 十位的值(num%1000/10) 十位的值(num % 100 / 10) 个位的值(num % 10) 计算完成相加就可以到得到四个数的和
        return num /1000 + num%1000/10 +num % 100 / 10 + num % 10;
    }
}
