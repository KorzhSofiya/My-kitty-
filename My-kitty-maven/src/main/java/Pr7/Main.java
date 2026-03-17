package Pr7;

public class Main {
    public static void main(String[] args) {
        ReceiptService receiptService = new ReceiptService();
        System.out.println("--- Старт генерації чека ---");
        try {
            receiptService.generate("Замовлення #101: Кава Лате - 65 грн");
        } catch (RecieptGenerateExeption e) {
            System.out.println(" Перехоплено помилку: " + e.getMessage());
        }
        System.out.println("--- Кінець роботи ---");
    }
}
