package com.jkn.hrpayroll.service;

import com.jkn.hrpayroll.entities.Payment;
import com.jkn.hrpayroll.entities.Worker;
import com.jkn.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

//    @Value("${hr-worker.host}")
//    private String workerHost;

    @Autowired
    private WorkerFeignClient feignClient;

//    public Payment getPayment(long workerId, int days){
//        Map<String, String> uriVariable = new HashMap<>();
//        uriVariable.put("id",""+workerId);
//
//        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);
//        return new Payment(worker.getName(), worker.getDailyIncome(), days);
//    }

    public Payment getPayment(long workerId, int days){
        Worker worker = feignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);

    }
}

