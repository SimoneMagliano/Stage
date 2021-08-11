package com.ecobonus.service;

import java.util.List;

import com.ecobonus.entity.TipoUtente;

public interface TipoUtenteService {
	public List<TipoUtente> getTipiUtente();
	public void saveTipoUtente(TipoUtente theTipoUtente);
	public TipoUtente getTipoUtente(int theIdTipoUtente);
	public void deleteTipoUtente(int theIdTipoUtente);
}
