package gestionale.calcolaData;

public class CodiceAnno {

	// CodiceAnno + CodiceMese + NumeroGiorno = (Risultato) Modulo(7) => Codice Giorno
	//Per calcolare il codice anno basta prendere le ultime due cifre dell anno ad esempio per il 2017 prendiamo il 17 e 
	//dividiamo per 4 prendendo dal risultato solo la parte intera 17/4 = 4 poi aggiungiamo il nostro risultato al 17, 
	//quindi 17+4 = 21 e infine sottraiamo il pi grande multiplo di 7 inferiore alla somma, nel nostro caso 21 -21 = 0.
	//Come vedete 17  un anno particolare, ha codice 0 il che ci semplifica molto i calcoli.
	
	private int codiceAnnoInt;
	private int codiceMeseInt;
	private int numeroGiornoInt;
	
	public CodiceAnno () {};
	
	
	public int codiceAnno (int anno) {
		
		int ultimeDueCifre = anno % 2000;
		ultimeDueCifre = ultimeDueCifre + (ultimeDueCifre / 4);
		int modulo7 = ultimeDueCifre / 7 ;
		modulo7 = modulo7*7;
		anno = ultimeDueCifre - modulo7;
		
		
		return anno ;
	}
	
	public boolean bisestile (int anno) {
		int ultimeDueCifre = anno % 2000;
		boolean tipoAnno = true;
		if (ultimeDueCifre % 4 == 0) {}
			else {
				tipoAnno = false;
			}
		
		return tipoAnno;
		
		
		
		
		
	}
}
