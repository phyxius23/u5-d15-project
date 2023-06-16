package it.gestioneincendi.model;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FireDetectorRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// 1. 
		ControlProcess controlProcessOne = new ControlProcessImpl();

		Probe probeOne = ProbeFactory.createProbe(1, 9.52353, 162.38309);
		Probe probeTwo = ProbeFactory.createProbe(2, 37.36987, 157.18530);
		Probe probeThree = ProbeFactory.createProbe(3, -4.14829, 113.74633);

		CommunicationCenter communicationCenterOne = new CommunicationCenter(List.of(probeOne, probeTwo, probeThree));

		communicationCenterOne.addObserver(controlProcessOne);

		// 2.
		ControlProcess controlProcessTwo = new ControlProcessImpl();

		Probe probeFour = ProbeFactory.createProbe(4, -53.39643, -71.85348);
		Probe probeFive = ProbeFactory.createProbe(5, -0.72887, 28.54524);

		CommunicationCenter communicationCenterTwo = new CommunicationCenter(List.of(probeFour, probeFive));
		communicationCenterTwo.addObserver(controlProcessTwo);

		// 3.
		communicationCenterOne.fireDetectorSystem();
		communicationCenterTwo.fireDetectorSystem();

		// 4.
		probeOne.setSmokeLevel(6);
		probeTwo.setSmokeLevel(8);
		probeFour.setSmokeLevel(7);

		// 5.
		communicationCenterOne.fireDetectorSystem();
		communicationCenterTwo.fireDetectorSystem();

	}

}
