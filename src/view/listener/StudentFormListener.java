/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.listener;

import view.event.StudentFormEvent;

import java.util.EventListener;

/**
 *
 * @author Exempel
 */
public interface StudentFormListener extends EventListener{
    void studentFormEventOccurred(StudentFormEvent event);
}
