class Outer{ // 外部类
  private String msg = "www"; // 私有成员属性
  public void fun() { // 普通方法
    Inner in = new Inner();  // 实例化内部类对象
    in.print(); // 调用内部类方法
    System.out.println(in.title);
  }

  class Inner { // 在Outer类中定义内部类
    private String title = "hello";
    public void print() {
      System.out.println(Outer.this.msg); // Outer类中的属性
    }
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    Outer out = new Outer();
    out.fun();
  }
}