package com.ecobonus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecobonus.entity.InizioLavoro;
import com.ecobonus.entity.Intervento;

@Repository
public class InizioLavoriDAOImpl implements InizioLavoriDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	public List<InizioLavoro> getList() {
		Session currentSession = sessionFactory.getCurrentSession();
			Query<InizioLavoro> theQuery = 
					currentSession.createQuery("from InizioLavoro order by idInizioLavori", InizioLavoro.class);
					List<InizioLavoro> inizioLavoro = theQuery.getResultList();	
				return inizioLavoro;
	}
	
	@Override
	public void saveInizioLavoro(InizioLavoro theInizioLavoro) {
			Session currentSession = sessionFactory.getCurrentSession();
				currentSession.saveOrUpdate(theInizioLavoro);
	}
	
	@Override
	public InizioLavoro getInizioLavoro(Intervento intervento) {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<InizioLavoro> theQuery = 
					currentSession.createQuery("from InizioLavoro where idIntervento=:idIntervento", InizioLavoro.class);
			InizioLavoro inizioLavoro = theQuery.uniqueResult();
			if(inizioLavoro==null) {
				inizioLavoro = new InizioLavoro();
				inizioLavoro.setIntervento(intervento);
			}
					return inizioLavoro;
	}
	@Override
	public void deleteInizioLavoro(int theIdInizioLavori) {
	
		Session currentSession = sessionFactory.getCurrentSession();
			Query theQuery = 
					currentSession.createQuery("delete from InizioLavoro where idInizioLavori=:idInizioLavori");
					theQuery.setParameter("idInizioLavori", theIdInizioLavori);
					theQuery.executeUpdate();		
	}

}
