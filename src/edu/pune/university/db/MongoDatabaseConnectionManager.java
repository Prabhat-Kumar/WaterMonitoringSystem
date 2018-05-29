package edu.pune.university.db;

import java.net.UnknownHostException;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDatabaseConnectionManager {
	
	private static MongoDatabaseConnectionManager instance = null;
	private static String USER = "Maya";
	private static String PASSWORD = "root";
	private static String HOST = "ds241699.mlab.com";
	private static String PORT_NUMBER = "41699";
	private static String DATABASE_NAME = "water";
	private static MongoClient client = null;
	private static MongoDatabase mongoDatabase = null;
	private static MongoClientURI MONGO_CLIENT_URL = new MongoClientURI(
			"mongodb://" + USER + ":" + PASSWORD + "@" + HOST + ":" + PORT_NUMBER + "/" + DATABASE_NAME);

	private MongoDatabaseConnectionManager() {

	}
	
	public static MongoDatabaseConnectionManager getInstance () {
		if(instance == null) {
			instance = new MongoDatabaseConnectionManager();
			return instance;
		}
		return instance;
	}

	public MongoDatabase getDatabaseConnection() throws UnknownHostException {
		if (mongoDatabase == null) {
			client = new MongoClient(MONGO_CLIENT_URL);
			mongoDatabase = client.getDatabase(MONGO_CLIENT_URL.getDatabase());
		}
		return mongoDatabase;
	}

	public void closeDatabaseConnection() {
		if (client != null) {
			client.close();
		}
	}

	public MongoCollection<Document> getMongoCollection(String collectionName) throws UnknownHostException {
		return getDatabaseConnection().getCollection(collectionName);
	}

	
}
