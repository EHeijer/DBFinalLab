package view.listener;

import view.event.AssociateEntityEvent;

import java.util.EventListener;

public interface AssociateEntityListener extends EventListener {
    void associateEntityEventOccurred(AssociateEntityEvent event);

}
