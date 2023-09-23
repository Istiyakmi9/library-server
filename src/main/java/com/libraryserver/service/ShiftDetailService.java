package com.libraryserver.service;

import com.libraryserver.entity.ShiftDetail;

public interface ShiftDetailService {

    public String addShiftDetailService(ShiftDetail shift);
    public ShiftDetail updateShiftDetailService(ShiftDetail shiftDetail, long shiftId) throws Exception;

}
