# 异常的捕获与处理

异常指的是导致程序中断执行的一种指令流


## 认识异常对程序的影响

``` java
public class JavaDemo {
  public static void main(String args[]) {
    System.out.println("【1】******程序执行开始");
    System.out.println("【2】******数字计算" + ( 10 / 0 ));
    System.out.println("【3】******程序执行完毕");
  }
}
// 执行结果： ArithmeticException
// 【1】******程序执行开始
// Exception in thread "main" java.lang.ArithmeticException: / by zero
// 	at JavaDemo.main(JavaDemo.java:4)
```

## 处理异常

异常处理可以使用： try catch finally这几个关键字来完成

``` java
try {
  // 可能出现异常的语句
} [catch (异常类型 异常对象) {
  // 异常处理
}catch (异常类型 异常对象) {
  // 异常处理
}catch (异常类型 异常对象) {
  // 异常处理
}...] [finally {
  // 不管异常是否处理都要执行
}]

// 在此结构中可以使用的组合为： try...catch,  try...catch...finally,  try...finally
```

如果要想获得非常完整的异常信息，则可以使用异常类中提供的printStackTrace()方法

``` java
public class JavaDemo {
  public static void main(String args[]) {
    System.out.println("【1】******程序执行开始");
    try{
      System.out.println("【2】******数字计算" + ( 10 / 0 ));
    }catch(ArithmeticException e) {
      e.printStackTrace();
    }
    System.out.println("【3】******程序执行完毕");
  }
}

// result:

// 【1】******程序执行开始
// java.lang.ArithmeticException: / by zero
// 	at JavaDemo.main(JavaDemo.java:5)
// 【3】******程序执行完毕
```

finally语句不管是否出现异常都会执行

``` java
public class JavaDemo {
  public static void main(String args[]) {
    System.out.println("【1】******程序执行开始");
    try{
      System.out.println("【2】******数字计算" + ( 10 / 0 ));
    }catch(ArithmeticException e) {
      e.printStackTrace();
    }finally {
      System.out.println("【F】不管是否出现异常都执行");
    }
    System.out.println("【3】******程序执行完毕");
  }
}
```

## 处理多个异常

``` java
public class JavaDemo {
  public static void main(String args[]) {
    System.out.println("【1】******程序执行开始");
    try{
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);
      System.out.println("【2】******数字计算" + ( x / y ));
    }catch(ArithmeticException e) {
      e.printStackTrace();
    }catch(NumberFormatException e) {
      e.printStackTrace();
    }catch(ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }finally {
      System.out.println("【F】不管是否出现异常都执行");
    }
    System.out.println("【3】******程序执行完毕");
  }
}
```

## 异常处理流程

![异常处理流程](./exception.jpg)

1. 在程序运行的过程之中才会产生异常，而一旦程序执行中产生了异常之后将自动进行指定类型的异常类对象实例化处理

2. 如果此时程序之中没有提供异常处理的支持，则会采用JVM默认异常处理方式，首先进行异常信息的打印，而后直接退出当前的程序

3. 此时程序中如果存在有异常处理，那么这个产生的异常类的实例化对象将会被try语句所捕获；

4. try捕获到异常之后与其后匹配的catch中的异常类型进行依次比对，如果此时与catch中的捕获异常类型相同，则认为应该使用此catch进行异常处理，如果不匹配则继续匹配后续的catch类型，如果没有任何catch匹配成功，那么表示该异常无法处理；

5. 不管异常是否处理最终都要执行finally语句，但是当执行完成finally的程序之后会进一步判断当前的异常是否已经处理过了，如果处理过了，则继续向后执行其他代码，如果没有进行处理则交给JVM进行默认的处理。

在程序之中可以处理的异常的最大类型是Throwable,有两个子类，一个是Error，一个是Exception，一般程序处理的都是Exception异常

**捕获异常的时候要把捕获范围大的异常放在捕获范围小的异常之后**

``` java
// 捕获异常的时候要把捕获范围大的异常放在捕获范围小的异常之后
public class JavaDemo {
  public static void main(String args[]) {
    System.out.println("【1】******程序执行开始");
    try{
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);
      System.out.println("【2】******数字计算" + ( x / y ));
    }catch(Exception e) {
      e.printStackTrace();
    }finally {
      System.out.println("【F】不管是否出现异常都执行");
    }
    System.out.println("【3】******程序执行完毕");
  }
}
```

## throws关键字

定义了一个方法，实际上就应该明确的告诉使用者这个方法可能会产生何种异常。那么此时就可以在方法的声明上使用throws关键字来进行异常类型的标注。

``` java
class MyMath{
  // 如果产生了异常，调用处处理异常
  public static int div (int x, int y) throws Exception{
    return x / y;
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    try{
      System.out.println(MyMath.div(10, 2));
    }catch(Exception e){
      // 捕获异常
      e.printStackTrace();
    }
  }
}
```

如果主方法继续向上抛出异常，那么表示此异常将交由JVM负责处理。

``` java
class MyMath{
  // 如果产生了异常，调用处处理异常
  public static int div (int x, int y) throws Exception{
    return x / y;
  }
}

public class JavaDemo {
  public static void main(String args[]) throws Exception {
    System.out.println(MyMath.div(10, 2));
  }
}
```

## throw关键字

与throws对应的还有throw关键字，此关键字的主要作用是在于表示手工进行异常的抛出，即：此时将手工产生一个异常类的实例化对象，并且进行异常的抛出处理

``` java
public class JavaDemo {
  public static void main(String args[]) {
    try{
      throw new Exception("自己抛着玩的异常对象");
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}

// result

// java.lang.Exception: 自己抛着玩的异常对象
// 	at JavaDemo.main(JavaDemo.java:4)
```

throw和throws区别

throw: 是在代码块中使用的，主要是手工进行异常对象的抛出；

throws：是在方法定义上使用的，表示将此方法中可能产生的异常告诉调用处，由调用处处理


## 异常处理模型



## RuntimeException



## 自定义异常类



## assert断言

