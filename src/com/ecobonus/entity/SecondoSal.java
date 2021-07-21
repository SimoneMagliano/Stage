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
@Table(name="secondosal")
public class SecondoSal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSecondoSal")
	private String idSecondoSal;
	
	@OneToOne(mappedBy="secondoSal", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	 private Intervento intervento;
	
	
	public Intervento getIntervento() {
		return intervento;
	}

	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

	@Column(name = "DataSecondoSal")
	String dataSecondoSal;
	
	@Column(name = "Descrizione")
	String descrizione;


	public SecondoSal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdSecondoSal() {
		return idSecondoSal;
	}

	public void setIdSecondoSal(String idSecondoSal) {
		this.idSecondoSal = idSecondoSal;
	}

	public String getDataSecondoSal() {
		return dataSecondoSal;
	}

	public void setDataSecondoSal(String dataSecondoSal) {
		this.dataSecondoSal = dataSecondoSal;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "SecondoSal [idSecondoSal=" + idSecondoSal + ", intervento=" + intervento + ", dataSecondoSal="
				+ dataSecondoSal + ", descrizione=" + descrizione + "]";
	}


	
}
