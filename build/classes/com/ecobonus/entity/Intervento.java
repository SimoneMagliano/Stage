package com.ecobonus.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("session")
@Table(name = "interventi")
public class Intervento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIntervento")
    private int idIntervento;
    
    @Column(name = "Descrizione")
    private String descrizione;
    
    @Column(name = "Referente")
    private String referente;

    @Column(name = "Contatto")
    private String contatto;
    
    @Column(name = "Cliente")
    private String cliente;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idInizioLavori")
    private InizioLavoro inizioLavoro;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idFineLavori")
    private FineLavoro fineLavoro;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idPrimoSal")
    private PrimoSal primoSal;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idSecondoSal")
    private SecondoSal secondoSal;
    
	@ManyToOne
    @JoinColumn(name="IdRegione")
    private Regione regione;
	
	@ManyToOne
    @JoinColumn(name="CodTipoIntervento")
    private TipoIntervento tipoIntervento;
	
	@ManyToOne
    @JoinColumn(name="CodiceSede")
    private Sede sede;
	
	@Override
	public String toString() {
		return "Intervento [idIntervento=" + idIntervento + ", descrizione=" + descrizione + ", referente=" + referente
				+ ", contatto=" + contatto + ", cliente=" + cliente + ", inizioLavoro=" + inizioLavoro + ", fineLavoro="
				+ fineLavoro + ", regione=" + regione + ", tipoIntervento=" + tipoIntervento + ", sede=" + sede + "]";
	}

	public Intervento() {
		super();
	}

	public int getIdIntervento() {
		return idIntervento;
	}

	public void setIdIntervento(int idIntervento) {
		this.idIntervento = idIntervento;
	}

	public TipoIntervento getTipoIntervento() {
		return tipoIntervento;
	}

	public void setTipoIntervento(TipoIntervento tipoIntervento) {
		this.tipoIntervento = tipoIntervento;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getReferente() {
		return referente;
	}

	public void setReferente(String referente) {
		this.referente = referente;
	}

	public String getContatto() {
		return contatto;
	}

	public void setContatto(String contatto) {
		this.contatto = contatto;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

	public InizioLavoro getInizioLavoro() {
		return inizioLavoro;
	}

	public void setInizioLavoro(InizioLavoro inizioLavoro) {
		this.inizioLavoro = inizioLavoro;
	}

	public FineLavoro getFineLavoro() {
		return fineLavoro;
	}

	public void setFineLavoro(FineLavoro fineLavoro) {
		this.fineLavoro = fineLavoro;
	}

	public PrimoSal getPrimoSal() {
		return primoSal;
	}

	public void setPrimoSal(PrimoSal primoSal) {
		this.primoSal = primoSal;
	}

	public SecondoSal getSecondoSal() {
		return secondoSal;
	}

	public void setSecondoSal(SecondoSal secondoSal) {
		this.secondoSal = secondoSal;
	}


}
