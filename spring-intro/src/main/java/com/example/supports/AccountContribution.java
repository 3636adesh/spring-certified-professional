package com.example.supports;

import com.common.money.MonetaryAmount;
import com.common.money.Percentage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountContribution {

	private String accountNumber;

	private MonetaryAmount amount;

	private Set<Distribution> distributions;

	@Getter
	@Setter
	@NoArgsConstructor
	public static class Distribution {

		private String beneficiary;

		private MonetaryAmount amount;

		private Percentage percentage;

		private MonetaryAmount totalSavings;
	}
}