package com.work.bugTracker.dataModel;


import javax.persistence.*;

@Table(
        name = "bugs"
)

@Entity
public class BugModel {

    @Id //specifying bugID is primary key
    //generating id for bugID
    @SequenceGenerator(
            name = "bugID_sequence",
            sequenceName = "bugID_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bugID_sequence"

    )
    @Column(
            updatable = false,
            nullable = false
    )
    private Long bugID; //pk
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String bugName;
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String bugDescription;
    private long UID; //user who created the bug
    @Column(
            nullable = false
    )
    private int status; // 0 = solved, any other number = active,

    public BugModel(String bugName, String bugDescription, long UID) {
        this.bugName = bugName;
        this.bugDescription = bugDescription;
        this.UID = UID;
        this.status = -1;
    }

    public BugModel(long bugID, String bugName, String bugDescription, long UID) {
        this.bugID = bugID;
        this.bugName = bugName;
        this.bugDescription = bugDescription;
        this.UID = UID;
        this.status = -1;
    }

    public long getBigID() {
        return bugID;
    }

    public void setBigID(long bigID) {
        this.bugID = bigID;
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
