class Person{
  private String name;
  public void setName(String name) {
    this.name = name;
  }
  public String getName () {
    return this.name;
  }
}

class Student extends Person{
  public Student(String name) {
    setName(name);
  }
  public void fun () {
    // System.out.println(name); // 直接访问不可能，因为是私有的
    System.out.println(getName());  // 间接访问
  }
}

public class JavaDemo{
  public static void main(String args[]) {
    Student stu = new Student("zhangsan");
    stu.fun();
  }
}