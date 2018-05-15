# 数组

> 数组中存储元素的类型是统一的，每一个元素在内存中所占用的空间大小是相同的

**数组长度是不可改变的，数组一旦被创建长度是固定的，不可变的**

**数组拿首元素的的内存地址作为数组对象的内存地址**

> 查找效率高，随意的增删元素效率低

``` java
public class ArrayTest {
    public static void main(String[] args) {
        // a引用中保存的是一维数组的首元素的内存地址
        int[] a = {100, 200, 300, 400}; //  静态初始化一维数组

        /* 动态声明一个int类型的数组,会在堆内存中分配这个数组，并且数组中的每一个元素都采用默认值。
        *  byte, short,int, long     0
        *  float, double             0.0
        *  boolean                   false
        *  char                      \u0000
        *  引用                       null
        */
        int[] a1 = new int[4];
    }
}
//   无论是动态初始化还是静态初始化，最终的内存分布是一样的
```

``` java
public class Test {
    public static void main(String[] args) {
        //第一种方式
        int[] a = {1,2,3,4,5};
        m1(a);

        // 第二种方式
        m1(new int[]{3,4,5,6,7});
    }

    public static void m1 (int[] a) {
        for(int i=0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
```

* String[] args是专门用来接收命令行参数的，例如，java Test aa bb cc

> JVM在调用Test类的main方法之前，先“aa bb cc”这个字符串以空格的方式分割，然后存储在String数组中

### 数组拷贝

``` java
    public class Test {
        public static void main (String[] args) {
            int[] a = {1,2,3,4,5};
            int[] b = {11,12,13,14,15};
            //System.arraycopy(源数组, 源数组开始下标, 目标数组, 目标数组开始下标, 拷贝长度);
            System.arraycopy(a, 1, b, 3, 2);
        }
    }
```

### 二维数组

``` java
public class Test {
    public static void main(String[] args) {
        // 静态初始化二维数组
        int[][] a = {{}, {}, {}, {}};

        // 动态初始化二维数组
        int[][] b = new int[3][4];
    }
}
```

### 冒泡排序