package bibliotecaTest;

import java.time.LocalDate;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Lector;
import biblioteca.Novela;
import biblioteca.Poesia;
import biblioteca.Teatro;

public class BibliotecaTest {

	public static void main(String[] args) {

		// todas las variables del main son variables locales de referencia (apuntan a objetos)

		// AUTORES
		Autor sabato = new Autor("Ernesto Sabato", "Argentina", LocalDate.of(1911, 6, 24));
		Autor lorca = new Autor("Federico Garcia Lorca", "Espaniola", LocalDate.of(1898, 6, 5));
		Autor storni = new Autor(); // constructor vacio, cargo los datos con los setters
		storni.setNombre("Alfonsina Storni");
		storni.setNacionalidad("Argentina");
		storni.setFechaNacimiento(LocalDate.of(1892, 5, 29));

		// LIBROS (cada subclase hereda de Libro)
		Novela tunel = new Novela("El tunel", "Sur", 1948, sabato, "psicologica");
		Teatro bodas = new Teatro("Bodas de sangre", lorca, 3);
		Poesia ocre = new Poesia("Ocre", "Babel", 1925, storni, "soneto");

		System.out.println("--- LIBROS ---");
		System.out.println(tunel);
		System.out.println(bodas);
		System.out.println(ocre);

		// BIBLIOTECA Y COPIAS
		Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");
		biblioteca.agregarCopia(1, tunel);
		biblioteca.agregarCopia(tunel); // sin id, toma el 2
		biblioteca.agregarCopia(bodas);
		biblioteca.agregarCopia(ocre);

		// LECTORES
		Lector ana = new Lector("Ana Perez", 30111222);
		Lector juan = new Lector("Juan Gomez", 28999000);
		biblioteca.registrarLector(ana);
		biblioteca.registrarLector(juan);

		System.out.println("\n--- BIBLIOTECA ---");
		System.out.println(biblioteca);
		biblioteca.mostrarCopias();

		// PRESTAMOS
		System.out.println("\n--- PRESTAMOS ---");
		biblioteca.prestar(ana, 1);
		biblioteca.prestar(ana, 3);
		biblioteca.prestar(ana, 4);
		biblioteca.prestar(ana, 2); // ya tiene 3, no puede
		biblioteca.prestar(juan, 1); // la copia 1 ya esta prestada
		biblioteca.prestar(juan, 2);

		// DEVOLUCIONES
		System.out.println("\n--- DEVOLUCIONES ---");
		biblioteca.devolver(ana, 1);
		biblioteca.devolver(juan, 3); // juan no tiene la copia 3

		System.out.println("\n--- ESTADO FINAL ---");
		biblioteca.mostrarCopias();
		biblioteca.mostrarLectores();
	}

}
