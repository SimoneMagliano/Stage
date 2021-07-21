package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecobonus.entity.FineLavoro;
import com.ecobonus.entity.Intervento;

@Repository
public class FineLavoriDAOImpl implements FineLavoriDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	public List<FineLavoro> getList() {
		Session currentSession = sessionFactory.getCurrentSession();
			Query<FineLavoro> theQuery = 
					currentSession.createQuery("from FineLavoro order by idFineLavori", FineLavoro.class);
					List<FineLavoro> fineLavoro = theQuery.getResultList();	
				return fineLavoro;
	}
	
	@Override
	public void saveFineLavoro(FineLavoro theFineLavoro) {
			Session currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(theFineLavoro);
	}
	
	@Override
	public FineLavoro getFineLavoro(Intervento intervento) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<FineLavoro> theQuery = 
					currentSession.createQuery("from FineLavoro where idIntervento=:idIntervento", FineLavoro.class);
			FineLavoro fineLavoro = theQuery.uniqueResult();
			if(fineLavoro==null) {
				fineLavoro = new FineLavoro();
				fineLavoro.setIntervento(intervento);
			}
					return fineLavoro;
	}
	@Override
	public void deleteFineLavoro(int theIdFineLavori) {
	
		Session currentSession = sessionFactory.getCurrentSession();
			Query theQuery = 
					currentSession.createQuery("delete from FineLavoro where idFineLavori=:idFineLavori");
					theQuery.setParameter("idFineLavori", theIdFineLavori);
					theQuery.executeUpdate();		
	}

}
