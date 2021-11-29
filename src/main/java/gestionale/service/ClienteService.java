package gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionale.model.Cliente;
import gestionale.repository.ClienteRepository;

@Service
public class ClienteService {

	final String NOME = "Nome";
	final String COGNOME = "Cognome";
	final String CODICE_FISCALE = "Codice Fiscale";
	final String CITTA = "Citta";

	@Autowired
	ClienteRepository clienteRepository;

	public void insertCliente(Cliente cliente) {

		clienteRepository.save(cliente);
	}

	public Cliente getById(Integer id) {
		return clienteRepository.getById(id);
	}

	public void updateCliente(Integer id, Cliente cliente) {
		cliente.setId(id);
		clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {

		return clienteRepository.findAll();
	}

	public void deleteCliente(Integer i) {

		clienteRepository.delete(clienteRepository.getById(i));
	}

	public List<Cliente> find(String campoFiltro, String nomeValore) {
		if (campoFiltro.equals(NOME)) {
			return clienteRepository.findByNome(nomeValore.toUpperCase());
		} else if (campoFiltro.equals(COGNOME)) {
			return clienteRepository.findByCognome(nomeValore.toUpperCase());
		} else if (campoFiltro.equals(CODICE_FISCALE)) {
			return clienteRepository.findByCodiceFiscale(nomeValore.toUpperCase());
		} else if (campoFiltro.equals(CITTA)) {
			return clienteRepository.findByCitta(nomeValore.toUpperCase());
		} else
			return null;
	}
	
	public Cliente findByNomeByCognome (String nome , String cognome) {
		return clienteRepository.findByNomeAndCognome(nome, cognome);
	}

}
