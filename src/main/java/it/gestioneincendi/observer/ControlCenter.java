package it.gestioneincendi.observer;

import java.util.ArrayList;
import java.util.List;

public class ControlCenter implements ControlProcess {

	private List<FireDetector> fireDetectors = new ArrayList<>();

	public void addProbe(FireDetector fd) {
		fireDetectors.add(fd);
	}

	public void removeProbe(FireDetector fd) {
		fireDetectors.remove(fd);
	}

	@Override
	public void sendAlarm(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
