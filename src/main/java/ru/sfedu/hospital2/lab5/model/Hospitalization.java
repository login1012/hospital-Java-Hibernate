/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import ru.sfedu.hospital2.enums.HospitalizationStatus;


/**
 *
 * @author Liza
 */
@Entity
public class Hospitalization extends Documents implements Serializable{
    @Id
    private long id;
    private int ward;
    @Enumerated
    private HospitalizationStatus status;
    
    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @PrimaryKeyJoinColumn
    private Appointment appointment;
    
     @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Hospital_Hospitalization", 
            joinColumns = @JoinColumn(name = "Hospital_Id"),
            inverseJoinColumns = @JoinColumn(name = "Hospitalization_Id"))
    private List<Hospital> hospital = new ArrayList<>();
    
    
    public Hospitalization() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public ru.sfedu.hospital2.lab5.model.Appointment getAppointment() {
        return appointment;
    }

    @Override
    public void setAppointment(ru.sfedu.hospital2.lab5.model.Appointment appointment) {
        this.appointment = appointment;
    }
    
    
    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public HospitalizationStatus getStatus() {
        return status;
    }

    public void setStatus(HospitalizationStatus status) {
        this.status = status;
    }

    public List<Hospital> getHospital() {
        return hospital;
    }

    public void setHospital(List<Hospital> hospital) {
        this.hospital = hospital;
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
        final Hospitalization other = (Hospitalization) obj;
        if (this.ward != other.ward) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hospitalization{" + ", ward=" + ward + ", status=" + status + '}';
    }

    
    
    
}
