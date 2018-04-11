package edu.pune.university.dao;

import java.net.UnknownHostException;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import edu.pune.university.data.WaterData;
import edu.pune.university.db.MongoDatabaseConnectionManager;
import edu.pune.university.exception.ApplicationException;

public class WaterDataDao extends _BaseDao{
	
	private static String COLLECTION = "Water_Data";
	
	
	private MongoCollection<Document> getMongoCollection() throws ApplicationException {
		try {
			return MongoDatabaseConnectionManager.getInstance().getMongoCollection(COLLECTION);
		} catch (UnknownHostException e) {
			throw new ApplicationException();
		}
	}

	
	
	public void createWaterData (WaterData waterData) throws ApplicationException {
		insertDocument(getMongoCollection(), waterData);
		MongoDatabaseConnectionManager.getInstance().closeDatabaseConnection();
	}
	
	public void createWaterData (List<WaterData> waterDatas) throws ApplicationException {
		insertDocument(getMongoCollection(), waterDatas);
	}
	
	public void updateWaterData (WaterData waterData) {
		
	}
	
	public void deleteWaterData (WaterData waterData) {
		
	}
	
	public List<WaterData> getAllWaterData () {
		return null;
	}
	
	public WaterData findWaterData (String id) {
		return null;
	}
}
