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
import com.example.model.PurchaseDetail;
import com.example.repository.PurchaseDetailRepository;
import com.example.service.PurchaseDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/purchaseDetail")
@Api(value="onlinestore", description="Operations pertaining to purchases Detail in Online Store")
public class PurchaseDetailController {
	
	@Autowired
	PurchaseDetailService purchaseDetailService;
	
	@Autowired
	PurchaseDetailRepository purchaseDetailRepository;
	
	@ApiOperation(value = "Search a purchase Detail with an ID",response = Purchase.class)
	@GetMapping("/api/purchaseDetail/{id}")
	public ResponseEntity<PurchaseDetail> getPurchaseDetail(@PathVariable("id") Long id) {
		PurchaseDetail PurchaseDetail = purchaseDetailService.findById(id);
		return new ResponseEntity<PurchaseDetail>(PurchaseDetail, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of available purchase Detail", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@GetMapping("/api/purchaseDetail/list/")
	public ResponseEntity<List<PurchaseDetail>> getAllPurchaseDetails() {
		ArrayList<PurchaseDetail >PurchaseDetailsList = (ArrayList<PurchaseDetail>) purchaseDetailService.getAllPurchaseDetail();
		return new ResponseEntity<List<PurchaseDetail>>(PurchaseDetailsList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add a purchase Detail")
	@PostMapping("/api/purchaseDetail/")
	public ResponseEntity<PurchaseDetail> addPurchaseDetail(@RequestBody PurchaseDetail PurchaseDetail) {
		System.out.print(PurchaseDetail);
		PurchaseDetail cPurchaseDetail = new PurchaseDetail();
		cPurchaseDetail.setItemId(PurchaseDetail.getItemId());
		cPurchaseDetail.setPurchaseId(PurchaseDetail.getPurchaseId());
		cPurchaseDetail.setItemPrice(PurchaseDetail.getItemPrice());
		cPurchaseDetail.setQty(PurchaseDetail.getQty());
		cPurchaseDetail.setExpiryDate(PurchaseDetail.getExpiryDate());
		cPurchaseDetail.setTotalAmount(PurchaseDetail.getTotalAmount());
		purchaseDetailRepository.save(cPurchaseDetail);
		return new ResponseEntity<PurchaseDetail>(PurchaseDetail, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a purchase Detail")
	@PutMapping("/api/purchaseDetail/{id}")
	public ResponseEntity<PurchaseDetail> updatePurchaseDetail(@PathVariable("id") Long id, @RequestBody PurchaseDetail PurchaseDetail) {
		PurchaseDetail cPurchaseDetail = purchaseDetailService.findById(id);
		cPurchaseDetail.setItemId(PurchaseDetail.getItemId());
		cPurchaseDetail.setPurchaseId(PurchaseDetail.getPurchaseId());
		cPurchaseDetail.setItemPrice(PurchaseDetail.getItemPrice());
		cPurchaseDetail.setQty(PurchaseDetail.getQty());
		cPurchaseDetail.setExpiryDate(PurchaseDetail.getExpiryDate());
		cPurchaseDetail.setTotalAmount(PurchaseDetail.getTotalAmount());
		purchaseDetailRepository.save(cPurchaseDetail);
		return new ResponseEntity<PurchaseDetail>(PurchaseDetail, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a purchase Detail")
	@DeleteMapping("/api/purchaseDetail/{id}")
	public ResponseEntity<String> deletePurchaseDetail(@PathVariable("id") Long id) {
		PurchaseDetail cPurchaseDetail = purchaseDetailService.findById(id);
		purchaseDetailRepository.delete(cPurchaseDetail);
		return new ResponseEntity<String>("PurchaseDetail removed", HttpStatus.OK);
	}
	
	

}
