package com.ecobonus.dao;

import java.util.List;

import com.ecobonus.entity.Sede;

public interface SediDAO {
	public List<Sede> getSedi();
	public void saveSede(Sede theSede);
	public Sede getSede(Sede theCodSede);
	public void deleteSede(String theCodSede);
	Sede getSede(String Sede);
}
