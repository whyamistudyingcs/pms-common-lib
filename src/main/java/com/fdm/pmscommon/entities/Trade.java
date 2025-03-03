package com.fdm.pmscommon.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@ToString
@NoArgsConstructor
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "external_order_id", unique = true)
    private String externalOrderId;

    @Column(name = "trade_date")
    private String tradeDate;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "order_type", nullable = false)
    private String orderType;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "exchange", nullable = false)
    private String exchange;

    @Column(name = "status")
    private String status;

    @Column(name = "position_id")
    private UUID positionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}