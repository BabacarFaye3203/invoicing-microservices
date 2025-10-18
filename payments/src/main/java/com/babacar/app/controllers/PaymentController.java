package com.babacar.app.controllers;

import com.babacar.app.dto.requests.CreatePaymentRequest;
import com.babacar.app.dto.responses.PaymentResponse;
import com.babacar.app.services.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "payments API")
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    public final PaymentService paymentService;

    @PostMapping("/create")
    @Operation(summary = "creation of a payment")
    public PaymentResponse create(
            @RequestBody CreatePaymentRequest request){
        return paymentService.create(request);
    }

    @GetMapping("{uuid}")
    @Operation(summary = "get a payment by uuid")
    public PaymentResponse getPaymentByUuid(
            @PathVariable(name = "uuid") String uuid){
        return paymentService.getPaymentByUuid(uuid);

    }
}
