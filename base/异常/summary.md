# 异常

### 处理异常的两种方式

1. 声明抛出 throws

``` java
// 在方法声明的位置上使用throws关键字向上抛出异常
public class ExceptionTest {
    //public static void main (String[] args) throws FileNotFoundException{
    //public static void main (String[] args) throws IOException{
    public static void main (String[] args) throws Exception{
        // 创建文件输入流，读取文件
        FileInputStram fis = new FileInputStream("c:/a.txt");
    }
}
```

2. 捕捉 try...catch

``` java
try{
    可能出现的异常
}catch(异常类型1 变量){
    处理异常的代码
}catch(异常类型2 变量){
    处理异常的代码
}...

// catch 可以写多个，但是必须从上到下，从小到大捕捉
// try...catch语句最多执行1个catch语句块，执行结束之后try...catch...就结束了

// 编译无法通过，因为IOException包含FileNotFoundException
try{
    FileInputStream fis = new FileInputStream("c:/a.txt");
    fis.read();
}catch(IOException e) {

}catch(FileNotFoundException e) {

}
```

``` java
// 事例
import java.io.*;
public class ExceptionTest {
    public static void main(String[] args) {
        try{
            // 程序执行到此处发生了FileNotFoundException类型的异常
            // JVM会自动创建一个FileNotFoundException类型的对象，将该对象的内存地址赋值给catch语句块中的e变量
            FileInputStream fis = new FileInputStream("abc");
            // 以下语句不会执行，直接进入catch语句块
            System.out.println("abc");
            fis.read();
        }catch(fileNotFoundException e) { // e内存地址指向堆中的那个对象是“FileNotFoundException类型的”事件
            System.out.println("读取的文件不存在");

            // FileNotFoundException将Object中的toString方法重写了
            System.out.println(e); // java.io.fileNotFoundException: abc (系统找不到指定的文件)
        }catch(IOException e) {
            System.out.println("其他IO异常");
        }
        System.out.println("ABC");
    }
}

// 执行结果
读取的文件不存在
ABC
```

#### finally语句块

``` java
// 只有在执行finally语句块之前退出了JVM，则finally语句块不会执行
try{
    // return;
    // 异常
    // FileInputStream fis = new FileInputStream("c:/a.txt");

    // 退出JVM
    System.exit(0);
}finally{
    System.out.println("finally...");
}
```

``` java
import java.io.*;

public class ExceptionTest{
    public static void main (String[] args) {
        // 必须定义在外面，出了大括号就不认识了
        FileInputStream fis = null;

        try{

            fis = new FileInputStream("c:/a.txt");

        }catch(FileNotFoundException e) {

            e.printStackTrace();

        }finally{
            // 为了保证资源一定会释放
            if(fis != null) {
                try{
                    fis.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### final finalize finally区别

> 三者之间没有联系

* final final修饰的类无法被继承，final修饰的方法无法被覆盖，final修饰的局部变量一旦被赋值不可被改变，final修饰的成员变量需要手动赋值，final修饰的成员变量和static连用称为常量，常量全部大写

* finalize 是Object中的方法，垃圾回收器在回收java对象之前会先自动调用java对象的finalize方法

* finally 异常处理机制中的finally语句块


### 自定义异常

``` java
// 编译时异常继承Exception
// 运行时异常继承RuntimeException


// 自定义异常类
public class IllegalNameException extends Exception{
//public class IllegalNameException extends RuntimeException{

    public IllegalNameException() {}

    public IllegalNameException(String msg) {
        super(msg);
    }

}


// 业务类
public class CustomerService {

    public void register(String name) throws IllegalNameException{
        // 完成注册
        if(name.length() < 6) {
            throw new IllegalNameException("用户名长度不能少于6位");
        }

        // 如果代码能执行到此处，证明用户名是合法的
        System.out.println("注册成功");
    }

}


// 测试类
public class Test {

    public static void main(String[] args) {

        String name = "jack";

        CustomerService cs = new CustomerService();

        try{
             cs.register(name);
        }catch(IllegalNameException e) {
            System.out.println(e.getMessages());
        }

    }

}
```

** 重写的方法不能比被重写的方法抛出更宽泛的异常 **

``` java
import java.io.*;

class A{
    public void m1() {}
}

// 这里子类不能抛出比父类更宽泛的异常
class B extends A {
    public void m1() throws Exception {}
}
```

``` java
import java.io.*;

class A{
    // public void m1() throws FileNotFoundException {}
    public void m1() throws IOException {}
}

class B extends A {
    // 这里子类不能抛出比父类更宽泛的异常
    //public void m1() throws IOException {}
    public void m1() throws FileNotFoundException {}
}

```