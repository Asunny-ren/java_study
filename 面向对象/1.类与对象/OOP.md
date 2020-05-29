# 面向对象简介

* 封装性：内部的操作对外部而言不可见，当内部的操作都不可直接使用的时候才是安全的

* 继承性：在已有结构的基础上继续进行功能的扩充

* 多态性：是在继承性的基础上扩充而来的概念，指的是类型的转换处理

在面向对象程序开发中有三个步骤：

1. OOA：面向对象分析
2. OOD：面向对象设计
3. OOP：面向对象编程

## 类与对象
 
> 类是对某一类事物的共性的抽象概念，而对象描述的是一个具体的产物

* 类是一个模版，而对象才是类可以使用的实例，先有类再有对象

在类之中一般都会有两个组成：

成员属性（field）

操作方法（method）

``` java
class Person {
  String name;
  int age;
  public void tell() {
    System.out.println("姓名:" + name + "、年龄:" + age);
  }
}
public class JavaDemo {
  public static void main (String args[]) {
    Person per = new Person();
    per.name = "张三";
    per.age = 18;
    per.tell();
  }
}
```

## 对象内存分析

* 堆内存：保存的是对象的具体信息，在程序之中堆内存空间的开辟是通过new完成的

* 栈内存：保存的是一块堆内存的地址，即通过地址找到堆内存，而后找到对象内容

## 引用传递分析

> 类本身属于引用数据类型，既然是引用数据类型，那么牵扯到内存的引用传递，所谓的引用传递的本质：同一块堆内存空间可以被不同栈内存所指向，也可以更换指向

``` java
// 通过对象引用传递
class Person {
  String name;
  Int age;
  public void tell() {
    System.out.print("姓名：" + name + "、年龄：" + age);
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    Person per1 = new Person();
    per1.name = "张三";
    per1.age = 18;
    // 引用传递，将栈内存地址传递过去，实际指向同一个堆内存
    Person per2 = per1;
    per2.age = 80;
    per1.tell(); // 输出结果为80；
  }
}
```

``` java
// 方法的引用传递
class Person {
  String name;
  Int age;
  public void tell () {
    System.out.print("姓名：" + name + "、年龄: " + age);
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    Person per = new Person();
    per.name = "张三";
    per.age = 18;
    // temp = per; 方法引用传递，将per的栈内存地址传递给temp
    // 方法执行完毕之后，temp断开连接
    change(per);
    per.tell();
  }

  public void change (Person temp) {
    temp.age = 80;
  }
}
```

> 所谓的垃圾空间指的是没有任何栈内存所指向的堆内存空间，所有的垃圾将被GC（GarbageCollector垃圾收集器）不定期进行回收并且释放无用内存空间，但是如果垃圾过多，一定将影响到GC的处理性能，从而降低整体的程序性能，那么在实际开发中，对于垃圾的产生应该越少越好
