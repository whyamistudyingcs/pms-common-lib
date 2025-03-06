package com.fdm.pmscommon.dto.general;

import com.fdm.pmscommon.dto.general.TradeDto;

import lombok.Data;

@Data
public class TradeResult {
    private TradeDto trade;
    private String result;
    private String message;
}

