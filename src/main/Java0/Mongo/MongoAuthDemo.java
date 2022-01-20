package main.Java0.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;



public class MongoAuthDemo {

	private static Logger log = Logger.getLogger(MongoAuthDemo.class);

	@SuppressWarnings("resource")//Use of @SuppressWarnings is to suppress or ignore warnings coming from the
	// compiler, i.e., the compiler will ignore warnings if any for that piece of code.This annotation is
	// dangerous because a warning is something potentially wrong with the code. So if we’re getting any
	// warning, the first approach should be resolving those errors. But if we’re suppressing any warnings,
	// we have to have some solid reason. The reason should be commented near to the annotation every
	// time it is used.
	public static void main(String[] args) {

		// Mongodb initialization parameters.
		int port_no = 27017;
		String auth_user="jcg", auth_pwd = "admin@123", host_name = "localhost", db_name = "mongoauthdemo", db_col_name = "emp", encoded_pwd = "";

		/* Imp. Note - 
		 * 		1.	Developers will need to encode the 'auth_user' or the 'auth_pwd' string if it contains the <code>:</code> or the <code>@</code> symbol. If not, the code will throw the <code>java.lang.IllegalArgumentException</code>.
		 *		2.	If the 'auth_user' or the 'auth_pwd' string does not contain the <code>:</code> or the <code>@</code> symbol, we can skip the encoding step.
		 */
		try {
			encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			log.error(ex);
		}

		// Mongodb connection string.
		String client_url = "mongodb://" + auth_user + ":" + encoded_pwd + "@" + host_name + ":" + port_no + "/" + db_name;
		MongoClientURI uri = new MongoClientURI(client_url);

		// Connecting to the mongodb server using the given client uri.
		MongoClient mongo_client = new MongoClient(uri);

		// Fetching the database from the mongodb.
		MongoDatabase db = mongo_client.getDatabase(db_name);

		// Fetching the collection from the mongodb.
		MongoCollection<Document> coll = db.getCollection(db_col_name);
		log.info("Fetching all documents from the collection");

		// Performing a read operation on the collection.
		FindIterable<Document> fi = coll.find();
		MongoCursor<Document> cursor = fi.iterator();
		try {
			while(cursor.hasNext()) {
				log.info(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}
	}
}
/**
 *use mongoauthdemo
 *
 * > db.createUser( { user: "jcg", pwd: "admin@123", roles: [ "readWrite", "dbAdmin" ] } )
 *
 * > db.emp.insertMany( [
 *     { "_id" : "101", "name" : "Daniel Atlas", "age": 26, "unit_tag_code": "tech_1001" },
 *     { "_id" : "102", "name" : "Charlotte Neil", "age": 30, "unit_tag_code": "hr_1002" },
 *     { "_id" : "103", "name" : "James Breen", "age": 32, "unit_tag_code": "payroll_1064" },
 *     { "_id" : "104", "name" : "John Gordon", "age": 24, "unit_tag_code": "tech_1001" },
 *     { "_id" : "105", "name" : "Rick Ford", "age": 21, "unit_tag_code": "hr_1002" }
 * ] )
 *
 * > db.emp.find()
 */
