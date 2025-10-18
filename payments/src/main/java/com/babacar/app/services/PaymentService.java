package com.babacar.app.services;

import com.babacar.app.constants.PaymentConstant;
import com.babacar.app.dto.requests.CreatePaymentRequest;
import com.babacar.app.dto.responses.PaymentResponse;
import com.babacar.app.entities.Payments;
import com.babacar.app.mappers.PaymentMapper;
import com.babacar.app.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentResponse create(CreatePaymentRequest request){

        Payments payments= new Payments();
        payments.setUuid(UUID.randomUUID().toString());
        if (request.paymentMethods().contains(PaymentConstant.VALID_PAYMENTS)){
            throw new IllegalStateException("payment methods are not supported");
        }
        payments.setPaymentMethods(request.paymentMethods());
        payments.setPrix(request.prix());
        payments.setPaymentDate(LocalDate.now());
        paymentRepository.save(payments);

        return paymentMapper.toPaymentResponse(payments);
    }


    public PaymentResponse getPaymentByUuid(String uuid){
        Payments payments= paymentRepository.findByUuid(uuid).orElseThrow(
                ()->new NoSuchElementException("payment with uuid"+uuid+"not found")
        );
        return paymentMapper.toPaymentResponse(payments);
    }
}
