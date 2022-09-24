package main.java.org.lykj;

public class PrimeNumbers {
    public static void primeNumbersSum(){
        System.out.print("--- 一百以内的素数和总个数 -----");
        int count = 0;

        for (int i = 2; i<=100;i++){
            for (int j = 2; j <= i;j++){
                //遍历2-i的数字
                if (i % j == 0 && i != j) break; //// 如果i % j余数为0，且i、j不相等，跳出if(i%j == 0 && i!=j) 说明这个数不是素数
                if (j == i){
                    // 判断i是否和j相等，若i==j，就说明该数是素数。因为可以被自身整除
                    if (count % 5 == 0)
                        System.out.println();
                    System.out.print(j + " ");
                    count++;
                }
            }
        }
        System.out.println("\n素数有" + count + "个");
    }
}
