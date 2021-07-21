package com.ecobonus.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sedi")
public class Sede {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodSede")
	private String codSede;
	
	@OneToMany(mappedBy = "sede")
	 private Set<Intervento> intervento;
	
	public Set<Intervento> getIntervento() {
		return intervento;
	}

	@Column(name = "Descrizione")
	String descrizione;

	public Sede() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodSede() {
		return codSede;
	}

	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setIntervento(Set<Intervento> intervento) {
		this.intervento = intervento;
	}

	@Override
	public String toString() {
		return "Sede [codSede=" + codSede + ", intervento=" + intervento + ", descrizione=" + descrizione + "]";
	}

}
