package com.libraryserver.repository;

import com.libraryserver.entity.StudentDetail;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface StudentDetailRepository extends JpaRepository<StudentDetail, Long> {

    @Query(nativeQuery = true, value = "select u.* from studentdetail u order by u.UserId desc limit 1")
    StudentDetail getLastUserId();

}
