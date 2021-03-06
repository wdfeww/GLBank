
package glbank;

import java.util.Date;

public class Client {
        private int idc;
        private String firstname;
        private String lastname;
        private String email;
        private String street;
        private int housenumber;
        private String postcode;
        private String city;
        private String username;
        private boolean disable;
        private boolean blocked;
        private Date dob;

    public Client(int idc, String firstname, String lastname, Date dob) {
        this.idc = idc;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        
        this.email = null;
        this.street = null;
        this.housenumber = -1;
        this.postcode = null;
        this.username = null;
        this.disable = false;
        this.blocked = false;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public Client(int idc, String firstname, String lastname, String email, String street, int housenumber, String postcode, String city, String username, boolean disable, boolean blocked, Date dob) {
        this.idc = idc;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.street = street;
        this.housenumber = housenumber;
        this.postcode = postcode;
        this.city = city;
        this.username = username;
        this.disable = disable;
        this.blocked = blocked;
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public int getIdc() {
        return idc;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getUsername() {
        return username;
    }

    public boolean isDisable() {
        return disable;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public Date getDob() {
        return dob;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
}