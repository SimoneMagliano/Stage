package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.TipoUtente;

public interface TipoUtenteDAO {

		public List<TipoUtente> getTipiUtente();
		public void saveTipoUtente(TipoUtente theTipoUtente);
		public TipoUtente getTipoUtente(int theIdTipoUtente);
		public void deleteTipoUtente(int theIdTipoUtente);
	}

