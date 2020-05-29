# Java 小记

## PATH 和 CLASSPATH的区别

PATH 是操作系统提供的路径配置，定义所有的可执行程序的路径

CLASSPATH 是由JRE提供的，用于定义Java程序解释时类加载路径，默认设置为当前所在目录加载，可以通过“SET CLASSPATH=路径”的命令形式来进行定义；


## 基本数据类型 描述的是一些具体的数字单元

* 数值型 
  整型   byte short int long    默认值 0
  浮点型 float double           默认值 0.0
  布尔型 boolean                默认值 false
  字符型 char                   默认值 '\u0000 '

## 引用数据类型 牵扯到内存关系的使用 

* 数组 类 接口                    默认值 null 

> 参考原则：如果要是描述数字首选的一定是int（整数）、double（小数）
  如果要进行数据传输或者是进行文字编码转换使用byte类型（二进制处理操作）
  处理中文的时候最方便的操作使用的是字符char来完成（可选概念）
  描述内存或文件大小、描述表的主键列（自动增长）可以使用long

## 循环控制

* break  主要的功能是退出整个循环结构

* continue 严格来讲只是结束当前的一次调用（结束当前循环），当执行到了continue的时候就表示在当前的语句之中后续代码不再执行，而直接进行后续的判断处理

``` java
// 乘法口诀表
public class JavaDemo {
  public static void main(String args[]) {
    for(int i = 1; i <= 9 ; i ++) {
      for(int j = 1; j<=i; j ++) {
        System.out.print( j + "*" + i + "=" + ( i * j + "\t" );
      }
      System.out.println();
    }
  }
}
```

``` java
// 输出三角形
public class JavaDemo {
  public static void main(String args[]) {
    int line = 5;
    for(int x = 0; x < line ; x ++) {
      for(int y = 0; y < line - x; y ++){
        System.out.print(" ");
      }
      for(int y = 0; y <= x; y ++){
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
```

## 方法 method

> 方法在主类中定义，并且由主方法直接调用

* 在进行方法名称定义的时候要求第一个单词的首字母小写，而后每个单词的首字母大写

* 在进行变量名称定义的时候要求第一个单词的首字母小写，而后每个单词的首字母大写

## 方法重载

> 当方法名称相同，参数的类型或个数不同的时候就称为方法的重载

> 千万记住一点，方法的重载与方法的返回值类型没有任何关系，它只跟参数有关系，但在实际开发之中请一定要把握一个基本的开发原则，只要是方法的重载强烈建议其返回值类型相同

``` java
public class JavaDemo {
  public static void main(String args[]) {
    int resultA = sum(10 , 10);
    int resultB = sum(10, 1, 2);
    double resultC = sum(10.0, 1.0);

    System.out.println(resultA);
    System.out.println(resultB);
    System.out.println(resultC);
  }

  public static int sum(int x, int y) {
    return x + y;
  }
  
  public static int sum(int x, int y, int z) {
    return x + y + z;
  }

  public static double sum (double x, double y) {
    return x + y;
  }
}
```

