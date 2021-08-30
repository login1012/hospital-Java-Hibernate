/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab5.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Liza
 */
@Entity
public class Payment extends Documents implements Serializable{
    @Id
    @GeneratedValue(generator = "urlGenerator")
    @GenericGenerator(name = "urlGenerator",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "appointment"))
    long id;
    @Column(nullable=false)
    private long number;
    @Column(nullable=false)
    private int price;
    
    @OneToOne(optional=false)
    @PrimaryKeyJoinColumn
    private Appointment appointment;
     
    public Payment() {
    }

    @Override
    public Appointment getAppointment() {
        return appointment;
    }

    @Override
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        final Payment other = (Payment) obj;
        if (this.number != other.number) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Payment{" + "number=" + number + ", price=" + price + '}';
    }
    
    
}
