/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab4.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 *
 * @author Liza
 */
@Entity (name = "FOURTH_HOSPITAL")
public class Hospital implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true, nullable = false)
    private long id;
    private String name;  
    private int wardsNumber;
    
    @ElementCollection
    @CollectionTable(name = "FOURTH_SET", joinColumns = @JoinColumn(name = "SET_ID"))
    @Column(name = "SET_NAME")
    protected Set<String> set = new HashSet<String>();
    
    @ElementCollection
    @CollectionTable(name = "FOURTH_LIST")
    @OrderColumn
    @Column(name = "LIST_NAME")
    protected List<String> list = new ArrayList<>();
    
    @ElementCollection
    @CollectionTable(name = "FOURTH_MAP")
    @MapKeyColumn(name = "MAP_KEY_NAME")
    @Column(name = "MAP_NAME")
    protected Map<String, String> map = new HashMap<>();
    
    @ElementCollection
    @CollectionTable(name = "FOURTH_SET_COMP")
    @AttributeOverride(
            name = "SET_COMP_NAME",
            column = @Column(name = "SET_COMP_ID")
    )
    protected Set<ru.sfedu.hospital2.lab4.model.Hospitalization> hospitalization = new HashSet<>();
    
    @ElementCollection
    @CollectionTable(name = "FOURTH_MAP_COMP")
    @MapKeyColumn(name = "MAP_COMP_KEY_NAME")
    protected Map<String, ru.sfedu.hospital2.lab4.model.Hospitalization> HospitalMap = new HashMap<>();

    public Hospital() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWardsNumber() {
        return wardsNumber;
    }

    public void setWardsNumber(int wardsNumber) {
        this.wardsNumber = wardsNumber;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<Hospitalization> getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Set<Hospitalization> hospitalization) {
        this.hospitalization = hospitalization;
    }

    public Map<String, Hospitalization> getHospitalMap() {
        return HospitalMap;
    }

    public void setHospitalMap(Map<String, Hospitalization> HospitalMap) {
        this.HospitalMap = HospitalMap;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.wardsNumber;
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
        final Hospital other = (Hospital) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.wardsNumber != other.wardsNumber) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hospital{" + "id=" + id + ", name=" + name + ", wardsNumber=" + wardsNumber + '}';
    }

    
}
