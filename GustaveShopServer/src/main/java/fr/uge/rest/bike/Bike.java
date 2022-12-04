package fr.uge.rest.bike;

import java.util.Arrays;

public class Bike {
	private long id;
	private String etat;
	private Integer[] notes;
	private String[] comments;
	private double price;
	private int timesRented;
	private boolean isAvailable;

	public Bike() {
		super();
		isAvailable = true;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setNotes(int note) {
		this.notes = Arrays.copyOf(notes, note);
	}

	public Integer[] getNotes() {
		return this.notes;
	}

	public int getAvgNote() {
		int avg = Arrays.stream(this.notes).mapToInt(Integer::intValue).sum() / this.notes.length;
		return avg;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getEtat() {
		return this.etat;
	}

	public String[] getComments() {
		return this.comments;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public void setTimesRented(int timesRented) {
		this.timesRented = timesRented;
	}

	public int getTimesRented() {
		return this.timesRented;
	}

	public void addTimesRented() {
		this.timesRented += 1;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
