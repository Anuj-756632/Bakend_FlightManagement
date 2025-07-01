package com.payment_service.controller;

import com.payment_service.dto.OrderRequestDTO;
import com.payment_service.service.RazorpayService;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private RazorpayService razorpayService;


    @PostMapping("/createOrder")
    public String createOrder(@RequestBody OrderRequestDTO request) throws RazorpayException {
        JSONObject order = razorpayService.createRazorpayOrder(request);
        return order.toString();
    }

    @GetMapping("/test")
    public String test() {
        return "Payment Gateway is running!";
    }
}
