package main.java.org.lykj;

public class Bounce_Ball {

    public static void main(String[] args) {
        int n = 10;
        //小球经过的经过的距离 第一次是100，从第二次开始每次弹起的高度是前一次的两倍
        double ways = 100;
        //小球弹起的高度
        final double height = bounce(n);
        System.out.println("该球第"+n+"次弹起的高度为："+height+"米。");

        //计算经过的距离，从第二次开始算
        for (int i = 2; i < n; i++) {
            ways += bounce(i) * 2;
        }
        System.out.println("该球到第"+n+"次落下总共经过了："+ways+"米");
    }

    /**
     * 使用递归方法，求小球n次弹起的距离 递归条件：h(n)=n(n-1)/2;
     * @param n 弹起的次数
     */
    public static double bounce(int n){
        //第一次弹起高度是100
        if (n == 1) return 100;
        //每次弹起的高度是前一次的一半
        else return bounce(n-1)/2;
    }
}
