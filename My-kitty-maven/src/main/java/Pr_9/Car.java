package Pr_9;

public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }
    public static class Engine {
        private int horsepower;

        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }
    }
    public Engine spec(){
        return new Engine(150);
    }
}
