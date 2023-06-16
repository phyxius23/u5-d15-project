package it.gestioneincendi.model;

public interface FireDetector {

	void addObserver(ControlProcess observer);

	void removeObserver(ControlProcess observer);

	void warningObservers();
}
