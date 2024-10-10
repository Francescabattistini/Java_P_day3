package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class GaraDiAtletica extends Evento{
private Person vincitore;
    private Set<Person> atleti = new HashSet<>();//crea una collezione atleti in cui è possibile aggiungere
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
