package gestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionale.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente getById(Integer id);
	
	Cliente findByNomeAndCognome (String nome , String cognome);

	List<Cliente> findByNome(String nome);

	List<Cliente> findByCognome(String cognome);

	List<Cliente> findByCodiceFiscale(String codiceFiscale);

	List<Cliente> findByCitta(String citta);



}
