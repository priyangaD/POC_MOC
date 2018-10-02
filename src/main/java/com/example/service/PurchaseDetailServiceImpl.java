package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.PurchaseDetail;
import com.example.repository.PurchaseDetailRepository;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService{
	
	@Autowired
	PurchaseDetailRepository purchaseDetailRepository;

	@Override
	public void save(PurchaseDetail purchaseDetail) {
		purchaseDetailRepository.save(purchaseDetail);
		
	}

	
	public PurchaseDetail findById(Long id) {
		return purchaseDetailRepository.findOne(id);
	}

	
	public List<PurchaseDetail> getAllPurchaseDetail() {
		return purchaseDetailRepository.findAll();
	}
	
	

}
