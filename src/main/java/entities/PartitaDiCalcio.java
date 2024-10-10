package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

 @Entity
 @Table(name = "partita_calcio")
 @DiscriminatorValue("Calcio")
//PER CAPIRE SE UNA PARTITA DI CALCIO E' STATA VINTA A CASA O IN TRASFERTA.
 @NamedQuery(name = "getPartiteVinteInCasa",
         query = "SELECT p FROM PartitaCalcio p WHERE p.golSquadraCasa > p.golSquadraOspite")
 //eleziona tutte le partite di calcio (PartitaCalcio) in cui i gol segnati dalla squadra di casa
 // (golSquadraCasa) sono superiori ai gol segnati dalla squadra ospite (golSquadraOspite).


 @NamedQuery(name = "getPartiteVinteInTrasferta",
         query = "SELECT p FROM PartitaCalcio p WHERE p.golSquadraOspite > p.golSquadraCasa")
 //Query: seleziona tutte le partite di calcio (PartitaCalcio)
 //in cui i gol segnati dalla squadra ospite (golSquadraOspite)
 // sono superiori ai gol segnati dalla squadra di casa

public class PartitaDiCalcio extends Evento{
     @Column(name = "squadra_casa",nullable = false)
    private String squadraDiCasa;
     @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;
     @Column(name ="squadra_vincente")
    private String squadraVincente;//[null se pareggio]
     @Column(name = "gol_squadra_casa",nullable = false)
    private int golSquadraDiCasa;
     @Column(name = "gol_squadra_ospite",nullable = false)
     private int golSquadraOspite;


    public PartitaDiCalcio(){

    }




    public PartitaDiCalcio(String title, LocalDate eventDate, String eventDescription, TipoEvento eventType, int maxParticipants, Location location,
                           String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraDiCasa, int golSquadraOspite) {
        super(title, eventDate, eventDescription, eventType, maxParticipants, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golSquadraDiCasa = golSquadraDiCasa;
        this.golSquadraOspite = golSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraDiCasa() {
        return golSquadraDiCasa;
    }

    public void setGolSquadraDiCasa(int golSquadraDiCasa) {
        this.golSquadraDiCasa = golSquadraDiCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraDiCasa=" + golSquadraDiCasa +
                ", golSquadraOspite=" + golSquadraOspite +
                '}'+ super.toString();
    }
}
