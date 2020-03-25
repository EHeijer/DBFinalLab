package view.event;

import java.util.EventObject;

public class DeleteEntityEvent extends EventObject {
    private int id;
    private String entityType;

    public DeleteEntityEvent(Object source, int id, String entityType) {
        super(source);
        this.id = id;
        this.entityType = entityType;
    }

    public int getId() {
        return id;
    }

    public String getEntityType() {
        return entityType;
    }
}
