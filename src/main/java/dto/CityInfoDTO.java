/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.CityInfo;

/**
 *
 * @author Hassuni
 */
public class CityInfoDTO
{

    private int id;
    private Integer zip;
    private String city;

    public CityInfoDTO()
    {

    }

    public CityInfoDTO(CityInfo c)
    {
        this.id = c.getId();
        this.zip = c.getZip();
        this.city = c.getCity();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Integer getZip()
    {
        return zip;
    }

    public void setZip(Integer zip)
    {
        this.zip = zip;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

}
