package ParadigmaObjetos.Práctica.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Documento documento = new Documento();
        Hoja hoja = new Hoja();

        Grupo grupo1 = new Grupo();
        grupo1.agregarObjeto(new Circulo());
        grupo1.agregarObjeto(new Rectangulo());

        Grupo grupo2 = new Grupo();
        grupo2.agregarObjeto(new Linea());

        hoja.agregarObjeto(grupo1);
        hoja.agregarObjeto(grupo2);
        hoja.agregarObjeto(new Cuadrado());

        documento.agregarHoja(hoja);
    }
}
