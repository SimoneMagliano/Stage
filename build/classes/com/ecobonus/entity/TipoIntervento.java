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
@Table(name="tipiinterventi")
public class TipoIntervento {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodiceTipoIntervento")
	private String codiceTipoIntervento;
	
	@OneToMany(mappedBy = "tipoIntervento")
	 private Set<Intervento> tipoIntervento;
	
	public Set<Intervento> getIntervento() {
		return tipoIntervento;
	}

	@Column(name = "Descrizione")
	String descrizione;

	public TipoIntervento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodiceTipoIntervento() {
		return codiceTipoIntervento;
	}

	public void setCodiceTipoIntervento(String codiceTipoIntervento) {
		this.codiceTipoIntervento = codiceTipoIntervento;
	}

	public Set<Intervento> getTipoIntervento() {
		return tipoIntervento;
	}

	public void setTipoIntervento(Set<Intervento> tipoIntervento) {
		this.tipoIntervento = tipoIntervento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@Override
	public String toString() {
		return "TipoIntervento [codiceTipoIntervento=" + codiceTipoIntervento + ", tipoIntervento=" + tipoIntervento
				+ ", descrizione=" + descrizione + "]";
	}
}
