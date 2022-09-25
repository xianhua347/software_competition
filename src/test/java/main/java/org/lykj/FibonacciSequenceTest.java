package main.java.org.lykj;

import java.util.Scanner;

class FibonacciSequenceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要打印的斐波那契数列的个数:");
        int count = scanner.nextInt();
       FibonacciSequence.getFibNums(count);
    }
}