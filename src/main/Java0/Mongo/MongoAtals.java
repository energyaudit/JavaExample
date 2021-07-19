package main.Java0.Mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;

public class MongoAtals {
    public static void main(String[] args) {
        try {
        System.setProperty("jdk.tls.trustNameService","true");
//        ConnectionString connectionString = new ConnectionString("mongodb+srv://billy:Ruby2020@cluster0.knh9x.mongodb.net/moviesDB?retryWrites=true&w=majority");
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//        MongoClient mongoClient = MongoClients.create(settings);
            MongoClient mongoClient = MongoClients.create("mongodb+srv://billy:Ruby2020@cluster0.knh9x.mongodb.net/moviesDB?retryWrites=true&w=majority");
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
        } catch (Error e) {
            System.out.println(e.getMessage());
        }

    }

}
