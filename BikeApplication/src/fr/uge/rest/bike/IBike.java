package fr.uge.rest.bike;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IBike extends Remote {
	public void setId(long id) throws RemoteException;
	public long getId() throws RemoteException;
	
	public void setNotes(int note) throws RemoteException;
	public List<Integer> getNotes() throws RemoteException;
	public int getAvgNote() throws RemoteException;
	public void addNote(int note) throws RemoteException;
	
	public void setEtat(String etat) throws RemoteException;
	public String getEtat() throws RemoteException;
	
	public void setComments(String comment) throws RemoteException;
	public List<String> getComments() throws RemoteException;
	public void addComment(String comment) throws RemoteException;
	
	public void setPrice(int price) throws RemoteException;
	public int getPrice() throws RemoteException;
	
	public void setTimesRented(int timesRented) throws RemoteException;
	public int getTimesRented() throws RemoteException;
	public void addTimesRented() throws RemoteException;

	//public String toString() throws RemoteException;
}
