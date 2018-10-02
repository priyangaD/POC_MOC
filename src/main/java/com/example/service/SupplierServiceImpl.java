package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Supplier;
import com.example.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
		
	}

	@Override
	public Supplier findById(Long id) {
		return supplierRepository.findOne(id);
	}

	@Override
	public List<Supplier> getAllSupplier() {
		
		return supplierRepository.findAll();
	}

}
