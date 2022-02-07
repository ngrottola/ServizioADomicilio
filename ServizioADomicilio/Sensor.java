
class Sensor {
	private String tipo;
	private Boolean stato;

	Sensor(String tipo, boolean stato) {
		this.tipo = tipo;
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Sensor" + tipo + " : " + stato.toString();
	}

	String getTipo() {
		return tipo;
	}

	boolean getStato() {
		return stato;
	}

	boolean isEqual(String type) {
		return type == this.tipo;
	}
}