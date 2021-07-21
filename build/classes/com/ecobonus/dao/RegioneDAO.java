package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.Regione;

public interface RegioneDAO {

	public List<Regione> getRegioni();
	public void saveRegione(Regione theRegione);
	public Regione getRegione(Regione theIdRegione);
	public void deleteRegione(int theIdRegione);
	Regione getRegione(int Regione);
}
