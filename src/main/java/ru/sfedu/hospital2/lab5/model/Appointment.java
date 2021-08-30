/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Liza
 */
@Entity(name = "appointment")
public class Appointment extends Service implements Serializable{
    
    /*@OneToOne(optional=false)
    @JoinColumn(name="doctor")
    private Employee doctor;*/
       
    private String specialization;

          
    @OneToMany(mappedBy = "appointment", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Diagnosis> diagnosis = new HashSet<>();

    @OneToOne(mappedBy = "appointment", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Payment payment;
    
    @OneToOne(mappedBy = "appointment", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private MedicalInsurance medicalInsurance;
     
    public Appointment() {
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
      
    public Set<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Set<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public MedicalInsurance getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(MedicalInsurance medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
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
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.specialization, other.specialization)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Appointment{" + "specialization=" + specialization + '}';
    }
    
    
    
    
    
}
