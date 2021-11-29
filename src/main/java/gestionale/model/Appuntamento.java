package gestionale.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Appuntamento {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Cliente cliente;
	private LocalDate orario;
	private LocalDate appuntamento;
}
