package biblioteca;

// Poesia hereda de Libro
public class Poesia extends Libro {

	private String estilo; // variable de instancia de referencia

	// CONSTRUCTORES (sobrecarga): con super llamo al constructor de Libro
	public Poesia(String nombre, String editorial, int anio, Autor autor, String estilo) {
		super(nombre, "poesia", editorial, anio, autor);
		this.estilo = estilo;
	}

	public Poesia(String nombre, Autor autor, String estilo) {
		super(nombre, "poesia", autor);
		this.estilo = estilo;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return super.toString() + ", Estilo = " + estilo;
	}

}
