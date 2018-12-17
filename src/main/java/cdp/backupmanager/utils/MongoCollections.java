package cdp.backupmanager.utils;

public enum MongoCollections {
    DATABASE("cdp_backupmanager"),
    SERVERS("servers"),
    BACKUPS("backups");

    private final String text;
    MongoCollections(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
