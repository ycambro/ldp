package ParadigmaObjetos.Práctica.Ejercicio1;

import java.util.ArrayList;
import java.util.List;


public class Documento {
    private List<Hoja> hojas = new ArrayList<>();

    public void agregarHoja(Hoja hoja) {
        hojas.add(hoja);
    }

    public List<Hoja> getHojas() {
        return hojas;
    }
}
