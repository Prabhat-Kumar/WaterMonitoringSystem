package edu.pune.university.data;

import org.bson.Document;

public class WaterDemoData extends Document{
	private static final long serialVersionUID = 1L;

	private String time;
	private int pH;
	private float temp;
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getpH() {
		return pH;
	}

	public void setpH(int pH) {
		this.pH = pH;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemprature(float temprature) {
		this.temp = temprature;
	}

}
