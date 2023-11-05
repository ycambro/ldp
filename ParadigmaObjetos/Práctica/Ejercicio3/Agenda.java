package ParadigmaObjetos.Práctica.Ejercicio3;

public interface Agenda {
    void agregarElemento(Object elemento);
    void eliminarElemento(Object elemento);
    void modificarElemento(int indice, Object nuevoElemento);
    String mostrarElementos();
}