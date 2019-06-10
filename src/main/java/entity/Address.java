/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Hassuni
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String additionalInfo;

    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CityInfo cityInfo;
    
    
    public Address() {
    }

    public Address(int id, String street, String additionalInfo) {
        this.id = id;
        this.street = street;
        this.additionalInfo = additionalInfo;
    }

    public Address(String street, String additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
    }

   
    public String getStreet() {
        return street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCityInfo(CityInfo ci){
        this.cityInfo = ci;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }
    
}
