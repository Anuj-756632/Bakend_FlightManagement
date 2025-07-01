package com.payment_service.service;

import com.payment_service.dto.OrderRequestDTO;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {

    @Value("${razorpay.key_id}")
    private String razorpayKeyId;

    @Value("${razorpay.key_secret}")
    private String razorpayKeySecret;

    public JSONObject createRazorpayOrder(OrderRequestDTO requestDTO) throws RazorpayException {
        RazorpayClient client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);

        JSONObject options = new JSONObject();
        options.put("amount", requestDTO.getAmount()); // Amount in paise
        options.put("currency", requestDTO.getCurrency());
        options.put("receipt", requestDTO.getReceipt());

        Order order = client.orders.create(options);
        return order.toJson();
    }
}
