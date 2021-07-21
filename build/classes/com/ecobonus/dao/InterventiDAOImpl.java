package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecobonus.entity.Intervento;

@Repository
public class InterventiDAOImpl implements InterventiDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	public List<Intervento> getList() {
		Session currentSession = sessionFactory.getCurrentSession();
			Query<Intervento> theQuery = 
					currentSession.createQuery("from Intervento order by idIntervento", Intervento.class);
					List<Intervento> intervento = theQuery.getResultList();	
				return intervento;
	}
	
	@Override
	public void saveIntervento(Intervento theIntervento) {
			Session currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(theIntervento);
	}
	
	@Override
	public Intervento getIntervento(int theIdIntervento) {
			Session currentSession = sessionFactory.getCurrentSession();
				Intervento theIntervento = currentSession.get(Intervento.class, theIdIntervento);
					return theIntervento;
	}
	@Override
	public void deleteIntervento(int theIdIntervento) {
	
		Session currentSession = sessionFactory.getCurrentSession();
			Query theQuery = 
					currentSession.createQuery("delete from Intervento where idIntervento=:idIntervento");
					theQuery.setParameter("idIntervento", theIdIntervento);
					theQuery.executeUpdate();		
	} 

}
