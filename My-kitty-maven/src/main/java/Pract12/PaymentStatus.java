package Pract12;

import java.util.List;

public enum PaymentStatus {
    NEW, PAID, FAILED
}
record LoadResult(List<Payment> payments, int invalidLines) {}