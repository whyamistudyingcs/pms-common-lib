package com.fdm.pmscommon.dto.outgoing;

import java.util.List;

import com.fdm.pmscommon.dto.TradeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TradeUploadRequestToPc {

    private List<TradeDto> tradeList;
}
