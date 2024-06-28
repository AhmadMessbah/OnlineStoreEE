package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.PaymentTransactionNotFoundException;
import com.store.onlinestore.model.entity.Base;
import com.store.onlinestore.model.entity.PaymentTransaction;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

public class PaymentTransactionService extends Base {
    @Getter
    private static PaymentTransactionService service = new PaymentTransactionService();

    private PaymentTransactionService() {
    }

    public PaymentTransaction save(PaymentTransaction paymentTransaction) throws Exception {
        try (CrudRepository<PaymentTransaction, Long> repository = new CrudRepository<>()) {
            return repository.save(paymentTransaction);
        }
    }

    public PaymentTransaction edit(PaymentTransaction PaymentTransaction) throws Exception {
        try (CrudRepository<PaymentTransaction, Long> repository = new CrudRepository<>()) {
            return repository.save(PaymentTransaction);
        }
    }

    public PaymentTransaction remove(Long id) throws Exception {
        try (CrudRepository<PaymentTransaction, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id , PaymentTransaction.class) != null) {
                return repository.remove(id, PaymentTransaction.class);
            }
            throw new PaymentTransactionNotFoundException();
        }
    }
}

