package com.fdm.pmscommon.dto.requests;

import java.util.List;
import java.util.UUID;

import com.fdm.pmscommon.dto.TradeDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TradeUploadRequest {
    @NotEmpty
    private List<TradeDto> tradeList;

    @NotBlank
    private UUID accountId;
}
