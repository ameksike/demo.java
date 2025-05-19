package mdb.quickstart;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Connection {

    public static void main(String[] args) {
        String connectionString = System.getProperty("mongodb.uri");
        System.out.println("------------------------------------------------------");
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
        System.out.println("------------------------------------------------------");
    }
}
