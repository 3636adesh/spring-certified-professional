package com.example.repo;

import com.example.supports.Restaurant;


public interface RestaurantRepository {

	public Restaurant findByMerchantNumber(String merchantNumber);
}
