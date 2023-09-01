package com.libraryserver.serviceImpl;

import com.libraryserver.entity.ShiftDetail;
import com.libraryserver.repository.ShiftDetailRepository;
import com.libraryserver.service.ShiftDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class ShiftDetailServiceImpl implements ShiftDetailService {

    @Autowired
    ShiftDetailRepository shiftRepository;


    public String addShiftDetailService(ShiftDetail shift) {
        java.util.Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        Optional<ShiftDetail> lastShiftId = Optional.ofNullable(this.shiftRepository.getLastShiftId());
        if (lastShiftId.isEmpty()){
            shift.setShiftId(1L);
        }else {
            shift.setShiftId(lastShiftId.get().getShiftId()+1);
            shift.setCreatedOn(date);
            this.shiftRepository.save(shift);
        }
        return "A new Shift has been added";
    }
}
