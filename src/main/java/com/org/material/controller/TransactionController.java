/**
 * © 2024 JTino Inc. Author: Joseph Tino.
 * Redistribution permitted with attribution. Provided "as is" without warranty.
 * No liability for damages. See full license for details.
 */

package com.org.material.controller;
import com.org.material.common.Transaction;
import com.org.material.service.TransactionProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/kafka")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    private final TransactionProducer kafkaProducerService;

    public TransactionController(TransactionProducer kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }


    @PostMapping("/publish")
    public ResponseEntity<String> processTransaction(@RequestBody Transaction transaction) {
        logger.info("Initiating send message to kafka topic (manual):   {}", transaction);
        if( (transaction.getTransactionId() == null && transaction.getCardNumber() == null &&
                transaction.getAmount() == 0.0 && transaction.getTimestamp() == 0 &&
                transaction.getMerchantId() == null) )  {
            //generate dummy
            kafkaProducerService.sendTransaction();
        }else{
            kafkaProducerService.sendTransaction(transaction);
        }
        return new ResponseEntity<>("Transaction processed successfully", HttpStatus.OK);
    }
    
}

