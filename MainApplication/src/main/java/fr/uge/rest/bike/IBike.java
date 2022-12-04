package fr.uge.rest.bike;

import org.apache.catalina.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

public interface IBike extends Remote {
	void setId(long id) throws RemoteException;
	long getId() throws RemoteException;
	
	void setNotes(int note) throws RemoteException;
	List<Integer> getNotes() throws RemoteException;
	int getAvgNote() throws RemoteException;
	void addNote(int note) throws RemoteException;
	
	void setEtat(String etat) throws RemoteException;
	String getEtat() throws RemoteException;
	
	void setComments(String comment) throws RemoteException;
	List<String> getComments() throws RemoteException;
	void addComment(String comment) throws RemoteException;
	
	void setPrice(double price) throws RemoteException;
	double getPrice() throws RemoteException;
	
	void setTimesRented(int timesRented) throws RemoteException;
	int getTimesRented() throws RemoteException;
	void addTimesRented() throws RemoteException;

	void setAvailable(boolean isAvailable) throws RemoteException;
	boolean getAvailable() throws RemoteException;
	/*
	void addToQueue(User user) throws RemoteException;
	Optional<User> popQueue() throws RemoteException;
	*/
	// String toString() throws RemoteException;
}
