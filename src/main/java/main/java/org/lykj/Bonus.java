package main.java.org.lykj;

import java.util.Scanner;

/**
 * 求利润
 * = 2
 *
 */
public class Bonus {
    public static void main(String[] args) {

        System.out.println("请输入您创造的利润！（单位：万元）");
        final Scanner scanner = new Scanner(System.in);
        //如果输入的不是小数类型就继续输入
        while (!scanner.hasNextDouble()){
            System.out.println("请输入金额：");
            scanner.next();
        }

        double profit = scanner.nextDouble();
        double bonus = 0;

        if (profit <= 10){
            bonus = profit * 0.1;
        }else if (profit<=20){
            bonus = (profit -10)*0.075 + 1;
        }else if (profit<=40){
            bonus = (profit - 10)*0.05 + 1.75;
        }else if (profit<=60){
            bonus = (profit-10)*0.03+2.75;
        }else if (bonus<=100){
            bonus = (profit -100)*0.01+3.95;
        }
        System.out.printf(profit + " is w profit you can have "+ bonus +" W RMB");
    }
}
