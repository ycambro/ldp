package ParadigmaObjetos.EjercicioAgenda.Agenda.src.main.java.com.mycompany.ejercicio1repo;

class ContactoPersonal extends Contacto {
    private String relacion;

    public ContactoPersonal(String nombre, String direccion, String relacion) {
        super(nombre, direccion);
        this.relacion = relacion;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Relación: " + relacion;
    }
}
