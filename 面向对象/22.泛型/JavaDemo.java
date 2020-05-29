interface IMessage{
  public void send(String str);
}

class MessageImpl implements IMessage {
  public void send(String str) {
    System.out.println("消息发送" + str);
  }
}

class Factory {
  public static <T> T getInstance(String className, T t) {
    if("messageImpl".equalsIgnoreCase(className)){
      return new MessageImpl();
    }
    return null;
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    IMessage msg = (MessageImpl)Factory.getInstance("messageImpl", IMessage.class);
    msg.send("www");
  }
}