package com.libraryserver.repository;

import com.libraryserver.entity.StudentDetail;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface StudentDetailRepository extends JpaRepository<StudentDetail, Long> {

}
