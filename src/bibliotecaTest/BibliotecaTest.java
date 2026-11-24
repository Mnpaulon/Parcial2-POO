package bibliotecaTest;

import java.time.LocalDate;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Lector;
import biblioteca.Libro;

public class BibliotecaTest {

	public static void main(String[] args) {

		// todas las variables del main son variables locales de referencia

		// AUTORES
		Autor sabato = new Autor("Ernesto Sabato", "Argentina", LocalDate.of(1911, 6, 24));
		Autor lorca = new Autor("Federico Garcia Lorca", "Espaniola", LocalDate.of(1898, 6, 5));
		Autor cervantes = new Autor("Miguel de Cervantes", "Espaniola", LocalDate.of(1547, 9, 29));
		// // constructor vacio, cargo los datos con los setters para variar en la creacion de objetos
		Autor storni = new Autor(); 
		storni.setNombre("Alfonsina Storni");
		storni.setNacionalidad("Argentina");
		storni.setFechaNacimiento(LocalDate.of(1892, 5, 29));

		// LIBROS (el tipo puede ser novela, teatro o poesia)
		Libro tunel = new Libro("El tunel", "novela", "Sur", 1948, sabato);
		Libro bodas = new Libro("Bodas de sangre", "teatro","Planeta de Libros",1931, lorca);
		Libro quijote = new Libro("Don Quijote de la Mancha", "novela", "Francisco de Robles", 1605, cervantes);
		Libro ocre = new Libro("Ocre", "poesia", "Babel", 1925, storni);

		System.out.println("--- LIBROS ---");
		System.out.println(tunel);
		System.out.println(bodas);
		System.out.println(quijote);
		System.out.println(ocre);

		// BIBLIOTECA Y COPIAS
		Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");
		biblioteca.agregarCopia(1, tunel);
		biblioteca.agregarCopia(tunel); // sin id, toma el 2
		biblioteca.agregarCopia(bodas);
		biblioteca.agregarCopia(quijote);
		biblioteca.agregarCopia(ocre);

		// LECTORES
		Lector ana = new Lector("Ana Perez", 30111222);
		Lector juan = new Lector("Juan Gomez", 28999000);
		Lector maria = new Lector("Maria Lopez", 30555444);
		biblioteca.registrarLector(ana);
		biblioteca.registrarLector(maria);
		biblioteca.registrarLector(juan);

		System.out.println("\n--- BIBLIOTECA ---");
		System.out.println(biblioteca);
		biblioteca.mostrarCopias();

		// PRESTAMOS
		System.out.println("\n--- PRESTAMOS ---");
		biblioteca.prestar(ana, 1);
		biblioteca.prestar(ana, 3);
		biblioteca.prestar(ana, 4);
		biblioteca.prestar(ana, 2); // se valida que ya tiene 3 libros, no puede seguir pidiendo prestados
		biblioteca.prestar(maria, 5);
		biblioteca.prestar(juan, 1); // la copia 1 ya esta prestada a otro lector
		biblioteca.prestar(juan, 2);
		
		System.out.println("\n--- ESTADO DE BIBLIOTECA LUEGO DE PRESTAR LIBROS ---");
		System.out.println(biblioteca);
		biblioteca.mostrarCopias();

		// DEVOLUCIONES
		System.out.println("\n--- DEVOLUCIONES ---");
		biblioteca.devolver(ana, 1);
		biblioteca.devolver(maria, 5);
		biblioteca.devolver(juan, 3); // juan no tiene la copia 3

		System.out.println("\n--- ESTADO FINAL ---");
		biblioteca.mostrarCopias();
		biblioteca.mostrarLectores();
	}

}
