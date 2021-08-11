package com.ecobonus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecobonus.dao.SediDAO;
import com.ecobonus.entity.Sede;

@Service
public class SediServiceImpl implements SediService {
	@Autowired
	private SediDAO sediDAO;

	@Override
	@Transactional
	public List<Sede> getSedi() {
		return sediDAO.getSedi();
	}
	
	@Override
	@Transactional
	public void saveSede(Sede theSede) {
		sediDAO.saveSede(theSede);
	}

	@Override
	@Transactional
	public void deleteSede(String theCodSede) {
		sediDAO.deleteSede(theCodSede);
	}

	@Override
	@Transactional
	public Sede getSede(String codSede) {
		return sediDAO.getSede(codSede);
	}
}
