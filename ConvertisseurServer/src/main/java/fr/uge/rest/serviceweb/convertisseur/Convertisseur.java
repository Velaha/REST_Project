package fr.uge.rest.serviceweb.convertisseur;

import FxtopAPI.FxtopServicesLocator;
import FxtopAPI.FxtopServicesPortType;

public class Convertisseur {
	
	public Convertisseur() {
	}
	
	
	public double convertToEuro(String isoMoney, double amount) {
		try {
			FxtopServicesPortType service = new FxtopServicesLocator().getFxtopServicesPort();
			double exchangeRate = Double.parseDouble(service.convert(String.valueOf(amount), isoMoney, "EUR", "", "", "").getExchangeRate());
			return amount * exchangeRate;
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong amount or wrong ISO value, need to be a 3 letter String, exemple : USD ");
		}
	}
		
	public double convertEuroTo(String isoToConvert, double amount) {
		try {
			FxtopServicesPortType service = new FxtopServicesLocator().getFxtopServicesPort();
			double exchangeRate = Double.parseDouble(service.convert(String.valueOf(amount), "EUR", isoToConvert, "", "", "").getExchangeRate());
			return amount * exchangeRate;
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong amount or wrong ISO value, need to be a 3 letter String, exemple : USD ");
		}
	}
}
