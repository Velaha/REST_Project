package fr.uge.project.rest.server.bikes;

import fr.uge.project.rest.common.IBike;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bike extends UnicastRemoteObject implements IBike {

    private Long id;
    private List<Integer> notes;
    private String etat_de_restitution;

    private List<String> comments;

    public Bike() throws RemoteException {
        super();
    }

    public Bike(Long id, String etat_de_restitution) throws RemoteException {
        super();
        this.id = id;
        this.notes = new ArrayList<>();
        this.etat_de_restitution = etat_de_restitution;
        this.comments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getNote() {
        AtomicInteger result = new AtomicInteger(0);
        notes.stream().mapToInt(Integer::intValue).average().ifPresent(value -> result.set((int) value));
        return result.get();
    }
    public void addNote(int note) {
        notes.add(note);
    }
    public void setNote(int note) {
        this.notes = new ArrayList<>();
        this.notes.add(note);
    }

    public String getEtat_de_restitution() {
        return etat_de_restitution;
    }
    public void setEtat_de_restitution(String etat_de_restitution) {
        this.etat_de_restitution = etat_de_restitution;
    }

    @Override
    public String toString() {
        return "Bike{" +
            "note='" + getNote() + '\'' +
            ", etat_de_restitution=" + etat_de_restitution +
            '}';
    }
}
