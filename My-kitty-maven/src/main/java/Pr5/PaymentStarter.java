package Pr5;

public class PaymentStarter {
    public static void main(String[] args){
        PaymentProcessor processor = new PaymentProcessor();
        PaymentMethod card = new CardPayment();
        PaymentMethod paypal = new PayPalPayment();
        card.name();
        processor.process(card,100);
        System.out.println();
        paypal.name();
        processor.process(paypal, 300);
        System.out.println();
        card.payWithFee(300,30);
        paypal.payWithFee(100,50);

    }
}
