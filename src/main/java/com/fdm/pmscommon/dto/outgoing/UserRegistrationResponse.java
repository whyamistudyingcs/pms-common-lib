package com.fdm.pmscommon.dto.outgoing;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRegistrationResponse {
    private UUID userId;
    private String username;
    private String status;
}
