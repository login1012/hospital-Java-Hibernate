/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab2.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Liza
 */
@Entity
@Table(name="Test_Entity")
public class TestEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Embedded
    private Address address;
    
        public TestEntity() {}

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

        public String getDescription() {
          return description;
        }

        public void setDescription(String description) {
          this.description = description;
        }
      

        public Address getAddress() {
          return address;
        }

        public void setAddress(Address address) {
          this.address = address;
        }

        @Override
        public String toString() {
          return "TestEntity{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", description='" + description + '\'' +                 
                  ", Address=" + address +
                  '}';
        }

        @Override
        public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          TestEntity that = (TestEntity) o;
          return Objects.equals(getId(), that.getId()) &&
                  Objects.equals(getName(), that.getName()) &&
                  Objects.equals(getDescription(), that.getDescription()) &&
                  Objects.equals(getAddress(), that.getAddress());
        }

        @Override
        public int hashCode() {
          return Objects.hash(getId(), getName(), getDescription(), getAddress());
        }
    
}
