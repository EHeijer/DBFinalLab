package view.listener;

import view.event.DeleteEntityEvent;

import java.util.EventListener;

public interface DeleteEntityListener extends EventListener {
    void deleteEntityEventOccurred(DeleteEntityEvent event);
}
