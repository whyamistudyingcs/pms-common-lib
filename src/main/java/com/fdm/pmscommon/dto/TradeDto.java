package com.fdm.pmscommon.dto;

import java.util.UUID;

import com.fdm.pmscommon.dto.validation.NonZero;
import com.fdm.pmscommon.dto.validation.ValidDate;
import com.fdm.pmscommon.dto.validation.ValidOrderType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = "Quantity cannot be empty")
    @NonZero(message = "Quantity cannot be zero. Either positive (buy) or negative (sell)")
    private Integer quantity;

    @NotBlank(message = "Exchange cannot be empty")
    private String exchange;

    @NotNull(message = "Price cannot be empty")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Currency cannot be empty")
    private String currency;

    // Helper attributes for position update
    private UUID positionId;

    private UUID accountId;
}