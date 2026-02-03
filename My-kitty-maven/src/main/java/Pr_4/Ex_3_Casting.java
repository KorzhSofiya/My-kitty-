package Pr_4;

public class Ex_3_Casting {
    public static void main(String[] args){
        Animal a = new Dog();
        Animal b = new Cat();
        if(a instanceof Dog dog){
            dog.fetchStick();
        }
        if(b instanceof Dog dog){//Variable b is not Dog, and since the
            // fetchStick method is only available for objects of this type, an error will occur
            dog.fetchStick();
        }else{
            throw new IllegalArgumentException("Oopsie");
        }
    }
}
