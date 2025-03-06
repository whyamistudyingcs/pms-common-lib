package com.fdm.pmscommon.dto.outgoing;

import lombok.Data;

import java.util.List;

import com.fdm.pmscommon.dto.general.PositionDto;

@Data
public class PositionResponse {
    private List<PositionDto> positionData;

}