package main.java.org.lykj;

/**
 * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13 … 求出这个数列的前20项之和
 * 规律:第二个数的分母等于分子 第二数的分子等于第一个数的分子+分母
 */
public class Seq {
    public static void sum(int n){
        float up = 2; //分子
        float down = 1; //分母
        float fraction = up / down; //分数
        float temp; //temp分数
        float sum = 0; //总数

        for (int i = 0; i < n; i++) {
            sum += fraction; //处理总数
            temp = up + down; //分子和分母的和给到temp
            down = up; // 第二个数的分子 = 第一个数的分母
            up = temp; // 第二个数的分母= temp
            fraction = up / down; //更新分数
        }
        System.out.println("sum "+ sum);
    }

    public static void main(String[] args) {
        sum(10);
    }
}
