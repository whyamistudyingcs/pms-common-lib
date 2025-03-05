package com.fdm.pmscommon.dto.outgoing;

import lombok.Data;
import com.fdm.pmscommon.dto.PositionDto;
import java.util.List;

@Data
public class PositionResponse {
    private List<PositionDto> positionData;

}