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
@Table(name="primosal")
public class PrimoSal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPrimoSal")
	private String idPrimoSal;
	
	@OneToOne(mappedBy="primosal", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	 private Intervento intervento;
	
	
	public Intervento getIntervento() {
		return intervento;
	}

	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

	@Column(name = "DataPrimoSal")
	String dataPrimoSal;
	
	@Column(name = "Descrizione")
	String descrizione;


	public PrimoSal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdPrimoSal() {
		return idPrimoSal;
	}

	public void setIdPrimoSal(String idPrimoSal) {
		this.idPrimoSal = idPrimoSal;
	}

	public String getDataPrimoSal() {
		return dataPrimoSal;
	}

	public void setDataPrimoSal(String dataPrimoSal) {
		this.dataPrimoSal = dataPrimoSal;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "PrimoSal [idPrimoSal=" + idPrimoSal + ", intervento=" + intervento + ", dataPrimoSal=" + dataPrimoSal
				+ ", descrizione=" + descrizione + "]";
	}


	
	
}
