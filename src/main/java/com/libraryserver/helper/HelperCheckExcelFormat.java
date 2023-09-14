package com.libraryserver.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class HelperCheckExcelFormat {
    // Check that file is of excel type or not
    public boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        } else {
            return false;
        }
    }

}
