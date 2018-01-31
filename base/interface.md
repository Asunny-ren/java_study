# interface

> 接口也是一种引用类型，可以等同看作类

``` java
    [修饰符] interface 接口名 {

    }

    接口中只能出现：常量、抽象方法

    接口是一个特殊的抽象类，接口是完全抽象的

    接口中没有构造方法，也无法被实例化

    接口和接口之间可以多继承

    一个类可以实现多个接口（这里的实现可以等同看作 继承 ）

    一个非抽象的类实现接口，需要将接口中所有的方法“实现／重写／覆盖”
```

``` java
public interface A{
    // 常量必须用public static final修饰, 可以省略不写
    public static final String SUCCESS = "success";

    public static final double PI = 3.14;

    byte MAX_VALUE = 127;// 省略之后并不是成员变量，还是常量

    // 抽象方法：接口中所有的抽象方法都是public abstract,也是可以省略的

    public abstract void m1 ();

    void m2();
}
```

``` java
    // 多继承
    interface B {
        void m1();
    }
    interface C {
        void m2();
    }
    interface D {
        void m3();
    }

    interface E extends B,C,D{
        void m4();
    }
```

``` java
    // implements是实现的意思，是一个关键字
    // implements和extends意义相同
    class MyClass implements B,C{
        public void m1() {};
        public void m2() {};
    }

    class F implements E{
        public void m1() {};
        public void m2() {};
        public void m3() {};
        public void m4() {};
    }
```
