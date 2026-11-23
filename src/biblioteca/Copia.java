package biblioteca;

public class Copia {

	// ATRIBUTOS DE LA CLASE COPIA (encapsulados con private)
	private int identificador; // variable de instancia primitiva que almacena el identificador de la copia
	private boolean prestada; // variable de instancia primitiva: true si esta prestada, false si esta en la biblioteca
	private Libro libro; // variable de instancia de referencia a un objeto Libro (vinculo de ASOCIACION)
	// ASOCIACION: la copia conoce el libro del que es copia. El libro existe por su cuenta
	// y puede tener muchas copias distintas.

	// SOBRECARGA DE CONSTRUCTORES
	// Los constructores NO son public: solo se pueden usar desde el paquete biblioteca.
	// Asi la unica que crea copias es la clase Biblioteca (vinculo de COMPOSICION Biblioteca - Copia).

	// constructor que crea una copia nueva, que siempre arranca en la biblioteca
	Copia(int identificador, Libro libro) {
		this(identificador, libro, false); // reutiliza el otro constructor
	}

	// constructor que permite indicar si la copia ya esta prestada
	// identificador y prestada son parametros: variables locales primitivas del constructor
	// libro es un parametro: variable local de referencia del constructor
	Copia(int identificador, Libro libro, boolean prestada) {
		this.identificador = identificador;
		this.libro = libro;
		this.prestada = prestada;
	}

	// METODOS DE INSTANCIA

	// marca la copia como prestada. Devuelve true si se pudo prestar.
	public boolean prestar() {
		if (prestada) {
			System.out.println("La copia " + identificador + " ya esta prestada.");
			return false;
		}
		prestada = true;
		return true;
	}

	// marca la copia como devuelta (vuelve a estar en la biblioteca). Devuelve true si se pudo devolver.
	public boolean devolver() {
		if (!prestada) {
			System.out.println("La copia " + identificador + " ya esta en la biblioteca.");
			return false;
		}
		prestada = false;
		return true;
	}

	// devuelve el estado de la copia como texto
	public String getEstado() {
		if (prestada) {
			return "prestada";
		}
		return "en biblioteca";
	}

	// GETTERS
	// No hay setters de identificador ni de prestada: el identificador no cambia
	// y el estado solo se modifica con prestar() y devolver() (encapsulamiento).
	public int getIdentificador() {
		return identificador;
	}

	public boolean isPrestada() {
		return prestada;
	}

	public Libro getLibro() {
		return libro;
	}

	// SOBREESCRITURA DEL METODO toString()
	// se muestra solo el nombre del libro para que la salida no sea tan larga
	@Override
	public String toString() {
		return "Copia [identificador = " + identificador + ", estado = " + getEstado() + ", libro = "
				+ libro.getNombre() + "]";
	}

}
