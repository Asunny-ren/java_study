public class javaDemo{
  public static void main (String args[]) {
    tell();
    new javaDemo().say();
  }

  public static void tell () {
    System.out.println("xxxxx");
  }

  public void say () {
    System.out.println("*****");
  }
}