package biblioteca;

import java.time.LocalDate;

public class Autor {

	// ATRIBUTOS
	private String nombre; // variable de instancia de referencia
	private String nacionalidad; // variable de instancia de referencia
	private LocalDate fechaNacimiento; // variable de instancia de referencia

	// CONSTRUCTORES (sobrecarga)
	public Autor() {
	}

	// los parametros son variables locales de referencia
	public Autor(String nombre, String nacionalidad, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
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
		return "Autor : Nombre = " + nombre + ", Nacionalidad = " + nacionalidad + ", Fecha de Nacimiento = "
				+ fechaNacimiento ;
	}

}
