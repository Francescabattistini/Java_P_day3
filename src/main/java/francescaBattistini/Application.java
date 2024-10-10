package francescaBattistini;

import DAO.EventsDAO;
import DAO.LocationsDAO;
import DAO.ParticipationDAO;
import DAO.PersonDAO;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3D4");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO ed = new EventsDAO(em);
        LocationsDAO ld = new LocationsDAO(em);
        ParticipationDAO pd = new ParticipationDAO(em);
        PersonDAO ped = new PersonDAO(em);

        Location Contea = new Location("Contea", "terra di mezzo ");
        ld.save(Contea);
        Location addaToAdd = ld.findById(Contea.getId());

       // Evento HobbitStory = new Evento("lo hobbit", LocalDate.of(2025, 2, 16), " riusciranno ad uccidere smaug", TipoEvento.PUBBLICO, 1000, addaToAdd);
        //ed.save(HobbitStory);
        ;

       /*Person aldo = new Person("Aldo", "Baglio", "aldo.baglio@gmail.com", LocalDate.of(1990, 2, 5),Genere.MASCHIO);
        ped.save(aldo);*/

        /*Participation aldoParticipation = new Participation(ped.findById(UUID.fromString("b10926f8-3d75-4d8f-a7f5-f95c405ced9d")), ed.getEventById(UUID.fromString("3a9fef30-284a-45d8-9e86-69a9ca9c818e")), ParticipationState.CONFERMATA);
        pd.save(aldoParticipation);*/

        System.out.println(pd.findById(UUID.fromString("4b781815-11e5-4fbc-b05a-bdf8840b3126")).getPerson());

        em.close();
        emf.close();
    }
}