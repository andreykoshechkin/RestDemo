package com.example.restdemo.rest;

import com.example.restdemo.data.ClientResponse;
import com.example.restdemo.data.DepositRateRequestMessage;
import com.example.restdemo.data.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class DepositRateController {

    private final FrontReqApplicationsRepository frontReqApplicationsRepository;

    @PostMapping(value = "/processRequest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> processRequest(@Valid @RequestBody DepositRateRequestMessage depositRateRequestMessage) {
        // Проверка наличия requestId в базе данных
        if (frontReqApplicationsRepository.existsByRequestId(depositRateRequestMessage.getRequestId())) {
            String message = String.format("Запрос с requestId = %s уже найден в базе. Используйте новый requestId.",
                    depositRateRequestMessage.getRequestId());
            ClientResponse clientResponse = ClientResponse.builder()
                    .requestId(depositRateRequestMessage.getRequestId())
                    .result(Result.VALIDATION_ERROR)
                    .message(message)
                    .filial(depositRateRequestMessage.getFilial())
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clientResponse);
        }

        // Продолжение обработки запроса, если requestId уникален
        ClientResponse clientResponse = ClientResponse.builder()
                .requestId(depositRateRequestMessage.getRequestId())
                .result(Result.OK)
                .filial(depositRateRequestMessage.getFilial())
                .message("Ставка рассчита")
                .build();
        return ResponseEntity.ok(clientResponse);
    }
}