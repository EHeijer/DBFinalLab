package view.listener;

import view.event.ShowAssociatedEntityEvent;

import java.util.EventListener;

public interface ShowAssociatedEntityListener extends EventListener {
    void showAssociatedEntityEventOccurred(ShowAssociatedEntityEvent event);
}
