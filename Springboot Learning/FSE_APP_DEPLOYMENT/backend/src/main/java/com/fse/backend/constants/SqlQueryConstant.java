package com.fse.backend.constants;

public class SqlQueryConstant {

    public static final String FIND_COUNT_PHONE_NUMBER="select count(p) from ContactEntity p where p.phoneNumber=:phoneNumber";
}
