package test;

public class Test{
    public static void main(String[] args) {

        Animal a1 = new Animal();
        a1.eat();

        cat c1 = new cat();
        c1.eat();

        dog d1 = new dog();
        d1.eat();

    }
}



class Animal{
    public void eat() {
        System.out.println("动物吃东西");
    }
}

class cat extends Animal{
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class dog extends Animal{
    public void eat() {
        System.out.println("狗啃骨头");
    }
}