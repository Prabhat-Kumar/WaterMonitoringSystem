package edu.pune.university.data;

import org.bson.Document;

public class WaterData extends Document {

	private static final long serialVersionUID = 1L;

	
	private String id ="id";
	private String temperature ="temperature";

	public String getId() {
		return (String) this.get(this.id);
	}

	public void setId(String id) {
		this.append(this.id, id);
	}

	public float getTemperature() {
		return (float) this.get(this.temperature);
	}

	public void setTemperature(float temperature) {
		this.append(this.temperature, temperature);
	}

}
