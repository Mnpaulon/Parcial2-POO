package biblioteca;

import java.util.ArrayList;

public class Lector {

	// ATRIBUTOS
	private String nombre; // variable de instancia de referencia
	private int dni; // variable de instancia primitiva
	private ArrayList<Copia> copias = new ArrayList<>(); // variable de instancia de referencia -> copias que tiene prestadas (ASOCIACION)

	// CONSTRUCTORES (sobrecarga)
	public Lector() {
	}

	public Lector(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	// METODOS
	// el lector puede tener como maximo 3 libros prestados
	public void pedirPrestamo(Copia copia) {
		if (copias.size() >= 3) {
			System.out.println(nombre + " ya tiene 3 libros prestados, no puede pedir otro.");
		} else if (copia.isPrestada()) {
			System.out.println("La copia " + copia.getId() + " ya esta prestada.");
		} else {
			copia.prestar();
			copias.add(copia);
			System.out.println(nombre + " se llevo prestada la copia " + copia.getId() + ".");
		}
	}

	public void devolver(Copia copia) {
		if (copias.contains(copia)) {
			copia.devolver();
			copias.remove(copia);
			System.out.println(nombre + " devolvio la copia " + copia.getId() + ".");
		} else {
			System.out.println(nombre + " no tiene la copia " + copia.getId() + ".");
		}
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public ArrayList<Copia> getCopias() {
		return copias;
	}

	// SOBREESCRITURA DEL METODO toString()
	@Override
	public String toString() {
		return "Lector : Nombre = " + nombre + ", DNI = " + dni + ", Libros prestados = " + copias.size();
	}

}
