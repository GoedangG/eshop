package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.List;

public interface PaymentRepositoryInterface {
    public Payment save (Payment payment);
    public Payment findById (String id);
    public List<Payment> findAll();
}
