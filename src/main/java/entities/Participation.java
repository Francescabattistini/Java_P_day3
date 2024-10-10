package entities;

import jakarta.persistence.*;

import java.util.UUID;
// la classe che passa i dati a evento e a persona
@Entity
@Table(name = "partecipazioni")
public class Participation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne//seconda FK
    @JoinColumn(name = "persona_id")
    private Person person;

    @ManyToOne // prima FK
    @JoinColumn(name = "evento_id")
    private Evento event;

    @Column(name = "stato_conferma")// enum
    @Enumerated(EnumType.STRING)
    private ParticipationState state;

    public Participation() {

    }

    public Participation(Person person, Evento event, ParticipationState state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Evento getEvent() {
        return event;
    }

    public void setEvent(Evento event) {
        this.event = event;
    }

    public ParticipationState getState() {
        return state;
    }

    public void setState(ParticipationState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", person=" + person.getName() + " " + person.getSurname() +
                ", event=" + event.getTitle() +
                ", state=" + state +
                '}';
    }
}
