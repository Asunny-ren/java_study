interface IEat{
  public void get();
}

class EatReal implements IEat {
  public void get() {
    System.out.println("【真实主题】得到食物");
  }
}

class EatProxy implements IEat { // 服务代理
  private IEat eat;
  public EatProxy(IEat eat) {
    this.eat = eat;
  }
  public void prepare() {
      System.out.println("【代理主题】购买食材");
      System.out.println("【代理主题】处理食材");
  }
  public void get() {
    this.prepare();
    this.eat.get();
    this.clear();
  }
  public void clear () {
    System.out.println("【代理主题】收拾碗筷");
  }
}

public class JavaDemo {
  public static void main(String args[]) {
    IEat eat = new EatProxy(new EatReal());
    eat.get();
  }
}