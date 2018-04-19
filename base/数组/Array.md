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

```