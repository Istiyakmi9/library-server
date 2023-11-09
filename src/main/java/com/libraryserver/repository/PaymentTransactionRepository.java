package com.libraryserver.repository;


import com.libraryserver.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {

    @Query(nativeQuery = true, value = "select pt.* from payment_transaction pt order by pt.TransactionId desc limit 1")
    PaymentTransaction getLastTransactionId();

}
