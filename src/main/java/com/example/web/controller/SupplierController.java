package com.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Supplier;
import com.example.repository.SupplierRepository;
import com.example.service.SupplierService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/supplier")
@Api(value="onlinestore", description="Operations pertaining to suppliers in Online Store")
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@ApiOperation(value = "Search a supplier with an ID",response = Supplier.class)
	@GetMapping("/api/supplier/{id}")
	public ResponseEntity<Supplier> getSupplier(@PathVariable("id") Long id) {
		Supplier Supplier = supplierService.findById(id);
		return new ResponseEntity<Supplier>(Supplier, HttpStatus.OK);
	}
	@ApiOperation(value = "View a list of available supplier", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
	
	@GetMapping("/api/supplier/list")
	public ResponseEntity<List<Supplier>> getAllSuppliers() {
		ArrayList<Supplier >SuppliersList = (ArrayList<Supplier>) supplierService.getAllSupplier();
		return new ResponseEntity<List<Supplier>>(SuppliersList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add a supplier")
	@PostMapping("/api/supplier/")
	public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier Supplier) {
		System.out.print(Supplier);
		Supplier cSupplier = new Supplier();
		cSupplier.setCompany(Supplier.getCompany());
		cSupplier.setMobile(Supplier.getMobile());
		cSupplier.setEmail(Supplier.getEmail());
		cSupplier.setCity(Supplier.getCity());
		cSupplier.setAddress(Supplier.getAddress());
		supplierRepository.save(cSupplier);
		return new ResponseEntity<Supplier>(Supplier, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a supplier")
	@PutMapping("/api/supplier/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") Long id, @RequestBody Supplier Supplier) {
		Supplier cSupplier = supplierService.findById(id);
		cSupplier.setCompany(Supplier.getCompany());
		cSupplier.setMobile(Supplier.getMobile());
		cSupplier.setEmail(Supplier.getEmail());
		cSupplier.setCity(Supplier.getCity());
		cSupplier.setAddress(Supplier.getAddress());
		supplierRepository.save(cSupplier);
		return new ResponseEntity<Supplier>(Supplier, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a supplier")
	@DeleteMapping("/api/supplier/{id}")
	public ResponseEntity<String> deleteSupplier(@PathVariable("id") Long id) {
		Supplier cSupplier = supplierService.findById(id);
		supplierRepository.delete(cSupplier);
		return new ResponseEntity<String>("Supplier removed", HttpStatus.OK);
	}

}
