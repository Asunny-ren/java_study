class Emp {
  private long empno;
  private String ename;
  private String dept;
  private double salary;

  // 构造方法
  public Emp () {
    this(1000, "无名氏", null, 0.0);
  }
  public Emp (long empno) {
    this(empno, "新员工", "未定", 0.0);
  }
  public Emp (long empno,String ename, String dept) {
    this(empno, ename, dept, 0.0);
  }
  public Emp (long empno,String ename, String dept, double salary) {
    this.empno = empno;
    this.ename = ename;
    this.dept = dept;
    this.salary = salary;
  }

  // setter getter省略
  // ...

  // 普通方法
  public String getInfo () {
    return "员工编号:" + this.empno + 
            "、员工姓名:" + this.ename + 
            "、员工部门:" + this.dept + 
            "、员工薪水:" + this.salary;
  }
}

public class javaDemo{
  public static void main(String args[]) {
    Emp emp = new Emp(7369L, "sunnyren", "财务部" );
    System.out.print(emp.getInfo());
  }
} 