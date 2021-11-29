package gestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gestionale.model.Fattura;

@Repository
public interface FatturaRepository extends JpaRepository<Fattura, Integer> {

	List<Fattura> findByCliente(String nome);

	@Query("SELECT u From Fattura u WHERE u.cliente.nome =:nomeValore")
	List<Fattura> findByNome(String nomeValore);

	@Query("SELECT u From Fattura u WHERE u.cliente.cognome =:nomeValore")
	List<Fattura> findByCognome(String nomeValore);

	@Query("SELECT u From Fattura u WHERE u.cliente.codiceFiscale =:nomeValore")
	List<Fattura> findByCodiceFiscale(String nomeValore);

	Fattura findByNumeroFattura(Integer numeroFattura);

	List<Fattura> findByDataFattura(String dataDafattura);

}
