package com.libraryserver.helper;

import com.libraryserver.entity.StudentDetail;
import com.libraryserver.repository.StudentDetailRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Component
public class HelperStudentDetailExcelUpload {

    @Autowired
    StudentDetailRepository studentDetailRepository;

    private long getLastStudentId(){
         long lastId = 0;
        Optional<StudentDetail> lastStudentId = Optional.ofNullable(studentDetailRepository.getLastStudentId());
        if (lastStudentId.isEmpty())
            lastId = 1;
        else
            lastId = lastStudentId.get().getStudentId()+1;
        return lastId;
    }
    // convert excel to list of products
    public List<StudentDetail> convertStudentDetailExcelToList(InputStream is) throws Exception {
        List<StudentDetail> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            long lastId = getLastStudentId();
            java.util.Date utilDate = new Date();
            var date = new Timestamp(utilDate.getTime());
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();
                int cid = 0;
                StudentDetail studentDetail = new StudentDetail();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    studentDetail.setStudentId(lastId);
                    switch (cid) {
                        case 0:
                            studentDetail.setStudentName(cell.getStringCellValue());
                            break;
                        case 1:
                            studentDetail.setMobile(cell.getStringCellValue());
                            break;
                        case 2:
                            studentDetail.setEmail(cell.getStringCellValue());
                            break;
                        case 3:
                            studentDetail.setSeatNo((int) cell.getNumericCellValue());
                            break;
                        case 4:
                            studentDetail.setAmount(BigDecimal.valueOf(cell.getNumericCellValue()));
                            break;
                        case 5:
                            studentDetail.setDateOfJoining(cell.getDateCellValue());
                            break;
                        case 6:
                            studentDetail.setDateOfFeesPayment(cell.getDateCellValue());
                            break;
                        case 7:
                            boolean isLockerFaciility = false;
                            if (cell.getStringCellValue().equalsIgnoreCase("yes"))
                                isLockerFaciility = true;

                            studentDetail.setLockerFesility(isLockerFaciility);
                            break;
                        case 8:
                            studentDetail.setLockerNo((int) cell.getNumericCellValue());
                            break;
                        case 9:
                            studentDetail.setLockerFees(BigDecimal.valueOf(cell.getNumericCellValue()));
                            break;
                        case 10:
                            boolean isRefCardIssue = false;
                            if (cell.getStringCellValue().equalsIgnoreCase("yes"))
                                isRefCardIssue = true;
                            studentDetail.setRefIdCardIssued(isRefCardIssue);
                            break;
                        case 11:
                            studentDetail.setRefIdCardIssueDate(cell.getDateCellValue());
                            break;
                        case 12:
                            boolean isCardDeposit = false;
                            if (cell.getStringCellValue().equalsIgnoreCase("yes"))
                                isCardDeposit = true;
                            studentDetail.setCardDeposit(isCardDeposit);
                            break;
                        case 13:
                            studentDetail.setRemarks(cell.getStringCellValue());
                            break;
                        default:
                            throw new Exception("Column name doesn't match");
                    }
                    cid++;
                }
                studentDetail.setCreatedOn(date);
                studentDetail.setCreatedBy(lastId);
                list.add(studentDetail);
                lastId = lastId+ 1;
            }
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
}
