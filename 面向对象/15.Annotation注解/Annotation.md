# Annotation注解

利用Annotation可以有效减少程序配置的代码，并且可以利用Annotation进行一些结构化的定义。Annotation是以一种注解的形式实现的程序开发

## 准确覆写 @Override

在程序编译的时候可以检查出程序的错误

``` java
class Channel {
  public void connet () {
    System.out.println("****** 父类Channel *******");
  }
}
class DatabaseChannel extends Channel{
  @Override
  // 如果这里覆写方法名写错会报错
  // 错误: 方法不会覆盖或实现超类型的方法
  public void connetion () {
    System.out.println("****** 子类DatabaseChannel *******");
  }
}

public class JavaDemo{
  public static void main (String args []) {
    new DatabaseChannel().connet();
  }
}
```

## 过期声明 @Deprecated

> 所谓的过期操作指的是在一个软件项目的迭代开发过程中，可能有一个方法或者某一个类，由于在最初设计的时候考虑不周（存在缺陷），导致新版本的应用会有不适应的地方（老版本不影响），这时候不可能直接删掉这些操作，那么就希望给一个过渡的时间，于是就可以采用过期的声明，目的是告诉新用户这些操作不要再用了,老的用户想用就用，这样的话就用到注解"@Deprecated"进行定义

``` java
class Channel {
  @Deprecated
  //编译的时候会输出下面的信息，但是不影响正常调用
  // 注: JavaDemo.java使用或覆盖了已过时的 API。
  // 注: 有关详细信息, 请使用 -Xlint:deprecation 重新编译。
  public void connet () {
    System.out.println("****** 父类Channel *******");
  }
  public String connetion () {
    return "****** 获取了xxx通道的连接信息 *******";
  }
}
public class JavaDemo{
  public static void main (String args []) {
    new Channel().connet();
  }
}
```

## 压制警告 @SuppressWarnings

> 屏蔽一些警告信息

``` java
class Channel {
  @Deprecated
  public void connet () {
    System.out.println("****** 父类Channel *******");
  }
  public String connetion () {
    return "****** 获取了xxx通道的连接信息 *******";
  }
}
public class JavaDemo{
  @SuppressWarnings({"deprecation"})
  // 这里进行压制注解之后在编译的过程中就不会出现上面例子中的提示信息
  public static void main (String args []) {
    new Channel().connet();
  }
}
```