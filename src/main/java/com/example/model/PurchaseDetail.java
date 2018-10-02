package com.example.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchaseDetail")
public class PurchaseDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purdt_id")	
	private Long id;	
	
	//@Column(name = "purdt_pur_id")	
//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name = "purdt_pur_id", nullable = false,foreignKey = @ForeignKey(name = "fk_purchase_detail_pur_id"))	
	@ManyToOne(optional = false)
	@JoinColumn(name = "purdt_pur_id")	
	private Purchase purchaseId;	
	
	//@Column(name = "purdt_item_id")	
	//@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	//@JoinColumn(name = "purdt_item_id", nullable = false,foreignKey = @ForeignKey(name = "fk_purchase_detail_itm_id"))	
	@ManyToOne(optional = false)
	@JoinColumn(name = "purdt_item_id")	
	private Item itemId; 
	
	@Column(name = "purdt_qty")
	private int Qty;
	
	@Column(name = "purdt_itemprice")		
	private Double itemPrice;
	
	@Column(name = "purdt_expdate")
	private Date expiryDate;
	
	@Column(name = "purdt_totamt")
	private Double totalAmount;

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Purchase getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Purchase purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}
	
	
}
