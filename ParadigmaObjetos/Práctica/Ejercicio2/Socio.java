package ParadigmaObjetos.Práctica.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Socio {
    private int numeroSocio;
    private String nombre;
    private String direccion;
    private List<Prestamo> prestamos = new ArrayList<>();

    public Socio(int numeroSocio, String nombre, String direccion) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public int getNumeroLibrosPrestados() {
        return prestamos.size();
    }

    public void prestarLibro(Libro libro, String fecha) {
        prestamos.add(new Prestamo(libro, fecha));
    }
}
