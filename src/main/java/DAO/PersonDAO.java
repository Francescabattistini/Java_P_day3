package DAO;

import entities.Person;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(person);

        transaction.commit();

        System.out.println("La persona " + person.getName() + " è stata aggiunta con successo!");
    }

    public Person findById(UUID personId) {
        Person found = em.find(Person.class, personId);

        if (found == null) throw new NotFoundException(personId);

        return found;
    }

    public void delete(UUID personId) {
        Person found = findById(personId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Persona " + found.getName() + " " + found.getSurname() + " rimossa con successo.");
    }
}
