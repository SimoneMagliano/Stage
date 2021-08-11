package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.FineLavoriDAO;
import com.ecobonus.dao.InterventiDAO;
import com.ecobonus.entity.FineLavoro;
import com.ecobonus.entity.Intervento;

@Service
public class FineLavoriServiceImpl implements FineLavoriService{


	@Autowired
	private FineLavoriDAO fineLavoriDAO;
	@Autowired
	private InterventiDAO interventiDAO;
	
	@Override
	@Transactional
	public List<FineLavoro> getList() {
		return fineLavoriDAO.getList();
	}

	@Override
	@Transactional
	public FineLavoro getFineLavoro(int idIntervento) {		
		Intervento intervento = interventiDAO.getIntervento(idIntervento);
		return fineLavoriDAO.getFineLavoro(intervento);
	}

	@Override
	@Transactional
	public void saveFineLavoro(FineLavoro fineLavori) {
		fineLavoriDAO.saveFineLavoro(fineLavori);		
	}
	
	@Override
	@Transactional
	public void deleteFineLavoro(int theIdFineLavori) {
		fineLavoriDAO.deleteFineLavoro(theIdFineLavori);		
	}
}
