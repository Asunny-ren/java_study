class Person {
  private String name;
  private int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getInfo () {
    return "姓名：" + this.name + "、年龄：" + this.age;
  }
}
public class ArrayDemo {
  public static void main(String args []) {
    Person per [] = new Person [] {new Person("张三", 19),new Person("李四", 18),new Person("王武", 20)};
    for(int x = 0; x < per.length; x ++) {
      System.out.println(per[x].getInfo());
    }
  }
}