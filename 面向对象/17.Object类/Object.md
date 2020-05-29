# Object类

## Object基本概念

使用Object类可以解决参数统一的问题，也就是说使用Object类可以接收所有的数据类型

而且在java中只有一个类不存在继承关系，就是Object，也就说所有的类默认情况下都是Object的子类

如果一个程序的方法要求可以接收所有类对象的时候就可以利用Object实现处理。但是在Java的设计过程之中对于所有的引用数据类型实际上都可以使用Object类接收，包括数组也可以.

``` java
public class JavaDemo{
  public static void main (String args []) {
    Object obj = new int [] {1, 2, 3}; // 向上转型
    if(obj instanceof int []) {
      int data [] = (int []) obj; // 向下转型
      for(int temp : data) {
        System.out.println(temp);
      }
    }
  }
}
```

## 取得对象信息： toString()

``` java
public String toString()
```

``` java
class Person{

}

public class JavaDemo{
  public static void main (String args []) {
    Person per = new Person();
    System.out.println(per); // Person@7852e922
    System.out.println(per.toString()); //Person@7852e922   // 这里的toString方法继承Object而来
  }
}
```

覆写toString方法

``` java
class Person{
  private String name;
  private int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  @Override
  public String toString() {
    return "姓名：" + this.name + "、年龄：" + this.age;
  }
}

public class JavaDemo{
  public static void main (String args []) {
    Person per = new Person("zhangsan", 18);
    System.out.println(per); // 姓名：zhangsan、年龄：18
  }
}
```

## 对象比较 equals()

> 所谓的对象比较主要的功能是比较两个对象的内容是否完全相同

String类中的equals方法实际上是覆写了Object中的equals方法

``` java
public boolean equals(Object obj) {
  return (this == obj);
}
```

``` java
class Person{
  private String name;
  private int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getName(String name) {
    return this.name;
  }
  public int getAge(int age) {
    return this.age;
  }

  @Override
  public String toString() {
    return "姓名：" + this.name + "、年龄：" + this.age;
  }

  public boolean equals (Object obj) {
    if(!(obj instanceof Person)) { // 先判断是否是一个类型
      return false;
    }
    if(obj == null) { // 不关心null的比较
      return false;
    }
    if(this == obj) { // 跟自己比较，同一个地址
      return true;
    }
    Person per = (Person) obj;
    return this.name.equals(per.name) && this.age == per.age;
  }
}

public class JavaDemo{
  public static void main (String args []) {
    Person perA = new Person("zhangsan", 18);
    Person perB = new Person("zhangsan", 18);
    System.out.println(perA.equals(perB)); // 姓名：zhangsan、年龄：18
  }
}
```


