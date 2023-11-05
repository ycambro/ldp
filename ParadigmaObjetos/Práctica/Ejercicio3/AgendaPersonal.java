package ParadigmaObjetos.Práctica.Ejercicio3;

import java.util.ArrayList;

public class AgendaPersonal implements Agenda{
    private final ArrayList<Object> contactosYEventos;

    public AgendaPersonal() {
        contactosYEventos = new ArrayList<>();
    }

    public void agregarElemento(Object elemento) {
        contactosYEventos.add(elemento);
    }

    public void eliminarElemento(Object elemento) {
        contactosYEventos.remove(elemento);
    }

    public void modificarElemento(int indice, Object nuevoElemento) {
        contactosYEventos.set(indice, nuevoElemento);
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object objeto : contactosYEventos) {
            result.append(objeto.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String mostrarElementos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarElementos'");
    }
}
