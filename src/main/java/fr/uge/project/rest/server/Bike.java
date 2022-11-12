package fr.uge.project.rest.server;

import fr.uge.project.rest.common.Bikes;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class Bike extends UnicastRemoteObject implements Serializable, Bikes {

    public enum Etat {
        EN_SERVICE,
        EN_REPARATION,
        EN_PANNE,
        EN_ATTENTE
    }

    private final String note;
    private final Etat etat_de_restitution;

    public Bike(String note, Etat etat_de_restitution) throws RemoteException {
        super();
        this.note = note;
        this.etat_de_restitution = etat_de_restitution;
    }

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
}
