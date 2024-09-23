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
public class Percentage implements Serializable {

    @Serial
    private static final long serialVersionUID = 8077279865855620752L;

    private BigDecimal value;

    @JsonCreator
    public Percentage(BigDecimal value) {
        initValue(value);
    }

    public Percentage(double value) {
        initValue(BigDecimal.valueOf(value));
    }

    private void initValue(BigDecimal value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        value = value.setScale(2, RoundingMode.HALF_UP);
        if (value.compareTo(BigDecimal.ZERO) < 0 || value.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("Percentage value must be between 0 and 1; your value was " + value);
        }
        this.value = value;
    }


    public Percentage add(Percentage  percentage){
        return  new Percentage(value.add(percentage.value));
    }


    public static Percentage oneHundred() {
        return new Percentage(1);
    }

    public static Percentage zero(){
        return new Percentage(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Percentage percentage) {
            return value.equals(percentage.value);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * @return as value*100%
     */
    @Override
    public String toString() {
        return String.format("%.0f%%", value.multiply(BigDecimal.valueOf(100)));
    }


}
