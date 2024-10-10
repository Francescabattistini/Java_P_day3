package DAO;

import entities.*;
import enumes.GenereType;
import enumes.InStreamingType;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("L'evento " + event.getTitolo() + " è stato salvato correttamente");
    }

    public Evento findByID(UUID id) {
        Evento found = em.find(Evento.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void delete(UUID id) {
        Evento found = this.findByID(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("l'evento è stato rimosso!");
    }

    public List<Concerto> getConcertiInStreaming(InStreamingType stato) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.in_streaming = :stato", Concerto.class);
        query.setParameter("stato", stato);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereType genere) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere= :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(String squadra) {
        TypedQuery<PartitaDiCalcio> query = em.createQuery(
                "SELECT p FROM PartitaDiCalcio p WHERE p.squadra_di_casa = :squadra AND p.squadra_vincente = :squadra",
                PartitaDiCalcio.class);
        query.setParameter("squadra", squadra);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(String squadra) {
        TypedQuery<PartitaDiCalcio> query = em.createQuery(
                "SELECT p FROM PartitaDiCalcio p WHERE p.squadra_ospite=:squadra AND p.squadra_vincente=:squadra",
                PartitaDiCalcio.class);
        query.setParameter("squadra", squadra);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        TypedQuery<PartitaDiCalcio> query = em.createQuery(
                "SELECT p FROM PartitaDiCalcio p WHERE p.squadra_vincente IS NULL",
                PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<GaraAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
        TypedQuery<GaraAtletica> query = em.createQuery(
                "SELECT g FROM GaraAtletica g WHERE g.vincitore=:vincitore",
                GaraAtletica.class);
        query.setParameter("vincitore", vincitore);
        if (query.getResultList().isEmpty()) {
            throw new NotFoundEx(vincitore);
        }
        return query.getResultList();
    }

    public List<GaraAtletica> getGareDiAtleticaPerPartecipante(Persona atleta) {
        TypedQuery<GaraAtletica> query = em.createQuery(
                "SELECT g FROM GaraAtletica g WHERE :atleta MEMBER OF g.lista_atleti",
                GaraAtletica.class);
        query.setParameter("atleta", atleta);
        if (query.getResultList().isEmpty()) {
            throw new NotFoundEx(atleta);
        }
        return query.getResultList();
    }

    public List<Concerto> getEventiSouldOut(int partecipanti) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.numeroMassimoPartecipanti=:partecipanti",
                Concerto.class);
        query.setParameter("partecipanti", partecipanti);
        if (query.getResultList().isEmpty()) {
            throw new NotFoundEx(partecipanti);
        }
        return query.getResultList();
    }
}
