package main.Java0.Mongo;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;

public class DemoFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("db_demo");
		MongoCollection<Document> collection = db.getCollection("cols_user_details");

		// sort the result
		// filter the results
		// Projections

		FindIterable<Document> iter = collection.find(and(ne("username", "admin3"), ne("username", "admin1")))
				.projection(include("username", "pwd")).projection(exclude("_id")).sort(descending("username"));

		Block<Document> printBlock = new Block<Document>() {

			public void apply(Document arg0) {
				// TODO Auto-generated method stub

				System.out.println("" + arg0.toJson());

			}

		};

		iter.forEach(printBlock);

		// to update

		collection.updateOne(eq("username", "admin"), set("pwd", "admin0"));

		// updates many

		collection.updateMany(ne("_id", "0"), inc("userid", 1));

		// to delete

		collection.deleteOne(eq("username", "admin"));
		// to delete Many

		collection.deleteMany(eq("username", "admin"));
		
		

	}

}
