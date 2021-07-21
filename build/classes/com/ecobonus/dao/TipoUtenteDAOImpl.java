package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecobonus.entity.TipoUtente;

	@Repository
	public class TipoUtenteDAOImpl implements TipoUtenteDAO{
		@Autowired 
		private SessionFactory sessionFactory;
		
	@Override
	public List<TipoUtente> getTipiUtente() {
		Session currentSession = sessionFactory.getCurrentSession();		
		Query<TipoUtente> theQuery = 
				currentSession.createQuery("from TipoUtente order by IdTipoUtente",
						TipoUtente.class);
		List<TipoUtente> tipoUtente = theQuery.getResultList();	
		return tipoUtente;
	}

	@Override
	public void saveTipoUtente(TipoUtente theTipoUtente) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theTipoUtente);
	}

	@Override
	  public TipoUtente getTipoUtente(int idTipoUtente) {
        Session currentSession = sessionFactory.getCurrentSession();
        TipoUtente tipoUtente = currentSession.get(TipoUtente.class, idTipoUtente);
        return tipoUtente;
    }
	
	@Override
	public void deleteTipoUtente(int idTipoUtente) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from TipoUtente where idTipoUtente=:idTipoUtente");
		theQuery.setParameter("idTipoUtente", idTipoUtente);
		theQuery.executeUpdate();		
	}
}
