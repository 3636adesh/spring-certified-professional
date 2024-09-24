package com.example.repo;

import com.example.supports.AccountContribution;
import com.example.supports.Dining;
import com.example.supports.RewardConfirmation;



public interface RewardRepository {


	RewardConfirmation confirmReward(AccountContribution contribution, Dining dining);
}