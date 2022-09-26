# 计算小球下落距离和经过多少米

### 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次弹起多高？

#### 分析 : 分析：每次球弹起的高度都是前一次高度的二分之一，可以用递归的方法，即：h(n)=h(n-1)/2; 共经过的距离：除了第一次落下只算一次，后面的每次弹起到落下都会经历两个弹起高度的距离

#### 实现

```java
public class Bounce_Ball {

    public static void main(String[] args) {
        
        //弹起的次数
        int n = 10;
        //小球经过的经过的距离 第一次是100，从第二次开始每次弹起的高度是前一次的两倍
        double ways = 100;
        //小球弹起的总高度
        final double height = bounce(n);

        //计算经过的距离，从第二次开始算
        for (int i = 2; i < n; i++) {
            ways += bounce(i) * 2;
        }
        
        System.out.println("该球第"+n+"次弹起的高度为："+height+"米。");
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
        else return bounce(n-1) / 2;
    }
}

```

