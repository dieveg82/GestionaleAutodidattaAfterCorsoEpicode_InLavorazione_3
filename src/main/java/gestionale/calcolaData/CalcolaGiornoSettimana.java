package gestionale.calcolaData;


// Esempi

//	27 aprile 2017
//	17/4 = 4  => 17+4 = 21-21 = 0 CodiceAnno
//	aprile = 5 CodiceMese
//	CodiceAnno + CodiceMese + numeroGiorno = 0+5+27 = 32 Mod(7) = 4 Gioved

public class CalcolaGiornoSettimana {

	CodiceAnno anno ;
	CodiceMese mese;
	CodiceGiorno giorno;
	

	
	public String CalcolaGiornoSettimana (int anno , int mese , int giorno) {
		
		boolean annoBisestile = true;
		int codiceAnnoInt = 0;
		int codiceMeseInt = 0;
		int giornoint = 0 ;
		CodiceAnno aCalcoloData = new CodiceAnno();
		CodiceMese codiceMese = new CodiceMese();
		
		annoBisestile = aCalcoloData.bisestile(anno);
		codiceAnnoInt = aCalcoloData.codiceAnno(anno);
		
		if (annoBisestile == true ) {	codiceMeseInt = codiceMese.codiceMeseBisestile(mese); }
		else { codiceMeseInt = codiceMese.codiceMese(mese) ;}	
		
		this.giorno = new CodiceGiorno(giorno);
		giornoint = this.giorno.giorno;
		
//		CodiceAnno + CodiceMese + numeroGiorno = 0+5+27 = 32 Mod(7) = 4 Gioved
		int codiceGiorno = (codiceAnnoInt + codiceMeseInt + giornoint ) % 7 ;
		String giornoSettimanaString = this.giorno.giornoSettimana1[codiceGiorno];
		return giornoSettimanaString;
			
	};
	
}
