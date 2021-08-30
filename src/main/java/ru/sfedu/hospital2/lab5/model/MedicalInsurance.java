/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5.model;

import ru.sfedu.hospital2.lab3.TablePerClass.model.*;
import ru.sfedu.hospital2.lab3.TablePerClass.model.*;
import java.io.Serializable;
import ru.sfedu.hospital2.lab3.TablePerClass.model.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Liza
 */
@Entity
public class MedicalInsurance extends Documents implements Serializable{
    @Id
    @GeneratedValue(generator = "urlGenerator")
    @GenericGenerator(name = "urlGenerator",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "appointment"))
    long id;
    private long number;
    
    private int reimbursement;
    
    @OneToOne(optional=false)
    @PrimaryKeyJoinColumn
    private Appointment appointment;
     
    public MedicalInsurance() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public ru.sfedu.hospital2.lab5.model.Appointment getAppointment() {
        return appointment;
    }

    @Override
    public void setAppointment(ru.sfedu.hospital2.lab5.model.Appointment appointment) {
        this.appointment = appointment;
    }
    
    
    
    public int getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(int reimbursement) {
        this.reimbursement = reimbursement;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MedicalInsurance other = (MedicalInsurance) obj;
        if (this.number != other.number) {
            return false;
        }
        if (this.reimbursement != other.reimbursement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MedicalInsurance{" + "number=" + number + ", reimbursement=" + reimbursement + '}';
    }
    
}
