package com.ecobonus.service;

import java.util.List;

import com.ecobonus.entity.FineLavoro;

public interface FineLavoriService {
	public List<FineLavoro> getList();
	public void saveFineLavoro(FineLavoro theFineLavoro);
	public FineLavoro getFineLavoro(int theIdFineLavori);
	public void deleteFineLavoro(int theIdFineLavori);
}
