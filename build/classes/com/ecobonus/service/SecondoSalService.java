package com.ecobonus.service;

import java.util.List;


import com.ecobonus.entity.SecondoSal;

public interface SecondoSalService {
	public List<SecondoSal> getList();
	public void saveSecondoSal(SecondoSal theSecondoSal);
	public SecondoSal getSecondoSal(int theIdSecondoSal);
	public void deleteSecondoSal(int theIdSecondoSal);
}
