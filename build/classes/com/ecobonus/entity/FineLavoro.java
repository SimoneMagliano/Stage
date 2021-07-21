package com.ecobonus.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="finelavori")
public class FineLavoro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFineLavori")
	private String idFineLavori;
	
	@OneToOne(mappedBy="fineLavoro", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	 private Intervento intervento;
	
	
	public Intervento getIntervento() {
		return intervento;
	}

	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

	@Column(name = "DataFine")
	String dataFine;
	
	@Column(name = "Descrizione")
	String descrizione;


	public FineLavoro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdFineLavori() {
		return idFineLavori;
	}

	public void setIdFineLavori(String idFineLavori) {
		this.idFineLavori = idFineLavori;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "FineLavoro [idFineLavori=" + idFineLavori + ", intervento=" + intervento + ", dataFine=" + dataFine
				+ ", descrizione=" + descrizione + "]";
	}

	
}
