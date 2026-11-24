package biblioteca;

public class Libro {

	// ATRIBUTOS
	private String nombre; // variable de instancia de referencia
	private String tipo; // variable de instancia de referencia (novela, teatro o poesia)
	private String editorial; // variable de instancia de referencia
	private int anio; // variable de instancia primitiva
	private Autor autor; // variable de instancia de referencia -> ASOCIACION con Autor

	// CONSTRUCTORES (sobrecarga)
	public Libro(String nombre, String tipo, String editorial, int anio, Autor autor) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.editorial = editorial;
		this.anio = anio;
		this.autor = autor;
	}

	// para cuando no se conoce la editorial ni el anio
	public Libro(String nombre, String tipo, Autor autor) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.editorial = "Desconocida";
		this.autor = autor;
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

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	@Override
	public String toString() {
		return "Nombre:  " + nombre + ", Tipo: " + tipo + ", Editorial: " + editorial + ", Anio:  " + anio
				+ ", Autor: " + autor.getNombre();
	}

}
