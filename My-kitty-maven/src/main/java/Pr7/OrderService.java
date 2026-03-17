package Pr7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

public class OrderService {
    private static final Logger log = getLogger(OrderService.class);
    public void checkout(String orderId, String userEmail) {
        try {
            callExternalPaymentGateway(orderId, 2500);

        } catch (PaymentGetAwayExeption e) {
            log.error("Payment failed for orderId: {}, userEmail: {}", orderId, userEmail, e);
            String errorMessage = String.format("Checkout failed. OrderID: %s, Email: %s", orderId, userEmail);
            throw new OrderProcessingExeption(errorMessage, e);
        }
    }

    private void callExternalPaymentGateway(String orderId, int amount) throws PaymentGetAwayExeption{
        throw new PaymentGetAwayExeption("Connection timeout to bank API");
    }
}
