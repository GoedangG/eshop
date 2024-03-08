package id.ac.ui.cs.advprog.eshop.repository;

import enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> payments;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp(){
        paymentRepository = new PaymentRepository();
        payments = new ArrayList<>();

        Payment payment1 = new Payment("eb558e9f-1c39-460e-8860-71af6af63bd6", PaymentMethod.VOUCHER_CODE.getValue(), paymentData);
        payments.add(payment1);

        Payment payment2 = new Payment("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.BANK_TRANSFER.getValue(), paymentData);
        payments.add(payment2);
    }

    @Test
    void testCreateSave(){
        Payment payment = payments.get(1);
        Payment rslt = paymentRepository.save(payment);

        Payment find = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), rslt.getId());
        assertEquals(payment.getId(), find.getId());
        assertEquals(payment.getMethod(), find.getMethod());
        assertEquals(payment.getStatus(), find.getStatus());
        assertSame(payment.getPaymentData(), find.getPaymentData());
    }

    @Test
    void testSaveUpdate(){
        Payment payment = payments.get(1);
        paymentRepository.save(payment);

        Payment newPayment = new Payment(payment.getId(), PaymentMethod.BANK_TRANSFER.getValue(), paymentData);
        Payment result = paymentRepository.save(newPayment);

        Payment find = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), find.getId());
        assertEquals(payment.getMethod(), find.getMethod());
        assertEquals(payment.getStatus(), find.getStatus());
        assertSame(payment.getPaymentData(), find.getPaymentData());
    }

    @Test
    void testFindById(){
        for (Payment payment : payments){
            paymentRepository.save(payment);
        }

        Payment result = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), result.getId());
        assertEquals(payments.get(1).getMethod(), result.getMethod());
        assertEquals(payments.get(1).getStatus(), result.getStatus());
        assertSame(payments.get(1).getPaymentData(), result.getPaymentData());
    }

    @Test
    void testFindByIdNotFound(){
        for(Payment payment : payments){
            paymentRepository.save(payment);
        }

        Payment result = paymentRepository.findById("netnot");
        assertNull(result);
    }
}
