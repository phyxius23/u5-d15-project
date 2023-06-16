package it.gestioneincendi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.gestioneincendi.model.CommunicationCenter;
import it.gestioneincendi.model.ControlProcess;
import it.gestioneincendi.model.ControlProcessImpl;
import it.gestioneincendi.model.Probe;
import it.gestioneincendi.model.ProbeFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class U5D15ProjectApplicationTests {

	Probe probe = ProbeFactory.createProbe(1, 45.4642, 23.1900);

	@Test
	void contextLoads() {
	}

	@Test
	void testSmokeLevel() {
		try {
			probe.setSmokeLevel(1);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		assertEquals(1, probe.getSmokeLevel());

	}

	@Test
	void testURL() {

		Probe probeOne = ProbeFactory.createProbe(4, 11.21823, -163.05250);
		ControlProcess controlProcess = new ControlProcessImpl(2);

		CommunicationCenter communicationCenter = new CommunicationCenter(List.of(probeOne));
		communicationCenter.addObserver(controlProcess);

		probeOne.setSmokeLevel(7);

		communicationCenter.fireDetectorSystem();

		String expectedUrl = "http://host/alarm?idsonda=4&lat=11.21823&lon=-163.05250&smokelevel=7";

		//=> mi manca di trovare il metodo che mi resituisca true al test: assertTrue()????
		//		assertTrue
	}

}
