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