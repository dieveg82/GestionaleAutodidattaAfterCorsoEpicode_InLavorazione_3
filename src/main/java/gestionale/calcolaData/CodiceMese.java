package gestionale.calcolaData;



public class CodiceMese {
	

	public CodiceMese () {};
	
	
	// nota bene essendo un array Gennaio parte da zero , Febbraio 1 , Marzo 2 etc etc
	public int codiceMese (int mese) {
	
		int[] meseArray = { 6 ,2 ,2,5,0,3,5,1,4,6,2,4};
		int codiceMese = meseArray[mese];
	return codiceMese;
	
}
	
	public int codiceMeseBisestile (int mese) {
	
		int[] meseArray = { 5 ,1 ,2,5,0,3,5,1,4,6,2,4};
		int codiceMese = meseArray[mese];
	return  codiceMese;

}
//  i case rappresentano i mesi Gennio 0 , Febbraio 1 , Marzo 2 , sono cos perch la classe calendar passa i numeri
//	del mese dentro un array quindi parte da zero	
	public int numeroGiorniMese (int mese) {
		int giorniMese = 0; 
		switch (mese) {
		
		case 0 :
			giorniMese = 31;
			break;
		case 1 :
			giorniMese = 28;
			break;
		case 2 :
			giorniMese = 31;
			break;
		case 3:
			giorniMese = 30;
			break;
		case 4 :
			giorniMese = 31;
			break;
		case 5 :
			giorniMese = 30;
			break;
		case 6 :
			giorniMese = 31;
			break;
		case 7 :
			giorniMese = 31;
			break;
		case 8 :
			giorniMese = 30;
			break;
		case 9 :
			giorniMese = 31;
			break;
		case 10 :
			giorniMese = 30;
			break;
		case 11 :
			giorniMese = 31;
			break;
				
		
		}
		
		return giorniMese;
	}
	public int numeroGiorniMeseBisestile (int mese) {
		int giorniMese = 0; 
		switch (mese) {
		
		case 0 :
			giorniMese = 31;
			break;
		case 1 :
			giorniMese = 29;
			break;
		case 2 :
			giorniMese = 31;
			break;
		case 3:
			giorniMese = 30;
			break;
		case 4 :
			giorniMese = 31;
			break;
		case 5 :
			giorniMese = 30;
			break;
		case 6 :
			giorniMese = 31;
			break;
		case 7 :
			giorniMese = 31;
			break;
		case 8 :
			giorniMese = 30;
			break;
		case 9 :
			giorniMese = 31;
			break;
		case 10 :
			giorniMese = 30;
			break;
		case 11 :
			giorniMese = 31;
			break;
				
		
		}
		
		return giorniMese;
	}	
	
}
