package com.mediatech.magnamedic.models;

import java.sql.Date;

public class Doctor {

    private int id;
    private int identification;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String telephone;
     private String email;
    private String especiality;
    private String professionalCard;   

    public Doctor(int id) {
        this.id = id;
    }

    public Doctor(int id, int identification, String name, String lastName, Date dateOfBirth, String address, String telephone, String email, String especiality, String professionalCard) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.especiality = especiality;
        this.professionalCard = professionalCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
    }

    public String getProfessionalCard() {
        return professionalCard;
    }

    public void setProfessionalCard(String professionalCard) {
        this.professionalCard = professionalCard;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", identification=" + identification + ", name=" + name + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", telephone=" + telephone + ", email=" + email + ", especiality=" + especiality + ", professionalCard=" + professionalCard + '}';
    }
   

}
