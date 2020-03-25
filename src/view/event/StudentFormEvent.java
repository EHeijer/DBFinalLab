/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.event;

import java.time.LocalDate;
import java.util.EventObject;


public class StudentFormEvent extends EventObject{
    private String name;
    private LocalDate birthDate;
    
    public StudentFormEvent(Object source, String name, LocalDate birthDate) {
        super(source);
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    
}
