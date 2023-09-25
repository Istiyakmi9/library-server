package com.libraryserver.repository;

import com.libraryserver.entity.Login;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface LoginRepository extends JpaRepository<Login, Long> {

//    @Query(value = "select u from User u where u.mobile = :mobile")
//    User getByUserMobile(@Param("mobile") String mobile);
//
//    @Query(nativeQuery = true, value = "select u.* from user u order by u.UserId desc limit 1")
//    User getLastUser();

    @Query(nativeQuery = true, value = " select l.* from login l where l.Email = :email or l.Mobile = :mobile ")
    Login getLoginByEmailOrMobile(@Param("mobile") String mobile, @Param("email") String email );

    @Query(value = "select l.* from login l order by l.UserId desc limit 1", nativeQuery = true)
    Login getLoginLastRecord();

}
