package biblioteca;

// SUPERCLASE (clase padre) de Novela, Teatro y Poesia.
// Tiene los atributos y metodos que comparten todos los libros; cada subclase los HEREDA con extends.
public class Libro {

	// ATRIBUTOS DE LA CLASE LIBRO (encapsulados con private)
	// las subclases los heredan, pero acceden a ellos a traves de los getters
	private String nombre; // variable de instancia de referencia que almacena el nombre del libro
	private String tipo; // variable de instancia de referencia que almacena el tipo de libro (novela, teatro o poesia)
	private String editorial; // variable de instancia de referencia que almacena la editorial del libro
	private int anio; // variable de instancia primitiva que almacena el anio de publicacion del libro
	private Autor autor; // variable de instancia de referencia a un objeto Autor (vinculo de ASOCIACION)
	// ASOCIACION: el libro conoce a su autor, pero el autor se crea afuera y existe por su cuenta.
	// Si el libro deja de existir, el autor sigue existiendo (incluso puede tener otros libros).

	// SOBRECARGA DE CONSTRUCTORES
	// Los constructores son protected: solo los pueden usar las subclases (con super(...)).
	// Asi desde afuera no se puede crear un "Libro" suelto: hay que crear una Novela, un Teatro o una Poesia,
	// y el tipo lo fija cada subclase (no puede quedar un tipo invalido).

	// constructor completo: recibe todos los datos del libro y una referencia a un autor ya creado
	protected Libro(String nombre, String tipo, String editorial, int anio, Autor autor) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.editorial = editorial;
		this.anio = anio;
		this.autor = autor;
	}

	// constructor para cuando no se conocen la editorial ni el anio
	protected Libro(String nombre, String tipo, Autor autor) {
		this(nombre, tipo, "Desconocida", 0, autor); // reutiliza el constructor completo
	}

	// METODO QUE LAS SUBCLASES SOBREESCRIBEN (cada tipo de libro se describe distinto)
	public String describir() {
		return nombre + " es un libro.";
	}

	// GETTERS Y SETTERS
	// tipo no tiene setter: lo define la subclase y no puede cambiar (encapsulamiento)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	// SOBREESCRITURA DEL METODO toString()
	// al concatenar autor se llama automaticamente al toString() de la clase Autor
	@Override
	public String toString() {
		return "Libro [nombre = " + nombre + ", tipo = " + tipo + ", editorial = " + editorial + ", anio = " + anio
				+ ", autor = " + autor + "]";
	}

}
