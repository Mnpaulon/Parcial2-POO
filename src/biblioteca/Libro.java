package biblioteca;

public class Libro {

	// ATRIBUTOS DE LA CLASE LIBRO (encapsulados con private)
	private String nombre; // variable de instancia de referencia que almacena el nombre del libro
	private String tipo; // variable de instancia de referencia que almacena el tipo de libro (novela, teatro o poesia)
	private String editorial; // variable de instancia de referencia que almacena la editorial del libro
	private int anio; // variable de instancia primitiva que almacena el anio de publicacion del libro
	private Autor autor; // variable de instancia de referencia a un objeto Autor (vinculo de ASOCIACION)
	// ASOCIACION: el libro conoce a su autor, pero el autor se crea afuera y existe por su cuenta.
	// Si el libro deja de existir, el autor sigue existiendo (incluso puede tener otros libros).

	// SOBRECARGA DE CONSTRUCTORES

	// constructor completo: recibe todos los datos del libro y una referencia a un autor ya creado
	public Libro(String nombre, String tipo, String editorial, int anio, Autor autor) {
		this.nombre = nombre;
		asignarTipo(tipo); // valida que el tipo sea novela, teatro o poesia antes de guardarlo
		this.editorial = editorial;
		this.anio = anio;
		this.autor = autor;
	}

	// constructor para cuando no se conocen la editorial ni el anio
	public Libro(String nombre, String tipo, Autor autor) {
		this(nombre, tipo, "Desconocida", 0, autor); // reutiliza el constructor completo
	}

	// METODO PRIVADO DE AYUDA: solo lo usa la propia clase (encapsulamiento)
	// lo usan el constructor y el setter, asi la validacion se escribe una sola vez
	// tipo es un parametro: variable local de referencia del metodo
	private void asignarTipo(String tipo) {
		if (tipo != null && (tipo.equalsIgnoreCase("novela") || tipo.equalsIgnoreCase("teatro")
				|| tipo.equalsIgnoreCase("poesia"))) {
			this.tipo = tipo.toLowerCase();
		} else {
			System.out.println("Tipo de libro invalido: " + tipo + ". Debe ser novela, teatro o poesia.");
		}
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	// el setter valida el dato antes de guardarlo: solo acepta novela, teatro o poesia
	public void setTipo(String tipo) {
		asignarTipo(tipo);
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
