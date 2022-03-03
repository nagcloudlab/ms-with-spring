package com.example.web;

import com.example.service.TransferService;
import com.example.web.payload.TransferRequest;
import com.example.web.payload.TransferResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/txr",
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> doTransfer(@RequestBody TransferRequest transferRequest) {
        transferService.transfer(transferRequest.getAmount(), transferRequest.getSourceAccountNumber(), transferRequest.getTargetAccountNumber());
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setMessage("transfer response");
        return ResponseEntity.status(200).body(transferResponse);
    }

}
