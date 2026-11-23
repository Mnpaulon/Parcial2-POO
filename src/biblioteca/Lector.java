package biblioteca;

import java.util.ArrayList;

public class Lector {

	// CONSTANTE DE CLASE: es igual para todos los lectores, por eso es static
	// y como no cambia nunca es final
	private static final int MAX_PRESTAMOS = 3; // variable de clase primitiva con la cantidad maxima de libros en prestamo

	// ATRIBUTOS DE LA CLASE LECTOR (encapsulados con private)
	private String nombre; // variable de instancia de referencia que almacena el nombre del lector
	private int dni; // variable de instancia primitiva que almacena el DNI del lector
	private ArrayList<Copia> copiasPrestadas = new ArrayList<>(); // variable de instancia de referencia: clase contenedora con las copias que tiene el lector
	// ASOCIACION Lector - Copia: el lector guarda referencias a las copias que pidio prestadas.
	// Las copias no son del lector (son de la biblioteca): cuando las devuelve, siguen existiendo.

	// SOBRECARGA DE CONSTRUCTORES

	// constructor vacio: crea un lector sin datos, que se pueden cargar despues con los setters
	public Lector() {
	}

	// constructor con nombre y dni
	// nombre es un parametro: variable local de referencia; dni es un parametro: variable local primitiva
	public Lector(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	// METODOS DE INSTANCIA

	// indica si el lector todavia puede pedir otro libro (tiene menos de 3 en prestamo)
	public boolean puedePedirPrestamo() {
		return copiasPrestadas.size() < MAX_PRESTAMOS;
	}

	// pide prestada una copia. Devuelve true si el prestamo se pudo hacer.
	public boolean pedirPrestamo(Copia copia) {
		if (!puedePedirPrestamo()) {
			System.out.println(nombre + " ya tiene " + MAX_PRESTAMOS + " libros en prestamo. No puede pedir otro.");
			return false;
		}
		if (copia.prestar()) { // prestar() devuelve false si la copia ya estaba prestada
			copiasPrestadas.add(copia);
			return true;
		}
		return false;
	}

	// SOBRECARGA DE METODOS: devolverCopia() se puede llamar con la copia o con su identificador

	// devuelve una copia que el lector tiene en prestamo. Devuelve true si se pudo devolver.
	public boolean devolverCopia(Copia copia) {
		if (!copiasPrestadas.contains(copia)) {
			System.out.println(nombre + " no tiene en prestamo la copia indicada.");
			return false;
		}
		copiasPrestadas.remove(copia);
		copia.devolver(); // la copia vuelve a estar en la biblioteca
		return true;
	}

	// devuelve una copia buscandola por su identificador
	// identificador es un parametro: variable local primitiva del metodo
	public boolean devolverCopia(int identificador) {
		for (Copia copia : copiasPrestadas) { // copia es una variable local de referencia del for
			if (copia.getIdentificador() == identificador) {
				return devolverCopia(copia); // llama a la otra version del metodo
			}
		}
		System.out.println(nombre + " no tiene en prestamo la copia " + identificador + ".");
		return false;
	}

	// devuelve cuantos libros tiene el lector en prestamo
	public int getCantidadPrestamos() {
		return copiasPrestadas.size();
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

	// devuelve una COPIA de la lista para que desde afuera no se pueda modificar
	// la lista original sin pasar por pedirPrestamo() y devolverCopia() (encapsulamiento)
	public ArrayList<Copia> getCopiasPrestadas() {
		return new ArrayList<>(copiasPrestadas);
	}

	// SOBREESCRITURA DEL METODO toString()
	// al concatenar la lista se llama al toString() de cada Copia
	@Override
	public String toString() {
		return "Lector [nombre = " + nombre + ", dni = " + dni + ", prestamos = " + copiasPrestadas.size() + "/"
				+ MAX_PRESTAMOS + ", copiasPrestadas = " + copiasPrestadas + "]";
	}

}
