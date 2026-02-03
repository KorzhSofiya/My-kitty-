package Pr_4;

public class AandB {
    public static void main(String[] args){
        AandB ab = new AandB();
        A a = new B();
        a.process("hi");
    }
}
class A{
    void process(Object obj){
        System.out.println("A obj");
    }
}
class B extends A{
    @Override
    void process(Object obj){
        System.out.println("B obj");
    }
    void process(String str){
        System.out.println("B string");
    }
}
