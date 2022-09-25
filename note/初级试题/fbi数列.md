# fbi数列

### 题目：观察规律： 1 1 2 3 5 8……，任意输入一个整数，输出其在规律中对应的数字 

#### 分析 : 观察规律不难发现，这是斐波那契数列（数列从第3项开始，每一项都等于前两项之和）。那就需要找到递归公式和边界条件
#### 递归公式:递推公式为 F(n) = f(n-1)+f(n+2)(n>2) 边界条件是 n > 0 n < 2 

#### 解题方法：
 - 计算斐波那契数列的n项值
 - 使用for循环打印每一次递归的值

#### 实现
 ##### 实现斐波那契数列
```java
    /**
 * 使用递归实现斐波那契数列
 * @param num 需要递推的值
 */
public static int fib(int num) {
        if (num<=0) throw new RuntimeException("无效参数！");
        if (num == 1 || num == 2) return 1; //递归边界 num为1或者为2 直接返回1
        return fib(num - 1) + fib(num - 2); //递归公式
}
```

##### 打印每一次递归的值 也就是输出其在规律中对应的数字 

```java
public static void getFibNums(int count) {
        //打印斐波那契数列的每一项数值！
        for (int i = 1; i <= count; i++) {
            System.out.print(fib(i)+"\t");
        }
    }
```
