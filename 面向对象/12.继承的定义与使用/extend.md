# 继承的定义与使用

定义方法：
class 子类 extends 父类{}

很多情况下，把子类成为派生类，把父类称为超类（SuperClass）

## 继承的实现

示例：
``` java
class Person{
  private String name;
  private int age;
  public Person() {}
  public Person (String name, int age){
    this.name = name;
    this.age = age;
  }

  public void setName (String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  public void setAge (int age) {
    this.age = age;
  }
  public int getAge () {
    return this.age;
  }
}

class Student extends Person{
  private String school;
  public void setSchool(String school){
    this.school = school;
  }
  public String getSchool() {
    return this.school;
  }
}

class Teacher extends Person{
  private String school;
  public void setSchool(String school){
    this.school = school;
  }
  public String getSchool() {
    return this.school;
  }
}

public class JavaDemo{
  public static void main(String args[]) {
    Student stu = new Student();
    Teacher tea = new Teacher();
    stu.setName("张三");
    stu.setAge(18);
    stu.setSchool("清华大学");
    System.out.println(stu.getName()); // 张三
    System.out.println(stu.getAge());// 18
    System.out.println(stu.getSchool());// 清华大学
    System.out.println(tea.getName());// null
    System.out.println(tea.getAge());// 0
    System.out.println(tea.getSchool());// null
  }
}
```

## 子类对象实例化流程

> 子类在实例化的同时自动实例化父类,目的是为了所有的属性可以进行空间分配

``` java
// 子类在实例化的同时自动实例化父类
// super()表示的就是子类构造调用父类构造的语句
// 该语句只允许放在子类构造方法的首行
// 在默认情况下，子类只会调用父类的无参构造方法。所以写与不写区别不大
// 如果说父类没有提供无参构造方法，必须利用super()明确调用有参构造方法
class Person{
  public Person() {
    System.out.println("父类构造方法执行");
  }
}

class Student extends Person{
  public Student() {
    super(); // 这里写和不写一样的效果
    System.out.println("子类构造方法执行");
  }
}

public class JavaDemo{
  public static void main(String args[]) {
    new Student();
  }
}
```

**super和this都可以调用构造方法，super是由子类调用父类构造方法，而this是调用本类中构造方法，并且都一定要方法构造方法的首行，所以两个语句不允许同时出现**

## 继承定义限制

* java中不允许多重继承，只允许多层继承

* 在进行继承关系定义的时候，实际上子类可以继承父类的所有的操作结构。但是对于私有操作属于隐式继承，而所有的非私有操作属于显示继承 

``` java
class Person{
  private String name;
  public void setName(String name) {
    this.name = name;
  }
  public String getName () {
    return this.name;
  }
}

class Student extends Person{
  public Student(String name) {
    setName(name);
  }
  public void fun () {
    // System.out.println(name); // 直接访问不可能，因为是私有的
    System.out.println(getName());  // 间接访问
  }
}

public class JavaDemo{
  public static void main(String args[]) {
    Student stu = new Student("zhangsan");
    stu.fun();
  }
}
```