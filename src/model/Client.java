/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.swing.ImageIcon;

/**
 *
 * @author placideh
 */
@Entity
public class Client implements Serializable{
    @Id
    private String regId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String clientCategory;
    @Lob
    private byte[] photo;

    public Client() {
    }
    public ImageIcon getImage(){
        return new ImageIcon(photo);
    }
    public Client(String regId, String firstName, String lastName, String phoneNumber, String email, String clientCategory, byte[] photo) {
        this.regId = regId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clientCategory = clientCategory;
        this.photo = photo;
    }

    public Client(String regId, String firstName, String lastName, String phoneNumber, String email, String clientCategory) {
        this.regId = regId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clientCategory = clientCategory;
    }
    

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientCategory() {
        return clientCategory;
    }

    public void setClientCategory(String clientCategory) {
        this.clientCategory = clientCategory;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Client{" + "regId=" + regId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", clientCategory=" + clientCategory + ", photo=" + photo + '}';
    }
    
    
    
    
}
