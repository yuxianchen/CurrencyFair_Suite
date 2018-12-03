package com.currencyfair_backend.repos;

import com.currencyfair_backend.entities.TradeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeTransactionRepository extends JpaRepository<TradeTransaction, Long> {
}
