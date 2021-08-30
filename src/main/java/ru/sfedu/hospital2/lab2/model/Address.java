/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.hospital2.lab2.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 *
 * @author Liza
 */
@Embeddable
public class Address {
  @Column(name = "city", nullable = false)
  private String city;
  @Column(name = "district", nullable = false)
  private String district;
  @Column(name = "region", nullable = false)
  private String region;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return Objects.equals(getCity(), address.getCity()) &&
            Objects.equals(getDistrict(), address.getDistrict()) &&
            Objects.equals(getRegion(), address.getRegion());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCity(), getDistrict(), getRegion());
  }

  @Override
  public String toString() {
    return "Address{" +
            "city='" + city + '\'' +
            ", district='" + district + '\'' +
            ", region='" + region + '\'' +
            '}';
  }
};