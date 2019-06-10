/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.PersonFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hassuni
 */
public class Tester {
   
    public static void main(String[] args) {

        Persistence.generateSchema("pu", null);
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
            
        try {
            em.getTransaction().begin();
           //  Oprettelse
           // Par 1
            Person p1 = new Person("gh@yahoo.com", "Lene", "Hansen");
            Person p2 = new Person("kl@yahoo.com", "Dan", "Pedersen");
            
            // par 2
            Person p3 = new Person("min@yahoo.com", "kir", "Johnsen");
            Person p4 = new Person("din@yahoo.com", "Ib", "Jensen");
            
            Hobby h1 = new Hobby("Golf","Motionist niveau");
            Hobby h2 = new Hobby("Badminton","Grøndal Center");
            Hobby h3 = new Hobby("Fodbold","nyt hold");
            Hobby h4 = new Hobby("Skydning","Motionist niveau");
            
            
            Address ad1 = new Address("Århusgade 30", "Hjemmeadress");
            Address ad2 = new Address("viborggade 20", "Hjemmeaddress");
            Address ad3 = new Address("Havnegade 11", "Hjemmeaddress");
            
            CityInfo ci1 = new CityInfo(2100, "København Ø");
            CityInfo ci2 = new CityInfo(2000, "Århus C");
            
            Phone ph1 = new Phone("777", "mobil");
            Phone ph2 = new Phone("888", "mobil");
            Phone ph3 = new Phone("999", "mobil");
            Phone ph4 = new Phone("444", "mobil");
            
         //   Adding
            ad1.setCityInfo(ci1);
            ad2.setCityInfo(ci2);
            ad3.setCityInfo(ci2);

            p1.addPhone(ph1);
            p1.addHobby(h1);
            p1.addHobby(h2);
            p1.setAddress(ad1);

            p2.addPhone(ph2);
            p2.addHobby(h1);
            p2.setAddress(ad1);

            p3.addPhone(ph3);           
            p3.addHobby(h3);
            p3.setAddress(ad2);

            p4.addPhone(ph4);
            p4.addHobby(h4);
            p4.setAddress(ad3);            
            
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
//        //Person p1 = new Person("jh@yahoo.com", "Lone", "Hansen");
//            PersonFacade pf = new PersonFacade();
//           // Hobby res = pf.getHobbyById(2);
//             System.out.println(pf.getPerson("777"));
//           //  System.out.println(pf.getAllPersonsDTO());
                    
        

    }
}

