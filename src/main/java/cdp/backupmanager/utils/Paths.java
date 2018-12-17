package cdp.backupmanager.utils;

public enum Paths {

    LOCALPATHBACKUPS("/CDP Backup Manager/backups"),
    PATHBACKUPS("/CDPBackup");

    private final String text;
    Paths(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
