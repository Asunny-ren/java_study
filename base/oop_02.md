# java 面向对象 Object-Oriented

* OOA 面向对象分析 analyse

* OOD 面向对象设计 design

* OOP 面向对象编程 programming

## Object类

* toString

    > SUN公司设计的Object的toString方法返回的是实例化对象的内存地址，十六进制的，一般在使用toString方法时都要按照项目需求重写这个方法

``` java
public String toString () {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}

```

* equals

``` java
// 双等号两边如果是引用类型，则比较内存地址
public boolean equals (Object obj) {
    return (this == obj);
}
```

``` java
public class Test {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        boolean b1 = o1.equals(o2);
        System.out. println(b1); // false

        Person p1 = new Person("张三", 22);
        Person p2 = new Person("张三", 22);
        System.out.println(p1.equals(p2)); // true;
    }
}

class Person () {
    int id;
    String name;

    public Person (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals (Object obj) {
        if(this == obj) return true;

        if(obj instanceof Person) {
            Person p = (Person)obj;
            if(p.id == id && p.name.equals(name)) {
                return true;
            }
        }
        return false;
    }
}

```

* finalize

    > 垃圾回收机制 GC

* hashCode

    > hashCode方法返回的是该对象的哈希码值，java对象的内存地址经过哈希算法得出的int类型的数值。

## package

    > pakage放在程序的第一行，import导入包放在package和class之间，

## 访问权限控制

> 可以限定其它类对该类、属性和方法的使用权限

* private:只能在本类中访问

* default: 缺省，本类、同一个包下、不同包不行，继承也不行

* protected:本类、同一个包下、不同包下不行，但是子类可以

* public:可以在任何位置访问

修饰符  |  类的内部  |  同一个包里  |  子类  |  任何地方
---    |  ---      |  ---       |  ---  |  ---
private    |  Y  |  N  |  N  |  N
default    |  Y  |  Y  |  N  |  N
protected  |  Y  |  Y  |  Y  |  N
public     |  Y  |  Y  |  Y  |  Y

**在user.java文件中类user只能用public或者缺省修饰**

## inner_class 内部类

* 静态内部类

``` java
// 静态内部类可以等同看作静态变量
// 作用：可以访问外部类中的私有数据
// 静态内部类可以直接访问外部类的静态数据，无法直接访问成员数据
public class OuterClass {
    // 静态变量
    static String s1 = "a";

    // 成员变量
    private String s2 = "b";

    // 静态方法
    private static void m1 () {
        System.out.println("static's m1 method excute!");
    }

    // 成员方法
    private void m2 () {
        System.out.println(" m2 method excute!");
    }

    // 静态内部类
    // 可以用访问控制权限的修饰符修饰public  protected private 缺省
    static class InnerClass{
        //静态方法
        public static void m3 () {
            System.out.println(s1);
            // System.out.println(s2); 编译无法通过，无法从静态上下文中引用非静态变量
            s1();
            // s2(); 编译无法通过，无法从静态上下文中引用非静态方法
        }

        // 成员方法
        public void m4 () {
            System.out.println(s1);
            // System.out.println(s2); 编译无法通过，无法从静态上下文中引用非静态变量
            s1();
            // s2(); 编译无法通过，无法从静态上下文中引用非静态方法
        }
    }

    // 入口
    public static void main (String[] args) {
        // 执行m3
        OuterClass.InnerClass.m3();

        // 执行m4
        InnerClass inner = new OuterClass.InnerClass();
        inner.m4();
    }
}
```

* 成员内部类

``` java
// 成员内部类可以等同看作成员变量
// 成员内部类中不能有静态声明
// 成员内部类可以访问外部类所有的数据
public class OuterClass {
    // 静态变量
    static String s1 = "a";

    // 成员变量
    private String s2 = "b";

    // 静态方法
    private static void m1 () {
        System.out.println("static's m1 method excute!");
    }

    // 成员方法
    private void m2 () {
        System.out.println(" m2 method excute!");
    }

    // 成员内部类
    // 可以用访问控制权限的修饰符修饰public  protected private 缺省
    class InnerClass{
        //静态方法  !成员内部类不能有静态声明!
        // public static void m3 () {}

        // 成员方法
        public void m4 () {
            System.out.println(s1);
            System.out.println(s2);
            s1();
            s2();
        }
    }


    // 入口
    public static void main (String[] args) {
        // 创建外部类对象
        OuterClass oc = new OuterClass();

        InnerClass inner = oc.new InnerClass();

        inner.m4();

    }
}

```

* 局部内部类

``` java
// 局部内部类等同于局部变量
// 从内部类中访问局部变量，需要被声明为最终类型,局部变量必须要使用final修饰
public class OuterClass {
    // 方法
    public void m1 () {

        // 局部变量
        final int i = 10;

        // 局部内部类，不能用访问控制修饰符修饰
        class InnerClass {

            // 内部类不能有静态声明
            // public static void m1() {}

            // 成员方法
            public void m2 () {

            }
        }

        // 调用m2
        InnerClass inner = new InnerClass();
        inner.m2();
    }

    // 入口
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.m1();
    }
}
```

* 匿名内部类

``` java
public class Test {
    // 静态方法
    public static void t (CustomerService cs) {
        cs.logout();
    }

    // 入口
    public static void main (String[] args) {
        // 调用t方法
        t(new CustomerServiceImpl());
    }
}


// 定义一个接口
interface CustomerService {
    // 推出系统
    void logout();
}

// 实现接口

class CustomerServiceImpl implments CustomerService {
    public void logout () {
        System.out.println("退出系统");
    }
}
```

``` java
// 使用匿名内部类的写法
// 匿名内部类指的是类没有名字
public class Test {
    // 静态方法
    public static void t (CustomerService cs) {
        cs.logout();
    }

    // 入口
    public static void main (String[] args) {
        // 调用t方法
        //t(new CustomerServiceImpl());
        // 整个“new CustomerService(){}”就是个匿名内部类
        t(new CustomerService(){
            public void logout () {
                System.out.println("退出系统");
            }
        });
        // 匿名内部类少定义了一个类，但是无法重复使用
    }
}


// 定义一个接口
interface CustomerService {
    // 推出系统
    void logout();
}
```


