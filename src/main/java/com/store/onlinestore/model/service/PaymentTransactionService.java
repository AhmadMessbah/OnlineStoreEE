package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.PaymentTransactionNotFoundException;
import com.store.onlinestore.model.entity.Base;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

public class PaymentTransactionService extends Base {
    @Getter
    private static PaymentTransactionService service = new PaymentTransactionService();

    private PaymentTransactionService() {
    }

    public PaymentTransactionService save(PaymentTransactionService paymentTransactionService) throws Exception {
        try (CrudRepository<PaymentTransactionService, Long> repository = new CrudRepository<>()) {
            return repository.save(paymentTransactionService);
        }
    }

    public PaymentTransactionService edit(PaymentTransactionService paymentTransactionService) throws Exception {
        try (CrudRepository<PaymentTransactionService, Long> repository = new CrudRepository<>()) {
            return repository.save(paymentTransactionService);
        }
    }

    public PaymentTransactionService remove(Long id) throws Exception {
        try (CrudRepository<PaymentTransactionService, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id , PaymentTransactionService.class) != null) {
                return repository.remove(id, PaymentTransactionService.class);
            }
            throw new PaymentTransactionNotFoundException();
        }
    }
}

