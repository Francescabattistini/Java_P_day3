package entities;

import java.time.LocalDate;

public class PartitaDiCalcio extends Evento{
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;//[null se pareggio]
    private int golSquadraDiCasa;
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
                '}';
    }
}
