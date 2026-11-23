package biblioteca;

import java.util.ArrayList;

public class Biblioteca {

	// ATRIBUTOS
	private String nombre; // variable de instancia de referencia
	private ArrayList<Copia> copias = new ArrayList<>(); // variable de instancia de referencia -> COMPOSICION con Copia
	private ArrayList<Lector> lectores = new ArrayList<>(); // variable de instancia de referencia -> AGREGACION con Lector

	// COMPOSICION: las copias se crean adentro de la biblioteca (new Copia en agregarCopia),
	// si la biblioteca no existe, las copias tampoco.
	// AGREGACION: los lectores se crean afuera y despues se registran,
	// si la biblioteca no existe, los lectores siguen existiendo.

	// CONSTRUCTORES (sobrecarga)
	public Biblioteca() {
	}

	public Biblioteca(String nombre) {
		this.nombre = nombre;
	}

	// METODOS (sobrecarga de agregarCopia)
	public void agregarCopia(int id, Libro libro) {
		Copia copia = new Copia(id, libro); // variable local de referencia
		copias.add(copia);
	}

	// si no se pasa el id, se usa el siguiente numero
	public void agregarCopia(Libro libro) {
		int id = copias.size() + 1; // variable local primitiva
		agregarCopia(id, libro);
	}

	public void registrarLector(Lector lector) {
		lectores.add(lector);
	}

	public Copia buscarCopia(int id) {
		for (Copia copia : copias) {
			if (copia.getId() == id) {
				return copia;
			}
		}
		return null;
	}

	public void prestar(Lector lector, int idCopia) {
		Copia copia = buscarCopia(idCopia);
		if (copia == null) {
			System.out.println("No existe la copia " + idCopia + ".");
		} else {
			lector.pedirPrestamo(copia);
		}
	}

	public void devolver(Lector lector, int idCopia) {
		Copia copia = buscarCopia(idCopia);
		if (copia == null) {
			System.out.println("No existe la copia " + idCopia + ".");
		} else {
			lector.devolver(copia);
		}
	}

	public void mostrarCopias() {
		for (Copia copia : copias) {
			System.out.println(copia);
		}
	}

	public void mostrarLectores() {
		for (Lector lector : lectores) {
			System.out.println(lector);
		}
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Copia> getCopias() {
		return copias;
	}

	public ArrayList<Lector> getLectores() {
		return lectores;
	}

	// SOBREESCRITURA DEL METODO toString()
	@Override
	public String toString() {
		return "Biblioteca : Nombre = " + nombre + ", Copias = " + copias.size() + ", Lectores = " + lectores.size();
	}

}
