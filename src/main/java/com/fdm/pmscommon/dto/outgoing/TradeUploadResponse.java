package com.fdm.pmscommon.dto.outgoing;

import java.util.List;

import com.fdm.pmscommon.dto.general.TradeResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeUploadResponse {
    private List<TradeResult> tradeResultList;
}
