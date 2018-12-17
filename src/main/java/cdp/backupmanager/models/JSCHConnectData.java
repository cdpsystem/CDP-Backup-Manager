package cdp.backupmanager.models;
import org.bson.types.ObjectId;
import xyz.morphia.annotations.*;

@Entity("servers")
public class JSCHConnectData {

    @Id
    private ObjectId id;

    private String user;
    private String password;
    private String host;
    private int port;

    public JSCHConnectData() {
    }

    public JSCHConnectData(String user, String password) {
        this.user = user;
        this.password = password;
        this.host = "127.0.0.1";
        this.port = 22;
    }

    public JSCHConnectData(String user, String password, String host) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = 22;
    }

    public JSCHConnectData(String user, String password, String host, int port) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public JSCHConnectData(ObjectId id, String user, String password, String host, int port) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
