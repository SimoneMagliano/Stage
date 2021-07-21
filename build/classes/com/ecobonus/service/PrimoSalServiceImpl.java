package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.InterventiDAO;
import com.ecobonus.dao.PrimoSalDAO;

import com.ecobonus.entity.Intervento;
import com.ecobonus.entity.PrimoSal;

@Service
public class PrimoSalServiceImpl implements PrimoSalService{


	@Autowired
	private PrimoSalDAO primoSalDAO;
	@Autowired
	private InterventiDAO interventiDAO;
	
	@Override
	@Transactional
	public List<PrimoSal> getList() {
		return primoSalDAO.getList();
	}

	@Override
	@Transactional
	public PrimoSal getPrimoSal(int idIntervento) {		
		Intervento intervento = interventiDAO.getIntervento(idIntervento);
		return primoSalDAO.getPrimoSal(intervento);
	}

	@Override
	@Transactional
	public void savePrimoSal(PrimoSal primoSal) {
		primoSalDAO.savePrimoSal(primoSal);		
	}
	
	@Override
	@Transactional
	public void deletePrimoSal(int theIdPrimoSal) {
		primoSalDAO.deletePrimoSal(theIdPrimoSal);		
	}
}
