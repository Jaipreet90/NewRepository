/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author trilok.sharma
 */
public class Player {
    private int PID;
    private String name=null;
    private String address=null;
    private String city=null;
    private String province=null;
    private String postalcode=null;
    private String division=null;

    public Player(String name,String address,String city,String province,String postalcode) {
       
        this.name = name;
        this.address=address;
        this.city=city;
        this.province=province;
        this.postalcode=postalcode;
    }

    public Player(Player player,League l,String division) {
        this.division=division;//To change body of generated methods, choose Tools | Templates.
    }

    

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    

    
}
