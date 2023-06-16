package it.gestioneincendi.model;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FireDetectorRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ControlProcess controlProcess = new ControlProcessImpl();

		Probe probeOne = ProbeFactory.createProbe(1, 9.52353, 162.38309);
		Probe probeTwo = ProbeFactory.createProbe(2, 37.36987, 157.18530);
		Probe probeThree = ProbeFactory.createProbe(3, -4.14829, 113.74633);

		CommunicationCenter communicationCenter = new CommunicationCenter(List.of(probeOne, probeTwo, probeThree));
		communicationCenter.addObserver(controlProcess);
		//		communicationCenter.addObserver(centroControllo1);

		communicationCenter.fireDetectorSystem();

	}

}
