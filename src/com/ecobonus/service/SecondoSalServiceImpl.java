package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.InterventiDAO;
import com.ecobonus.dao.SecondoSalDAO;
import com.ecobonus.entity.Intervento;
import com.ecobonus.entity.SecondoSal;

@Service
public class SecondoSalServiceImpl implements SecondoSalService{


	@Autowired
	private SecondoSalDAO secondoSalDAO;
	@Autowired
	private InterventiDAO interventiDAO;
	
	@Override
	@Transactional
	public List<SecondoSal> getList() {
		return secondoSalDAO.getList();
	}

	@Override
	@Transactional
	public SecondoSal getSecondoSal(int idIntervento) {		
		Intervento intervento = interventiDAO.getIntervento(idIntervento);
		return secondoSalDAO.getSecondoSal(intervento);
	}

	@Override
	@Transactional
	public void saveSecondoSal(SecondoSal secondoSal) {
		secondoSalDAO.saveSecondoSal(secondoSal);		
	}
	
	@Override
	@Transactional
	public void deleteSecondoSal(int theIdSecondoSal) {
		secondoSalDAO.deleteSecondoSal(theIdSecondoSal);		
	}
}
