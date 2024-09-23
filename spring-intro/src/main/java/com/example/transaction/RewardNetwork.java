package com.example.transaction;

import com.example.supports.Dining;
import com.example.supports.RewardConfirmation;

public interface RewardNetwork {

    RewardConfirmation rewardAccountFor(Dining dining);
}
