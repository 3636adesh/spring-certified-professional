package com.example.account;


import com.common.enititable.Entity;
import com.common.money.MonetaryAmount;
import com.common.money.Percentage;
import com.example.supports.AccountContribution;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class Account extends Entity {

    private String name;
    private String number;
    private Set<Beneficiary> beneficiaries;


    private boolean isValid(){
        Percentage totalPercentage = Percentage.zero();
        for(var beneficiary:beneficiaries){
            totalPercentage=totalPercentage.add(beneficiary.getAllocationPercentage());
        }
        return totalPercentage.equals(Percentage.oneHundred());

    }

    public AccountContribution makeContribution(MonetaryAmount amount){
        if(!isValid()){
            throw new IllegalStateException(
                    "Cannot make contributions to this account: it has invalid beneficiary allocations");
        }
    }
}
