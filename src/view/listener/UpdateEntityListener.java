/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listener;

import java.util.EventListener;
import view.event.UpdateEntityEvent;

/**
 *
 * @author Exempel
 */
public interface UpdateEntityListener extends EventListener{
    void updateEntityEventOccurred(UpdateEntityEvent event);
}
