package Pr_4;

 abstract class Animal {
    public abstract void speek();

}
class Cat extends Animal{
    @Override
    public void speek(){
        System.out.println("Myow");
    }
}
class Dog extends Animal{
    @Override
    public void speek(){
        System.out.println("Woof");
    }
    public void fetchStick(){
        System.out.println("chasing a fetchStick ");
    }
}