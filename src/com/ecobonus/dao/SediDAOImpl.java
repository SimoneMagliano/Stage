package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ecobonus.entity.Sede;

@Repository
public class SediDAOImpl implements SediDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<Sede> getSedi() {	
		Session currentSession = sessionFactory.getCurrentSession();		
		Query<Sede> theQuery = 
				currentSession.createQuery("from Sede order by codSede",
						Sede.class);
		List<Sede> sedi = theQuery.getResultList();	
		return sedi;
	}

	@Override
	public void saveSede(Sede theSede) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theSede);
	}

	@Override
	  public Sede getSede(String codSede) {
        Session currentSession = sessionFactory.getCurrentSession();
        Sede sede = currentSession.get(Sede.class, codSede);
        return sede;
    }
	
	@Override
	public void deleteSede(String codSede) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Sede where codSede=:codSede");
		theQuery.setParameter("CodSede", codSede);
		theQuery.executeUpdate();		
	}

	@Override
	public Sede getSede(Sede theCodSede) {
		return null;
	}	
}
