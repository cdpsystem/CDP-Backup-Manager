package cdp.backupmanager.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import java.io.File;
import java.util.function.Consumer;

public class CDPUtils {

    public static boolean createDirectories(){
        String userHome = System.getProperty("user.home");
        String localBackupFolder = userHome + Paths.LOCALPATHBACKUPS;
        return new File(localBackupFolder).mkdirs();
    }

    public static boolean createMongoDatabase() {
        MongoClient mc = new MongoClient();
        MongoDatabase database  = mc.getDatabase(MongoCollections.DATABASE.toString());

        MongoIterable<String> collectionList = database.listCollectionNames();

        for(MongoCollections mcoll : MongoCollections.values()){
            boolean isCreated = true;
            if(!mcoll.equals(MongoCollections.DATABASE.toString())){

                for(String collName : collectionList){
                    if(collName.equals(mcoll.toString())){
                        isCreated = true;
                        break;
                    }
                    isCreated=false;
                }
                if(!isCreated){
                    database.createCollection(mcoll.toString());
                }
            }
        }



        return true;
    }
}
