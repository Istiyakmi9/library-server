package com.libraryserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="studentdetail")
public class StudentDetail {

    @Id
    @Column(name= "StudentId")
    Long studentId;

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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    Date dateOfJoining;

    @Column(name = "DateOfFeesPayment")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    Date refIdCardIssueDate;

    @Column(name = "CardDeposit")
    Boolean cardDeposit;

    @Column(name = "UserRoleId")
    int userRoleId;

    @Column(name = "Remarks")
    String remarks;

    @Column(name = "FileId")
    long fileId;

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

    @Transient
    String filePath;

}
