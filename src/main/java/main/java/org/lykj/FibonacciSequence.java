package main.java.org.lykj;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 斐波那契数列
 * 递推公式为 F(n) = f(n-1)+f(n+2)(n>2)
 * @version 1.0
 *
 */
public class FibonacciSequence {

    /**
     * 使用递归实现斐波那契数列
     * @param num 需要递推的值
     */
    public static int fib(int num) {
        if (num<=0) throw new RuntimeException("无效参数！");
        if (num == 1 || num == 2) return 1; //递归边界 num为1或者为2 直接返回1
        return fib(num - 1) + fib(num - 2); //递归公式
    }

    /**
     * 使用HashMap当作缓存优化fib数列
     * @param num 需要归推的值
     */
    public static int fibWithMapCache(int num){
        Map<Integer,Integer> cache  = new HashMap<>();

        if (num<=0) throw new RuntimeException("无效参数！");
        if (num == 1 || num == 2) return 1; //递归边界 num为1或者为2 直接返回1

        //如果map缓存有计算完成的数值就直接返回
        if (cache.containsKey(num)){
            return cache.get(num);
        }

        //计算fib数列
        int result = fibWithMapCache(num-1) + fibWithMapCache(num -2);
        //存入Map缓存下次调用可以直接提取出来，优化时间复杂度
        cache.put(num,result);
        return result;
    }

    /**
     * 打印斐波那契数组数列
     * @param count 需要打印斐波那契数列的个数
     */
    public static void getFibNums(int count) {
        //打印斐波那契数列的每一项数值！
        for (int i = 1; i <= count; i++) {
            System.out.print(fib(i)+"\t");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要打印的斐波那契数列的个数:");
        int count = scanner.nextInt();
        FibonacciSequence.getFibNums(count);
    }
}
