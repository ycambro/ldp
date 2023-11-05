package ParadigmaObjetos.Práctica.Ejercicio3;

public class AgendaFactory {
    private static final AgendaFactory instance = new AgendaFactory();

    private AgendaFactory() {
    }

    public static AgendaFactory getInstance() {
        return instance;
    }

    public AgendaEmpresarial createAgenda() {
        return new AgendaEmpresarial();
    }
}

/* Diferencias entre el Singleton Eager y Lazy
 * En el Singleton Eager este se crea en el momento de la carga de la clase y esta disponible en todo momento, garantizando asi
 * que la instancia siempre este lista para ser usada pero puede llevar a un mayor costo de recursos si la instancia no se usa inmediatamente.
 * 
 * En el Singleton Lazy la instancia se crea solo cuando es necesaria lo cual ahorra recursos, sin embargo ocupa una buena sincronizacion
 * para garantizar que se cree una instancia en entornos multihilos.
 * 
 * Aqui se ha utilizado el Singleton Eager porque la creacion de una fábrica de agendas unico es adecuado para el caso en cuestión.
 * La creacion de instancias de agendas es una operacion ligera por lo que no se necesita crear la fabrica solo cuando sea necesario.
 * Por lo cual usar un Singleton Eager es una opcion simple y eficiente en este contexto.
 */