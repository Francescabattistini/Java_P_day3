package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "gare_atletica")
@DiscriminatorValue("Gara_atletica")
public class GaraDiAtletica extends Evento{

    //3.Molti a uno, ogni gara può avere solo un vincitore ma una persona può vincere molte gare
@ManyToOne
@JoinColumn(name = "vincitore_id")/*
@JoinColumn(name = "vincitore_id"): specifica il nome della colonna
 (vincitore_id) nella tabella gare_atletica
che memorizza l'ID del vincitore della gara, collegandolo alla tabella Person.*/
private Person vincitore;

// 2. molti a molti perchè ogni gara può avere molti atleti e ogni atleta può fare molte gare
@ManyToMany
@JoinTable(name = "altleti_gare",//definisce la tabella
        joinColumns = @JoinColumn(name = "gare_id"),//definiamo le gare nella colonna nella tabella "atleti_gare"
        inverseJoinColumns = @JoinColumn(name = "atleta_id"))//definiamo gli id degli atleti nella colonna
private Set<Person> atleti = new HashSet<>();





//1.crea una collezione atleti in cui è possibile aggiungere
    // più oggetti Person senza temere duplicati e con accesso limitato a livello di classe.
    //HashSet è una struttura di dati che non mantiene un ordine specifico degli elementi,
    // ma permette un accesso rapido e garantisce che ogni elemento sia unico.





    public  GaraDiAtletica(){

    }

    public GaraDiAtletica(String title, LocalDate eventDate, String eventDescription, TipoEvento eventType,
                          int maxParticipants, Location location, Person vincitore, Set<Person> atleti) {
        super(title, eventDate, eventDescription, eventType, maxParticipants, location);
        this.vincitore = vincitore;
        this.atleti = atleti;
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }

    public Set<Person> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Person> atleti) {
        this.atleti = atleti;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "vincitore=" + vincitore +
                ", atleti=" + atleti +
                '}';
    }
}
