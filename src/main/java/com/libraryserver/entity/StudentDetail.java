package com.libraryserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="studentdetail")
public class StudentDetail {

    @Id
    @Column(name= "UserId")
    Long userId;

      @Column(name = "StudentName")
    String studentName;

    @Column(name = "Mobile")
    String mobile;

    @Column(name = "Email")
    String email;

    @Column(name = "SeatNo")
    int seatNo;

    @Column(name = "Amount")
    BigDecimal amount;

    @Column(name = "DateOfJoining")
    Date dateOfJoining;

    @Column(name = "DateOfFeesPayment")
    Date dateOfFeesPayment;

    @Column(name = "LockerFesility")
    Boolean lockerFesility;

    @Column(name = "LockerNo")
    int lockerNo;

    @Column(name = "lockerFees")
    BigDecimal lockerFees;

    @Column(name = "RefIdCardIssued")
    Boolean refIdCardIssued;

    @Column(name = "RefIdCardIssueDate")
    Date refIdCardIssueDate;

    @Column(name = "CardDeposit")
    Boolean cardDeposit;

    @Column(name = "Remarks")
    String remarks;

    @Column(name = "ImageProfile")
    String imageProfile;

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

    public StudentDetail(Long userId, String studentName, String mobile, String email, int seatNo, BigDecimal amount, Date dateOfJoining, Date dateOfFeesPayment, Boolean lockerFesility, int lockerNo, BigDecimal lockerFees, Boolean refIdCardIssued, Date refIdCardIssueDate, Boolean cardDeposit, String remarks, String imageProfile, Long createdBy, Long updatedBy, Date createdOn, Date updatedOn) {
        this.userId = userId;
        this.studentName = studentName;
        this.mobile = mobile;
        this.email = email;
        this.seatNo = seatNo;
        this.amount = amount;
        this.dateOfJoining = dateOfJoining;
        this.dateOfFeesPayment = dateOfFeesPayment;
        this.lockerFesility = lockerFesility;
        this.lockerNo = lockerNo;
        this.lockerFees = lockerFees;
        this.refIdCardIssued = refIdCardIssued;
        this.refIdCardIssueDate = refIdCardIssueDate;
        this.cardDeposit = cardDeposit;
        this.remarks = remarks;
        this.imageProfile = imageProfile;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public StudentDetail() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfFeesPayment() {
        return dateOfFeesPayment;
    }

    public void setDateOfFeesPayment(Date dateOfFeesPayment) {
        this.dateOfFeesPayment = dateOfFeesPayment;
    }

    public Boolean getLockerFesility() {
        return lockerFesility;
    }

    public void setLockerFesility(Boolean lockerFesility) {
        this.lockerFesility = lockerFesility;
    }

    public int getLockerNo() {
        return lockerNo;
    }

    public void setLockerNo(int lockerNo) {
        this.lockerNo = lockerNo;
    }

    public BigDecimal getLockerFees() {
        return lockerFees;
    }

    public void setLockerFees(BigDecimal lockerFees) {
        this.lockerFees = lockerFees;
    }

    public Boolean getRefIdCardIssued() {
        return refIdCardIssued;
    }

    public void setRefIdCardIssued(Boolean refIdCardIssued) {
        this.refIdCardIssued = refIdCardIssued;
    }

    public Date getRefIdCardIssueDate() {
        return refIdCardIssueDate;
    }

    public void setRefIdCardIssueDate(Date refIdCardIssueDate) {
        this.refIdCardIssueDate = refIdCardIssueDate;
    }

    public Boolean getCardDeposit() {
        return cardDeposit;
    }

    public void setCardDeposit(Boolean cardDeposit) {
        this.cardDeposit = cardDeposit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
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
        return "StudentDetail{" +
                "userId=" + userId +
                ", studentName='" + studentName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", seatNo=" + seatNo +
                ", amount=" + amount +
                ", dateOfJoining=" + dateOfJoining +
                ", dateOfFeesPayment=" + dateOfFeesPayment +
                ", lockerFesility=" + lockerFesility +
                ", lockerNo=" + lockerNo +
                ", lockerFees=" + lockerFees +
                ", refIdCardIssued=" + refIdCardIssued +
                ", refIdCardIssueDate=" + refIdCardIssueDate +
                ", cardDeposit=" + cardDeposit +
                ", remarks='" + remarks + '\'' +
                ", imageProfile='" + imageProfile + '\'' +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
