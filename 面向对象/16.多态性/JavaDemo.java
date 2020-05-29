class Person {
  public void print() {
    System.out.println("xxxxx 一个正常的人类 xxxxx");
  }
}

class SuperMan extends Person{
  public String fly() {
    return "我可以飞";
  }
  public String fire() {
    return "我可以喷火";
  }
}

public class JavaDemo{
  public static void main (String args []) {
    Person per = new SuperMan(); // 向上转型
    System.out.println(per instanceof Person);
    System.out.println(per instanceof SuperMan);
  }
}