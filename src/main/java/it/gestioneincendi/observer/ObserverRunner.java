package it.gestioneincendi.observer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ObserverRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ControlCenter controlCenter = new ControlCenter();

		FireDetector fdOne = new FireDetector(controlCenter, 0001);
		controlCenter.addProbe(fdOne);

		fdOne.detectedFire(fdOne.getId(), 45.806452, 10.229569, 3);
		fdOne.detectedFire(fdOne.getId(), 45.232292, 9.720953, 7);

		FireDetector fdTwo = new FireDetector(controlCenter, 0002);
		controlCenter.addProbe(fdTwo);

		fdTwo.detectedFire(fdTwo.getId(), 45.806452, 10.229569, 5);
		fdTwo.detectedFire(fdTwo.getId(), 45.232292, 9.720953, 9);

		FireDetector fdThree = new FireDetector(controlCenter, 0003);
		controlCenter.addProbe(fdThree);

		fdThree.detectedFire(fdThree.getId(), 43.813813, 15.002888, 1);
		fdThree.detectedFire(fdThree.getId(), 43.792739, 14.992629, 6);
	}

}
