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
@Table(name="tipiutente")
public class TipoUtente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdTipoUtente")
	private int idTipoUtente;
	
	@OneToMany(mappedBy = "tipoUtente")
	 private Set<User> users;
	
	@Column(name = "Descrizione")
	String descrizione;

	public int getIdTipoUtente() {
		return idTipoUtente;
	}

	public void setIdTipoUtente(int idTipoUtente) {
		this.idTipoUtente = idTipoUtente;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return "TipoUtente [idTipoUtente=" + idTipoUtente + ", users=" + users + ", descrizione=" + descrizione + "]";
	}
	
	public TipoUtente() {
		super();
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
}
