package com.eca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eca.model.Ecommerce;

@Repository
public interface EcommerceRepo extends JpaRepository<Ecommerce, Integer> {

}
