# 数组的定义与使用

在java中将数组定义为引用数据类型

* 数组的动态初始化
  
  数组的动态初始化，初始化之后数组每一个元素的保存内容为其对应数据类型的默认值
  
  声明并初始化数组： 
    
    数据类型 数组名称 [] = new 数据类型 [];
    
    数据类型 [] 数组名称 = new 数据类型 [];

``` java
public class ArrayDemo {
  public static void main(String [] args) {
    // 使用数组动态初始化定义数组,如果未赋值则为对应数据类型的默认值,
    int data [] = new int [3];
    data[0] = 1;
    data[1] = 10;
    data[2] = 11;
    for(int x = 0; x < data.length; x++) {
      System.out.println(data[x]);
    }
    // 如果越界，则会报java.lang.ArrayIndexOutOfBoundsException异常
    System.out.println(data[3]);
  }
}
```

* 数组的静态初始化 

  在数组定义的时候就为其设置好了里面的内容

  简化格式：

  数据类型 数组名称 [] = {数据1,数据2, ...};

  完整格式：

  数据类型 数组名称 [] = new 数据类型 [] {数据1,数据2, ...};

``` java
public class ArrayDemo {
  public static void main(String [] args) {
    // 使用数组静态初始化定义数组,
    int data [] = new int [] {1,2,3};
    for(int x = 0; x < data.length; x++) {
      System.out.println(data[x]);
    }
  }
}
```

## 数组的引用传递

由于数组属于引用数据类型，所以一定要为其开辟内存空间之后才可以使用，如果使用了未开辟堆内存空间的数组会出现“java.lang.NullPointerException”异常（空指针异常）

``` java
public class ArrayDemo {
  public static void main(String [] args) {
    // 使用数组静态初始化定义数组,
    int data [] = new int [] {1,2,3};
    int temp [] = data;
    temp[0] = 99;
    for(int x = 0; x < data.length; x++) {
      System.out.println(data[x]);
    }
  }
}
```

## foreach迭代输出

for(数据类型 变量 : 数组 ｜ 集合) {}

``` java
public class ArrayDemo {
  public static void main(String [] args) {
    // 使用数组静态初始化定义数组,
    int data [] = new int [] {1,2,3};
    for (int temp: data) {
      System.out.println(temp);
    }
  }
}
```

## 二维数组

* 动态初始化

  数据类型 数组名称 [][] = new 数据类型 [行个数] [列个数]; 

* 静态初始化

  数据类型 数组名称 [][] = new 数据类型 [][]{{数据1, 数据2, ...}, {数据x, 数据y, ...}, ...}

``` java
public class ArrayDemo {
  public static void main(String [] args) {
    // 使用二维数组静态初始化定义数组,
    int data [][] = new int [][] {{1,2,3,4,5}, {1,2,3}, {4,2,6}};
    for(int x = 0; x < data.length; x ++) {
      for(int y = 0; y < data[x].length; y ++) {
        System.out.println("data[" + x + "-" + y + "] = " + data[x][y]);
      }
      System.out.println();
    }
  }
}
```

``` java
// 使用foreach遍历二维数组
public class ArrayDemo {
  public static void main(String [] args) {
    // 使用数组静态初始化定义数组,
    int data [][] = new int [][] {{1,2,3,4,5}, {1,2,3}, {4,2,6}};
    for(int x []: data){
      for(int y : x) {
        System.out.println(y + "、");
      }
    }
  }
}
```

## 数组排序案例

``` java
class ArrayUtil {
  public static void sort (int data []) {
    for(int x = 0; x < data.length; x ++) {
      for(int y = 0; y < data.length - x - 1; y ++) {
        if(data[y] > data[y + 1]) {
          int temp = data[y];
          data[y] = data[y + 1];
          data[y + 1] = temp;
        }
      }
    }
  }
  public static void printArray (int [] temp) {
    for(int x = 0; x < temp.length; x ++){
      System.out.println(temp[x] + "、");
    }
  }
}
public class ArrayDemo {
  public static void main(String [] args) {
    int data [] = new int [] {8,9,0,2,3,5,10,7,6,1};
    ArrayUtil.sort(data);  
    ArrayUtil.printArray(data);
  }
}
```

## 数组转置

``` java
class ArrayUtil {
  public static void reverse (int data []) {
    int center = data.length / 2;
    int head = 0;
    int tail = data.length - 1;
    for(int x = 0; x < center; x ++) {
      int temp = data[head];
      data[head] = data[tail];
      data[tail] = temp;
      head++;
      tail--;
    }
  }
  public static void printArray (int [] temp) {
    for(int x = 0; x < temp.length; x ++){
      System.out.println(temp[x] + "、");
    }
  }
}
public class ArrayDemo {
  public static void main(String args []) {
    int data [] = new int [] {1,2,3,4,5,6,7,8,9};
    ArrayUtil.reverse(data);  
    ArrayUtil.printArray(data);
  }
}
```

## 数组相关类库

* 排序 java.util.Arrays.sort(数组名称)

* 数组拷贝 System.arraycopy(源数组, 源数组开始点, 目标数组, 目标数组开始点, 拷贝长度);

## 可变参数

可变参数的最大作用在于，在以后进行一些程序类设计或者开发者类调用的时候，利用此种形式就可以避免数组的传递操作了，可变参数的本质需要清楚的是： 依然属于数组

``` java
// 利用...作为可变参数
class ArrayUtil {
  public static int sum (int ... temp) {
    int sum = 0;
    for(int x = 0; x < temp.length; x ++){
      sum += temp[x];
    }
    return sum;
  }
}
public class ArrayDemo {
  public static void main(String args []) {
    int data [] = new int [] {1,5,10,4,23,6,0,8,9};
    System.out.println(ArrayUtil.sum(data));
    System.out.println(ArrayUtil.sum(1,2,3,4,5,6,7,8));
  }
}
```

## 对象数组

在java程序本身各种数据类型都可以成为数组类型，所以类也可以成为数组类型，而这样的数组就称为对象数组，定义格式为：

* 动态初始化：

  类 对象数组名称 [] = new 类 [长度]; 每一个元素默认为null

``` java
// 使用动态初始化方式
class Person {
  private String name;
  private int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getInfo () {
    return "姓名：" + this.name + "、年龄：" + this.age;
  }
}
public class ArrayDemo {
  public static void main(String args []) {
    Person per [] = new Person [3];
    per[0] = new Person("张三", 19);
    per[1] = new Person("李四", 18);
    per[2] = new Person("王武", 20);
    for(int x = 0; x < per.length; x ++) {
      System.out.println(per[x].getInfo());
    }
  }
}
```

* 静态初始化：
  类 对象数组名称 [] = new 类 [] {实例化对象, 实例化对象, ...};

``` java
// 使用静态初始化方式
class Person {
  private String name;
  private int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getInfo () {
    return "姓名：" + this.name + "、年龄：" + this.age;
  }
}
public class ArrayDemo {
  public static void main(String args []) {
    Person per [] = new Person [] {new Person("张三", 19),new Person("李四", 18),new Person("王武", 20)};
    for(int x = 0; x < per.length; x ++) {
      System.out.println(per[x].getInfo());
    }
  }
}
```

> 所有的开发中都不可能离开对象数组，但是通过一系列的分析也应该知道一个数组中的最大缺陷：长度固定。优势：数据线性保存，根据索引访问速度较快（时间复杂度为1）。