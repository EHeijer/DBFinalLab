package view.listener;

import view.event.ListEntityEvent;
import java.util.EventListener;

// Rikards version

public interface ListEntityListener extends EventListener {
    void listEntityEventOccurred(ListEntityEvent event);
}
