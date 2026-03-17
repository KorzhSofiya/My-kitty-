package Pr_9;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

public class Task_4 {

}
@Data
class UserDTO{
    private String email;
    private String name;
}

@Value
class Price{
    BigDecimal amount;
    String curency;
}
@Builder
class CheckoutRequest {
    private long orderId;
    private String userEmail;
    private BigDecimal total;
}


