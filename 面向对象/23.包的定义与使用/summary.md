# 包的定义与使用

## 包的定义

> 包名称用小写字母定义

``` java
package cn.rjd.demo
```

打包编译处理

``` dash
// -d 表示要生成目录，而目录的结构就是package定义的结构
javac -d . Hello.java

java cn.rjd.demo.Hello
```

## 包的导入

``` java
package cn.rjd.test;

import cn.rjd.util.Message;

public class TestMessage {
  public static void main(String args []) {
    System.out.println(new Message().getMessage());
  }
}
```

``` dash
javac -d . *.java
```

**如果引用的包出现相同的类名称，往往使用类的完整名称，例如**

``` java
import cn.rjd.util.*;
import org.demo.*;

// 如果两个包中都有Message类，使用类的完整名称
cn.rjd.util.Message msg = new cn.rjd.util.Message();
```

## 静态导入

``` java
// MyMath.java
package cn.rjd.util;

public class MyMath {
  public static int add (int ... args) {
    int sum = 0;
    for(int temp : args) {
      sum += temp;
    }
    return sum;
  }
  public static int sub (int x, int y) {
    return x - y;
  }
}
```

``` java
// TestMath.java
package cn.rjd.test;

import static cn.rjd.util.MyMath.*;

public class TestMath {
  public static void main(String args[]) {
    System.out.println(add(1,2,3,4,5));
    System.out.println(sub(20,10));
  }
}
```

## 生成jar文件

``` dash
// 对程序打包编译
javac -d . Message.java

// 此时会形成cn的包，将其打包为rjd.jar
jar -cvf rjd.jar cn 

// -c 创建一个新的jar文件
// -v 得到一个详细输出
// -f 设置要生成的jar文件名称
```

每一个“*.jar”文件都是一个独立的程序路径，如果想要在java程序之中使用此路径，则必须通过CLASSPATH进行配置

``` dash
// windows环境下
SET CLASSPATH=.;/Users/RJD/Desktop/Java_Study/面向对象/23.包的定义与使用/rjd.jar

// mac环境
export CLASSPATH=.;/Users/RJD/Desktop/Java_Study/面向对象/23.包的定义与使用/rjd.jar
```

如果出现错误提示：Exception in thread "main" java.lang.NoClassDefFoundError:cn/rjd/util/Message，只有一种情况：*.java包没有配置正确

## 系统常用包

* java.lang: String Number Object,这个包在jdk1.1之后默认导入

* java.lang.reflect: 反射机制处理包，所有的设计从此开始

* java.util: 工具类的定义，包括数据结构的定义

* java.io: 进行输入与输出流操作的程序包

* java.net: 网络程序开发的程序包

* java.sql: 进行数据库编程的开发包

* java.applet: Java的最原始的使用形式，直接嵌套在网页上执行的程序类

  现在的程序以Application为主了（有主方法的程序）

* java.awt、java.swing: Java的图形界面开发包（GUI），其中awt是属于重量级的组件，而swing是轻量级的组件