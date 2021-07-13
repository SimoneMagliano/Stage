package com.ecobonus.service;

import java.util.List;

import com.ecobonus.entity.InizioLavoro;

public interface InizioLavoriService {
	public List<InizioLavoro> getList();
	public void saveInizioLavoro(InizioLavoro theInizioLavoro);
	public InizioLavoro getInizioLavoro(int theIdInizioLavori);
	public void deleteInizioLavoro(int theIdInizioLavori);
}
