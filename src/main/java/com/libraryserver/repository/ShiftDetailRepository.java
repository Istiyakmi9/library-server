package com.libraryserver.repository;

import com.libraryserver.entity.ShiftDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftDetailRepository extends JpaRepository<ShiftDetail, Long> {

    @Query(nativeQuery = true, value = "select s.* from shiftdetail s order by s.ShiftId desc limit 1")
    ShiftDetail getLastShiftId();


}
