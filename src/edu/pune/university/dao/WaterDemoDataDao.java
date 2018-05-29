package edu.pune.university.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

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

	public List<WaterDemoData> getAllWaterDemoData () throws ApplicationException {
		List<WaterDemoData> waterDemoDatas = new ArrayList<>();
		MongoCursor<Document> cursor = getMongoCollection().find(Document.class).iterator();
		try {
			while (cursor.hasNext()) {
				WaterDemoData waterData = (new Gson()).fromJson(cursor.next().toJson(), WaterDemoData.class);
				waterDemoDatas.add(waterData);
						
			}
		} finally {
			cursor.close();
		}
		return waterDemoDatas;
	}

}
