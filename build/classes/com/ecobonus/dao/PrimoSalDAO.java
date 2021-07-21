package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.Intervento;
import com.ecobonus.entity.PrimoSal;


public interface PrimoSalDAO {
	public List<PrimoSal> getList();
	public void savePrimoSal(PrimoSal primoSal);
	public void deletePrimoSal(int theIdPrimoSal);
	PrimoSal getPrimoSal(Intervento intervento);
}
