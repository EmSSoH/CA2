/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.PersonFacade;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Hassuni
 */
@Path("person")
public class PersonResource {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    PersonFacade pf = new PersonFacade();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok().entity(gson.toJson(pf.getAllPersonsDTO())).build();
    }

    @GET
    @Path("/allzip")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllZipcodes() {
        return Response.ok().entity(gson.toJson(pf.getAllzipCodes())).build();
    }

    @GET
    @Path("zip/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByZip(@PathParam("zip") Integer zip) {
        List<PersonDTO> persons = pf.getPersonsByZip(zip);

        return Response.ok().entity(gson.toJson(persons)).build();

    }

    @GET
    @Path("city/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByCity(@PathParam("city") String city) {
        List<PersonDTO> persons = pf.getPersonsByCity(city);

        return Response.ok().entity(gson.toJson(persons)).build();

    }

    @GET
    @Path("hobby/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByHobby(@PathParam("hobby") String hobby) {
        List<PersonDTO> persons = pf.getPersonsByHobby(hobby);

        return Response.ok().entity(gson.toJson(persons)).build();

    }

    @GET
    @Path("number/{phoneNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonByPhoneNumber(@PathParam("phoneNumber") String phoneNumber) {
        PersonDTO p = pf.getPerson(phoneNumber);

        return Response.ok().entity(gson.toJson(p)).build();

    }

    @POST
    @Path("postPerson")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPerson(
            @QueryParam("fname") String fname,
            @QueryParam("lname") String lname,
            @QueryParam("email") String email,
            
            @QueryParam("number") String number,
            @QueryParam("numberDesc") String description,
            
            @QueryParam("city") String city,
            @QueryParam("zip") Integer zip,
            
            @QueryParam("street") String street,
            @QueryParam("addinfo") String addinfo,
            
            @QueryParam("hobby") String hobby,
            @QueryParam("hobbyDesc") String hobbyDesc
            
    ) {
        Hobby h = new Hobby(hobby, hobbyDesc);
        Phone ph = new Phone(number, description);
        CityInfo c = new CityInfo(zip, city);
        Address a = new Address(street, addinfo);
        a.setCityInfo(c);
        Person p = new Person(email, fname, lname);
        p.setAddress(a);
        p.addPhone(ph);
        p.addHobby(h);
        
        
        PersonDTO pdto = new PersonDTO(pf.addPerson(p));
        

        return Response.ok().entity(gson.toJson(pdto)).build();

    }
    
    @GET
    @Path("countHobby/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonCountByHobby(@PathParam("hobby") String hobby)
    {
        List<PersonDTO> p = pf.getPersonsByHobby(hobby);
        return Response.ok().entity(gson.toJson(p)).build();
    }
}

