package Pr_4;

public class AnimalChoir {
    public static void main(String[] args){
        AnimalChoir a = new AnimalChoir();
        Animal[] choir = new Animal[2];
        choir[0]=new Cat();
        choir[1]=new Dog();
        for(Animal b : choir){
            b.speek();
        }
    }
}
