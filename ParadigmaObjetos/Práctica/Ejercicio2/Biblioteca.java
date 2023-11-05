package ParadigmaObjetos.Práctica.Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Socio> socios = new ArrayList();
    private List<Libro> libros = new ArrayList();

    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Socio> getSociosConMasDeTresLibros() {
        return socios.stream()
            .filter(socio -> socio.getNumeroLibrosPrestados() > 3)
            .collect(Collectors.toList());
    }
}
