package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.Intervento;
import com.ecobonus.entity.SecondoSal;


public interface SecondoSalDAO {
	public List<SecondoSal> getList();
	public void saveSecondoSal(SecondoSal secondoSal);
	public void deleteSecondoSal(int theIdSecondoSal);
	SecondoSal getSecondoSal(Intervento intervento);
}
