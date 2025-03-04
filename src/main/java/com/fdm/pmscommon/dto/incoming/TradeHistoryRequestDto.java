package com.fdm.pmscommon.dto.incoming;

import java.util.UUID;

import com.fdm.pmscommon.dto.validation.ValidDate;
import com.fdm.pmscommon.dto.validation.ValidDateRange;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@ValidDateRange
public class TradeHistoryRequestDto {
    @NotNull
    private UUID accountId;

    @ValidDate
    @NotBlank
    private String startDate;

    @ValidDate
    @NotBlank
    private String endDate;
}
