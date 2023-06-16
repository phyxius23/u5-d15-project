package it.gestioneincendi.model;

public class ProbeFactory {

	public static Probe createProbe(int id, double latitude, double longitude) {

		return new Probe(id, latitude, longitude);
	}

}
