package biblioteca;

import java.util.ArrayList;

public class Biblioteca {

	// ATRIBUTOS DE LA CLASE BIBLIOTECA (encapsulados con private)
	private String nombre; // variable de instancia de referencia que almacena el nombre de la biblioteca
	private int proximoIdentificador = 1; // variable de instancia primitiva: identificador que se le dara a la proxima copia

	private ArrayList<Copia> copias = new ArrayList<>(); // variable de instancia de referencia: clase contenedora con las copias
	// COMPOSICION Biblioteca - Copia: la biblioteca CREA sus copias adentro (new Copia(...) en agregarCopia).
	// Las copias no existen fuera de la biblioteca: si la biblioteca desaparece, sus copias tambien.

	private ArrayList<Lector> lectores = new ArrayList<>(); // variable de instancia de referencia: clase contenedora con los lectores
	// AGREGACION Biblioteca - Lector: los lectores se crean AFUERA y despues se registran en la biblioteca.
	// Si la biblioteca desaparece, los lectores siguen existiendo.

	// SOBRECARGA DE CONSTRUCTORES

	// constructor que recibe el nombre de la biblioteca
	// nombre es un parametro: variable local de referencia del constructor
	public Biblioteca(String nombre) {
		this.nombre = nombre;
	}

	// constructor sin parametros: le pone un nombre por defecto
	public Biblioteca() {
		this("Biblioteca sin nombre"); // reutiliza el otro constructor
	}

	// METODOS PARA LAS COPIAS (COMPOSICION)
	// SOBRECARGA DE METODOS: agregarCopia() agrega una sola copia o varias de una vez

	// crea una copia nueva del libro y la guarda. Devuelve el identificador asignado.
	public int agregarCopia(Libro libro) {
		Copia copia = new Copia(proximoIdentificador, libro); // copia es una variable local de referencia
		copias.add(copia);
		proximoIdentificador++;
		return copia.getIdentificador();
	}

	// crea varias copias del mismo libro
	// cantidad es un parametro: variable local primitiva del metodo
	public void agregarCopia(Libro libro, int cantidad) {
		for (int i = 0; i < cantidad; i++) { // i es una variable local primitiva del for
			agregarCopia(libro); // llama a la otra version del metodo
		}
	}

	// METODO PARA LOS LECTORES (AGREGACION)

	// registra un lector que ya fue creado afuera. Devuelve true si se pudo registrar.
	public boolean registrarLector(Lector lector) {
		if (lectores.contains(lector)) {
			System.out.println(lector.getNombre() + " ya esta registrado en la biblioteca.");
			return false;
		}
		lectores.add(lector);
		return true;
	}

	// METODOS PRIVADOS DE BUSQUEDA (solo los usa la propia clase)
	// SOBRECARGA DE METODOS: buscarCopia() busca por identificador o por nombre del libro

	// busca una copia por su identificador. Devuelve null si no existe.
	private Copia buscarCopia(int identificador) {
		for (Copia copia : copias) {
			if (copia.getIdentificador() == identificador) {
				return copia;
			}
		}
		return null;
	}

	// busca una copia DISPONIBLE (en biblioteca) del libro con ese nombre. Devuelve null si no hay.
	private Copia buscarCopia(String nombreLibro) {
		for (Copia copia : copias) {
			if (!copia.isPrestada() && copia.getLibro().getNombre().equalsIgnoreCase(nombreLibro)) {
				return copia;
			}
		}
		return null;
	}

	// METODOS DE PRESTAMO
	// SOBRECARGA DE METODOS: prestar() recibe el identificador de la copia o el nombre del libro

	// presta la copia con ese identificador al lector. Devuelve true si se pudo prestar.
	public boolean prestar(Lector lector, int identificador) {
		if (!lectores.contains(lector)) {
			System.out.println(lector.getNombre() + " no esta registrado en la biblioteca.");
			return false;
		}
		Copia copia = buscarCopia(identificador);
		if (copia == null) {
			System.out.println("No existe la copia " + identificador + ".");
			return false;
		}
		return lector.pedirPrestamo(copia); // el lector controla el maximo de 3 prestamos
	}

	// presta al lector cualquier copia disponible del libro con ese nombre
	public boolean prestar(Lector lector, String nombreLibro) {
		Copia copia = buscarCopia(nombreLibro);
		if (copia == null) {
			System.out.println("No hay copias disponibles de " + nombreLibro + ".");
			return false;
		}
		return prestar(lector, copia.getIdentificador()); // llama a la otra version del metodo
	}

	// el lector devuelve la copia con ese identificador. Devuelve true si se pudo devolver.
	public boolean devolver(Lector lector, int identificador) {
		return lector.devolverCopia(identificador);
	}

	// cuenta cuantas copias estan en la biblioteca (no prestadas)
	public int getCantidadCopiasDisponibles() {
		int disponibles = 0; // variable local primitiva
		for (Copia copia : copias) {
			if (!copia.isPrestada()) {
				disponibles++;
			}
		}
		return disponibles;
	}

	// muestra todas las copias por consola (usa el toString() de Copia)
	public void mostrarCopias() {
		System.out.println("Copias de " + nombre + ":");
		for (Copia copia : copias) {
			System.out.println("  " + copia);
		}
	}

	// muestra todos los lectores por consola (usa el toString() de Lector)
	public void mostrarLectores() {
		System.out.println("Lectores de " + nombre + ":");
		for (Lector lector : lectores) {
			System.out.println("  " + lector);
		}
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// devuelven una COPIA de las listas para que desde afuera no se puedan modificar
	// las listas originales (encapsulamiento)
	public ArrayList<Copia> getCopias() {
		return new ArrayList<>(copias);
	}

	public ArrayList<Lector> getLectores() {
		return new ArrayList<>(lectores);
	}

	// SOBREESCRITURA DEL METODO toString()
	@Override
	public String toString() {
		return "Biblioteca [nombre = " + nombre + ", copias = " + copias.size() + ", disponibles = "
				+ getCantidadCopiasDisponibles() + ", lectores = " + lectores.size() + "]";
	}

}
