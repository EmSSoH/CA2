/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Hassuni
 */
@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer zip;
    private String city;
    
    

    public CityInfo() {
    }

    public CityInfo(int id, Integer zipCode, String city) {
        this.id = id;
        this.zip = zipCode;
        this.city = city;
    }

    public CityInfo(Integer zipCode, String city) {
        this.zip = zipCode;
        this.city = city;
    }

    

    public Integer getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public void setZipCode(int zipCode) {
        this.zip = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
