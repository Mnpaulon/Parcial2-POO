package biblioteca;

// SUBCLASE de Libro: un libro de Poesia ES UN Libro (HERENCIA con extends)
// hereda nombre, tipo, editorial, anio y autor, y agrega su propio atributo: estilo
public class Poesia extends Libro {

	// ATRIBUTO PROPIO DE LA SUBCLASE
	private String estilo; // variable de instancia de referencia que almacena el estilo de los poemas (soneto, verso libre, etc.)

	// SOBRECARGA DE CONSTRUCTORES
	// super(...) llama al constructor de la superclase Libro y le pasa el tipo fijo "poesia"

	// constructor completo
	public Poesia(String nombre, String editorial, int anio, Autor autor, String estilo) {
		super(nombre, "poesia", editorial, anio, autor);
		this.estilo = estilo;
	}

	// constructor para cuando no se conocen la editorial ni el anio
	public Poesia(String nombre, Autor autor, String estilo) {
		super(nombre, "poesia", autor);
		this.estilo = estilo;
	}

	// SOBREESCRITURA DEL METODO describir() heredado de Libro
	@Override
	public String describir() {
		return getNombre() + " es un libro de poesia de estilo " + estilo + ".";
	}

	// GETTERS Y SETTERS
	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	// SOBREESCRITURA DEL METODO toString()
	// super.toString() reutiliza el toString() de Libro y se le agrega el atributo propio
	@Override
	public String toString() {
		return "Poesia [estilo = " + estilo + ", " + super.toString() + "]";
	}

}
