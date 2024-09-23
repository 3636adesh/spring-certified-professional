package com.common.money;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@Embeddable
public class MonetaryAmount implements Serializable {

    @Serial
    private static final long serialVersionUID = 8077279865855620753L;

    private BigDecimal value;

    @JsonCreator
    public MonetaryAmount(BigDecimal value) {
        initValue(value);
    }

    public MonetaryAmount(double value) {
        initValue(BigDecimal.valueOf(value));
    }

    private void initValue(BigDecimal  value){
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        value = value.setScale(2, RoundingMode.HALF_UP);
        if (value.compareTo(BigDecimal.ZERO) < 0 || value.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("MonetaryAmount value must be between 0 and 1; your value was " + value);
        }
        this.value = value;
    }


    public static MonetaryAmount oneHundred(){
        return new MonetaryAmount(1);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MonetaryAmount MonetaryAmount){
            return value.equals(MonetaryAmount.value);
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    @Override
    public String toString() {
        return "$" + value.toString();
    }


}