package com.ahmedeid.supermarket.supermarket.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ahmedeid.supermarket.supermarket.entity.Supermarket;

@Repository
@Transactional
public class SupermarketDAO {

	@Autowired
	private EntityManager entityManager;

	public Supermarket getSupermarketById(int id) {

		Session session = entityManager.unwrap(Session.class);

		Query supermarketById = session.createQuery("From Supermarket s where s.id= :id ");

		supermarketById.setParameter("id", id);
		Supermarket supermarket = (Supermarket) supermarketById.uniqueResult();
		
		return supermarket;
	}

	public List<Supermarket> getSupermarketList() {

		Session session = entityManager.unwrap(Session.class);

		Query supermarketList = session.createQuery("From Supermarket s");

		List<Supermarket> supermarkets = supermarketList.list();
		
		return supermarkets;
	}
	
	/**
	 * save new supermarket fun().
	 * @param supermarket
	 * @return
	 */
	public Supermarket saveOrUpdateSupermarket(Supermarket supermarket) {

		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(supermarket);
		
		return supermarket;
	}

	public boolean deleteSupermarketById(int id) {
		boolean status = false;
		Session session = entityManager.unwrap(Session.class);

		Query deleteSupermarket = session.createQuery("delete Supermarket s where s.id= :id");
		deleteSupermarket.setParameter("id", id);
		
		int statusNumber = deleteSupermarket.executeUpdate();
		
		if(statusNumber > 0)
			status = true;
		return status;
	}

}
