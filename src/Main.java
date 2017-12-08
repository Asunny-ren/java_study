public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main.sumInt(20, 30);


        // 方法的重载
        // System.out = PrintStream, println就是一种重载
        System.out.println(Computed.sum(1, 2));
        System.out.println(Computed.sum(1.0, 2.0));
        System.out.println(Computed.sum(1L, 2L));

        // 创建对象，new出来的数据都是存储在堆中，无法直接对堆区数据进行操作，只能通过内存地址间接操作
        // Student stu  = new Student();


    }

    /* [方法的修饰符列表] 方法的返回值类型 方法名(方法的形式参数列表) {
            java 语句;
        }

        [方法的修饰符列表]是可选项，暂时先写public static
        方法的返回值类型，可以是java语言中的任意一种数据类型(基本数据类型和引用数据类型)
        如果方法结束之后没有任何返回值，那么定义方法的时候，返回值类型写void,否则在方法体中必须使用return语句来返回数据，并且在方法体中必须保证有返回值
    */
    public static void sumInt(int a, int b) {
        int c = a + b;
        System.out.println(c);
    }
    
}

// 重载
/*
    什么时候使用方法的重载
    1.发生在同一个类中
    2.方法名相同
    3.参数列表不同(类型 个数 顺序)
    4.与返回值无关
    5.与方法的修饰符无关
* */
class Computed {
    public static int sum(int a , int b) {
        return a + b;
    }
    public static double sum(double a , double b) {
        return a + b;
    }
    public static long sum(long a , long b) {
        return a + b;
    }
}
