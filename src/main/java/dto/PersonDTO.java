/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hassuni
 */
public class PersonDTO {

    private int id;
    private String email;
    private String fName;
    private String lName;
    private String address;

    private List<String> phones = new ArrayList();
    private List<String> hobbies = new ArrayList();
    
    
   

    public PersonDTO() {
    }

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.email = p.getEmail();
        this.fName = p.getfName();
        this.lName = p.getlName();

        this.phones = p.getPhones();
        this.hobbies = p.getHobbies();
        this.address = p.getAddress();
    }

    public List<String> getPhones() {
        return phones;
    }

    public List<String> getHobbies() {
        return hobbies;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

}
