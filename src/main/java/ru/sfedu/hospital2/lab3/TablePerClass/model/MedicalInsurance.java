/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab3.TablePerClass.model;

import ru.sfedu.hospital2.lab3.TablePerClass.model.*;
import java.io.Serializable;
import ru.sfedu.hospital2.lab3.TablePerClass.model.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Liza
 */
@Entity(name = "tableperclass_medicalinsurance")
public class MedicalInsurance extends Documents implements Serializable{
    
    private long number;
    
    private int reimbursement;

    public MedicalInsurance() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
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
