package edu.pune.university.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import edu.pune.university.data.WaterData;
import edu.pune.university.data.WaterDemoData;
import edu.pune.university.db.MongoDatabaseConnectionManager;
import edu.pune.university.exception.ApplicationException;

public class WaterDemoDataDao extends _BaseDao {
	
	private static String COLLECTION = "Water_Demo";
	
	
	private MongoCollection<Document> getMongoCollection() throws ApplicationException {
		try {
			return MongoDatabaseConnectionManager.getInstance().getMongoCollection(COLLECTION);
		} catch (UnknownHostException e) {
			throw new ApplicationException();
		}
	}

	
	
	public void createWaterDemoData (WaterDemoData waterDemoData) throws ApplicationException {
		insertDocument(getMongoCollection(), waterDemoData);
		MongoDatabaseConnectionManager.getInstance().closeDatabaseConnection();
	}
	
	public void createWaterDemoData (List<WaterDemoData> waterDemoDatas) throws ApplicationException {
		insertDocument(getMongoCollection(), waterDemoDatas);
	}
	
	public void updateWaterData (WaterData waterData) {
		
	}
	
	public void deleteWaterData (WaterData waterData) {
		
	}
	
	public List<WaterDemoData> getAllWaterDemoData () throws ApplicationException {
		List<WaterDemoData> waterDemoDatas = new ArrayList<>();
		MongoCursor<Document> cursor = getMongoCollection().find(Document.class).iterator();
		try {
			while (cursor.hasNext()) {
				//WaterData waterData = (new Gson()).fromJson(cursor.next().toJson(), WaterData.class);
				//waterDatas.add(waterData);
				WaterDemoData dd = new WaterDemoData();
				waterDemoDatas.add(dd);
						
			}
		} finally {
			cursor.close();
		}
		return waterDemoDatas;
	}
	
	public WaterDemoData findWaterDemoData (String id) {
		return null;
	}

}
