package fr.uge.project.rest.server;

import fr.uge.project.rest.common.Etat;
import fr.uge.project.rest.common.IBike;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Bike extends UnicastRemoteObject implements IBike {

    private Long id;
    private String note;
    private Etat etat_de_restitution;

    public Bike() throws RemoteException {
    }

    public Bike(Long id, String note, Etat etat_de_restitution) throws RemoteException {
        super();
        this.id = id;
        this.note = note;
        this.etat_de_restitution = etat_de_restitution;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public Etat getEtat_de_restitution() {
        return etat_de_restitution;
    }
    public void setEtat_de_restitution(Etat etat_de_restitution) {
        this.etat_de_restitution = etat_de_restitution;
    }

    @Override
    public String toString() {
        return "Bike{" +
            "note='" + note + '\'' +
            ", etat_de_restitution=" + etat_de_restitution +
            '}';
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bike bike = (Bike) o;
        return Objects.equals(note, bike.note) && Objects.equals(etat_de_restitution, bike.etat_de_restitution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), note, etat_de_restitution);
    }
    */
}
