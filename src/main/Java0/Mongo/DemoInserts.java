package main.Java0.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DemoInserts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub,you must install mongo server and run the server to
		//  run this code
		

		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("db_demo");
		MongoCollection collection = db.getCollection("cols_user_details");
		
		// create a new Document
		
		List<Document>  list_docs=new ArrayList<Document>();
		
		Document doc1=new Document().append("username", "admin1").append("pwd", "admin123_1");
		Document doc2=new Document().append("username", "admin2").append("pwd", "admin123_2");
		Document doc3=new Document().append("username", "admin3").append("pwd", "admin123_3");
		
		list_docs.add(doc1);
		list_docs.add(doc2);
		list_docs.add(doc3);
		
		collection.insertMany(list_docs);
		client.close();
		

	}

}
