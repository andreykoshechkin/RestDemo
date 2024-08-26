package com.example.restdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ContractCur {

    RUR("Рубли"),
    EUR("Евро"),
    JPY("Иена"),
    USD("Доллар");

    private final String cur;

}
