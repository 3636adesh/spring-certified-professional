package com.example.transaction.imp;

import com.common.money.MonetaryAmount;
import com.example.account.Account;
import com.example.repo.AccountRepository;
import com.example.repo.RestaurantRepository;
import com.example.repo.RewardRepository;
import com.example.supports.AccountContribution;
import com.example.supports.Dining;
import com.example.supports.Restaurant;
import com.example.supports.RewardConfirmation;
import com.example.transaction.RewardNetwork;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionImp implements RewardNetwork {

    private final AccountRepository accountRepository;
    private final RestaurantRepository restaurantRepository;
    private final RewardRepository rewardRepository;

    @Override
    public RewardConfirmation rewardAccountFor(Dining dining) {
        Account existsAccount = accountRepository.findByCreditCard(dining.getCreditCardNumber());
        Restaurant restaurant = restaurantRepository.findByMerchantNumber(dining.getMerchantNumber());
        MonetaryAmount monetaryAmount = restaurant.calculateBenefitFor( dining);
        AccountContribution contribution = existsAccount.makeContribution(monetaryAmount);
        accountRepository.updateBeneficiaries(existsAccount);
        return rewardRepository.confirmReward(contribution, dining);
    }
}
