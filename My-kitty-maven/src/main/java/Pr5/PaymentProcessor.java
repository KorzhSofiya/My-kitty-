package Pr5;

interface PaymentMethod{
    void name();
    void pay(int amount);
    default void payWithFee(int amount, int fee){
        System.out.println("Paid with fee: "+(amount+fee));
    }
}
class CardPayment implements PaymentMethod{
    @Override
    public void name(){
        System.out.println("Card");
    }
    @Override
    public void pay(int amount){
        System.out.println("paid: "+amount);
    }
}
class PayPalPayment implements PaymentMethod{
    @Override
    public void name(){
        System.out.println("PayPal");
    }
    @Override
    public void pay(int amount){
        System.out.println("paid: "+amount);
    }
}
public class PaymentProcessor {
    public void process(PaymentMethod method, int amount){
        method.pay(amount);
    }
}
