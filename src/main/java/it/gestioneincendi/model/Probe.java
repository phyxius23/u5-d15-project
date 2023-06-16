package it.gestioneincendi.model;

import lombok.Data;

@Data
public class Probe {

	// attributi
	private int id;
	private double latitude;
	private double longitude;
	private int smokeLevel;

	// costruttore
	public Probe(int id, double latitude, double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLevel = 0;
	}
}
