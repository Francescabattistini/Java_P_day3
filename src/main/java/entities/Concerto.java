package entities;

import java.time.LocalDate;

public class Concerto extends Evento{




private GeneriMusicali generiMusicali;
private boolean inStreaming;


public Concerto () {}

    public Concerto(String title, LocalDate eventDate, String eventDescription, TipoEvento eventType,
                    int maxParticipants, Location location, GeneriMusicali generiMusicali, boolean inStreaming) {
        super(title, eventDate, eventDescription, eventType, maxParticipants, location);
        this.generiMusicali = generiMusicali;
        this.inStreaming = inStreaming;
    }

    public GeneriMusicali getGeneriMusicali() {
        return generiMusicali;
    }

    public void setGeneriMusicali(GeneriMusicali generiMusicali) {
        this.generiMusicali = generiMusicali;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "generiMusicali=" + generiMusicali +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
