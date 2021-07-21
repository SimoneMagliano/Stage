package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.TipoIntervento;

public interface TipoInterventoDAO {
	public List<TipoIntervento> getTipiIntervento();
	public void saveTipoIntervento(TipoIntervento theTipoIntervento);
	public TipoIntervento getTipoIntervento(String theCodiceTipoIntervento);
	public void deleteTipoIntervento(String theCodiceTipoIntervento);
}
