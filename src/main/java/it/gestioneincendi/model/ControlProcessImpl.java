package it.gestioneincendi.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ControlProcessImpl implements ControlProcess {

	// attributi 
	private int id;

	@Override
	public void update(List<Probe> probes) {

		for (Probe probe : probes) {

			int smokeLevel = probe.getSmokeLevel();

			if (smokeLevel > 5) {
				String url = "http://host/alarm?idsonda=" + probe.getId() + "&lat=" + probe.getLatitude() + "&lon="
						+ probe.getLongitude() + "&smokelevel=" + smokeLevel;

				System.out.println("*************** ALLARME ***************\nSONDA CON ID: " + probe.getId()
						+ "\nLIVELLO FUMO RILEVATO: " + probe.getSmokeLevel() + "\nURL: " + url);
			}

		}

	};

};
