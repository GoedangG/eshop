package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp(){
        this.paymentData = new HashMap<>();
    }

    @Test
    void testCreatePaymentDefaultStatus(){
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", "VOUCHER", this.paymentData);
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals("REJECTED", payment.getStatus());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertSame(this.paymentData, payment.getPaymentData);
    }

    @Test
    void testCreatePaymentSuccesStatus(){
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", "VOUCHER", this.paymentData, "SUCCESS");
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertSame(this.paymentData, payment.getPaymentData);
    }

    @Test
    void testCreatePaymentInvalidStatus(){
        assertThrows (IllegalArgumentException.class, () -> {
            Payment payment = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", "VOUCHER", this.paymentData, "INVALID");
        });
    }

    @Test
    void testSetPaymentDataEmpty(){
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", "VOUCHER", this.paymentData);
        this.paymentData.clear();
        assertThrows (IllegalArgumentException.class, () -> {
            payment.setPaymentData(this.paymentData);
        });
    }

    @Test
    void testSetStatusToInvalid(){
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", "VOUCHER", this.paymentData);
        payment.setStatus("INVALID");
        assertEquals("INVALID", payment.getStatus);
    }
}
