package biblioteca;

// SUBCLASE de Libro: una obra de Teatro ES UN Libro (HERENCIA con extends)
// hereda nombre, tipo, editorial, anio y autor, y agrega su propio atributo: cantidadActos
public class Teatro extends Libro {

	// ATRIBUTO PROPIO DE LA SUBCLASE
	private int cantidadActos; // variable de instancia primitiva que almacena la cantidad de actos de la obra

	// SOBRECARGA DE CONSTRUCTORES
	// super(...) llama al constructor de la superclase Libro y le pasa el tipo fijo "teatro"

	// constructor completo
	public Teatro(String nombre, String editorial, int anio, Autor autor, int cantidadActos) {
		super(nombre, "teatro", editorial, anio, autor);
		this.cantidadActos = cantidadActos;
	}

	// constructor para cuando no se conocen la editorial ni el anio
	public Teatro(String nombre, Autor autor, int cantidadActos) {
		super(nombre, "teatro", autor);
		this.cantidadActos = cantidadActos;
	}

	// SOBREESCRITURA DEL METODO describir() heredado de Libro
	@Override
	public String describir() {
		return getNombre() + " es una obra de teatro en " + cantidadActos + " actos, escrita para ser representada.";
	}

	// GETTERS Y SETTERS
	public int getCantidadActos() {
		return cantidadActos;
	}

	public void setCantidadActos(int cantidadActos) {
		this.cantidadActos = cantidadActos;
	}

	// SOBREESCRITURA DEL METODO toString()
	// super.toString() reutiliza el toString() de Libro y se le agrega el atributo propio
	@Override
	public String toString() {
		return "Teatro [cantidadActos = " + cantidadActos + ", " + super.toString() + "]";
	}

}
