package view.event;

import java.util.EventObject;

public class UpdateEntityEvent extends EventObject {
    private int id;
    private String newName;
    private String entityType;
    
    public UpdateEntityEvent(Object source, int id, String newName, String entityType) {
        super(source);
        this.id = id;
        this.newName = newName;
        this.entityType = entityType;
    }

    public int getId() {
        return id;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getNewName() {
        return newName;
    }
}
