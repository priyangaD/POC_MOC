package com.example.service;

import java.util.List;

import com.example.model.PurchaseDetail;
import com.example.model.Purchase;


public interface PurchaseService {
	
	void save(Purchase purchase);
	Purchase findById(Long id);
	List<Purchase> getAllPurchases();

}
