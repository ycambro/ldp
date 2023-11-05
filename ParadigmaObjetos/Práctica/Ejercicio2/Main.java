package ParadigmaObjetos.Práctica.Ejercicio2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Socio socio1 = new Socio(1, "Juan", "Calle A");
        Socio socio2 = new Socio(2, "Maria", "Calle B");

        Libro libro1 = new Libro(101, "El libro 1", "Autor 1");
        Libro libro2 = new Libro(102, "El libro 2", "Autor 2");

        biblioteca.agregarSocio(socio1);
        biblioteca.agregarSocio(socio2);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        socio1.prestarLibro(libro1, "2023-11-06");
        socio1.prestarLibro(libro2, "2023-11-07");

        List<Socio> sociosConMasDeTresLibros = biblioteca.getSociosConMasDeTresLibros();
        for (Socio socio : sociosConMasDeTresLibros) {
            System.out.println(socio.getNombre() + " tiene más de 3 libros prestados.");
        }
    }
}
