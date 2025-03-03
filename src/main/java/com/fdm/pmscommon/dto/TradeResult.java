package com.fdm.pmscommon.dto;

import lombok.Data;

@Data
public class TradeResult {
    private TradeDto trade;
    private String result;
    private String message;
}

