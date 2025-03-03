package com.fdm.pmscommon.dto.responses;

import java.util.UUID;

import lombok.Data;

@Data
public class AccountDto {
    private UUID Id;
    private String accountName;
    private String departmentName;
    private UUID ownerId;
}
