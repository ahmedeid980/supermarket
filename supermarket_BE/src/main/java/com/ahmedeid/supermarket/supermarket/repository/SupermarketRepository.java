package com.ahmedeid.supermarket.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahmedeid.supermarket.supermarket.entity.Supermarket;

@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket, Integer> {

}
