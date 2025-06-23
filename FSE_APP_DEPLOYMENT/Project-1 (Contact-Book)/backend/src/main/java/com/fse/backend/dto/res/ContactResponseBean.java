package com.fse.backend.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactResponseBean {
    private Long id;
    private String name;
    private String phoneNumber;
}
