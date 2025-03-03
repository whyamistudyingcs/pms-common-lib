package com.fdm.pmscommon.dto;

import com.fdm.pmscommon.dto.validation.ValidDate;
import com.fdm.pmscommon.dto.validation.ValidOrderType;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TradeDto {

    @NotBlank(message = "External Order ID cannot be empty")
    private String extOrderId;

    @ValidDate
    @NotBlank(message = "Trade date cannot be empty")
    private String tradeDate;

    @NotBlank(message = "Ticker cannot be empty")
    private String ticker;

    @ValidOrderType
    @NotBlank(message = "Order type cannot be empty")
    private String orderType;

    @NotBlank(message = "Quantity cannot be empty")
    private String quantity;

    @NotBlank(message = "Exchange cannot be empty")
    private String exchange;

    @NotBlank(message = "Price cannot be empty")
    private String price;

    @NotBlank(message = "Currency cannot be empty")
    private String currency;

}