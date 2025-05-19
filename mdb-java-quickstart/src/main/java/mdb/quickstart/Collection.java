package mdb.quickstart;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Collection {

    public static void main(String[] args) {
        // Connection string using SCRAM-SHA
        String connectionString = System.getProperty("mongodb.uri");

        try (MongoClient mongoClient = MongoClients.create(new ConnectionString(connectionString))) {
            // Select the database
            MongoDatabase database = mongoClient.getDatabase("security");

            // Select the collection
            MongoCollection<Document> collection = database.getCollection("users");

            // List all documents in the collection
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Documents in the collection:");
            for (Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
