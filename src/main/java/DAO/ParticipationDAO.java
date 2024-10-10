package DAO;

import entities.Participation;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class ParticipationDAO {
    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation participation) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(participation);

        transaction.commit();

        System.out.println("La partecipazione di " + participation.getPerson().getSurname() + " è stata aggiunta con successo!");
    }

    public Participation findById(UUID participationId) {
        Participation found = em.find(Participation.class, participationId);

        if (found == null) throw new NotFoundException(participationId);

        return found;
    }

    public void delete(UUID participationId) {
        Participation found = findById(participationId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Partecipazione di " + found.getPerson().getSurname() + " " + " rimossa con successo.");
    }
}
