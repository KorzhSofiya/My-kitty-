package Pr_4;

public class Calculator {
    public int divide(int a, int b){
        if(b==0)
            throw new IllegalArgumentException("Oopsie");
        return a/b;
    }
}
