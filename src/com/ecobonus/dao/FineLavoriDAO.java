package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.FineLavoro;
import com.ecobonus.entity.Intervento;


public interface FineLavoriDAO {
	public List<FineLavoro> getList();
	public void saveFineLavoro(FineLavoro fineLavoro);
	public void deleteFineLavoro(int theIdFineLavori);
	FineLavoro getFineLavoro(Intervento intervento);
}
