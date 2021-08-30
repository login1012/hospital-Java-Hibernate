/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab3.MappedSuperClass.model;

import java.io.Serializable;
import ru.sfedu.hospital2.lab3.MappedSuperClass.model.*;
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
@Entity(name = "mapped_survey")
public class Survey extends Service implements Serializable{
    @Column (nullable = false)
    private String type;
    private String report;

    public Survey() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Survey other = (Survey) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.report, other.report)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Survey{" + "type=" + type + ", report=" + report + '}';
    }
}
