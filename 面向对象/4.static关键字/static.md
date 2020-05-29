# static 关键字

> 主要用来定义属性和方法

## static定义属性

static属性虽然定义在类之中，但是其不受类实例化对象的控制。static属性可以在没有实例化对象的时候使用。

在进行类设计的时候首选的一定是非static属性（95%）， 而考虑到公共信息存储的时候才会使用到static属性（5%）。非static属性必须在类实例化对象产生之后才可以使用，而static属性可以在类没有实例化对象产生时调用

``` java
class Person {
  private String name;
  private int age;
  static String country = "中华民国";
  public Person (String name, int age) {
    this.name = name;
    this.age = age;
  }

  // setter getter省略

  public String getInfo () {
    return "姓名：" + this.name + "、年龄：" + this.age + "、国家：" + this.country;
  }
}

public class javaDemo{
  public static void main (String args[]) {
    System.out.println(Person.country);
    Person.country = "中华人民共和国";
    Person per = new Person("张三", 18);
    System.out.println(per.getInfo());
  }
}
```

## static定义方法

static方法可以直接由类名称在没有实例化对象的情况下调用

* static方法只允许调用static属性或者static方法 

* 非static方法允许调用static属性和static方法 

``` java
public class javaDemo{
  public static void main (String args[]) {
    // static方法可以在类没有实例化对象之前调用
    tell();
    // 非staitc方法必须在类对象实例化之后调用
    new javaDemo().say();
  }
  
  // 静态方法
  public static void tell () {
    System.out.println("xxxxx");
  }

  // 非静态方法
  public void say () {
    System.out.println("*****");
  }
}
```