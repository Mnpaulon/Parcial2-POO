package biblioteca;

import java.time.LocalDate;

public class Autor {

	// ATRIBUTOS DE LA CLASE AUTOR (encapsulados con private)
	private String nombre; // variable de instancia de referencia que almacena el nombre del autor
	private String nacionalidad; // variable de instancia de referencia que almacena la nacionalidad del autor
	private LocalDate fechaNacimiento; // variable de instancia de referencia que almacena la fecha de nacimiento del autor

	// SOBRECARGA DE CONSTRUCTORES

	// constructor vacio: crea un autor sin datos, que se pueden cargar despues con los setters
	public Autor() {
	}

	// constructor que recibe la fecha de nacimiento como un objeto LocalDate
	// nombre, nacionalidad y fechaNacimiento son parametros: variables locales de referencia del constructor
	public Autor(String nombre, String nacionalidad, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}

	// constructor que recibe la fecha de nacimiento como dia, mes y anio
	// dia, mes y anio son parametros: variables locales primitivas del constructor
	public Autor(String nombre, String nacionalidad, int dia, int mes, int anio) {
		this(nombre, nacionalidad, LocalDate.of(anio, mes, dia)); // reutiliza el constructor anterior
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	// SOBREESCRITURA DEL METODO toString()
	@Override
	public String toString() {
		return "Autor [nombre = " + nombre + ", nacionalidad = " + nacionalidad + ", fechaNacimiento = "
				+ fechaNacimiento + "]";
	}

}
