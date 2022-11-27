package fr.uge.rest.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Bike extends UnicastRemoteObject implements fr.uge.rest.bike.IBike {
	private long id;
	private String etat;
	private List<Integer> notes;
	private List<String> comments;
	private int price;
	private int timesRented;

	public Bike() throws RemoteException {
		super();
		notes = new ArrayList<>();
		comments = new ArrayList<>();
	}
	
	public Bike(long id, String etat) throws RemoteException {
		super();
		this.id = id;
		this.etat = etat;
		notes = new ArrayList<>();
		comments = new ArrayList<>();
	}
	
	public Bike(long id, String etat, int price, int timesRented) throws RemoteException {
		super();
		this.id = id;
		this.etat = etat;
		notes = new ArrayList<>();
		comments = new ArrayList<>();
		this.price = price;
		this.timesRented = timesRented;
	}

	@Override
	public void setId(long id) throws RemoteException {
		this.id = id;
	}
	
	@Override
	public long getId() throws RemoteException {
		return this.id;
	}

	@Override
	public void setNotes(int note) throws RemoteException {
		this.notes = List.of(note);		
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
		this.notes.add(note);		
	}

	@Override
	public void setEtat(String etat) throws RemoteException {
		this.etat = etat;		
	}

	@Override
	public String getEtat() throws RemoteException {
		return this.etat;
	}

	@Override
	public void setComments(String comment) throws RemoteException {
		this.comments = List.of(comment);		
	}

	@Override
	public List<String> getComments() throws RemoteException {
		return this.comments;
	}

	@Override
	public void addComment(String comment) throws RemoteException {
		this.comments.add(comment);
	}

	@Override
	public void setPrice(int price) throws RemoteException {
		this.price = price;
	}

	@Override
	public int getPrice() throws RemoteException {
		return this.price;
	}

	@Override
	public void setTimesRented(int timesRented) throws RemoteException {
		this.timesRented = timesRented;
	}

	@Override
	public int getTimesRented() throws RemoteException {
		return this.timesRented;
	}

	@Override
	public void addTimesRented() throws RemoteException {
		this.timesRented += 1;
	}
}
