package edu.pune.university.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import edu.pune.university.data.UserData;
import edu.pune.university.db.MongoDatabaseConnectionManager;
import edu.pune.university.exception.ApplicationException;

public class UserInfoDao extends _BaseDao {
private static String COLLECTION = "User_Info";
	
	
	private MongoCollection<Document> getMongoCollection() throws ApplicationException {
		try {
			return MongoDatabaseConnectionManager.getInstance().getMongoCollection(COLLECTION);
		} catch (UnknownHostException e) {
			throw new ApplicationException();
		}
	}

	public List<UserData> getAllUserData () throws ApplicationException {
		List<UserData> userDatas = new ArrayList<>();
		MongoCursor<Document> cursor = getMongoCollection().find(Document.class).iterator();
		try {
			while (cursor.hasNext()) {
				UserData UserData = (new Gson()).fromJson(cursor.next().toJson(), UserData.class);
				userDatas.add(UserData);
			}
		} finally {
			cursor.close();
		}
		return userDatas;
	}

}
