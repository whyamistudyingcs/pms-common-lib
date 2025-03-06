package com.fdm.pmscommon.dto.general;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class PositionDto {
    private String positionId;
    private String ticker;
    private String totalQty;
    private String avgPrice;
    private String unrealizedPnl;
    private String currency;
    private String lastPrice;
}
