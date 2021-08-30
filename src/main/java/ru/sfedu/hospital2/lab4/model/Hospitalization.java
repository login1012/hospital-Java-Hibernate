/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab4.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import ru.sfedu.hospital2.enums.HospitalizationStatus;


/**
 *
 * @author Liza
 */
@Embeddable
public class Hospitalization extends Documents implements Serializable{
    private long hospitalId;
    @Column(name = "WARD")
    private int ward;
    @Column(name = "STATUS")
    private HospitalizationStatus status;  
    
    
    public Hospitalization() {
    }

    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId) {
        this.hospitalId = hospitalId;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.hospitalId ^ (this.hospitalId >>> 32));
        hash = 41 * hash + this.ward;
        hash = 41 * hash + Objects.hashCode(this.status);
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
        if (this.hospitalId != other.hospitalId) {
            return false;
        }
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
        return "Hospitalization{" + "hospitalId=" + hospitalId + ", ward=" + ward + ", status=" + status + '}';
    }

    
    
    
}
