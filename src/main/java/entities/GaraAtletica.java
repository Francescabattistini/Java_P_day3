package entities;

import enumes.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class GaraAtletica extends Evento {
    // ci possono essere sia molti atleti che molte gare
    @ManyToMany
    @JoinTable(name = "lista_atleti",
     joinColumns = @JoinColumn(name = "gara_id", nullable = false),//memorizziamo un id per la gara
     inverseJoinColumns = @JoinColumn(name = "persona_id", nullable = false))// memorizziamo un id per la persona
    private List<Persona> lista_atleti;// creiamo una lista perchè sono più atleti

    @ManyToOne
    @JoinColumn(name = "vincitore")
    private Persona vincitore;

    public GaraAtletica() {

    }

    public GaraAtletica(String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, long numeroMassimoPartecipanti, Location location, List<Persona> lista_atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.lista_atleti = lista_atleti;
        this.vincitore = vincitore;
    }

    public List<Persona> getLista_atleti() {
        return lista_atleti;
    }

    public void setLista_atleti(List<Persona> lista_atleti) {
        this.lista_atleti = lista_atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }


    @Override
    public String toString() {
        return "GaraAtletica{" + super.toString() +
                "lista_atleti=" + lista_atleti +
                ", vincitore=" + vincitore +
                "}";
    }
}
