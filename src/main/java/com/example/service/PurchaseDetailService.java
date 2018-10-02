package com.example.service;

import java.util.List;

import com.example.model.PurchaseDetail;


public interface PurchaseDetailService {
	
	void save(PurchaseDetail purchaseDetail);
	PurchaseDetail findById(Long id);
	List<PurchaseDetail> getAllPurchaseDetail();

}
