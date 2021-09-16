package main.Java0.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.bson.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class RunCommandDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("db_demo");
		MongoCollection collection = db.getCollection("cols_user_details");
		
		// execute Commands against MongoDB.https://docs.mongodb.com/manual/reference/command/
		
		Document result=db.runCommand(new Document("collStats","cols_user_details"));
		
		System.out.println(""+result.toJson());
		
		
		
		GridFSBucket  bucket= GridFSBuckets.create(db, "demo_temp_bucket");
		bucket.uploadFromStream("LangStats", new FileInputStream(new File("src/main/resources/IEDriverServer.exe")));
		
		
		
		
		
		
		

	}

}
