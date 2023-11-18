package com.libraryserver.serviceImpl;

import com.libraryserver.entity.ShiftDetail;
import com.libraryserver.repository.ShiftDetailRepository;
import com.libraryserver.service.ShiftDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShiftDetailServiceImpl implements ShiftDetailService {
    @Autowired
    ShiftDetailRepository shiftRepository;

    public String addShiftDetailService(ShiftDetail shift) {
        java.util.Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        var lastShiftId = this.shiftRepository.getLastShiftId();
        if (lastShiftId == null){
            shift.setShiftId(1L);
        }else {
            shift.setShiftId(lastShiftId.getShiftId()+1);
        }
        shift.setCreatedOn(date);
        this.shiftRepository.save(shift);
        return "A new Shift has been added";
    }

    public ShiftDetail updateShiftDetailService(ShiftDetail shiftDetail, long shiftId) throws Exception {
        Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        Optional<ShiftDetail> result = this.shiftRepository.findById(shiftId);
        if (result.isEmpty())
            throw new Exception();
        ShiftDetail existingShiftDetail = result.get();
        existingShiftDetail.setType(shiftDetail.getType());
        existingShiftDetail.setFeesPerMonth(shiftDetail.getFeesPerMonth());
        existingShiftDetail.setFeesQuaterly(shiftDetail.getFeesQuaterly());
        existingShiftDetail.setFeesHalfYearly(shiftDetail.getFeesHalfYearly());
        existingShiftDetail.setUpdatedBy(1L);
        existingShiftDetail.setUpdatedOn(date);
        this.shiftRepository.save(existingShiftDetail);
        return existingShiftDetail;
    }


    public ArrayList<ShiftDetail> getAllShiftDetailService() {
        List<ShiftDetail> result = this.shiftRepository.findAll();
        return  (ArrayList<ShiftDetail>) result;
    }

    public Optional<ShiftDetail> getShiftDetailByShiftIdService(long shiftId) {
        Optional<ShiftDetail> result = this.shiftRepository.findById(shiftId);
        return result;
    }
}
