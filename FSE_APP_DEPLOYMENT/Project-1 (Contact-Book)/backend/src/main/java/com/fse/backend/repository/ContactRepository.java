package com.fse.backend.repository;

import com.fse.backend.constants.SqlQueryConstant;
import com.fse.backend.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity,Long> {

    @Query(SqlQueryConstant.FIND_COUNT_PHONE_NUMBER)
    public Long checkPhoneNumberAlreadyExist(@Param("phoneNumber") String phoneNumber);

}
