package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.model.Purchase;
import com.example.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	PurchaseRepository purchaseRepository;

	@Override
	public void save(Purchase purchase) {
		purchaseRepository.save(purchase);
		
	}

	
	public Purchase findById(Long id) {
		return purchaseRepository.findOne(id);
	}

	
	public List<Purchase> getAllPurchases() {
		return purchaseRepository.findAll();
	}


	

}
