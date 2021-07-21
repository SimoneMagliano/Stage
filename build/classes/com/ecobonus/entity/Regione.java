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
@Table(name="regioni")
public class Regione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdRegione")
	private int idRegione;
	
	@OneToMany(mappedBy = "regione")
	 private Set<User> users;
	
	public Set<User> getUsers() {
		return users;
	}

	@Column(name = "NomeRegione")
	String nomeRegione;

	public int getIdRegione() {
		return idRegione;
	}

	public void setIdRegione(int idRegione) {
		this.idRegione = idRegione;
	}

	public String getNomeRegione() {
		return nomeRegione;
	}

	public void setNomeRegione(String nomeRegione) {
		this.nomeRegione = nomeRegione;
	}
	

	@Override
	public String toString() {
		return "Regione [idRegione=" + idRegione + ", users=" + users + ", nomeRegione=" + nomeRegione + "]";
	}

	public Regione() {
		super();
	}

}
