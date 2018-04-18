package edu.pune.university.data;

import java.util.List;

import org.bson.Document;

public class WaterData extends Document {

	private static final long serialVersionUID = 1L;

	private String location = "location";
	private String latitude = "latitude";
	private String longitude = "longitude";
	private String records = "records";

	public String getLocation() {
		return (String) this.get(this.location);
	}

	public void setLocation(String location) {
		this.append(this.location, location);
	}

	public float getLatitude() {
		return (float) this.get(this.latitude);
	}

	public void setLatitude(float latitude) {
		this.append(this.latitude, latitude);
	}

	public float getLongitude() {
		return (float) this.get(this.longitude);
	}

	public void setLongitude(float longitude) {
		this.append(this.longitude, longitude);
	}

	@SuppressWarnings("unchecked")
	public List<Record> getRecords() {
		return (List<Record>) this.get(this.records);
	}

	public void setRecords(List<Record> records) {
		this.append(this.records, records);
	}
	
	
}
