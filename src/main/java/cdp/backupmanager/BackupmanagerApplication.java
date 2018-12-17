package cdp.backupmanager;

import cdp.backupmanager.models.JSCHConnectData;
import cdp.backupmanager.services.MongoService;
import cdp.backupmanager.threads.JSCHConnect;
import cdp.backupmanager.utils.CDPUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication
public class BackupmanagerApplication {
    static Executor executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        // Create Master folder if not exists
        CDPUtils.createDirectories();

        // Create the mongo database if not exists
        CDPUtils.createMongoDatabase();

        // Throw Web Service
		SpringApplication.run(BackupmanagerApplication.class, args);

        JSCHConnectData connData = new JSCHConnectData("cristian","Gp$\\93.Cr1sti@n","192.168.0.100");
        JSCHConnect connectThread = new JSCHConnect(connData,"C-Raspberry");

        Thread thread1 = new Thread(connectThread);
        thread1.setName(connectThread.getThreadName());
        executor.execute(thread1);
    }
}