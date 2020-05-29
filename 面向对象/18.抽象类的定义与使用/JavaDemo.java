abstract class Message { // 定义抽象类
  private String type; // 消息类型
  public abstract String getConnectInfo(); // 抽象方法
  public void setType(String type) { // 普通方法
    this.type = type;
  }
  public String getType() { // 普通方法
    return this.type;
  }
}

class DataBaseMessage extends Message {
  public String getConnectInfo() {
    return "子类覆写抽象方法";
  }
}

public class JavaDemo{
  public static void main (String args[]) {
    Message msg = new DataBaseMessage();
    msg.setType("客户消息");
    System.out.println(msg.getConnectInfo());
    System.out.println(msg.getType());
  }
}