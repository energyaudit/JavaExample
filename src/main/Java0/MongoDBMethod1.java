package main.Java0;


import com.mongodb.client.*;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDBMethod1 {
    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("moviesDB");
            for (String name : database.listCollectionNames()) {
                System.out.println(name);
            }
            MongoCollection<Document> moviesCollection = database.getCollection("moviesNew");
            FindIterable<Document> iterable = moviesCollection.find();
            MongoCursor<Document> cursor = iterable.iterator();
            System.out.println("The data in this collection are: ");
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }

        }
    }
}