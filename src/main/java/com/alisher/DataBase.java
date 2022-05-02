package com.alisher;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class DataBase {
    private MongoClient client;
    private MongoDatabase db;

    public DataBase(){
        try {
            this.client = new MongoClient("localhost", 27017);
            db = client.getDatabase("dev-data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printDatabases(){
        try{
            System.out.println("All the available databases:");
            for(String name : client.listDatabaseNames()){
                System.out.print(name + " ");
            }
            System.out.println();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void createCollection(String name){
        db.createCollection(name);
    }

    public MongoCollection<Document> getCollection(String name){
        return db.getCollection(name);
    }

    public void printCollections(){
        try{
            System.out.println("All the available collections for the current database:");
            for(String name : db.listCollectionNames()){
                System.out.print(name + " ");
            }
            System.out.println();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}
