/**
 * © 2024 JTino Inc. Author: Joseph Tino.
 * Redistribution permitted with attribution. Provided "as is" without warranty.
 * No liability for damages. See full license for details.
 */

package com.org.material.service;

import com.org.material.common.Transaction;
import com.org.material.util.CCUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TransactionProducer {
    private static final Logger logger = LoggerFactory.getLogger(TransactionProducer.class);
    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    private static final String TOPIC = "transactions";

    /**
     * Method to send transaction using Dummy Data
     */
    @Scheduled(fixedRate = 1000)  //enable it
    public void sendTransaction() {
        Transaction transaction = generateDummyTransactionObj();
        kafkaTemplate.send(TOPIC, transaction);
        logger.info("Publish Credit Card transaction Details to kafka : " + transaction.toString());
        //todo handle exception
    }

    /**
     * Method to send transaction using input Data from postman
     */

    public void sendTransaction(Transaction t) {
        Transaction transaction = mapTransactionObj(t);
        kafkaTemplate.send(TOPIC, transaction);
        logger.info("Publish Credit Card transaction Details to kafka : " + transaction.toString());
        //todo handle exception
    }


   private  Transaction generateDummyTransactionObj(){

        logger.info("Generate  Credit Card transaction object " );
        Transaction transaction = new Transaction();
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setCardNumber(CCUtility.generateCreditCardNumber());
        transaction.setAmount(Math.random() * 1000);
        transaction.setTimestamp(System.currentTimeMillis());
        transaction.setMerchantId(UUID.randomUUID().toString());
        return transaction;
    }

    private Transaction mapTransactionObj(Transaction t){

        logger.info("Map Credit Card transaction object " );
        Transaction transaction = new Transaction();
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setCardNumber(t.getCardNumber());
        transaction.setAmount(t.getAmount());
        transaction.setTimestamp(System.currentTimeMillis());
        transaction.setMerchantId(t.getMerchantId());
        return transaction;
    }




}