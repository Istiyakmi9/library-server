package com.libraryserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction {
    @Id
    @Column(name = "TransactionId")
    long transactionId;

    @Column(name = "StudentId")
    long studentId;

    @Column(name = "LibraryId")
    int libraryId;

    @Column(name = "SubscriptionId")
    int subscriptionId;

    @Column(name = "Month")
    int month;

    @Column(name = "Year")
    int year;

    @Column(name = "AmountReceived")
    BigDecimal amountReceived;

    @Column(name = "DiscountCode")
    String discountCode;

    @Column(name = "FinalAmountAfterDiscount")
    BigDecimal finalAmountAfterDiscount;

    @Column(name = "ModeOfPayment")
    String modeOfPayment;

    @Column(name = "TransactionReferenceId")
    String transactionReferenceId;

    @Column(name = "ReferenceLink")
    String referenceLink;

    @Column(name = "PaymentStatusId")
    int paymentStatusId;

    @Column(name ="TransactionDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date transactionDate;

    @Column(name = "CreatedBy")
    Long createdBy;

    @Column(name = "UpdatedBy")
    Long updatedBy;

    @Column(name = "CreatedOn")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createdOn;
    @Column(name = "UpdatedOn")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updatedOn;

}
