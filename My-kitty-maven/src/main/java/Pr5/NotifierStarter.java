package Pr5;

public class NotifierStarter {
    public static void main(String[] args){
        NotifierStarter ns = new NotifierStarter();
        MultiNotifier mn = new MultiNotifier();
        mn.send("YA lublu kvas");
    }
}
interface SmsNotifier {
    default void send(String messege){
        System.out.println("SMS: "+messege);
    }
}
interface EmailNotifier{
    default void send(String messege){
        System.out.println("Email: "+messege);
    }
}
class MultiNotifier implements SmsNotifier, EmailNotifier{
    @Override
    public void send(String messege){
        SmsNotifier.super.send(messege);
        EmailNotifier.super.send(messege);
    }
}
