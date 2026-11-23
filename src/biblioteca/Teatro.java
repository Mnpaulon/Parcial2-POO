package biblioteca;

// Teatro hereda de Libro
public class Teatro extends Libro {

	private int cantidadActos; // variable de instancia primitiva

	// CONSTRUCTORES (sobrecarga): con super llamo al constructor de Libro
	public Teatro(String nombre, String editorial, int anio, Autor autor, int cantidadActos) {
		super(nombre, "teatro", editorial, anio, autor);
		this.cantidadActos = cantidadActos;
	}

	public Teatro(String nombre, Autor autor, int cantidadActos) {
		super(nombre, "teatro", autor);
		this.cantidadActos = cantidadActos;
	}

	public int getCantidadActos() {
		return cantidadActos;
	}

	public void setCantidadActos(int cantidadActos) {
		this.cantidadActos = cantidadActos;
	}

	@Override
	public String toString() {
		return super.toString() + ", Cantidad de Actos = " + cantidadActos;
	}

}
