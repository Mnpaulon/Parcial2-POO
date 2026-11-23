package biblioteca;

// SUBCLASE de Libro: una Novela ES UN Libro (HERENCIA con extends)
// hereda nombre, tipo, editorial, anio y autor, y agrega su propio atributo: genero
public class Novela extends Libro {

	// ATRIBUTO PROPIO DE LA SUBCLASE
	private String genero; // variable de instancia de referencia que almacena el genero de la novela (policial, romantica, etc.)

	// SOBRECARGA DE CONSTRUCTORES
	// super(...) llama al constructor de la superclase Libro y le pasa el tipo fijo "novela"

	// constructor completo
	public Novela(String nombre, String editorial, int anio, Autor autor, String genero) {
		super(nombre, "novela", editorial, anio, autor);
		this.genero = genero;
	}

	// constructor para cuando no se conocen la editorial ni el anio
	public Novela(String nombre, Autor autor, String genero) {
		super(nombre, "novela", autor);
		this.genero = genero;
	}

	// SOBREESCRITURA DEL METODO describir() heredado de Libro
	@Override
	public String describir() {
		return getNombre() + " es una novela " + genero + ": una historia en prosa narrada por capitulos.";
	}

	// GETTERS Y SETTERS
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	// SOBREESCRITURA DEL METODO toString()
	// super.toString() reutiliza el toString() de Libro y se le agrega el atributo propio
	@Override
	public String toString() {
		return "Novela [genero = " + genero + ", " + super.toString() + "]";
	}

}
