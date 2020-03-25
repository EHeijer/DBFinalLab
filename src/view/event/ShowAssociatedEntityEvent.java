package view.event;

import java.util.EventObject;

public class ShowAssociatedEntityEvent extends EventObject {
    private int id;
    private String entityType;
    private String targetEntityType;

    public ShowAssociatedEntityEvent(Object source, int id, String entityType, String targetEntityType) {
        super(source);
        this.id = id;
        this.entityType = entityType;
        this.targetEntityType = targetEntityType;
    }

    public int getId() {
        return id;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getTargetEntityType() {
        return targetEntityType;
    }
}
