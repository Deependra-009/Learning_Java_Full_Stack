package com.fse.backend.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusMessage {

    private String message;
}
