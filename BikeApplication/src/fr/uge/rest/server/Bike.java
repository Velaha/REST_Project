package fr.uge.rest.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import fr.uge.rest.bike.IBike;

public class Bike extends UnicastRemoteObject implements IBike {
	private long id;
	private String etat;
	private List<Integer> notes;
	private List<String> comments;
	private double price;
	private int timesRented;
	private boolean isAvailable;
	private Object lock = new Object();

	public Bike() throws RemoteException {
		super();
		synchronized (lock) {
			notes = new ArrayList<>();
			comments = new ArrayList<>();
			isAvailable = true;
		}
	}

	public Bike(long id, String etat) throws RemoteException {
		super();
		synchronized (lock) {
			this.id = id;
			this.etat = etat;
			notes = new ArrayList<>();
			comments = new ArrayList<>();
			isAvailable = true;
		}
	}

	public Bike(long id, String etat, int price, int timesRented) throws RemoteException {
		super();
		synchronized (lock) {
			this.id = id;
			this.etat = etat;
			notes = new ArrayList<>();
			comments = new ArrayList<>();
			this.price = price;
			this.timesRented = timesRented;
			isAvailable = true;
		}
	}

	@Override
	public void setId(long id) throws RemoteException {
		synchronized (lock) {
			this.id = id;
		}
	}

	@Override
	public long getId() throws RemoteException {
		return this.id;
	}

	@Override
	public void setNotes(int note) throws RemoteException {
		synchronized (lock) {
			this.notes = List.of(note);
		}
	}

	@Override
	public List<Integer> getNotes() throws RemoteException {
		return this.notes;
	}

	@Override
	public int getAvgNote() throws RemoteException {
		var avg = this.notes.stream().mapToInt(Integer::intValue).average();
		return avg.isPresent() ? (int) avg.getAsDouble() : 0;
	}

	@Override
	public void addNote(int note) throws RemoteException {
		synchronized (lock) {
			this.notes.add(note);
		}
	}

	@Override
	public void setEtat(String etat) throws RemoteException {
		synchronized (lock) {
			this.etat = etat;
		}
	}

	@Override
	public String getEtat() throws RemoteException {
		return this.etat;
	}

	@Override
	public void setComments(String comment) throws RemoteException {
		synchronized (lock) {
			this.comments = List.of(comment);
		}
	}

	@Override
	public List<String> getComments() throws RemoteException {
		return this.comments;
	}

	@Override
	public void addComment(String comment) throws RemoteException {
		synchronized (lock) {
			this.comments.add(comment);
		}
	}

	@Override
	public void setPrice(double price) throws RemoteException {
		synchronized (lock) {
			this.price = price;
		}
	}

	@Override
	public double getPrice() throws RemoteException {
		return this.price;
	}

	@Override
	public void setTimesRented(int timesRented) throws RemoteException {
		synchronized (lock) {
			this.timesRented = timesRented;
		}
	}

	@Override
	public int getTimesRented() throws RemoteException {
		return this.timesRented;
	}

	@Override
	public void addTimesRented() throws RemoteException {
		synchronized (lock) {
			this.timesRented += 1;
		}
	}

	@Override
	public void setAvailable(boolean isAvailable) throws RemoteException {
		synchronized (lock) {
			this.isAvailable = isAvailable;
		}
	}

	@Override
	public boolean getAvailable() throws RemoteException {
		return this.isAvailable;
	}
}
