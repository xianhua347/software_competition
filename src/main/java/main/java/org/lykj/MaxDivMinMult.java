package main.java.org.lykj;

import java.util.Scanner;

public class MaxDivMinMult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入两个数：");
         int a = scanner.nextInt();
         int b = scanner.nextInt();

         int c = a % b;
         int d = c *b;
         while (c != 0){
             a = b;
             b =c ;
             c = a %b;
         }
        System.out.println("最大公约数为："+b);
        System.out.println("最小公倍数为："+d/b);
    }
}
