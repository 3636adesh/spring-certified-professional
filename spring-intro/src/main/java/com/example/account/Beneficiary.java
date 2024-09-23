package com.example.account;

import com.common.enititable.Entity;
import com.common.money.MonetaryAmount;
import com.common.money.Percentage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary extends Entity {

    private String name;
    private Percentage allocationPercentage;
    private MonetaryAmount savings = MonetaryAmount.valueOf("0.00");
}
