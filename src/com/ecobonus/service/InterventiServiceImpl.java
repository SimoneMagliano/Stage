package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.InterventiDAO;
import com.ecobonus.entity.Intervento;

@Service
public class InterventiServiceImpl implements InterventiService {

	@Autowired
	private InterventiDAO InterventiDAO;
	
	@Override
	@Transactional
	public List<Intervento> getList() {
		return InterventiDAO.getList();
	}

	@Override
	@Transactional
	public Intervento getIntervento(int theIdIntervento) {		
		return InterventiDAO.getIntervento(theIdIntervento);
	}

	@Override
	@Transactional
	public void saveIntervento(Intervento interventi) {
		InterventiDAO.saveIntervento(interventi);		
	}
	
	@Override
	@Transactional
	public void deleteIntervento(int theIdIntervento) {
		InterventiDAO.deleteIntervento(theIdIntervento);		
	}
}
