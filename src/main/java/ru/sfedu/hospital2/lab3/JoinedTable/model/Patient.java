/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab3.JoinedTable.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Liza
 */

@Entity(name = "joined_patient")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient extends Person{
    @Column(nullable = false)
    private String passport;
    private String allergy;

    public Patient() {
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Patient other = (Patient) obj;
        if (this.passport != other.passport) {
            return false;
        }
        if (!Objects.equals(this.allergy, other.allergy)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "passport=" + passport + ", allergy=" + allergy + '}';
    }
    
    
}
