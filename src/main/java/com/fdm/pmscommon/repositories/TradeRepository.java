package com.fdm.pmscommon.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdm.pmscommon.entities.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, UUID> {
    Trade findByExternalOrderId(String externalOrderId);
}