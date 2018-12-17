package cdp.backupmanager.services;

import cdp.backupmanager.models.JSCHConnectData;
import cdp.backupmanager.utils.MongoCollections;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import xyz.morphia.Datastore;
import xyz.morphia.Morphia;

import java.util.List;

public class MongoService {
    MongoClient mc;
    MongoDatabase database;
    final Morphia morphia  = new Morphia();


    public MongoService(){
        this.mc = new MongoClient();
        morphia.mapPackage("cdp.backupmanager.models");
    }

    public List<JSCHConnectData> getServers(){
        Datastore datastore = morphia.createDatastore(mc,MongoCollections.DATABASE.toString());
        return datastore.find(JSCHConnectData.class).asList();
    }

    public void saveServer(JSCHConnectData connData){
        Datastore datastore = morphia.createDatastore(mc,MongoCollections.DATABASE.toString());
        datastore.save(connData);
    }



}
