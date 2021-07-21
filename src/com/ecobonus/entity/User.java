package com.ecobonus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("session")
@Table(name = "utenti")
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "IdUtente")
	    private int idUtente;

	    @Column(name = "Nome")
	    private String nome;

	    @Column(name = "Cognome")
	    private String cognome;
	    
	    @Column(name = "RagioneSociale")
	    private String ragioneSociale;
	    
	    @Column(name = "CodFisc_PIva")
	    private String codFiscPIva;

	    @Column(name = "Email")
	    private String email;
	    
	    @Column(name = "Telefono")
	    private String telefono;
	    
	    @Column(name = "Indirizzo")
	    private String indirizzo;
	    
	    @Column(name = "Pec")
	    private String pec;
	 
		@ManyToOne
	    @JoinColumn(name="idTipoUtente")
	    private TipoUtente tipoUtente;

		@ManyToOne
	    @JoinColumn(name="IdRegione")
	    private Regione regione;

		public TipoUtente getTipoUtente() {
			return tipoUtente;
		}

		public void setTipoUtente(TipoUtente tipoUtente) {
			this.tipoUtente = tipoUtente;
		}
		
		public int getIdUtente() {
			return idUtente;
		}

		public void setIdUtente(int idUtente) {
			this.idUtente = idUtente;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		

		public String getCognome() {
			return cognome;
		}


		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	    public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getIndirizzo() {
			return indirizzo;
		}

		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}

		public String getPec() {
			return pec;
		}

		public void setPec(String pec) {
			this.pec = pec;
		}

		@Column(name = "Password")
	    private String password;
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRagioneSociale() {
			return ragioneSociale;
		}

		public void setRagioneSociale(String ragioneSociale) {
			this.ragioneSociale = ragioneSociale;
		}

		public String getCodFiscPIva() {
			return codFiscPIva;
		}

		public void setCodFiscPIva(String codFiscPIva) {
			this.codFiscPIva = codFiscPIva;
		}

		public Regione getRegione() {
			return regione;
		}

		public void setRegione(Regione regione) {
			this.regione = regione;
		}

		@Override
		public String toString() {
			return "User [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email+ "]";
		}

		public User() {
			super();
		}
}
