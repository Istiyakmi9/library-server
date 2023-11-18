package com.libraryserver.serviceImpl;

import com.libraryserver.entity.PaymentTransaction;
import com.libraryserver.repository.PaymentTransactionRepository;
import com.libraryserver.service.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentTransactionImpl implements PaymentTransactionService {

    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;


    public String addPaymentTransactionService(PaymentTransaction paymentTransaction) {
        Date utilDate = new Date();
        Timestamp date = new Timestamp(utilDate.getTime());
        var lastTransactionId = this.paymentTransactionRepository.getLastTransactionId();
        if (lastTransactionId == null){
            paymentTransaction.setTransactionId(1L);
        }else {
            paymentTransaction.setTransactionId(lastTransactionId.getTransactionId()+1);
        }
        paymentTransaction.setStudentId(1L);
        paymentTransaction.setLibraryId(1);
        paymentTransaction.setSubscriptionId(1);
        paymentTransaction.setCreatedOn(date);
        this.paymentTransactionRepository.save(paymentTransaction);
        return "A new Transaction has been done";
    }

    public PaymentTransaction updatePaymentTransactionService(PaymentTransaction paymentTransaction, long transactionId) throws Exception {
        Date utilDate = new Date();
        Timestamp date = new Timestamp(utilDate.getTime());
        Optional<PaymentTransaction> result = this.paymentTransactionRepository.findById(transactionId);
        if (result.isEmpty())
            throw new Exception();
        PaymentTransaction existingPaymentTransaction = result.get();
//        existingPaymentTransaction.setStudentId(1L);
//        existingPaymentTransaction.setLibraryId(1);
//        existingPaymentTransaction.setSubscriptionId(1);
        existingPaymentTransaction.setMonth(paymentTransaction.getMonth());
        existingPaymentTransaction.setYear(paymentTransaction.getYear());
        existingPaymentTransaction.setAmountReceived(paymentTransaction.getAmountReceived());
        existingPaymentTransaction.setDiscountCode(paymentTransaction.getDiscountCode());
        existingPaymentTransaction.setFinalAmountAfterDiscount(paymentTransaction.getFinalAmountAfterDiscount());
        existingPaymentTransaction.setModeOfPayment(paymentTransaction.getModeOfPayment());
        existingPaymentTransaction.setTransactionReferenceId(paymentTransaction.getTransactionReferenceId());
        existingPaymentTransaction.setReferenceLink(paymentTransaction.getReferenceLink());
        existingPaymentTransaction.setPaymentStatusId(paymentTransaction.getPaymentStatusId());
        existingPaymentTransaction.setTransactionDate(paymentTransaction.getTransactionDate());
//        existingPaymentTransaction.setCreatedBy(1L);
//        existingPaymentTransaction.setUpdatedBy(1L);
        existingPaymentTransaction.setUpdatedOn(date);
        this.paymentTransactionRepository.save(existingPaymentTransaction);
        return existingPaymentTransaction;
    }


    public ArrayList<PaymentTransaction> getAllPaymentTransactionService() {
        List<PaymentTransaction> result = this.paymentTransactionRepository.findAll();
        return (ArrayList<PaymentTransaction>) result;
    }

    public Optional<PaymentTransaction> getPaymentTransactionByTransactionIdService(long transactionId) {
        Optional<PaymentTransaction> result = this.paymentTransactionRepository.findById(transactionId);
        return result;
    }
}
