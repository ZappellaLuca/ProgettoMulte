package pattern;


public class Contatore_multa {

	private static volatile Contatore_multa instance = null;
	long numero;
	Contatore_multa() {
		numero=0;
	}

	public static Contatore_multa getInstance() {
		if (instance == null) {
			synchronized (Contatore_multa.class) {
				if (instance == null) {
					instance = new Contatore_multa();
				}
			}
		}
		instance.numero++;
		return instance;
	}

}
