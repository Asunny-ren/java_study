# java学习知识点小记

* 拓展运算符不改变类型

``` java
  byte i = 10;

  // i = i + 10;编译不通过，java语言中存在变量类型转换，小精度可以转换为大精度的，但是大精度转小精度会损失精度，通过强制转换类型
  // int a = 10;
  // i = (byte)a;


  i += 10 //编译通过
```

* break & return

``` java
public class BreakTest{
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
      if(i == 5) {
        //break; 只会终止循环
        return; // 直接终止方法，同js
      }
    }
    System.out.println('hello world');
  }
}
```

``` java
public class BreakTest {
  public static void main (String[] args) {
    /* for(int i = 5; i > 0; i--) {
      for (int j = 0; j < i; j ++) {
        if(j == 2) {
          break;
        }
        System.out.println(j);
      }
    } */
    
    outerFor: for(int i = 5; i > 0; i--) {
      for (int j = 0; j < i; j ++) {
        if(j == 2) {
          break outerFor;
        }
        System.out.println(j);
      }
    }
  }
}
```

* continue

``` java
public class ContinueTest{
  public static void main (String[], args) {
    for(int i = 0; i < 10; i++) {
      if(i == 5) {
        continue;
      }
      System.out.println(i);
    }
  }
}
// 到5的时候continue会终止循环中的语句，执行下一次循环
0
1
2
3
4
6
7
8
9
```

* 方法

  > 方法只有在调用的时候才会在内存中分配空间，并且是在栈中分配空间(JVM内存中有一块内存是栈内存),方法调用其实就是压栈，方法结束就是出栈

``` code
    /* [方法的修饰符列表] 方法的返回值类型 方法名(方法的形式参数列表) {
                java 语句;
            }

            [方法的修饰符列表]是可选项，暂时先写public static
            方法的返回值类型，可以是java语言中的任意一种数据类型(基本数据类型和引用数据类型)
            如果方法结束之后没有任何返回值，那么定义方法的时候，返回值类型写void,否则在方法体中必须使用return语句来返回数据，并且在方法体中必须保证有返回值
        */
        public static void sumInt(int a, int b) {
            int c = a + b;
            System.out.println(c);
        }
```

* 方法重载(overload)

* 栈(stack) 先进后出

* 堆 先进先出

* 面向对象封装性

    > 私有化，对外提供公开的get和set方法，set和get方法注意遵循规范setAge  getAge

* 构造方法

``` code

    静态方法 类名.xxx  ()
    成员方法 引用.xxx  (set,get)


    关于java类的构造函数
    1. 语法
    [修饰符列表] 构造方法名(形式参数列表) {
        方法体
    }
    2.构造方法的方法名必须和类名一致

    3.作用
        创建对象
        给成员变量赋值（初始化成员变量）

    4. 调用
        new 构造方法名(实参) 在堆中开辟空间存储对象

    5.如果一个类没有提供任何构造方法，系统默认提供无参构造方法，如果一个类已经手动提供了构造方法，那么系统不会再提供任何构造方法。
```
