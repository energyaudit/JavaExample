package main.Java0.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DropDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("temp_testDB");
		db.drop();
		
		//MongoCollection collection = db.getCollection("demo_users");
		//collection.drop();
		
	}

}
