class Channel {
  @Deprecated // 
  public void connet () {
    System.out.println("****** 父类Channel *******");
  }
  public String connetion () {
    return "****** 获取了xxx通道的连接信息 *******";
  }
}
public class JavaDemo{
  @SuppressWarnings({"deprecation"})
  public static void main (String args []) {
    new Channel().connet();
  }
}