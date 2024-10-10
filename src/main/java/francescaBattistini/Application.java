package francescaBattistini;


import DAO.EventDAO;
import DAO.LocationDAO;
import DAO.PartecipazioneDAO;
import DAO.PersonaDAO;
import entities.*;
import enumes.EventType;
import enumes.GenereType;
import enumes.InStreamingType;
import enumes.SessoType;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Application {
    private static final
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaP4");// ci permette di interaggire con il db
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();// creo istanza che ti permetterà di gestire
        // le operazioni di persistenza, ma finora non hai ancora salvato nulla.
        //ISTANZO I DAO
        //------------>*I DAO sono pattern progettuali utilizzati per gestire l'interazione
        // con il database per specifici tipi di entità.
        // In sostanza, un DAO incapsula tutte le operazioni di accesso ai dati
        // per una determinata entità, consentendo di isolare
        // la logica di persistenza dal resto della tua applicazione.*<------------------------
        EventDAO eventDAO = new EventDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
//--------------------------------------------- operazioni Save----------------------------------------------------
        Location location1 = new Location("Salone Conferenze", "Milano");
        locationDAO.save(location1);

        Persona persona1 = new Persona("Eddy", "Turpo", "edyan7@hotmail.it", LocalDate.of(1990, 04, 01), SessoType.M);
        personaDAO.save(persona1);
        Persona persona2 = new Persona("Arianna", "Loreti", "aryanna@hotmail.it", LocalDate.of(1999, 04, 01), SessoType.F);
        personaDAO.save(persona2);
        Persona persona3 = new Persona("Francesca", "Battistini", "frabba@hotmail.it", LocalDate.of(1991, 04, 01), SessoType.F);
        personaDAO.save(persona3);

        Concerto concerto1 = new Concerto("Milky Chance", LocalDate.now(), "musica indie", EventType.PUBBLICO, 150, location1, GenereType.POP, InStreamingType.TRUE);
        eventDAO.save(concerto1);

//------------------------------------------- GET------------------------------------------------------
        //Questo metodo cerca nel database tutti i concerti che sono attualmente disponibili in streaming.
        //1.eventDAO.getConcertiInStreaming(InStreamingType.TRUE)
        // è un metodo che probabilmente è definito nella classe EventDAO.******
        //2. Il parametro InStreamingType.TRUE suggerisce che il metodo filtra i concerti in base al loro stato di streaming,
        // quindi probabilmente il metodo restituirà solo i concerti che sono in streaming attivo.
        List<Concerto> concertiInStreaming = eventDAO.getConcertiInStreaming(InStreamingType.TRUE);
        System.out.println(concertiInStreaming);
        //PRENDE I CONCERTI PER GENERE
        List<Concerto> concertiPerGenere = eventDAO.getConcertiPerGenere(GenereType.POP);
        System.out.println(concertiPerGenere);
//        if (concerto1.getIn_streaming() == InStreamingType.TRUE) {
//            System.out.println("Il concerto 'Milky Chance' è in streaming.");
//        } else {
//            System.out.println("Il concerto 'Milky Chance' non è in streaming.");
//        }

       // try {
             //Evento laureaDB = eventDAO.findByID(UUID.fromString("6c0882df-551e-4398-9acd-065df73d5d4f"));
             //System.out.println(laureaDB);
       // } catch (NotFoundEx e) {
          //  System.out.println(e.getMessage());
       // }

        /*try {
            eventDAO.delete(UUID.fromString("c1926e8d-f537-4050-a9d1-0ffe23fcabc8"));
        } catch (NotFoundEx e) {
            System.out.println(e.getMessage());
        }*/
//------------------------------------------- SAVE ------------------------------------------------------
        PartitaDiCalcio romaLazio = new PartitaDiCalcio("Serie A", LocalDate.now(), "Derby capitolino", EventType.PUBBLICO, 5000, location1, "Roma", "Lazio", 3, 2);
        // eventDAO.save(romaLazio);
        PartitaDiCalcio lazioRoma = new PartitaDiCalcio("Serie A", LocalDate.now(), "Derby capitolino", EventType.PUBBLICO, 5000, location1, "Lazio", "Roma", 2, 3);
        //eventDAO.save(lazioRoma);
        PartitaDiCalcio romaInter = new PartitaDiCalcio("Roma-Inter", LocalDate.now(), "DAJE ROMA DAJE", EventType.PUBBLICO, 8000, location1, "Roma", "Inter", 1, 1);
        //eventDAO.save(romaInter);
//------------------------------------------- PARTITE VINTE CASA------------------------------------------------------
        List<PartitaDiCalcio> casaVincitore = eventDAO.getPartiteVinteInCasa("Roma");
        System.out.println("Lista casa vincitore: " + casaVincitore);
//------------------------------------------- PARTITE VINTE IN TRASFERTA------------------------------------------------------
        System.out.println("-------------");
        List<PartitaDiCalcio> ospiteVincitore = eventDAO.getPartiteVinteInTrasferta("Lazio");
        ospiteVincitore.forEach(System.out::println);
        System.out.println("-------------");
        //------------------------------------------- GET PAREGGIO------------------------------------------------------
        List<PartitaDiCalcio> partitePareggiate = eventDAO.getPartitePareggiate();
        System.out.println(partitePareggiate);
        System.out.println("-------------");
        //------------------------------------------- lISTA ATLETI------------------------------------------------------
        System.out.println("lista atleti");
        List<Persona> listaAtleti = new ArrayList<>();
        listaAtleti.add(persona1);// popolamento della lista persona
        listaAtleti.add(persona2);
        listaAtleti.add(persona3);
        GaraAtletica olimpiadi = new GaraAtletica("Olimpiadi", LocalDate.now(), "si volaaa", EventType.PUBBLICO, 50, location1, listaAtleti, persona1);
        eventDAO.save(olimpiadi);
        GaraAtletica olimpiadi2 = new GaraAtletica("Olimpiadi2", LocalDate.now(), "si volaaa", EventType.PUBBLICO, 50, location1, listaAtleti, persona1);
        eventDAO.save(olimpiadi2);
        System.out.println(olimpiadi);
        List<GaraAtletica> vincitoriOlimpiadi = eventDAO.getGareDiAtleticaPerVincitore(persona1);
        vincitoriOlimpiadi.forEach(System.out::println);
        System.out.println("------1-------");
        List<GaraAtletica> atletiOlimpiadi = eventDAO.getGareDiAtleticaPerPartecipante(persona2);
        atletiOlimpiadi.forEach(System.out::println);
        System.out.println("-------2------");

        List<Concerto> eventiSoldOut = eventDAO.getEventiSouldOut(150);
        eventiSoldOut.forEach(System.out::println);
        System.out.println("-------3------");

        Partecipazione concertoMilky = new Partecipazione(persona3, concerto1, null);
        partecipazioneDAO.save(concertoMilky);
        System.out.println("-------4------");
        List<Partecipazione> pDaConfermare = partecipazioneDAO.getPartecipazioniDaConfermarePerEvento(concerto1);
        System.out.println(pDaConfermare);
        System.out.println("-------5------");
        em.close();
        emf.close();
    }

}