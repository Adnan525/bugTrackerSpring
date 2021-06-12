package com.work.bugTracker.dataModel;


import javax.persistence.*;

@Table(
        name = "bugs"
)

@Entity
public class BugModel {
    @Id
    private String bugName;
    private String bugDescription;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    private String UID; //user who created the bug
    private String status; // 0 = solved, any other number = active,

    public BugModel() {
    }

    public BugModel(String bugName, String bugDescription, String UID) {
        this.bugName = bugName;
        this.bugDescription = bugDescription;
        this.UID = UID;
        this.status = "active";
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

    public long getLongUID() {
        return Long.parseLong(this.UID);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
