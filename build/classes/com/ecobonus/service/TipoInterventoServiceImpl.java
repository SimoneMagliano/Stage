package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.TipoInterventoDAO;
import com.ecobonus.entity.TipoIntervento;

@Service
public class TipoInterventoServiceImpl implements TipoInterventoService {
	@Autowired
	private TipoInterventoDAO tipoInterventoDAO;

	@Override
	@Transactional
	public List<TipoIntervento> getTipiIntervento() {
		
		return tipoInterventoDAO.getTipiIntervento();
	}
	
	@Override
	@Transactional
	public void saveTipoIntervento(TipoIntervento theTipoIntervento) {
		tipoInterventoDAO.saveTipoIntervento(theTipoIntervento);
	}

	@Override
	@Transactional
	public void deleteTipoIntervento(String theCodiceTipoIntervento) {
		tipoInterventoDAO.deleteTipoIntervento(theCodiceTipoIntervento);
	}

	@Override
	@Transactional
	public TipoIntervento getTipoIntervento(String theCodiceTipoIntervento) {
		return tipoInterventoDAO.getTipoIntervento(theCodiceTipoIntervento);
	}
}
