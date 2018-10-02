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

import com.example.model.Purchase;
import com.example.model.Supplier;
import com.example.repository.PurchaseRepository;
import com.example.repository.SupplierRepository;
import com.example.service.PurchaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/purchase")
@Api(value="onlinestore", description="Operations pertaining to purchase in Online Store")
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@ApiOperation(value = "Search a purchase with an ID",response = Purchase.class)
	@GetMapping("/api/purchase/{id}")
	public ResponseEntity<Purchase> getPurchase(@PathVariable("id") Long id) {
		Purchase purchase = purchaseService.findById(id);
		return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of available purchase", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	
	@GetMapping("/api/purchase/list/")
	public ResponseEntity<List<Purchase>> getAllPurchases() {
		ArrayList<Purchase >purchaseList = (ArrayList<Purchase>) purchaseService.getAllPurchases();
		return new ResponseEntity<List<Purchase>>(purchaseList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add a purchase")
	@PostMapping("/api/purchase/")
	public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase) {
		System.out.print(purchase);
		Purchase cPurchase = new Purchase();	
		Supplier sup=new Supplier();
		sup.setId(purchase.getSupplier().getId());
		//sup=supplierRepository.findOne(purchase.getSupplier().getId());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println(purchase.getSupplier().getId());
		cPurchase.setSupplier(sup);
		cPurchase.setDate(purchase.getDate());
		cPurchase.setInvoiceNo(purchase.getInvoiceNo());
		cPurchase.setPaymentType(purchase.getPaymentType());		
		cPurchase.setDiscount(purchase.getDiscount());
		cPurchase.setNetAmount(purchase.getNetAmount());
		cPurchase.setPayedAmount(purchase.getPayedAmount());
		cPurchase.setRemaingAmount(purchase.getRemaingAmount());
		purchase=purchaseRepository.save(cPurchase);
		return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a purchase")
	@PutMapping("/api/purchase/{id}")
	public ResponseEntity<Purchase> updatePurchase(@PathVariable("id") Long id, @RequestBody Purchase purchase) {
		Purchase cPurchase = purchaseService.findById(id);
		cPurchase.setSupplier(purchase.getSupplier());
		cPurchase.setInvoiceNo(purchase.getInvoiceNo());
		cPurchase.setDate(purchase.getDate());
		cPurchase.setPaymentType(purchase.getPaymentType());		
		cPurchase.setDiscount(purchase.getDiscount());
		cPurchase.setNetAmount(purchase.getNetAmount());
		cPurchase.setPayedAmount(purchase.getPayedAmount());
		cPurchase.setRemaingAmount(purchase.getRemaingAmount());
		purchaseRepository.save(cPurchase);
		return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a purchase")
	@DeleteMapping("/api/purchase/{id}")
	public ResponseEntity<String> deletePurchase(@PathVariable("id") Long id) {
		Purchase cPurchase = purchaseService.findById(id);
		purchaseRepository.delete(cPurchase);
		return new ResponseEntity<String>("purchase removed", HttpStatus.OK);
	}

}
