package DAO;

import entities.Location;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationsDAO {
    private final EntityManager em;

    public LocationsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(location);

        transaction.commit();

        System.out.println("La location " + location.getName() + " è stata aggiunta con successo!");
    }

    public Location findById(UUID locationId) {
        Location found = em.find(Location.class, locationId);

        if (found == null) throw new NotFoundException(locationId);

        return found;
    }

    public void delete(UUID locationId) {
        Location found = findById(locationId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Location " + found.getName() + " rimossa con successo.");
    }
}
