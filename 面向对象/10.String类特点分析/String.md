# String

String这个类里面之所以可以保存字符串主要的原因是其中定义了一个数组，也就是说在String里面所有的字符串中的每一个字符的数据都是保存在了数组之中

``` txt
JDK1.8以前String保存的是字符数组
private final char value[];

JDK1.9以后保存的是字节数组
private final byte[] value;
```

``` java
String strA = "aaaa";
String strB = new String("bbbb");
String strC = "aaaa";

// 进行两个字符串比较用==不准确。一般用String的方法equals
System.out.println(strA == strB) // false
System.out.println(strA.equals(strB)) // true
System.out.println(strA == strC) // true ,这里是内存共享机制，strA和strC指向同一个堆内存

```

> 任何使用“""”定义的字符串常量实际上描述的都是一个String类的匿名对象，一般在比较的时候将字符串常量放在前面

``` java
String str = "aaa";

System.out.println("aaa".equals(str)); // 这么写不会由于str为null导致nullPinterException报错
```

## 构造方法实例化String类对象

``` java
String str = new String("aaa");
```

此时会开辟两块堆内存空间，而后只会使用一块，而另一块由于字符串常量所定义的匿名对象将成为垃圾空间

在使用构造方法实例化String类对象时不会自动出现保存到字符串池的处理

``` java
String strA = "aaa";
String strB = new String("aaa").intern(); // 手动入池
System.out.println(strA == strB); // true
```

## 字符串修改分析

> 在String类中包含的是一个数组，数组的最大缺点在于长度不可改变，当设置了一个字符串之后，会自动的进行一个数组空间的开辟，开辟的内容长度是固定的

``` java
// 内存分析参照String不可修改.jpg
// 在整个处理过程中，字符串常量的内容并没有发生任何的改变，改变的只是一个String类对象的引用
// 并且这种改变将有可能带来大量的垃圾空间
// 所以在实际开发中尽量避免频繁修改String的内容
public class JavaDemo {
  public static void main (String args[]) {
    String str = "www.";
    str += "mldn.";
    str += "cn";
    System.out.println(str);
  }
}
```

## 主方法组成分析

``` java
public class JavaDemo{
  public static void main(String args[]) {
    for(String arg : args) {
      System.out.println(arg);
    }
  }
}
// java JavaDemo hello world
// java JavaDemo "hello world" "hello rjd"
```