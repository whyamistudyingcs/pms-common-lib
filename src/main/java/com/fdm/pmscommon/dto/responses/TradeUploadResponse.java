package com.fdm.pmscommon.dto.responses;

import java.util.List;

import com.fdm.pmscommon.dto.TradeResult;

import lombok.Data;

@Data
public class TradeUploadResponse {
    private List<TradeResult> tradeResultList;
}
