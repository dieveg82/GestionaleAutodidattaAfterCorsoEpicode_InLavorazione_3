package gestionale.calcolaData;

public class CodiceGiorno {

	String[] giornoSettimana1 = { "domenica", "lunedi", "martedi", "mercoledi", "giovedi", "venerdi", "sabato",
			"domenica" };
	int giorno = 0;

	public CodiceGiorno() {
	};

	public CodiceGiorno(int giorno) {

		this.giorno = giorno;
	}

	public int GiornoSettimanaDefaultModel(String giorno) {
		int giornoSettimanaInt = 0;
		switch (giorno) {

		case "lunedi":
			giornoSettimanaInt = 0;
			break;
		case "martedi":
			giornoSettimanaInt = 1;
			break;
		case "mercoledi":
			giornoSettimanaInt = 2;
			break;
		case "giovedi":
			giornoSettimanaInt = 3;
			break;
		case "venerdi":
			giornoSettimanaInt = 4;
			break;
		case "sabato":
			giornoSettimanaInt = 5;
			break;
		case "domenica":
			giornoSettimanaInt = 6;
			break;

		}

		return giornoSettimanaInt;

	}

}