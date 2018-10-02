package com.example.service;

import java.util.List;

import com.example.model.Supplier;

public interface SupplierService {
	void save(Supplier supplier);
	Supplier findById(Long id);
	List<Supplier> getAllSupplier();

}
