package com.fdm.pmscommon.dto.outgoing;

import java.util.List;

import com.fdm.pmscommon.dto.general.TradeDto;

import lombok.Data;

@Data
public class TradeHistoryResponseDto {
    private List<TradeDto> trades;
    private String startDate;
    private String endDate;
}
