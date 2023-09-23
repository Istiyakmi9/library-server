package com.libraryserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

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

    public ShiftDetail(long shiftId, String type, BigDecimal feesPerMonth, BigDecimal feesQuaterly, BigDecimal feesHalfYearly, Long createdBy, Long updatedBy, Date createdOn, Date updatedOn) {
        this.shiftId = shiftId;
        this.type = type;
        this.feesPerMonth = feesPerMonth;
        this.feesQuaterly = feesQuaterly;
        this.feesHalfYearly = feesHalfYearly;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public ShiftDetail() {
    }

    public long getShiftId() {
        return shiftId;
    }

    public void setShiftId(long shiftId) {
        this.shiftId = shiftId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getFeesPerMonth() {
        return feesPerMonth;
    }

    public void setFeesPerMonth(BigDecimal feesPerMonth) {
        this.feesPerMonth = feesPerMonth;
    }

    public BigDecimal getFeesQuaterly() {
        return feesQuaterly;
    }

    public void setFeesQuaterly(BigDecimal feesQuaterly) {
        this.feesQuaterly = feesQuaterly;
    }

    public BigDecimal getFeesHalfYearly() {
        return feesHalfYearly;
    }

    public void setFeesHalfYearly(BigDecimal feesHalfYearly) {
        this.feesHalfYearly = feesHalfYearly;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiftId=" + shiftId +
                ", type='" + type + '\'' +
                ", feesPerMonth=" + feesPerMonth +
                ", feesQuaterly=" + feesQuaterly +
                ", feesHalfYearly=" + feesHalfYearly +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
