package bibliotecaTest;

import java.time.LocalDate;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Copia;
import biblioteca.Lector;
import biblioteca.Libro;

public class BibliotecaTest {

	public static void main(String[] args) {

		// Todas las variables declaradas dentro del main son VARIABLES LOCALES:
		// las de tipo objeto (Autor, Libro, Lector, Biblioteca, Copia) son de REFERENCIA
		// y las de tipo int o boolean son PRIMITIVAS.

		// 1) CREACION DE AUTORES (uso de los 3 constructores sobrecargados)
		System.out.println("=== AUTORES ===");
		Autor borges = new Autor("Jorge Luis Borges", "Argentina", LocalDate.of(1899, 8, 24)); // variable local de referencia
		Autor lorca = new Autor("Federico Garcia Lorca", "Espaniola", 5, 6, 1898); // variable local de referencia
		Autor storni = new Autor(); // constructor vacio: los datos se cargan con los setters
		storni.setNombre("Alfonsina Storni");
		storni.setNacionalidad("Argentina");
		storni.setFechaNacimiento(LocalDate.of(1892, 5, 29));
		System.out.println(borges);
		System.out.println(lorca);
		System.out.println(storni);

		// 2) CREACION DE LIBROS (ASOCIACION Libro - Autor)
		System.out.println("\n=== LIBROS ===");
		Libro ficciones = new Libro("Ficciones", "Novela", "Sur", 1944, borges);
		Libro bodas = new Libro("Bodas de sangre", "teatro", "Losada", 1933, lorca);
		Libro ocre = new Libro("Ocre", "poesia", storni); // constructor sobrecargado sin editorial ni anio
		System.out.println(ficciones);
		System.out.println(bodas);
		System.out.println(ocre);
		System.out.println("Prueba de tipo invalido:");
		Libro ensayo = new Libro("Otras inquisiciones", "ensayo", borges); // el tipo no se guarda porque es invalido
		System.out.println(ensayo);

		// 3) CREACION DE LA BIBLIOTECA Y SUS COPIAS (COMPOSICION Biblioteca - Copia)
		System.out.println("\n=== BIBLIOTECA ===");
		Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");
		int idPrimeraCopia = biblioteca.agregarCopia(ficciones); // variable local primitiva
		biblioteca.agregarCopia(ficciones, 2); // metodo sobrecargado: agrega 2 copias de una vez
		biblioteca.agregarCopia(bodas, 2);
		biblioteca.agregarCopia(ocre);
		System.out.println("Identificador de la primera copia: " + idPrimeraCopia);
		System.out.println(biblioteca);
		biblioteca.mostrarCopias();

		// 4) CREACION Y REGISTRO DE LECTORES (AGREGACION Biblioteca - Lector)
		System.out.println("\n=== LECTORES ===");
		Lector ana = new Lector("Ana Perez", 30111222); // el lector se crea AFUERA de la biblioteca
		Lector juan = new Lector();
		juan.setNombre("Juan Gomez");
		juan.setDni(28999000);
		biblioteca.registrarLector(ana); // y despues se registra en la biblioteca
		biblioteca.registrarLector(juan);
		biblioteca.registrarLector(ana); // no se puede registrar dos veces
		biblioteca.mostrarLectores();

		// 5) PRESTAMOS (metodo prestar() sobrecargado)
		System.out.println("\n=== PRESTAMOS ===");
		boolean prestado = biblioteca.prestar(ana, 1); // variable local primitiva: por identificador de copia
		System.out.println("Ana pide la copia 1: " + prestado);
		System.out.println("Ana pide 'Bodas de sangre': " + biblioteca.prestar(ana, "Bodas de sangre")); // por nombre
		System.out.println("Ana pide 'Ocre': " + biblioteca.prestar(ana, "Ocre"));
		System.out.println("Ana pide un 4to libro:");
		System.out.println("Resultado: " + biblioteca.prestar(ana, "Ficciones")); // supera el maximo de 3
		System.out.println("Juan pide la copia 1 (ya prestada):");
		System.out.println("Resultado: " + biblioteca.prestar(juan, 1));
		System.out.println("Juan pide 'Ficciones': " + biblioteca.prestar(juan, "Ficciones"));
		System.out.println("Juan pide 'Ocre' (no quedan copias):");
		System.out.println("Resultado: " + biblioteca.prestar(juan, "Ocre"));
		System.out.println(biblioteca);
		biblioteca.mostrarLectores();

		// 6) DEVOLUCIONES (metodo devolverCopia() sobrecargado en Lector)
		System.out.println("\n=== DEVOLUCIONES ===");
		System.out.println("Ana devuelve la copia 1: " + biblioteca.devolver(ana, 1)); // por identificador
		Copia copiaDeAna = ana.getCopiasPrestadas().get(0); // variable local de referencia
		System.out.println("Ana devuelve " + copiaDeAna + ": " + ana.devolverCopia(copiaDeAna)); // por objeto Copia
		System.out.println("Juan intenta devolver la copia 1 (no la tiene):");
		System.out.println("Resultado: " + biblioteca.devolver(juan, 1));
		System.out.println("Ana ahora puede pedir otro libro: " + ana.puedePedirPrestamo());
		System.out.println("Ana pide 'Ficciones': " + biblioteca.prestar(ana, "Ficciones"));

		// 7) ESTADO FINAL
		System.out.println("\n=== ESTADO FINAL ===");
		System.out.println(biblioteca);
		biblioteca.mostrarCopias();
		biblioteca.mostrarLectores();
	}

}
