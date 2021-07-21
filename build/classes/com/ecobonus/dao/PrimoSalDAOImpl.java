package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ecobonus.entity.Intervento;
import com.ecobonus.entity.PrimoSal;

@Repository
public class PrimoSalDAOImpl implements PrimoSalDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	public List<PrimoSal> getList() {
		Session currentSession = sessionFactory.getCurrentSession();
			Query<PrimoSal> theQuery = 
					currentSession.createQuery("from PrimoSal order by idPrimoSal", PrimoSal.class);
					List<PrimoSal> primoSal = theQuery.getResultList();	
				return primoSal;
	}
	
	@Override
	public void savePrimoSal(PrimoSal thePrimoSal) {
			Session currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(thePrimoSal);
	}
	
	@Override
	public PrimoSal getPrimoSal(Intervento intervento) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<PrimoSal> theQuery = 
					currentSession.createQuery("from PrimoSal where idIntervento=:idIntervento", PrimoSal.class);
			PrimoSal primoSal = theQuery.uniqueResult();
			if(primoSal==null) {
				primoSal = new PrimoSal();
				primoSal.setIntervento(intervento);
			}
					return primoSal;
	}
	@Override
	public void deletePrimoSal(int theIdPrimoSal) {
	
		Session currentSession = sessionFactory.getCurrentSession();
			Query theQuery = 
					currentSession.createQuery("delete from PrimoSal where idPrimoSal=:idPrimoSal");
					theQuery.setParameter("idPrimoSal", theIdPrimoSal);
					theQuery.executeUpdate();		
	}

}
