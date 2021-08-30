/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Liza
 */

@Entity(name = "patient")
public class Patient extends Person implements Serializable{

    private String passport;
    private String allergy;
            
    /*@OneToOne(mappedBy="patient", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Survey survey; */
    
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

    /*public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }*/
    
    
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
