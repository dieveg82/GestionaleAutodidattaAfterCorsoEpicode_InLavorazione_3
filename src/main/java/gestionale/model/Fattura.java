package gestionale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Fattura {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer numeroFattura;
	private String dataFattura;
	@ManyToOne 
	private Cliente cliente;
	private String trattamento;
	private String trattamento2;
	private String trattamento3;
	private Double imponibile;
	private Double emap;
	private Double bollo;
	private Double totaleFattura;
	private String metodoPagamento;

	public Fattura( String dataFattura, Cliente cliente, String trattamento,
			String trattamento2, String trattamento3, Double imponibile, Double emap, Double bollo,
			Double totaleFattura, String metodoPagamento) {
		this.dataFattura = dataFattura;
		this.cliente = cliente;
		this.trattamento = trattamento;
		this.trattamento2 = trattamento2;
		this.trattamento3 = trattamento3;
		this.imponibile = imponibile;
		this.emap = emap;
		this.bollo = bollo;
		this.totaleFattura = totaleFattura;
		this.metodoPagamento = metodoPagamento;
	}

}
