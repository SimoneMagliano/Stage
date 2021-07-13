package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecobonus.entity.TipoIntervento;

@Repository
public class TipoInterventoDAOImpl implements TipoInterventoDAO{
	
		@Autowired 
		private SessionFactory sessionFactory;
		
	@Override
	public List<TipoIntervento> getTipiIntervento() {
		Session currentSession = sessionFactory.getCurrentSession();		
		Query<TipoIntervento> theQuery = 
				currentSession.createQuery("from TipoIntervento order by codiceTipoIntervento",
						TipoIntervento.class);
		List<TipoIntervento> tipoUtente = theQuery.getResultList();	
		return tipoUtente;
	}

	@Override
	public void saveTipoIntervento(TipoIntervento theTipoIntervento) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theTipoIntervento);
	}

	@Override
	  public TipoIntervento getTipoIntervento(String codiceTipoIntervento) {
        Session currentSession = sessionFactory.getCurrentSession();
        TipoIntervento tipoIntervento = currentSession.get(TipoIntervento.class, codiceTipoIntervento);
        return tipoIntervento;
    }
	
	@Override
	public void deleteTipoIntervento(String codiceTipoIntervento) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from TipoIntervento where codiceTipoIntervento=:codiceTipoIntervento");
		theQuery.setParameter("CodiceTipoIntervento", codiceTipoIntervento);
		theQuery.executeUpdate();		
	}
}
