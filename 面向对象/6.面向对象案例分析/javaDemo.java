class Book {
  private String title;
  private int bid;
  private double price;
  private static int count = 0;
  public Book(){}
  public Book(String title, double price) {
    this.bid = count + 1;
    this.title = title;
    this.price = price;
    count ++;
  }
  // setter getter 略
  public String getInfo () {
    return "图书编号：" + this.bid + "、书名：" + this.title + "、价格：" + this.price;
  }
  //
  public static int getTotal () {
    return count;
  }
}

public class javaDemo{
  public static void main(String[] args) {
    Book b1 = new Book("书啦啦", 29.0 );
    Book b2 = new Book("书啦啦啦", 19.0 );
    System.out.println(b1.getInfo());
    System.out.println(b2.getInfo());
    System.out.println("图书总数" + Book.getTotal());
  }
}