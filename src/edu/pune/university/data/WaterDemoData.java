package edu.pune.university.data;

import org.bson.Document;

public class WaterDemoData extends Document{
	
	private static final long serialVersionUID = 1L;

	private String time = "time";
	private String ph = "ph";
	private String temp = "temp";
	
	
	public String getTime() {
		return (String) this.get(this.time);
	}

	public double getpH() {
		return (double) this.get(this.ph);
	}

	public double getTemp() {
		return (double) this.get(this.temp);
	}

}
