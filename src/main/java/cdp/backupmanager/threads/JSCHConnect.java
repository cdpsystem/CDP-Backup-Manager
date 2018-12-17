package cdp.backupmanager.threads;

import cdp.backupmanager.models.JSCHConnectData;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSCHConnect implements Runnable {

    private String threadName=null;

    private JSCHConnectData connData;
    private JSch jsch = new JSch();

    private Session session;
    private java.util.Properties config = new java.util.Properties();

    private Logger logger = LoggerFactory.getLogger(JSCHConnect.class);

    public JSCHConnect(JSCHConnectData connData){
        this.connData = connData;
    }

    public JSCHConnect(JSCHConnectData connData,String threadName) {
        this.connData = connData;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            // Set data for connection
            session = jsch.getSession(connData.getUser(),connData.getHost(),connData.getPort());
            session.setPassword(connData.getPassword());

            // Disable RSA Checking
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect(30000);
            if(session.isConnected()){
                logger.info("Connection with -> " + connData.getUser() + "@"+connData.getHost() + ":" + connData.getPort());
            }

        } catch (JSchException e) {
            e.printStackTrace();
        }
        logger.info("Endend with -> " + connData.getUser() + "@"+connData.getHost() + ":" + connData.getPort());


    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
