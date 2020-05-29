public class JavaDemo{
  public static void main(String args[]) {
    final String strA = "final"; // 这里strA已经定义为一个常量
    String strB = "hellofinal";
    String strC = "hello" + strA;
    System.out.println(strB == strC); // true
  }
}