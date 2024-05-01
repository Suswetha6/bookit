package org.abhinavgpt.bookit.modals;

package org.abhinavgpt.bookit.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.abhinavgpt.bookit.modals.data.AvailableTechnology;

@Entity
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int capacity;
    private String location;
    private AvailableTechnology availableTechnology;

    public CinemaHall() {
    }

    public CinemaHall(String name, int capacity, String location, AvailableTechnology availableTechnology) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.availableTechnology = availableTechnology;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AvailableTechnology getAvailableTechnology() {
        return availableTechnology;
    }

    public void setAvailableTechnology(AvailableTechnology availableTechnology) {
        this.availableTechnology = availableTechnology;
    }
}
