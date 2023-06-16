package it.gestioneincendi.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FireDetector {

	//attributi
	private int id;
	private double latitude;
	private double longitude;
	private int smokeLevel;

	private ControlCenter controlCenter;
	private String alarm;

	// costruttore, getter & setter aggiunti con lombok
	public FireDetector(ControlCenter cc, int id) {
		this.controlCenter = cc;
		this.id = id;
	}

	// 
	public void detectedFire(int id, double lat, double lon, int smokeLevel) {
		if (smokeLevel > 5) {
			this.alarm = "********** ALLARME **********\nSONDA ID: " + id + "\nLATITUDINE: " + lat + "\nLONGITUDINE: " + lon
					+ "\nSMOKE LEVEL: " + smokeLevel + "\nURL: http://host/alarm?=idsonda=" + id + "&lat=" + lat + "&lon=" + lon
					+ "&smokelevel=" + smokeLevel;
			controlCenter.sendAlarm(alarm);
		} else {
			controlCenter.sendAlarm("Nessun incendio rilevato. Livello di fumo: " + smokeLevel);
		}
	}

}
