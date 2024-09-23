package com.example.supports;

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
public class Restaurant extends Entity {

    private String number;

    private String name;

    private Percentage benefitPercentage;

    public MonetaryAmount calculateBenefitFor(Dining dining){
        return dining.getAmount().multiplyBy(benefitPercentage);
    }
}