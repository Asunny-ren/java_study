# interface

接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。

接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。类描述对象的属性和方法。接口则包含类要实现的方法。

除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。

接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类。另外，在Java中，接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象。

``` java
interface IMessage{
  public static final String INFO = "aaa"; // 全局常量
  public abstract String getInfo(); // 抽象方法
}

class MessageImpl implements IMessage { // 实现了接口
  public String getInfo() {
    return "bbb";
  }
}

public class JavaDemo {
  public static void main (String args[]) {
    IMessage m = new MessageImpl();
    System.out.println(m.getInfo());
    System.out.println(IMessage.INFO);
  }
}
```

``` java
interface IMessage{
  // 完整定义：
  // public static final String INFO = "aaa"; // 全局常量
  // public abstract String getInfo(); // 抽象方法
  // 方法不写访问权限也是public，而不是default，所以覆写的时候只能够使用public

  // 简化写法：
  final String INFO = "aaa"; // 全局常量
  String getInfo(); // 抽象方法
}

interface IChannel{
  public abstract boolean connect();
}

class MessageImpl implements IMessage, IChannel { // 实现了接口
  public String getInfo() {
    if(this.connect()){
      return "bbb";
    }
    return "消息发送失败";
  }
  public boolean connect () {
    System.out.println("消息发送成功");
    return true;
  }
}

public class JavaDemo {
  public static void main (String args[]) {
    IMessage m = new MessageImpl();
    System.out.println(m.getInfo());
    System.out.println(IMessage.INFO);
  }
}
```

接口与类相似点：

    一个接口可以有多个方法。

    接口文件保存在.java结尾的文件中，文件名使用接口名。

    接口的字节码文件保存在.class结尾的文件中。

    接口相应的字节码文件必须在与包名称相匹配的目录结构中。

接口与类的区别：

    接口不能用于实例化对象。

    接口没有构造方法。

    接口中所有的方法必须是抽象方法。

    接口不能包含成员变量，除了static和final变量。

    接口不是被类继承了，而是要被类实现。
    
    接口支持多重继承。

``` java
interface IMessage{
  final String INFO = "aaa"; // 全局常量
  String getInfo(); // 抽象方法
}

interface IChannel{
  public abstract boolean connect();
}

abstract class DatabaseAbstract{
  public abstract boolean databaseConnection();
}

class MessageImpl extends DatabaseAbstract implements IMessage, IChannel { // 实现了接口
  public String getInfo() {
    if(this.connect()){
      if(this.databaseConnection()){
        return "数据库得到一个消息：bbb";
      }else {
        return "数据库无法访问";
      }
    }
    return "消息发送失败";
  }
  public boolean connect () {
    System.out.println("消息发送成功");
    return true;
  }
  public boolean databaseConnection() {
    return true;
  }
}

public class JavaDemo {
  public static void main (String args[]) {
    IMessage m = new MessageImpl();
    System.out.println(m.getInfo());
  }
}
```

## 接口定义加强

## 使用接口定义标准

``` java
interface IUSB{
  public boolean check();
  public void work();
}

class Computer {
  public void plugin(IUSB usb) {
    if(usb.check()) {
      usb.work();
    }else {
      System.out.println("硬件设备出现问题");
    }
  }
}

class Keyboard implements IUSB{
  public boolean check() {
    return true;
  }
  public void work() {
    System.out.println("开始码字工作");
  }
}

class Print implements IUSB{
  public boolean check() {
    return false;
  }
  public void work() {
    System.out.println("开始打印");
  }
}

public class JavaDemo {
  public static void main (String args[]) {
    Computer computer = new Computer();
    computer.plugin(new Keyboard());
    computer.plugin(new Print());
  }
}
```

## 工厂设计模式

``` java
interface IFood {
  public void eat();
}

class Bread implements IFood {
  public void eat() {
    System.out.println("吃面包");
  }
}

class Milk implements IFood {
  public void eat() {
    System.out.println("喝牛奶");
  }
}

class Factory{
  public static IFood getInstance(String className) {
    if("bread".equals(className)) {
      return new Bread();
    }else if("milk".equals(className)){
      return new Milk();
    }else {
      return null;
    }
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    IFood food = Factory.getInstance(args[0]);
    food.eat();
  }
}

// java JavaDemo bread   吃面包
// java JavaDemo milk   喝牛奶
```

## 代理设计模式（proxy）

代理设计模式的主要特点是：一个接口提供有两个子类，其中一个子类是真实业务操作类，另外一个主题是代理业务操作类，没有代理业务操作，真实业务无法进行。

``` java
interface IEat{
  public void get();
}

class EatReal implements IEat {
  public void get() {
    System.out.println("【真实主题】得到食物");
  }
}

class EatProxy implements IEat { // 服务代理
  private IEat eat;
  public EatProxy(IEat eat) {
    this.eat = eat;
  }
  public void prepare() {
      System.out.println("【代理主题】购买食材");
      System.out.println("【代理主题】处理食材");
  }
  public void get() {
    this.prepare();
    this.eat.get();
    this.clear();
  }
  public void clear () {
    System.out.println("【代理主题】收拾碗筷");
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    IEat eat = new EatProxy(new EatReal());
    eat.get();
  }
}
```

## 抽象类与接口区别

### 定义关键字

``` java
//////////////定义关键字////////////////////

// 抽象类
abstract class 抽象类名称 {}

// 接口
interface 接口名称 {}

//////////////组成////////////////////

// 抽象类
// 构造、普通方法、静态方法、全局常量、成员

// 接口
// 抽象方法、全局常量、普通方法、static方法

//////////////权限////////////////////

// 抽象类
// 可以使用各种权限定义

// 接口
// 只能够使用public

//////////////子类使用////////////////////

// 抽象类
// 子类通过extends关键字可以继承一个抽象类

// 接口
// 子类使用implements关键字可以实现多个接口

//////////////两者关系////////////////////

// 抽象类
// 抽象类可以实现若干个接口

// 接口
// 接口不允许继承抽象类，但是允许继承多个接口

//////////////使用////////////////////

// 1.抽象类或接口必须定义子类
// 2.子类一定要覆写抽象类或接口中的全部抽象方法
// 3.通过子类的向上转型实现抽象类或接口对象实例化
```