package com.fdm.pmscommon.dto.incoming;

import java.util.List;
import java.util.UUID;

import com.fdm.pmscommon.dto.general.TradeDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TradeUploadRequest {
    @NotEmpty
    private List<TradeDto> tradeList;

    @NotNull
    private UUID accountId;
}
