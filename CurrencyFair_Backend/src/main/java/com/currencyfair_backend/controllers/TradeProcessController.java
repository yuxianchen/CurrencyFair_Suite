package com.currencyfair_backend.controllers;

import com.currencyfair_backend.dtos.TradeTransactionDTO;
import com.currencyfair_backend.entities.TradeTransaction;
import com.currencyfair_backend.repos.TradeTransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TradeProcessController {

    private final Logger logger = LogManager.getLogger(TradeProcessController.class);

    private final TradeTransactionRepository tradeTransactionRepository;

    @Autowired
    public TradeProcessController(TradeTransactionRepository tradeTransactionRepository) {
        this.tradeTransactionRepository = tradeTransactionRepository;
    }

    @PostMapping(path="/tradetrans",consumes = "application/json",produces = "application/json")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ResponseEntity<Object> pushTradeTransaction(@RequestBody TradeTransaction tran) {
        logger.info("calling pushTradeTransaction api....");
        TradeTransaction savedTran = tradeTransactionRepository.save(tran);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTran.getId()).toUri();
        if(logger.isDebugEnabled()) {
            logger.debug("Trade transaction " + savedTran.getId() + " has been created....");
        }
        return ResponseEntity.created(location).build();
    }


    @RequestMapping(value = {"/tradetrans"}, method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    @ResponseBody
    public List<TradeTransactionDTO> listTradeTransactions(){

        logger.info("Calling listTradeTransactions....");
        List<TradeTransaction> trans = tradeTransactionRepository.findAll();
        List<TradeTransactionDTO> res = new ArrayList<>();
        for(TradeTransaction tran : trans) {
            TradeTransactionDTO t = new TradeTransactionDTO();
            t.setUserId(tran.getUserId());
            t.setCurrencyFrom(tran.getCurrencyFrom().name());
            t.setCurrencyTo(tran.getCurrencyTo().name());
            t.setAmountBuy(tran.getAmountBuy());
            t.setAmountSell(tran.getAmountSell());
            t.setRate(tran.getRate());
            t.setTimePlaced(new SimpleDateFormat("dd-MMM-YY hh:mm:ss").format(tran.getTimePlaced()));
            t.setOriginatingCountry(tran.getOriginatingCountry().name());
            res.add(t);
        }

        if(logger.isDebugEnabled()) {
            logger.debug("Number of results: " + res.size());
        }
        return res;
    }
}
