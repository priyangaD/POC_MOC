package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.PurchaseDetail;
import com.example.model.Purchase;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Long>{

	

}
