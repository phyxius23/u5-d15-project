package it.gestioneincendi.model;

import java.util.ArrayList;
import java.util.List;

public class CommunicationCenter implements FireDetector {

	// attributi
	private List<ControlProcess> observers;
	private List<Probe> probes;

	public CommunicationCenter(List<Probe> probes) {
		this.observers = new ArrayList<>();
		this.probes = probes;
	}

	@Override
	public void addObserver(ControlProcess observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void removeObserver(ControlProcess observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void warningObservers() {

		// TODO Auto-generated method stub
		for (ControlProcess observer : observers) {

			List<Probe> probesWithAlarm = new ArrayList<>();

			for (Probe probe : probes) {

				if (probe.getSmokeLevel() > 5) {

					probesWithAlarm.add(probe);
				}
			}
			observer.update(probesWithAlarm);
		}
	}

	public void fireDetectorSystem() {
		for (Probe probe : probes) {
			probe.setSmokeLevel(8);
			;
		}
		warningObservers();
	}

}
