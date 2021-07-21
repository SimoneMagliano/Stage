package com.ecobonus.service;

import java.util.List;

import com.ecobonus.entity.Intervento;

public interface InterventiService {
	public List<Intervento> getList();
	public void saveIntervento(Intervento theInterventi);
	public Intervento getIntervento(int theIdIntervento);
	public void deleteIntervento(int theIdIntervento);
}
