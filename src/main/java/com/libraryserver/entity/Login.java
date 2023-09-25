package com.libraryserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="login")
public class Login {

    @Id
    @Column(name = "LoginId")
    Long loginId;

    @Column(name = "UserId")
    Long userId;

    @Column(name = "Email")
    String email;

    @Column(name = "Password")
    String password;

    @Column(name = "Mobile")
    String mobile;

    @Column(name = "UserRoleId")
    int userRoleId;

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
