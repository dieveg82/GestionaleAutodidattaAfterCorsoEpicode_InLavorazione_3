package gestionale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Cliente {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cognome;
	private String nome;
	private String codiceFiscale;
	private String via;
	private String numeroCivico;
	private String codicePostale;
	private String citta;
	private String capoluogo;
	
	
	public Cliente(String cognome, String nome, String codiceFiscale, String via, String numeroCivico,
			String codicePostale, String citta, String capoluogo) {
		this.cognome = cognome;
		this.nome = nome;
		this.codiceFiscale = codiceFiscale;
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.codicePostale = codicePostale;
		this.citta = citta;
		this.capoluogo = capoluogo;
	}
	
	

	
	
	

	
}
