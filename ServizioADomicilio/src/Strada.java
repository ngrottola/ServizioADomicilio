
class Strada {
	
	private double costo;
	private Luogo luogo;

	Strada(Luogo luogo, double costo) {
		this.luogo = luogo;
		this.costo = costo;
	}

	double getCosto() {
		return costo;
	}

	Luogo getIncrocio() {
		return luogo;
	}
}
