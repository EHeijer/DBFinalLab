package view.event;

import java.util.EventObject;

public class AssociateEntityEvent extends EventObject {
    private int currentId;
    private int otherId;
    private boolean isCourse;
    private String entityType;

    public AssociateEntityEvent(Object source, int currentId, int otherId, boolean isCourse, String entityType) {
        super(source);
        this.currentId = currentId;
        this.otherId = otherId;
        this.isCourse = isCourse;
        this.entityType = entityType;
    }

    public int getCurrentId() {

        return currentId;
    }

    public int getOtherId() {
        return otherId;
    }

    public boolean isCourse() {
        return isCourse;
    }

    public String getEntityType() {
        return entityType;
    }
}
