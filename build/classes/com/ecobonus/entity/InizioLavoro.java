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
@Table(name="iniziolavori")
public class InizioLavoro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInizioLavori")
	private String idInizioLavori;
	
	@OneToOne(mappedBy="inizioLavoro", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	 private Intervento intervento;
	
	
	public Intervento getIntervento() {
		return intervento;
	}

	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

	@Column(name = "DataInizio")
	String dataInizio;
	
	@Column(name = "Descrizione")
	String descrizione;

	public InizioLavoro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdInizioLavori() {
		return idInizioLavori;
	}

	public void setIdInizioLavori(String idInizioLavori) {
		this.idInizioLavori = idInizioLavori;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "InizioLavoro [idInizioLavori=" + idInizioLavori + ", intervento=" + intervento + ", dataInizio="
				+ dataInizio + ", descrizione=" + descrizione + "]";
	}
	
}
