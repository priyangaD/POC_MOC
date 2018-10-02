package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
