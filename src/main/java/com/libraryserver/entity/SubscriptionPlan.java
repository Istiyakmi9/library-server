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
@Table(name = "subscription_plan")
public class SubscriptionPlan {

    @Id
    @Column(name = "SubscriptionId")
    int subscriptionId;

    @Column(name = "LibraryId")
    int libraryId;

    @Column(name = "SubscriptionName")
    String subscriptionName;

    @Column(name = "SubscriptionDescription")
    String subscriptionDescription;

    @Column(name = "IsMonthlySubscription")
    boolean isMonthlySubscription;

    @Column(name = "NumberOfMonths")
    int numberOfMonths;

    @Column(name = "MonthlyAmount")
    BigDecimal monthlyAmount;

    @Column(name = "IsHourlySubscription")
    boolean isHourlySubscription;

    @Column(name = "HourlyAmount")
    BigDecimal hourlyAmount;

    @Column(name = "NumberOfHours")
    int numberOfHours;

    @Column(name = "FinalAmountPerMonth")
    BigDecimal finalAmountPerMonth;

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
