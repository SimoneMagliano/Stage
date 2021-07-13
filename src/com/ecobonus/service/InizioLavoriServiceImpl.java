package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.InizioLavoriDAO;
import com.ecobonus.dao.InterventiDAO;
import com.ecobonus.entity.InizioLavoro;
import com.ecobonus.entity.Intervento;

@Service
public class InizioLavoriServiceImpl implements InizioLavoriService{


	@Autowired
	private InizioLavoriDAO inizioLavoriDAO;
	@Autowired
	private InterventiDAO interventiDAO;
	
	@Override
	@Transactional
	public List<InizioLavoro> getList() {
		return inizioLavoriDAO.getList();
	}

	@Override
	@Transactional
	public InizioLavoro getInizioLavoro(int idIntervento) {		
		Intervento intervento = interventiDAO.getIntervento(idIntervento);
		return inizioLavoriDAO.getInizioLavoro(idIntervento);
	}

	@Override
	@Transactional
	public void saveInizioLavoro(InizioLavoro inizioLavori) {
		inizioLavoriDAO.saveInizioLavoro(inizioLavori);		
	}
	
	@Override
	@Transactional
	public void deleteInizioLavoro(int theIdInizioLavori) {
		inizioLavoriDAO.deleteInizioLavoro(theIdInizioLavori);		
	}
}
