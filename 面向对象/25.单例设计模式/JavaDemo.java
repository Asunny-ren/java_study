class Color { // 定义描述颜色的类
  private static final Color RED = new Color("红色");
  private static final Color GREEN = new Color("绿色");
  private static final Color YELLOW = new Color("黄色");
  private String title;
  private Color(String title) { // 构造方法私有化
    this.title = title;
  }

  public static Color getInstance (String color) {
    switch(color){
      case "red": return RED;
      case "green": return GREEN;
      case "yellow": return YELLOW;
      default: return null;
    }
  }

  public String toString() {
    return this.title;
  }
}

public class JavaDemo{
  public static void main(String args[]) {
    Color c = Color.getInstance("red");
    System.out.println(c);
  }
}