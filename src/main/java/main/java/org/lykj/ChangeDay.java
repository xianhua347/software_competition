package main.java.org.lykj;

import java.util.Scanner;

public class ChangeDay {
    public static void main(String[] args) {
        System.out.println("请输入年月日");
        final Scanner scanner = new Scanner(System.in);
         int year = scanner.nextInt();
         int month = scanner.nextInt();
         int day = scanner.nextInt();
         int sum; //天数总和

        int[] months={31,28,31,30,31,30,31,31,30,31,30,31}; //定义月份
        sum = day; //加上输入的天数
        for (int i = 1; i < month; i++) {
            sum+=months[i]; //加上输入月份的天数
        }
        boolean isRun = ((year%4==0)&&(year%100!=0)||(year%400==0))&&(month>2);

        //如果是闰年sum+1；
        if (isRun) sum++;

        System.out.println(year + " year "+ month +" month " + day+ " day "+" 这一年的 " + sum + " day ");
    }
}
