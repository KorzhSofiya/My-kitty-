package Pr7;

import java.io.IOException;

public class RecieptWriter implements AutoCloseable{
    public RecieptWriter() {
        System.out.println("1. ReceiptWriter відкрито");
    }
    public void write(String text) throws IOException {
        System.out.println("2. Запис даних чека: " + text);
        throw new IOException("Принтер чеків не відповідає (закінчився папір)!");
    }
    @Override
    public void close() throws IOException {
        System.out.println("3.  метод close() викликано");
    }
}
