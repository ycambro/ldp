package ParadigmaObjetos.Práctica.Ejercicio2;

public class Prestamo {
    private Libro libro;
    private String fecha;

    public Prestamo(Libro libro, String fecha) {
        this.libro = libro;
        this.fecha = fecha;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getFecha() {
        return fecha;
    }
}
