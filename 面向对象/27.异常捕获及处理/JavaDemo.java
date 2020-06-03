public class JavaDemo {
  public static void main(String args[]) {
    try{
      throw new Exception("自己抛着玩的异常对象");
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}