package com.payment_service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    public Order createRazorpayOrder(int amount, String currency, String receipt) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(keyId, keySecret);

        JSONObject options = new JSONObject();
        options.put("amount", amount * 100); // convert to paise
        options.put("currency", currency);
        options.put("receipt", receipt);
        options.put("payment_capture", 1);

        return razorpay.orders.create(options);
    }
}
