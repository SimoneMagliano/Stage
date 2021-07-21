package com.ecobonus.service;

import java.util.List;

import com.ecobonus.entity.Sede;

public interface SediService {
	public List<Sede> getSedi();
	public void saveSede(Sede theSede);
	public Sede getSede(String theCodSede);
	public void deleteSede(String theCodSede);
}
