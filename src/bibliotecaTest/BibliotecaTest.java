package bibliotecaTest;

import java.time.LocalDate;
import java.util.ArrayList;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Copia;
import biblioteca.Lector;
import biblioteca.Libro;
import biblioteca.Novela;
import biblioteca.Poesia;
import biblioteca.Teatro;

public class BibliotecaTest {

	public static void main(String[] args) {

		// Todas las variables declaradas dentro del main son VARIABLES LOCALES:
		// las de tipo objeto (Autor, Novela, Teatro, Poesia, Lector, Biblioteca, Copia) son de REFERENCIA
		// y las de tipo int o boolean son PRIMITIVAS.

		// 1) CREACION DE AUTORES (uso de los 3 constructores sobrecargados)
		System.out.println("=== AUTORES ===");
		Autor sabato = new Autor("Ernesto Sabato", "Argentina", LocalDate.of(1911, 6, 24)); // variable local de referencia
		Autor lorca = new Autor("Federico Garcia Lorca", "Espaniola", 5, 6, 1898); // variable local de referencia
		Autor storni = new Autor(); // constructor vacio: los datos se cargan con los setters
		storni.setNombre("Alfonsina Storni");
		storni.setNacionalidad("Argentina");
		storni.setFechaNacimiento(LocalDate.of(1892, 5, 29));
		System.out.println(sabato);
		System.out.println(lorca);
		System.out.println(storni);

		// 2) CREACION DE LIBROS CON HERENCIA (Novela, Teatro y Poesia extienden de Libro)
		// cada libro tiene ASOCIACION con su Autor
		System.out.println("\n=== LIBROS ===");
		Novela tunel = new Novela("El tunel", "Sur", 1948, sabato, "psicologica"); // constructor completo
		Teatro bodas = new Teatro("Bodas de sangre", lorca, 3); // constructor sobrecargado sin editorial ni anio
		Poesia ocre = new Poesia("Ocre", "Babel", 1925, storni, "soneto");
		System.out.println(tunel);
		System.out.println(bodas);
		System.out.println(ocre);

		// POLIMORFISMO: una variable de tipo Libro puede guardar una Novela, un Teatro o una Poesia,
		// y al llamar a describir() se ejecuta la version sobreescrita de cada subclase
		System.out.println("\n=== HERENCIA Y POLIMORFISMO ===");
		ArrayList<Libro> libros = new ArrayList<>(); // variable local de referencia: lista de la superclase Libro
		libros.add(tunel);
		libros.add(bodas);
		libros.add(ocre);
		for (Libro libro : libros) { // libro es una variable local de referencia del for
			System.out.println(libro.getTipo() + " -> " + libro.describir());
		}

		// 3) CREACION DE LA BIBLIOTECA Y SUS COPIAS (COMPOSICION Biblioteca - Copia)
		System.out.println("\n=== BIBLIOTECA ===");
		Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");
		int idPrimeraCopia = biblioteca.agregarCopia(tunel); // variable local primitiva
		biblioteca.agregarCopia(tunel, 2); // metodo sobrecargado: agrega 2 copias de una vez
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
		System.out.println("Resultado: " + biblioteca.prestar(ana, "El tunel")); // supera el maximo de 3
		System.out.println("Juan pide la copia 1 (ya prestada):");
		System.out.println("Resultado: " + biblioteca.prestar(juan, 1));
		System.out.println("Juan pide 'El tunel': " + biblioteca.prestar(juan, "El tunel"));
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
		System.out.println("Ana pide 'El tunel': " + biblioteca.prestar(ana, "El tunel"));

		// 7) ESTADO FINAL
		System.out.println("\n=== ESTADO FINAL ===");
		System.out.println(biblioteca);
		biblioteca.mostrarCopias();
		biblioteca.mostrarLectores();
	}

}
