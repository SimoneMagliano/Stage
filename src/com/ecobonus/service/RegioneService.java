package com.ecobonus.service;

import java.util.List;

import com.ecobonus.entity.Regione;

public interface RegioneService {
	public List<Regione> getRegioni();
	public void saveRegione(Regione theRegione);
	public Regione getRegione(int theIdRegione);
	public void deleteRegione(int theIdRegione);
}
