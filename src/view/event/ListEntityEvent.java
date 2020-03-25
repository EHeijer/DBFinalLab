package view.event;

import java.util.EventObject;

// Rikards version

public class ListEntityEvent extends EventObject {
    private int modelTypeIndex;

    public ListEntityEvent(Object source, int modelTypeIndex) {
        super(source);
        this.modelTypeIndex = modelTypeIndex;
    }

    public int getModelTypeIndex() {
        return modelTypeIndex;
    }
}
