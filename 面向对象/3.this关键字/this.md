# this关键字

this关键字三类结构的描述：

1. 当前类中的属性：this.属性
2. 当前类中的方法（包括构造方法和普通方法）：this()、 this.方法名称()
3. 描述当前对象： 

## 使用类中的属性

只要是访问本类中的属性的时候，一定要加“this”关键字;

``` java
class Person {
  private String name;
  private int age;

  // 构造方法
  public Person (String name, int age) {
    this.name = name;
    this.age = age;
  }
  // setter getter
  public void setName (String name) {
    this.name = name;
  }
  public void setAge (int age) {
    this.age = age;
  }
  public String getName () {
    return this.name;
  }
  public int getAge () {
    return this.age;
  }
  
  // 普通方法
  public void tell () {
    System.out.print("姓名：" + this.name + "、年龄:" + this.age);
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    Person per = new Person("张三", 28);
    per.tell();
  }
}
```

## 使用this调用方法

> 构造方法必须在实例化对象的时候调用，所以“this()”只允许放在构造方法的首行

> 构造方法互相调用时请保留有程序的出口，别形成死循环

示例1

``` java
class Person {
  private String name;
  private int age;

  public Person () {
    System.out.print("*******");
  }
  public Person (String name) {
    this();
    this.setName(name);
  }
  public Person (String name, int age) {
    this(name);
    this.setAge(age);
  }

  // setter getter
  public void setName (String name) {
    this.name = name;
  }
  public void setAge (int age) {
    this.age = age;
  }
  public String getName () {
    return this.name;
  }
  public int getAge () {
    return this.age;
  }

  // 普通方法
  public void tell () {
    System.out.print("姓名: " + this.name + "、年龄：" + this.age);
  }
}

public class JavaDemo{
  public static void main(String args[]) {
    Person per = new Person("张三", 18);
    per.tell();
  }
}
```

示例2
``` java
class Emp {
  private long empno;
  private String ename;
  private String dept;
  private double salary;

  // 构造方法
  public Emp () {
    this(1000, "无名氏", null, 0.0);
  }
  public Emp (long empno) {
    this(empno, "新员工", "未定", 0.0);
  }
  public Emp (long empno,String ename, String dept) {
    this(empno, ename, dept, 0.0);
  }
  public Emp (long empno,String ename, String dept, double salary) {
    this.empno = empno;
    this.ename = ename;
    this.dept = dept;
    this.salary = salary;
  }

  // setter getter省略
  // ...

  // 普通方法
  public String getInfo () {
    return "员工编号:" + this.empno + 
            "、员工姓名:" + this.ename + 
            "、员工部门:" + this.dept + 
            "、员工薪水:" + this.salary;
  }
}

public class javaDemo{
  public static void main(String args[]) {
    Emp emp = new Emp(7369L, "sunnyren", "财务部" );
    System.out.print(emp.getInfo());
  }
} 
```

## 简单java类

* 类名称一定要有意义，可以明确的描述某一类事物

* 类之中的属性都必须使用private进行封装，同时封装后的属性必须提供setter和getter方法

* 类之中可以提供无数多个构造方法，但是必须要保留有无参构造方法

* 类之中不允许出现任何的输出语句，所有内容的获取必须返回

