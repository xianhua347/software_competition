package main.java.org.lykj;

import java.util.Scanner;

public class Login {
    public static void loginWithUserPassWord(){

        int count = 0;
        final String initialUserName = "admin";
       final String initialPassword = "123";
        final Scanner scanner = new Scanner(System.in);

        while (count<=3){
            System.out.println("请输入账号");
            String userName = scanner.nextLine();
            System.out.println("请输入密码");
            String passWord = scanner.nextLine();
            if (userName.equals(initialUserName)&&passWord.equals(initialPassword)){
                System.out.println("登录成功");
                break;
            }else {
                System.out.println("登录失败,请重新输入");
                count++;
            }
            if (count >= 3){
                System.out.println("用户名或者密码错误，已经输入三次。");
                break;
            }
        }
    }
}
