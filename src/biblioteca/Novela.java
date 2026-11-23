package biblioteca;

// Novela hereda de Libro
public class Novela extends Libro {

	private String genero; // variable de instancia de referencia

	// CONSTRUCTORES (sobrecarga): con super llamo al constructor de Libro
	public Novela(String nombre, String editorial, int anio, Autor autor, String genero) {
		super(nombre, "novela", editorial, anio, autor);
		this.genero = genero;
	}

	public Novela(String nombre, Autor autor, String genero) {
		super(nombre, "novela", autor);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return super.toString() + ", Genero = " + genero;
	}

}
