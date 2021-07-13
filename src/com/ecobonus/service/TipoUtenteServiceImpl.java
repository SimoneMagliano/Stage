package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.TipoUtenteDAO;
import com.ecobonus.entity.TipoUtente;

@Service
public class TipoUtenteServiceImpl implements TipoUtenteService{

	@Autowired
	private TipoUtenteDAO tipoUtenteDAO;

	@Override
	@Transactional
	public List<TipoUtente> getTipiUtente() {
		
		return tipoUtenteDAO.getTipiUtente();
	}
	
	@Override
	@Transactional
	public void saveTipoUtente(TipoUtente theTipoUtente) {
		tipoUtenteDAO.saveTipoUtente(theTipoUtente);
	}

	@Override
	@Transactional
	public void deleteTipoUtente(int theIdTipoUtente) {
		tipoUtenteDAO.deleteTipoUtente(theIdTipoUtente);
	}

	@Override
	@Transactional
	public TipoUtente getTipoUtente(int theIdTipoUtente) {
		return tipoUtenteDAO.getTipoUtente(theIdTipoUtente);
	}
}
