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
@Table(name ="shiftdetail")
public class ShiftDetail {

    @Id
    @Column(name = "ShiftId")
    long shiftId;

    @Column(name = "Type")
    String type;

    @Column(name = "FeesPerMonth")
    BigDecimal feesPerMonth;

    @Column(name = "FeesQuaterly")
    BigDecimal feesQuaterly;

    @Column(name = "FeesHalfYearly")
    BigDecimal feesHalfYearly;

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
