package main.Java0.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.UpdateOneModel;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class BulkWriteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient client = new MongoClient("127.0.0.1", 27017);
		MongoDatabase db = client.getDatabase("db_demo");
		MongoCollection<Document> collection = db.getCollection("cols_user_details");
		
	  // BulkWrite 
		
		//  2 Inserts , a update , a Delete
		
		Document doc_ins1=new Document("username","insert1").append("pwd", "pwd_insert1");
		Document doc_ins2=new Document("username","insert2").append("pwd", "pwd_insert2");
		
		Document doc_update_original=new Document("username","admin2");
		Document doc_update_new=new Document("username","admin2mod");
		Document doc_update_command=new Document("$set",doc_update_new);
		
		Document doc_del=new Document("username","admin3");
		
		List  list_data=Arrays.asList( new InsertOneModel<>(doc_ins1),new InsertOneModel<>(doc_ins2),
				
				new UpdateOneModel<>(doc_update_original,doc_update_command),
				
				new DeleteOneModel<>(doc_del)	);
		
		collection.bulkWrite(list_data);
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
