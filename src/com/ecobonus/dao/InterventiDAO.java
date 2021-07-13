package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.Intervento;

public interface InterventiDAO {
	public List<Intervento> getList();
	public void saveIntervento(Intervento theIntervento);
	public Intervento getIntervento(int theIdIntervento);
	public void deleteIntervento(int theIdIntervento);
}
