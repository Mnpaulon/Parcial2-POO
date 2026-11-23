package biblioteca;

public class Copia {

	// ATRIBUTOS
	private int id; // variable de instancia primitiva
	private boolean prestada; // variable de instancia primitiva (true = prestada, false = en la biblioteca)
	private Libro libro; // variable de instancia de referencia -> ASOCIACION con Libro

	// CONSTRUCTOR: la copia empieza estando en la biblioteca
	public Copia(int id, Libro libro) {
		this.id = id;
		this.libro = libro;
		this.prestada = false;
	}

	// METODOS
	public void prestar() {
		prestada = true;
	}

	public void devolver() {
		prestada = false;
	}

	public String getEstado() {
		if (prestada) {
			return "Prestada";
		}
		return "En biblioteca";
	}

	// GETTERS (no hay setters: el estado solo cambia con prestar() y devolver())
	public int getId() {
		return id;
	}

	public boolean isPrestada() {
		return prestada;
	}

	public Libro getLibro() {
		return libro;
	}

	// SOBREESCRITURA DEL METODO toString()
	@Override
	public String toString() {
		return "Copia : Id = " + id + ", Libro = " + libro.getNombre() + ", Estado = " + getEstado();
	}

}
