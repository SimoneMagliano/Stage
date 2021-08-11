package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.RegioneDAO;
import com.ecobonus.entity.Regione;

@Service
public class RegioneServiceImpl implements RegioneService {
	
	@Autowired
	private RegioneDAO regioneDAO;

	@Override
	@Transactional
	public List<Regione> getRegioni() {
		return regioneDAO.getRegioni();
	}
	
	@Override
	@Transactional
	public void saveRegione(Regione theRegione) {
		regioneDAO.saveRegione(theRegione);
	}

	@Override
	@Transactional
	public void deleteRegione(int theIdRegione) {
		regioneDAO.deleteRegione(theIdRegione);
	}

	@Override
	@Transactional
	public Regione getRegione(int theIdRegione) {
		return regioneDAO.getRegione(theIdRegione);
	}
}
