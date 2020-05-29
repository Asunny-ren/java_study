public class JavaDemo {
  public static void main(String args[]) {
    int resultA = sum(10 , 10);
    int resultB = sum(10, 1, 2);
    double resultC = sum(10.0, 1.0);

    System.out.println(resultA);
    System.out.println(resultB);
    System.out.println(resultC);
  }

  public static int sum(int x, int y) {
    return x + y;
  }
  
  public static int sum(int x, int y, int z) {
    return x + y + z;
  }

  public static double sum (double x, double y) {
    return x + y;
  }
}