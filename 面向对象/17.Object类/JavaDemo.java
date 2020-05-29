class Person{
  private String name;
  private int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getName(String name) {
    return this.name;
  }
  public int getAge(int age) {
    return this.age;
  }

  @Override
  public String toString() {
    return "姓名：" + this.name + "、年龄：" + this.age;
  }

  public boolean equals (Object obj) {
    if(!(obj instanceof Person || obj == null)) { // 先判断是否是一个类型
      return false;
    }
    if(this == obj) { // 跟自己比较，同一个地址
      return true;
    }
    Person per = (Person) obj;
    return this.name.equals(per.name) && this.age == per.age;
  }
}

public class JavaDemo{
  public static void main (String args []) {
    Person perA = new Person("zhangsan", 18);
    Person perB = new Person("zhangsan", 18);
    System.out.println(perA.equals(perB)); // 姓名：zhangsan、年龄：18
  }
}