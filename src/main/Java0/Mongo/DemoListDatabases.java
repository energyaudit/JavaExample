package main.Java0.Mongo;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class DemoListDatabases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// step1 - Connection

		MongoClient client = new MongoClient("127.0.0.1", 27017);

		// Step2 - List Databases

		MongoIterable<String> mIter = client.listDatabaseNames();

		mIter.forEach(new Block<String>() {

			public void apply(String dbName) {
				// TODO Auto-generated method stub

				System.out.println("" + dbName);

			}
		});

		// List all the contents of the collection

		MongoDatabase db = client.getDatabase("db_demo");

//		MongoCollection collection = db.getCollection("tbl_login");
		MongoCollection collection = db.getCollection("cols_user_details");

		MongoIterable<Document> iter_collection = collection.find();

		iter_collection.forEach(new Block<Document>() {

			public void apply(Document doc_content) {
				// TODO Auto-generated method stub

				System.out.println("" + doc_content.toJson());

			}
		});
		
		
		// create a new Collection
		
//		db.createCollection("cols_user_details");
		
		
		
		
		
		

		client.close();

	}

}
