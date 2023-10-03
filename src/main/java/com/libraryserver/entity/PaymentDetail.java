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
@Table(name = "payment_detail")
public class PaymentDetail {
    @Id
    @Column(name = "PaymentId")
    long paymentId;

    @Column(name = "UserId")
    long userId;

    @Column(name = "SubscriptionId")
    long subscriptionId;

    @Column(name = "FromDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date fromDate;

    @Column(name = "ToDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date toDate;

    @Column(name = "Month")
    int month;

    @Column(name = "Year")
    int year;

    @Column(name = "PaymentMode")
    String paymentMode;

    @Column(name = "Amount")
    BigDecimal amount;

    @Column(name = "PaymentStatus")
    int paymentStatus;

    @Column(name = "ReferenceLink")
    String referenceLink;

    @Column(name = "PaymentReferenceId")
    String paymentReferenceId;

    @Column(name = "PaymentDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date paymentDate;

    @Column(name = "ApprovedBy")
    long approvedBy;

    @Column(name = "ApprovedOn")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date approvedOn;


}
