# java 面向对象 Object-Oriented

* OOA 面向对象分析 analyse

* OOD 面向对象设计 design

* OOP 面向对象编程 programming

* this 关键字

  > this是一个引用类型， 在堆中的每一个java对象上都有this， this保存内存地址指向自身

  > this可以用在成员方法中，this可以用在构造方法中：this(实参)，通过一个构造方法去调用另一个构造方法，代码重用。this(实参)必须放在构造方法的第一行


## static关键字

  > static修饰的变量为 静态变量

  > static修饰的方法为 静态方法

  > static定义静态语句块

  **static定义的静态语句块在类加载阶段执行，并且只执行一次，并且是自上而下执行**

  ``` code

  public class statictTest{

    static {
      System.out.println('1');
    }

    static {
      System.out.println('2');
    }

    static {
      System.out.println('3');
    }

    static {
      System.out.println('4');
    }

    // 入口
    public static void main(String[] args) {

      System.out.println('static execute!');

    }

  }
  // out
    1
    2
    3
    4
    static execute!

  ```

* 实例语句块

  > 每次调用构造方法之前会执行一次

  ``` code
    public class staticTest{

      // 静态语句块
      static{
        System.out.println("A");
      }

      // 实例语句块
      {
        System.out.println("1");
      }

      {
        System.out.println("2");
      }

      // 构造方法
      staticTest() {
        System.out.pringln("无参构造方法执行");
      }

      // 入口
      public static void main(String[] args) {

        // 调用构造方法
        staticTest();

        staticTest();

      }

    }

    // out
    A
    1
    2
    无参构造方法执行
    1
    2
    无参构造方法执行
  ```

* static 静态方法

  > static修饰的方法，一般情况工具类中的方法都是静态方法，不用创建对象也能直接访问该方法

``` code
  public class staticTest{

    // 成员方法
    // 成员方法必须使用“引用.”调用
    public void m1() {

    }

    // 静态方法
    // 可以使用“类名.”方式调用
    // 静态方法中不能直接访问非静态数据（成员变量和成员方法)
    // 静态方法中不能使用this
    public static void m2() {

    }

    public static void main(String[] args) {

      // 成员方法调用,不可以直接m1()调用
      staticTest st = new staticTest();
      st.m1();

      // 静态方法调用,类名省略（在类体中）
      m2();


      // 注意
      // 静态方法也可以利用“引用.”调用
      st.m2() // 编译阶段检查出st是staticTest类型，编译通过，运行的时候仍然使用“staticTest.”的方式访问，该方法执行不需要对象



      // 空的引用去访问成员的时候会出现空指针异常
      // m2方法不是成员方法而是静态方法，所以即使引用是空的，也不会报空指针异常
      staticTest s = null;
      s.m2() // 不会报空指针异常

    }

  }

```

* 静态变量 static修饰的变量
  > 如果这个属性所有的对象都有，并且属性的值相同，则该属性声明成静态变量
  ``` code

    变量分类：

      局部变量
      成员变量（实例变量，非静态变量）
      静态变量（方法区中存储）



    class{

      成员变量
      成员方法

      静态变量
      静态方法

      静态语句块
      实例语句块

      构造方法

      this
    }

  ```

  ``` code

    public class staticTest{
      // 入口
      public static void main (String[] args) {

        Animal a1 = new Animal("aaa", 12);
        Animal a2 = new Animal("bbb", 13);

      }



    }


    // 抽象一个陆生动物的类
    class Animal{

      // 成员变量（一个对象一份）
      // 成员变量在创建对象的时候初始化，并且存储在堆中的每一个对象中
      String name;
      int age;

       // 静态变量存储在方法区中
       // 所有的java对象共享这一份，属于类级别的，通过“类名.”访问
       // 在类加载阶段赋值，并且只赋值一次
      static String type = "陆生";

      // constructor
      Animal(String name, int age){
        this.name = name;
        this.age = age;
      }


    }


  ```

* static 执行顺序

``` code
  public class staticTest{

    // 编译通过
    static int i = 100;
    static{
      System.out.println(i);
    }

    // 非法的向前引用
    static{
      System.out.println(i);
    }
    static int i = 100;
  }
```


## 单例模式
  > 单例模式是23种设计模式中最简单的一种设计模式，为了保障JVM中某一个类型的java对象永远只有一个，为了节省内存的开销

  **如果==两边都是基本数据类型，可以比较这两个基本数据类型是否相等。如果两边是引用数据类型，则比较的是内存地址**


``` code
// 懒汉单例
public class test{

  public static void main(String[] args) {

    Singleton s1 = Singleton getInstance();
    Singleton s2 = Singleton getInstance();

    System.out.println(s1 == s2); // true

  }

}

class Singleton{

  // 静态变量只执行一次,默认为null
  private static Singleton s;

  // 将构造方法私有化
  private Singleton () {}

  // 对外提供一个公开获取Singleton对象的方法
  public static Singleton getInstance() {

    if(s == null) {
      s = new Singleton();
    }
    return s;

  }

}

```

``` code
// 饿汉式单例
class Singleton{

  // 类加载时执行一次
  private static Singleton c = new Singleton();

  // 构造方法私有化
  private Singleton() {}

  // 提供公开的方法
  public static Singleton getInstance() {
    return c;
  }
}

```



## 继承

  > 一个类如果没有显示的继承其他类，则该类默认继承Object类，Object是Sun公司提供的java中的根类

  > java语言中子类继承父类，会将父类中的所有数据全部继承，包括私有的也能继承过来，但是在子类中无法直接访问父类中的私有数据，但是可以间接访问。get 和 set

  > 注意：构造方法无法继承

  ``` code

    //Super.class
    public class Super () {

        public void m1() {
          System.out.println("m1");
        }

        public void m2() {
          System.out.println("m2");
        }

    }

    // Sub.class
    // java语言中类和类之间只支持单继承
    public class Sub extends Super{

      public void m3() {
        System.out.println("m3");
      }

    }

    // test.class
    public class test {

      public static void main(String[] args) {
        Sub s = new Sub();
        s.m1;
        s.m2;
        s.m3;
      }

    }
  ```

## 方法重写override

  > 如果父类中的方法已经无法满足子类业务需求，需要将父类中的方法重新写一遍

  > 子类如果重写父类中的方法，子类对象一定调用的是子类中重写的方法

  ``` code
  1.发生在具有继承关系的两个类之间
  2.必须具有相同的方法名，相同的返回值类型，相同的参数列表
  3.重写的方法不能比被重写的方法拥有更低的访问权限
  4.重写的方法不能比被重写的方法抛出更宽泛的异常(throws Exception)
  5.私有的方法不能被覆盖
  6.构造的方法不能被覆盖，因为构造方法无法被继承
  7.静态方法不存在覆盖
  8.覆盖指的是成员方法，与成员变量无关
  ```

## 多态
  > 尽量面向抽象编程，可以使代码之间的耦合度降低，项目的扩展能力增强

### 向上转型(upcasting)和向下转型(downcasting)

  >  无论向上转型（自动类型装换）还是向下转型（强制类型转换），两个类之间必须要有继承关系

  ``` hash
    # instanceof 结果是boolean类型

    # 引用 instanceof 类型
    (a instanceof cat) --> 如果结果为true表示：a引用指向堆中的java对象是cat类型

    # 在做向下转型的时候要使用instanceof运算符判断，避免ClassCastException错误
  ```

### super关键字

  > super代表的是当前子类对象中的父类型特征，可以用在成员方法和构造方法中

  > this和super一样，都不能用在静态上下文中

  ``` hash

  # Employee.class
  public class Employee{

    String name = "张三";

    public void work() {
      System.out.println('员工在工作');
    }
  }


  # Manage.class
  public class Manage extends Employee{

    String name = "李四";

    public void work() {
      System.out.println('员工在工作');
    }

    public void m1() {
      System.out.println(this.name);
      System.out.println(name);
      System.out.println(superTest.name);

      // work();
      // this.work();
      superTest.work();
    }
  }

  ```

  参考superTest包中的代码理解
  
  > super()只能放在第一行

  > 如果构造函数第一行没有this(...)和super(...),系统会默认调用super(),super调用了父类的构造方法，但是不会创建对象，所以构造函数的调用不一定会创建对象。

  > 在java语言中只要是创建了java对象，那么Object中的无参构造方法一定会执行

  > 单例模式没有子类，因为单例模式构造函数私有化，子类构造函数默认第一行会调用super(),导致程序出错

  ### final关键字

  > final修饰的成员变量一般和static联用
  ``` code

  // 常量,而非静态变量，java规范中要求所有的常量大写
  public static final double PI = 3.14;

  ```

  ``` hash
  # final修饰的类不能被继承
  public final class A {}
  // error
  public B extends A {}


  # final修饰的方法不能被重写
  class A{
    public final void m1 () {}
  }
  // error
  class B extends A{
    public void m1 () {}
  }


  # final 修饰的局部变量，一旦赋值，不可再改变
  class A{
    public void m1() {

      // 声明
      final int i;

      // 第一次赋值
      i = 100;

      // 第二次赋值error
      i = 120;
    }
  }
  

  # final修饰的成员变量，必须`显示的`初始化
  
  class A{
    // final修饰的成员变量必须手动初始化
    // final int i; error 
    final int i = 100;

    // 成员
    final int k;
    // constructor
    A () {
      k = 200;
    }
  }

  ```


## 抽象类（abstract）

  > 抽象类不能被final修饰，抽象方法不能被final修饰

``` hash

  # 抽象类无法被实例化,但是抽象类也有构造方法，该构造方法是给子类创建对象用的。
  public abstract class A{

    A() {
      System.out.println("A...");
    }

    public static void main(String[] args) {
      // 抽象类无法创建对象
      // A a = new A();

      A a = new B();
    }
   
  }


  class B extends A{
    B() {
      //super();
      System.out.println("B...");
    }
  }

```

``` hash
  # 抽象类中可以定义抽象方法,没有方法体
  public abstract void m1();

  #抽象类中不一定有抽象方法，但抽象方法必须出现在抽象类中。
  

  # eg
   public abstract class A{

    A() {
      System.out.println("A...");
    }

    // 抽象方法
    public abstract void m1();

    public static void main(String[] args) {
      // 抽象类无法创建对象
      // A a = new A();

      A a = new B();
    }
   
  }

  // B继承了A的抽象方法，一种方式把B也写为抽象类
  abstract class B extends A{

    B() {
      //super();
      System.out.println("B...");
    }
  }

  // B继承了A的抽象方法，第二种方式把m1方法重写
  class B extends A{
    // 注意这里重写有方法体
    public void m1() {}

    B() {
      //super();
      System.out.println("B...");
    }
  }


  一个非抽象的类继承抽象类，必须将抽象类中的抽象方法覆盖，实现重写

```



### 补充深入final

  > final修饰的引用类型，该引用不可再重新指向其他的java对象。

  > 但是final修饰的引用，该引用指向的对象的属性是可以修改的。

  ``` hash

  public class Test {

    public static void main(String[] args) {

      final Customer c = new Customer("zhang", 12);
      
      // c 是final的，无法重新赋值error
      // c = new Customer("li", 20);

      c.name = "li";
      c.age = 20;

      System.out.println(c.name);
      System.out.println(c.age);

    }

  }

  class Customer{

    String name;
    int age;

    Customer(String name, int age) {
      this.name = name;
      this.age = age;
    }

  }

  ```