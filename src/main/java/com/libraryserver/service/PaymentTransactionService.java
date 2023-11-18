package com.libraryserver.service;

import com.libraryserver.entity.PaymentTransaction;

import java.util.ArrayList;
import java.util.Optional;

public interface PaymentTransactionService {

    public String addPaymentTransactionService(PaymentTransaction paymentTransaction);
    public PaymentTransaction updatePaymentTransactionService(PaymentTransaction paymentTransaction, long transactionId) throws Exception;
    public ArrayList<PaymentTransaction> getAllPaymentTransactionService();
    public Optional<PaymentTransaction> getPaymentTransactionByTransactionIdService(long transactionId);

}
