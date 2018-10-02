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

import com.example.model.Item;
import com.example.model.Supplier;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/item")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemRepository itemRepository;
	
	@ApiOperation(value = "Search a product with an ID",response = Item.class)
	@GetMapping("/api/item/{id}")
	public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {
		Item item = itemService.findById(id);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)	
	@GetMapping("/api/item/list")
	public ResponseEntity<List<Item>> getAllItems() {
		ArrayList<Item >itemsList = (ArrayList<Item>) itemService.getAllItems();
		return new ResponseEntity<List<Item>>(itemsList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add a product")
	@PostMapping("/api/item/")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		System.out.print(item);
		Item iItem = new Item();
		iItem.setCode(item.getCode());
		iItem.setName(item.getName()); 
		iItem.setCategory(item.getCategory());
		iItem.setPrice(item.getPrice());
		iItem.setTax(item.getTax());
		itemRepository.save(iItem);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a product")
	@PutMapping("/api/item/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable("id") Long id, @RequestBody Item item) {
		Item iItem = itemService.findById(id);
		iItem.setCode(item.getCode());
		iItem.setName(item.getName()); 
		iItem.setCategory(item.getCategory());
		iItem.setPrice(item.getPrice());
		iItem.setTax(item.getTax());
		itemRepository.save(iItem);
		return new ResponseEntity<Item>(iItem, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a product")
	@DeleteMapping("/api/item/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable("id") Long id) {
		Item iItem = itemService.findById(id);
		itemRepository.delete(iItem);
		return new ResponseEntity<String>("Item removed", HttpStatus.OK);
	}
}
