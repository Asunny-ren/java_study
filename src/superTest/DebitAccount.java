package superTest;

/*
    super 关键字用在构造方法中：
        语法： super(实参)
    作用：通过子类的构造方法调用父类的构造方法

    语法规则：一个构造方法第一行如果没有this(...),也没有super(...);
            系统会默认调用super(...)

    注意： super(...)的调用只能放在第一行,super(...)和this(...)不能共存
          super()调用了父类中的构造方法，但是不会创建父类对象

    在java语言中只要是创建java对象，那么Object中的无参数构造方法一定会执行

    单例模式的缺点：
        单例模式的类型无法被继承

 */
public class DebitAccount extends Account{

    // field
    private double debit;

    // constructor
    DebitAccount() {}

    DebitAccount(String actno, boolean balance, double debit) {

        //通过子类的构造方法去调用父类的构造方法，作用是： 给当前子类的对象中的父类型特征赋值,这儿super不会创建对象
        super(actno, balance);
        this.debit = debit;

    }

    // getter and setter
    public void setDebit(double debit) {
        this.debit = debit;
    }
    public double getDebit() {
        return this.debit;
    }
}