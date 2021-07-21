package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecobonus.entity.Regione;

@Repository
public class RegioneDAOImpl implements RegioneDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<Regione> getRegioni() {	
		Session currentSession = sessionFactory.getCurrentSession();		
		Query<Regione> theQuery = 
				currentSession.createQuery("from Regione order by idRegione",
						Regione.class);
		List<Regione> regione = theQuery.getResultList();	
		return regione;
	}

	@Override
	public void saveRegione(Regione theRegione) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theRegione);
	}

	@Override
	  public Regione getRegione(int idRegione) {
        Session currentSession = sessionFactory.getCurrentSession();
        Regione regione = currentSession.get(Regione.class, idRegione);
        return regione;
    }
	
	@Override
	public void deleteRegione(int idRegione) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Regione where idRegione=:idRegione");
		theQuery.setParameter("idRegione", idRegione);
		theQuery.executeUpdate();		
	}

	@Override
	public Regione getRegione(Regione theIdRegione) {
		return null;
	}	
}
