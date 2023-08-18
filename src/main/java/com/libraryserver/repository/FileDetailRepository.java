package com.libraryserver.repository;

import com.libraryserver.entity.FileDetail;
import com.libraryserver.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
public interface FileDetailRepository extends JpaRepository <FileDetail, Long> {

    @Query("select f from FileDetail f where f.fileOwnerId = :fileownerid and f.fileName like :fileName")
    public FileDetail filterByName(@Param("fileownerid") long fileownerid, @Param("fileName")  String fileName);

    @Query(nativeQuery = true, value = "select u.* from filedetail u order by u.FileId desc limit 1")
    FileDetail getLastFileDetail();

}
