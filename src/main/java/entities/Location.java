package entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nome_location", nullable = false)
    private String name;

    @Column(name = "città", nullable = false)
    private String city;

    public Location() {

    }

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}