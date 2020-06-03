enum Sex{ // 枚举类
  MALE("男"),FEMALE("女"); // 枚举对象要放在首行
  private String title;
  private Sex(String title) {
    this.title = title; 
  }
  public String toString() {
    return this.title;
  }
}

class Person {
  private String name;
  private int age;
  private Sex sex;
  public Person (String name, int age, Sex sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }

  public String toString () {
    return "姓名： " + this.name + "，年龄： " + this.age + "，性别： " + this.sex;
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    System.out.println(new Person("rjd", 18, Sex.MALE));
  }
}