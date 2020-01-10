package it.jac.javadb.esercitazione.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Multe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome", length = 45)
	private String nome;

	@Column(name = "cognome", length = 45)
	private String cognome;

	@Column(name = "targa", length = 45)
	private String targa;

	@Column(name = "idvarco")
	private int idvarco;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}


	public int getIdVarco() {
		return idvarco;
	}

	public void setIdVarco(int idvarco) {
		this.idvarco = idvarco;
	}
	
/*
	@Override
	public String toString() {
		return "Documento [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", targa=" + targa
				+ ", idVarco=" + idvarco  + "]";
	}
*/
}
