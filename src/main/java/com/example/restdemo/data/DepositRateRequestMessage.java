package com.example.restdemo.data;

import com.example.restdemo.annotation.CheckContractCur;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.example.restdemo.ContractCur.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositRateRequestMessage {

    @JsonProperty("requestId")
    @NotBlank(message = "Отсутствует параметр requestId")
    private String requestId;

    @JsonProperty("inputSource")
    @NotBlank(message = "Отсутствует параметр inputSource")
    private String inputSource;

    @JsonProperty("clientInn")
    @Size(min = 10, max = 12, message = "ИНН не действительный")
    @NotNull(message = "Отсутствует параметр clientInn")
    private String clientInn;

    @JsonProperty("filial")
    @NotBlank(message = "Отсутствует параметр filial")
    private String filial;

    @JsonProperty("contractCur")
    @CheckContractCur(curVal = {RUR, EUR, USD, JPY})
    private String contractCur;
}