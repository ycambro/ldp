package ParadigmaObjetos.Práctica.Ejercicio1;

import java.util.ArrayList;
import java.util.List;


public class Grupo extends ObjetoGrafico {
    private List<ObjetoGrafico> objetos = new ArrayList<>();

    public void agregarObjeto(ObjetoGrafico objeto) {
        objetos.add(objeto);
    }

    public List<ObjetoGrafico> getObjetos() {
        return objetos;
    } 
}
