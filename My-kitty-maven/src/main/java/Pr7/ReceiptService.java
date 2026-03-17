package Pr7;

import java.io.IOException;

public class ReceiptService {
    public void generate(String receiptData) {
        try (RecieptWriter writer = new RecieptWriter()) {

            writer.write(receiptData);

        } catch (IOException e) {
            throw new RecieptGenerateExeption("Не вдалося згенерувати чек для: " + receiptData, e);
        }
    }
}

