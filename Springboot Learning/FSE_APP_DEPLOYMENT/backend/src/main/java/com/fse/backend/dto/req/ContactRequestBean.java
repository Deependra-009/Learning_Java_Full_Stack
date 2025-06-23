package com.fse.backend.dto.req;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactRequestBean {
    private String name;
    private String phoneNumber;
}
