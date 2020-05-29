class Person {
  // 这里将成员属性私有化封装，防止外部直接调用
  private String name;
  private int age;

  public void setName (String n) {
    name = n;
  }
  public void setAge (int a) {
    age = a;
  }
  public String getName () {
    return name;
  }
  public int getAge () {
    return age;
  }

  public void tell () {
    System.out.print("姓名：" + name + "、年龄:" + age);
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    Person per = new Person();
    per.setName("张三");
    per.setAge(18);
    per.tell();
  }
}