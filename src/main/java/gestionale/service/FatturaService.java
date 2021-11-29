package gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionale.model.Fattura;
import gestionale.repository.FatturaRepository;

@Service
public class FatturaService {

	final String NOME = "Nome";
	final String COGNOME = "Cognome";
	final String CODICE_FISCALE = "Codice fiscale";
	final String NUMERO_FATTURA = "Numero Fattura";
	final String DATA_FATTURA = "Data Fattura";

	@Autowired
	FatturaRepository fatturaRepository;

	public String insertFattura() {
		fatturaRepository.save(new Fattura());
		return "Inserimento effettuato con successo";
	}

	public List<Fattura> findAll() {
		return fatturaRepository.findAll();
	}
	
	public Fattura findByNumeroFattura(Integer numeroFattura) {
		return fatturaRepository.findByNumeroFattura(numeroFattura);
	}

	public void insertFattura(Fattura fattura) {
		fatturaRepository.save(fattura);
	}

	public List<Fattura> find(String campoFiltro, String nomeValore) {
		if (campoFiltro.equals(NOME)) {
			return fatturaRepository.findByNome(nomeValore);
		} else if (campoFiltro.equals(COGNOME)) {
			return fatturaRepository.findByCognome(nomeValore);
		} else if (campoFiltro.equals(CODICE_FISCALE)) {
			return fatturaRepository.findByCodiceFiscale(nomeValore);
		} else if (campoFiltro.equals(NUMERO_FATTURA)) {
//			return fatturaRepository.findByNumeroFattura ();
		} else if (campoFiltro.equals(DATA_FATTURA)) {
//			return fatturaRepository.findByDataFattura ();
		}
		return null;
	}

	public void delete(Fattura fattura) {
		fatturaRepository.delete(fattura);
	}



}
