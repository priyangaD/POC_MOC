package com.example.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {
	
	@Id
	@Column(name = "pur_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "pur_invoiceno")
	private String invoiceNo;
	
	@Column(name = "pur_invoicedt")
	private Date date;
	
	@Column(name = "pur_paytype")
	private String paymentType;
	
	//@Column(name = "pur_sup_id")
	@ManyToOne(optional = false)
	@JoinColumn(name = "pur_sup_id")		
	private Supplier supplier;
		
	@Column(name = "pur_dis")
	private Double discount;
	
	@Column(name = "pur_netamt")
	private Double netAmount;
	
	@Column(name = "pur_payamt")
	private Double payedAmount;
	
	@Column(name = "pur_remaningamt")
	private Double remaingAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}	

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(Double payedAmount) {
		this.payedAmount = payedAmount;
	}

	public Double getRemaingAmount() {
		return remaingAmount;
	}

	public void setRemaingAmount(Double remaingAmount) {
		this.remaingAmount = remaingAmount;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	
	
}
