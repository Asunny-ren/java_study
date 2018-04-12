# 类和类之间的关系

* 泛化关系(is-a)

> 类和类之间，接口和接口之间的继承叫做泛化关系

``` java
public class A {

}

public class B extends A {

}

public interface C {

}

public interface D extends C {

}

```

* 实现关系(is-like-a)

> 类对接口的实现属于实现关系

``` java
public interface A {

}

public class B implements A {

}
```

* 关联关系(has-a)

> 类与类之间的连接，一个类可以知道另一个类的属性和方法

``` java
public class Me {
    // field
    String name;
    // 在当前类中含有其他类的引用
    Friend f; // Me 和 Friend 就是一种关联关系
}

public class Friend {
    String name;
    String addr;
    String contact;
}
```

* 聚合关系

> 是关联关系的一种，是较强的关联关系，是整体和部分的关系，整体不依赖部分，部分也不依赖整体，整体无法决定部分的生命周期

``` java
public class Student {

}

public class ClassRoom {
    //Student s;

    // ClassRoom 和List 是关联关系，和stus是聚合关系
    List<Student> stus;// ClassRoom是整体，Student是部分
}

```

* 合成关系

> 合成关系和聚合关系是相似的，区别在于：整体和部分是紧密相连的，整体的生命周期决定部分的生命周期。


* 依赖关系

> 

``` java
public class User {

}

public class Test {
    public void m1() {
        // 局部变量
        User u = new User(); // 依赖关系
    }
}
```