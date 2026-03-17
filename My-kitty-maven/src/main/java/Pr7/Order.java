package Pr7;

public record Order (int id, String email, double totalCents){
    public Order{
        if(id<0){
            throw new IllegalArgumentException(" id is not in right format");
        }
        if(!email.contains("@"))
            throw new IllegalArgumentException("Email is not correct");
        if(totalCents>=0)
            throw new IllegalArgumentException("Total cents must be <0");
    }
    public static void main(String[] args) {
        Order r1 = new Order(27, "ewbdchj@", -5);
        Order r2 = new Order(-25, "fechjq", 25);
    }
}
