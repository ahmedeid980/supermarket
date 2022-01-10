package com.ahmedeid.supermarket.supermarket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.supermarket.supermarket.entity.Supermarket;
import com.ahmedeid.supermarket.supermarket.repository.SupermarketDAO;
import com.ahmedeid.supermarket.supermarket.repository.SupermarketRepository;

@Service
public class SupermarketService {
	
	/**
	 * i can use this repository .
	 * it prevent me to use DAO 
	 * and use it's embedded function as findAll(), findById(), save(object), ... 
	 */
	@Autowired
	private SupermarketRepository supermarketRepository;
	
	/**
	 * using DAO
	 */
	@Autowired
	private SupermarketDAO supermarketDAO;
	
	/**
	 * getSupermarketById fun.
	 * using Repository ...
	 * @param id
	 * @return
	 */
	public Supermarket getSupermarketById(int id) {
		if(id != 0)
			return this.supermarketRepository.findById(id).get();
		
		return null;
	}
	
	/**
	 * getSupermarketList fun.
	 * using Repository ...
	 * @return
	 */
	public List<Supermarket> getSupermarketList() {
		return this.supermarketRepository.findAll();
	}
	
	/**
	 * saveSupermarket fun.
	 * using Repository ...
	 * @param supermarket
	 * @return
	 */
	public Supermarket saveSupermarket(Supermarket supermarket) {
		return this.supermarketRepository.save(supermarket);
	}
	
	/**
	 * deleteSupermarket fun. 
	 * useing Repository ... 
	 * @param id
	 * @return
	 */
	public boolean deleteSupermarket(int id) {
		Supermarket supermarket = this.supermarketRepository.findById(id).get();
		boolean status = false;
		if(supermarket != null) {
			this.supermarketRepository.delete(supermarket);
			status = true;
		}
		return status;
	}
	
	// ------------------------------------------------------ //
	
	/**
	 * getSupermarketById fun.
	 * using DAO
	 * @param id
	 * @return
	 */
	public Supermarket getSupermarketById_usingDAO(int id) {
		if(id != 0)
			return this.supermarketDAO.getSupermarketById(id);
		
		return null;
	}
	
	/**
	 * getSupermarketList fun.
	 * using DAO
	 * @return
	 */
	public List<Supermarket> getSupermarketList_usingDAO() {
		return this.supermarketDAO.getSupermarketList();
	}
	
	/**
	 * saveSupermarket fun.
	 * using DAO
	 * @param supermarket
	 * @return
	 */
	@Transactional
	public Supermarket saveSupermarket_usingDAO(Supermarket supermarket) {
		return this.supermarketDAO.saveOrUpdateSupermarket(supermarket);
	}
	
	/**
	 * deleteSupermarket fun. 
	 * using DAO
	 * @param id
	 * @return
	 */
	public boolean deleteSupermarket_usingDAO(int id) {
		return this.supermarketDAO.deleteSupermarketById(id);
	}
	
}
