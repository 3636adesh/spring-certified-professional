package com.example.supports;

import com.common.money.MonetaryAmount;
import com.common.time.SimpleDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Dining {

	private MonetaryAmount amount;

	private String creditCardNumber;

	private String merchantNumber;

	private SimpleDate date;

}