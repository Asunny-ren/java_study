class StringUtil{
  public static String initScap(String str){
    if(str == null || "".equals(str)) return str;
    if(str.length() == 1){
      return str.toUpperCase();
    }
    return str.substring(0 ,1).toUpperCase() + str.substring(1);
  }
}

public class JavaDemo{
  public static void main(String args[]) {
    System.out.println(StringUtil.initScap("hello world"));
    System.out.println(StringUtil.initScap("h"));
    System.out.println(StringUtil.initScap("我"));
  }
}

