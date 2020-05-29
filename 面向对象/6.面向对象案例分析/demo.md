# 案例分析

## 案例一

``` java
class Address {
  private String country;
  private String province;
  private String city;
  private String street;
  private String zipcode;
  public Address () {

  }
  public Address (String country, String province, String city, String street, String zipcode) {
    this.country = country;
    this.province = province;
    this.city = city;
    this.street = street;
    this.zipcode = zipcode;
  }
  public String getCountry () {
    return this.country;
  }
  public void setCountry (String country) {
    this.country = country;
  }
  public String getProvince() {
    return this.province;
  }
  public void setProvince(String province) {
    this.province = province;
  }
  public String getCity () {
    return this.city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getStreet() {
    return this.street;
  }
  public void setStreet(String street) {
    this.street = street;
  }
  public String getZipcode () {
    return this.zipcode;
  }
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  public String getInfo () {
    return "国家：" + this.country + "、省份：" + this.province + "、城市：" + this.city + "、街道：" + this.street + "、邮编：" + this.zipcode;
  }
}

public class javaDemo{
  public static void main(String[] args) {
    Address adr = new Address("中国", "山西", "太原", "南中环" ,"600200");
    System.out.println(adr.getInfo());
  }
}
```

## 案例二

``` java
class Employee {
  private long empno;
  private String ename;
  private double salary;
  private double rate;
  public Employee () {}
  public Employee (long empno, String ename, double salary, double rate) {
    this.empno = empno;
    this.ename = ename;
    this.salary = salary;
    this.rate = rate;
  }
  public double salaryIncValue () { // 薪水的增长额度
    return this.salary * this.rate;
  }
  public double salaryIncResult () { // 工资总额
    this.salary = this.salary + this .salary * this.rate;
    return this.salary; 
  }
  public String getInfo() {
    return "员工编号：" + this.empno + "、姓名：" + this.ename + "、薪水：" + this.salary + "、工资增长率" + this.rate;
  }

  // setter getter 略
 }

public class javaDemo{
  public static void main(String[] args) {
    Employee emp = new Employee(7369L, "史密斯", 10000.0, 0.3);
    System.out.println(emp.getInfo());
    System.out.println("工资增长额度:" + emp.salaryIncValue());
    System.out.println("工资增长：" + emp.salaryIncResult());
    System.out.println("工资增长后：" + emp.getInfo());
  }
}
```

## 案例三

``` java
class Account {
  private String name;
  private double balance;
  public Account() {}
  public Account (String name) {
    this(name, 0.0);
  }
  public Account (String name, double balance) {
    this.name = name;
    this.balance = balance;
  }
  // setter getter 略
  public double getBalance() {
    return this.balance;
  }
  public String getInfo () {
    return "账户名称:" + this.name + "、余额:" + this.balance;
  }
 }

public class javaDemo{
  public static void main(String[] args) {
    Account ac = new Account("史密斯", 90000.00);
    System.out.println(ac.getBalance());
    System.out.println(ac.getInfo());
  }
}
```

## 案例四

``` java
class User {
  private String uid;
  private String pwd;
  private static int count = 0;
  public User () {
    this("noid", "123");
  }
  public User (String uid) {
    this(uid, "123");
  }
  public User (String uid, String pwd) {
    this.uid = uid;
    this.pwd = pwd;
    count ++;
  }
  // setter getter 略
  public static int getUserTotal () {
    return count;
  }
  public String getInfo () {
    return "用户id:" + this.uid + "、用户密码：" + this.pwd;
  }
}

public class javaDemo{
  public static void main(String[] args) {
    User userA = new User();
    User userB = new User("lalal");
    User userC = new User("asdas", "*****");
    System.out.println(userA.getInfo());
    System.out.println(userB.getInfo());
    System.out.println(userC.getInfo());
    System.out.println("用户总数：" + User.getUserTotal());
  }
}
```

## 案例五

``` java
class Book {
  private String title;
  private int bid;
  private double price;
  private static int count = 0;
  public Book(){}
  public Book(String title, double price) {
    this.bid = count + 1;
    this.title = title;
    this.price = price;
    count ++;
  }
  // setter getter 略
  public String getInfo () {
    return "图书编号：" + this.bid + "、书名：" + this.title + "、价格：" + this.price;
  }
  //
  public static int getTotal () {
    return count;
  }
}

public class javaDemo{
  public static void main(String[] args) {
    Book b1 = new Book("书啦啦", 29.0 );
    Book b2 = new Book("书啦啦啦", 19.0 );
    System.out.println(b1.getInfo());
    System.out.println(b2.getInfo());
    System.out.println("图书总数" + Book.getTotal());
  }
}
```
