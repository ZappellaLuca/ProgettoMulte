package it.jac.javadb.esercitazione.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lista_varchi")
public class Varchi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvarchi")
	private int id;

	@Column(name = "nomevarco", length = 45)
	private String nomevarco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomevarco() {
		return nomevarco;
	}

	public void setNomevarco(String nomevarco) {
		this.nomevarco = nomevarco;
	}

}
