package main.Java0.Mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoExample {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        DB database = mongoClient.getDB("moviesDB");

        // print existing databases
        mongoClient.getDatabaseNames().forEach(System.out::println);

        database.createCollection("customers", null);

        // print all collections in customers database
        database.getCollectionNames().forEach(System.out::println);

        // create data
        DBCollection collection = database.getCollection("customers");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Shubham");
        document.put("company", "Baeldung");
        collection.insert(document);

        // update data
        BasicDBObject query = new BasicDBObject();
        query.put("name", "Shubham");
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "John");
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        collection.update(query, updateObject);

        // read data
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "John");
        DBCursor cursor = collection.find(searchQuery);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }


        MongoDatabase database1 = mongoClient.getDatabase("moviesDB");
        MongoCollection<Document> collection1 = database1.getCollection("student");
        BasicDBObject searchQuery1 = new BasicDBObject();
        searchQuery1.put("name", "Kevin");
        MongoCursor<Document> cursor1 = collection1.find(searchQuery1).iterator();
        while (cursor1.hasNext()) {
            System.out.println(cursor1.next());
        }



        // delete data
        BasicDBObject deleteQuery = new BasicDBObject();
        deleteQuery.put("name", "John");
        collection.remove(deleteQuery);
    }
}
