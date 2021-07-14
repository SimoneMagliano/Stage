package com.ecobonus.service;

import java.util.List;


import com.ecobonus.entity.PrimoSal;

public interface PrimoSalService {
	public List<PrimoSal> getList();
	public void savePrimoSal(PrimoSal thePrimoSal);
	public PrimoSal getPrimoSal(int theIdPrimoSal);
	public void deletePrimoSal(int theIdPrimoSal);
}
