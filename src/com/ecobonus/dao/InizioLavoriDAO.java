package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.InizioLavoro;
import com.ecobonus.entity.Intervento;



public interface InizioLavoriDAO {
	public List<InizioLavoro> getList();
	public void saveInizioLavoro(InizioLavoro inizioLavoro);
	public InizioLavoro getInizioLavoro(int theIdInizioLavori);
	public void deleteInizioLavoro(int theIdInizioLavori);
	InizioLavoro getInizioLavoro(Intervento intervento);
}
