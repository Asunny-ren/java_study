# String常用方法

## 字符串与字符数组

在JDK1.9以前，所有的String都利用了字符数组实现了包装的处理，所以在String类里面是提供有相应的转换处理方法的，这些方法包含有构造方法和普通方法

``` java
// 这里只是简单列举一二
************************ 构造方法 ************************

// 将传入的全部字符数组变为字符串
public String (char value[])

// 将部分字符数组变为字符串
public String(char value[], int offset, int count)

************************ 普通方法 ************************

// 获取指定索引位置的字符
public char charAt(int index)

// 将字符串中的数据以字符数组的形式返回
public char[] toCharArray()
```

``` java
// 范例
public class JavaDemo{
  public static void main(String args[]) {
    String str = "www.baidu.com";
    char c = str.charAt(0);
    System.out.println(c);
  }
}
```

``` java
public class JavaDemo{
  public static void main(String args[]) {
    String str = "helloworld";
    char result[] = str.toCharArray();
    for(int x = 0; x < result.length; x++) {
      result[x] -= 32;
    }
    // System.out.println(result);
    // 将处理后的字符数组交给String变为字符串
    String newStr = new String(result);
    System.out.println(newStr);
    System.out.println(new String(result, 0, 5));
  }
}
```

``` java
// 判断某一个字符串中的数据是否全部由数字组成
public class JavaDemo{
  public static void main(String args[]) {
    String str = "hello123world";
    System.out.println(isNumber(str) ? "由数字所组成" : "不都是由数字所组成");
    // "123" 字符串常量为匿名对象
    System.out.println(isNumber("123") ? "由数字所组成" : "不都是由数字所组成");
  }

  public static boolean isNumber (String str){
    char c [] = str.toCharArray();
    for(int x = 0; x < c.length; x++) {
      if(c[x] < '0' || c[x] > '9'){
        return false;
      }
    }
    return true;
  }
}
```

## 字符串与字节数组

> 进行字符串与字节转换时，其主要目的是为了进行二进制传输或者进行编码转换

``` java
************************ 构造方法 ************************
// 将全部的字节数组变为字符串
public String(byte[] bytes)

// 将部分字节数组变为字符串
public String(byte [] bytes, int offset, int length)

************************ 普通方法 ************************
// 将字符串转为字节数组
public byte [] getBytes()

// 编码转换
public byte[] getBytes(String charsetName) throws UnsupportedEncodingException
```

示例：
``` java
public class JavaDemo{
  public static void main(String args[]) {
    String str = "helloworld";
    byte data [] = str.getBytes(); // 将字符串变为字节数组
    for(int i =  0; i < data.length; i++) {
      // System.out.println(data[i]);
      data[i] -= 32;
    }
    System.out.println(new String(data));
    System.out.println(new String(data, 0, 5));
  }
}
```

## 字符串比较

> 字符串比较中最为常用的方法就是equals()方法，但是这个方法需要注意的是其进行大小写区分的，除了equls之外还有许多的其他方法

``` java
************************ 普通方法 ************************
// 区分大小写的判断
public boolean equals(String anObject)
// 不区分大小写的判断
public boolean equalsIgnoreCase(String anotherString)

// 进行字符串大小比较，该方法返回一个int数据，该数据有三种取值：大于（>0）,小于(<0), 等于(=0)
public int compareTo(String anotherString)
// 不区分大小写进行字符串大小比较
public int compareToIgnoreCase(String str)
```

示例：

``` java
public class JavaDemo{
  public static void main(String args[]) {
    String str = "helloworld";
    byte data [] = str.getBytes(); // 将字符串变为字节数组
    for(int i =  0; i < data.length; i++) {
      // System.out.println(data[i]);
      data[i] -= 32;
    }
    System.out.println(new String(data).equals(str)); // false
    System.out.println(new String(data).equalsIgnoreCase(str)); // true
  }
}
```

示例：
``` java
public class JavaDemo{
  public static void main(String args[]) {
    String str = "helloworld";
    // 区分大小写
    System.out.println(str.compareTo("helloworld")); // 0
    System.out.println(str.compareTo("helloworlD")); // 32
    System.out.println("helloworlD".compareTo(str)); // -32
    // 不区分大小写
    System.out.println("helloworlD".compareToIgnoreCase(str)); // 0
  }
}
```

## 字符串查找

``` java
************************ 普通方法 ************************
// 判断子字符串是否存在
public boolean contains (String str)

// 从头查找指定字符串的位置，找不到返回-1
public int indexOf(String str)
// 从fromIndex开始查找指定字符串的位置，由前向后
public int indexOf(String str, int fromIndex)

// 从尾部开始查找指定字符串的位置，由后向前
public int lastIndexOf(String str)
// 从fromIndex开始查找指定字符串的位置，由前向后
public int lastIndexOf(String str, int fromIndex)

// 判断是否以指定的字符串开头
public boolean startsWith(String prefix)
// 由指定位置判断是否以指定的字符串开头
public boolean startsWith(String prefix, int toffset)

// 判断是否以指定的字符串结尾
public boolean endsWith(String suffix)
// 判断是否以指定的字符串结尾
// public boolean endsWith(String prefix, int toffset)
```

## 字符串替换

``` java
************************ 普通方法 ************************
// 全部替换
public String replaceAll(String regex, String replacement)
// 替换第一个
public String replaceFirst(String regex, String replacement)
```

## 字符串拆分

``` java
************************ 普通方法 ************************
// 按照指定的字符串全部拆分
public String [] split(String regex)
// 按照指定的字符串拆分为指定个数，后面不拆了
public String [] split(String regex, int limit)
```

如果遇到拆不了的情况，需要进行转义"\\."

示例：

``` java
public class JavaDemo{
  public static void main(String args[]) {
    String str = "127.0.0.1";
    String data [] = str.split("\\.");
    for(int x = 0; x < data.length; x++){
      System.out.println(data[x]);
    }
  }
}
```

## 字符串截取

``` java
************************ 普通方法 ************************
// 由指定索引截取到结尾
public String substring(int beginIndex)
// 截取指定范围内的子字符串
public String substring(int beginIndex, int endIndex)
```

## 字符串格式化

常用的占位符：字符串(%s)、字符(%c)、整数(%d)、小数(%f)

``` java
************************ 普通方法 ************************
// 根据指定结构进行文本格式化显示
public static String format(String format, Object... args)
```

示例：

``` java
public class JavaDemo{
  public static void main(String args[]) {
    String name = "张三";
    int age = 18;
    double score = 98.765321;
    String str = String.format("姓名：%s、年龄：%d、成绩：%5.2f", name, age, score);
    System.out.println(str); // 姓名：张三、年龄：18、成绩：98.77
  }
}
```

## 其他操作方法

``` java
************************ 普通方法 ************************
// 字符串连接
public String concat(String str)
// 对字符串入池保存
public String intern()
// 判断是否为空字符串""(不是null)
public boolean isEmpty()
// 计算字符串长度
public int length()
// 去除字符串左右两端的空格
public String trim()
// 转换为大写
public String toUpperCase()
// 转换为小写
public String toLowerCase()
```

示例：将字符串首字母转换为大写

``` java
class StringUtil{
  public static String initScap(String str){
    if(str == null || "".equals(str)) return str;
    if(str.length() == 1){
      return str.toUpperCase();
    }
    return str.substring(0 ,1).toUpperCase() + str.substring(1);
  }
}

public class JavaDemo{
  public static void main(String args[]) {
    System.out.println(StringUtil.initScap("hello world")); // Hello world
    System.out.println(StringUtil.initScap("h")); // H
    System.out.println(StringUtil.initScap("我")); // 我
  }
}
```