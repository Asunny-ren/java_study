public class JavaDemo {
  public static void main(String args[]) {
    System.out.println("【1】******程序执行开始");
    try{
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);
      System.out.println("【2】******数字计算" + ( x / y ));
    }catch(ArithmeticException e) {
      e.printStackTrace();
    }catch(NumberFormatException e) {
      e.printStackTrace();
    }catch(ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }finally {
      System.out.println("【F】不管是否出现异常都执行");
    }
    System.out.println("【3】******程序执行完毕");
  }
}