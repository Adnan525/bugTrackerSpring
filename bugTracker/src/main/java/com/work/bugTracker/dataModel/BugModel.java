package com.work.bugTracker.dataModel;

public class BugModel {
    private long bigID;
    private String bugName;
    private String bugDescription;
    private long UID;
    private int status; // 0 = solved, any other number = active,

    public BugModel(long bigID, String bugName, String bugDescription, long UID) {
        this.bigID = bigID;
        this.bugName = bugName;
        this.bugDescription = bugDescription;
        this.UID = UID;
        this.status = -1;
    }

    public long getBigID() {
        return bigID;
    }

    public void setBigID(long bigID) {
        this.bigID = bigID;
    }

    public String getBugName() {
        return bugName;
    }

    public void setBugName(String bugName) {
        this.bugName = bugName;
    }

    public String getBugDescription() {
        return bugDescription;
    }

    public void setBugDescription(String bugDescription) {
        this.bugDescription = bugDescription;
    }

    public long getUID() {
        return UID;
    }

    public void setUID(long UID) {
        this.UID = UID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
