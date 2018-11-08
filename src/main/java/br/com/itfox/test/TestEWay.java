/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.test;

import com.eway.payment.rapid.sdk.*;
import com.eway.payment.rapid.sdk.beans.external.*;
import com.eway.payment.rapid.sdk.output.*;

/**
 *
 * @author belchiorpalma
 */
public class TestEWay {
    public static void main(String[] args) {
        try{
        String apiKey = "44DD7CfnAKlw1sNplZ8Ue/3imR3DcWfKokZOBerZ/ijRkuVRdfNQzNrQ05GYtW4ni6ACFB";
        String password = "zm3dRlSA";
        String rapidEndpoint = "Sandbox";
        String accessCode="F9802Af1q9L9fW_O3D2mwdZpJ_4nfZPIhbGu14mVYHtBB4CIR9fWUduVAtO1Gv4vJFmwGflc_9-wHsgIwP4k_dlE1lHoVMPgVHJ34p7QXLy_sVAVEt7ASXz9uZwC18Q6baYdZcnSDhEmQlgDXlXZEhuKhnQ==";
        RapidClient client = RapidSDK.newRapidClient(apiKey, password, rapidEndpoint);
        
        QueryTransactionResponse response = 
    client.queryTransaction(accessCode);
        
        if (response.getTransactionStatus().isStatus()) {
    System.out.println("Payment successful! ID: " + response.getTransactionStatus().getTransactionID());
} else {
    String[] errorcodes = response.getTransactionStatus().getProcessingDetails().getResponseMessage().split(", ");
    
    for (String errorcode: errorcodes) {
        System.out.println("Response Messages: " 
            + RapidSDK.userDisplayMessage(errorcode, "en"));
    }
 
}
        
            System.out.println("Cliente e' valido?: "+client.isValid());
        
        CardDetails cardDetails = new CardDetails();
        cardDetails.setName("John Smith");
        cardDetails.setNumber("4444333322221111");
        cardDetails.setExpiryMonth("12");
        cardDetails.setExpiryYear("25");
        cardDetails.setCVN("123");

        Customer customer = new Customer();
        customer.setCardDetails(cardDetails);

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setTotalAmount(1000);

        Transaction transaction = new Transaction();
        transaction.setCustomer(customer);
        transaction.setPaymentDetails(paymentDetails);
        transaction.setTransactionType(TransactionType.Purchase);

        PaymentMethod method = PaymentMethod.Direct;
        //CreateTransactionResponse response = client.create(method, transaction);
        
          

        if (response.getTransactionStatus().isStatus()) {
            System.out.println("Transaction successful! ID: " + response.getTransactionStatus().getTransactionID());
        }else{
            System.out.println("Error: " + response.getTransactionStatus().getProcessingDetails().getResponseMessage());
        }
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
