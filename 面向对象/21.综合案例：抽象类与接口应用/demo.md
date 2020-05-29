# 案例

## 案例一

``` java
interface IClassName{
  public String getClassName();
}

class Company implements IClassName{
  public String getClassName() {
    return "Company";
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    IClassName ica = new Company();
    System.out.println(ica.getClassName()); // Company
  }
}
```

## 案例二

``` java
// 利用接口
interface IGraphical {
  public void paint(); // 绘图
}

class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }
}

class Triangle implements IGraphical {
  private Point[] x;
  private Point[] y;
  private Point[] z;

  public Triangle(Point[] x, Point[] y, Point[] z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public void paint() {
    System.out.println("绘制第一条边，开始坐标[" + this.x[0].getX() + "," + this.x[0].getY() + "],结束坐标[" + this.x[1].getX() + ","
        + this.x[1].getY() + "]");
    System.out.println("绘制第二条边，开始坐标[" + this.y[0].getX() + "," + this.y[0].getY() + "],结束坐标[" + this.y[1].getX() + ","
        + this.y[1].getY() + "]");
    System.out.println("绘制第三条边，开始坐标[" + this.z[0].getX() + "," + this.z[0].getY() + "],结束坐标[" + this.z[1].getX() + ","
        + this.z[1].getY() + "]");
  }
}

class Circular implements IGraphical {
  private double radius;

  public Circular(double radius) {
    this.radius = radius;
  }

  public void paint() {
    System.out.println("以半径为" + this.radius + "绘制圆形");
  }
}

class Factory {
  public static IGraphical getInstance(String className, double ... args) {
    if ("triangle".equalsIgnoreCase(className)) {
      return new Triangle(
        new Point[] { new Point(args[0], args[1]), new Point(args[2], args[3]) },
        new Point[] { new Point(args[4], args[5]), new Point(args[6], args[7]) },
        new Point[] { new Point(args[8], args[9]), new Point(args[10], args[11]) }
      );
    } else if ("Circular".equalsIgnoreCase(className)) {
      return new Circular(args[0]);
    } else {
      return null;
    }
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    IGraphical iga = Factory.getInstance("triangle", 1.1, 2.2, 3.3, 4.4,11.11, 22.22, 33.33, 44.44,111.111, 222.222, 333.333, 444.444);
    iga.paint();
    IGraphical cir = Factory.getInstance("Circular", 88);
    cir.paint();
  }
}
// 绘制第一条边，开始坐标[1.1,2.2],结束坐标[3.3,4.4]
// 绘制第二条边，开始坐标[11.11,22.22],结束坐标[33.33,44.44]
// 绘制第三条边，开始坐标[111.111,222.222],结束坐标[333.333,444.444]
// 以半径为88.0绘制圆形
```

## 案例三

``` java
// 利用抽象方法
abstract class AbsShape {
  public abstract double area();
  public abstract double perimeter();
}

class Circular extends AbsShape {
  private double radius;
  public Circular (double radius) {
    this.radius = radius;
  }
  public double area () {
    return 3.1415926 * this.radius * this.radius;
  }
  public double perimeter () {
    return 2 * 3.1415926 * this.radius;
  }
}

class Rectangle extends AbsShape {
  private double length;
  private double width;
  public Rectangle (double length, double width) {
    this.length = length;
    this.width = width;
  }
  public double area () {
    return this.length * this.width;
  }
  public double perimeter () {
    return 2 * (this.length + this.width);
  }
}

class Factory{
  public static AbsShape getInstance(String className, double ... args){
    if("Circular".equalsIgnoreCase(className)){
      return new Circular(args[0]);
    }else if("Rectangle".equalsIgnoreCase(className)){
      return new Rectangle(args[0], args[1]);
    }else {
      return null;
    }
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    AbsShape asa = Factory.getInstance("Circular", 3);
    System.out.println("圆形的面积：" + asa.area());
    System.out.println("圆形的周长：" + asa.perimeter());
    AbsShape asb = Factory.getInstance("Rectangle", 10, 15);
    System.out.println("长方形的面积：" + asb.area());
    System.out.println("长方形的周长：" + asb.perimeter());
  }
}
```