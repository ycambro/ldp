package ParadigmaObjetos.EjercicioAgenda;

public class Main {

    public static void main(String[] args) {
        Agenda agenda1 = new Agenda();
        Agenda agenda2 = new Agenda();

        ContactoEmpresarial contactoEmp1 = new ContactoEmpresarial("Andres Rojas", "Sarchi, Alajuela", "CEO");
        ContactoEmpresarial contactoEmp2 = new ContactoEmpresarial("Karla Salas", "Grecia, Alajuela", "Proyect Manager");
        
        ContactoPersonal contactoPersonal1 = new ContactoPersonal("Sarah Rojas", "San Jose, San Jose", "Familiar");
        ContactoPersonal contactoPersonal2 = new ContactoPersonal("Santiago Rodriguez", "Naranjo, Alajuela", "Amigo");
        
        EventoEmpresarial eventoEmpresarial1 = new EventoEmpresarial("Conferencia", "11/29/2023", "Centro de Conferencias");
        EventoEmpresarial eventoEmpresarial2 = new EventoEmpresarial("Reunion", "12/05/2023", "Sala de Reuniones");
        
        EventoPersonal eventoPersonal1 = new EventoPersonal("Cena familiar", "11/28/2023", "Reunión familiar");
        EventoPersonal eventoPersonal2 = new EventoPersonal("Fiesta con amigos", "12/01/2023", "Celebración vuelve Alejandro");
        
        agenda1.agregarElemento(contactoEmp1);
        agenda1.agregarElemento(contactoPersonal1);
        agenda1.agregarElemento(eventoEmpresarial1);
        agenda1.agregarElemento(eventoPersonal1);
        
        agenda2.agregarElemento(contactoEmp2);
        agenda2.agregarElemento(contactoPersonal2);
        agenda2.agregarElemento(eventoPersonal2);
        agenda2.agregarElemento(eventoEmpresarial2);

        System.out.println("Agenda 1:");
        System.out.println(agenda1);

        System.out.println("Agenda 2:");
        System.out.println(agenda2);

        ContactoPersonal nuevoContactoPersonal = new ContactoPersonal("Pablo Rodriguez", "Alajuela, Alajuela", "Hermano");
        agenda1.modificarElemento(0, nuevoContactoPersonal);

        agenda2.eliminarElemento(eventoPersonal2);

        EventoEmpresarial nuevoEventoEmpresarial = new EventoEmpresarial("Reunion", "12/02/2023", "Sala de reuniones");
        agenda1.agregarElemento(nuevoEventoEmpresarial);

        System.out.println("Agenda 1 (actualizada):");
        System.out.println(agenda1);
        
        System.out.println("Agenda 2 (actualizada):");
        System.out.println(agenda2);
    }
}
