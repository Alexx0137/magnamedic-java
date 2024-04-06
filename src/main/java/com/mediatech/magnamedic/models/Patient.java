package com.mediatech.magnamedic.models;

import java.sql.Date;

public class Patient {

    private int id;
    private String identification;
    private int identificationTypeId;
    private String name;
    private String lastName;
    private int genderId;
    private Date dateOfBirth;
    private String address;
    private String city;
    private String telephone;
    private String email;
    private int bloodTypeId;
    private Date createdAt;

    public Patient(int id) {
        this.id = id;
    }

    public Patient() {
    }

    public Patient(int id, String identification, int identificationTypeId, String name, String lastName, int genderId, Date dateOfBirth, String address, String city, String telephone, String email, int bloodTypeId, Date createdAt) {
        this.id = id;
        this.identification = identification;
        this.identificationTypeId = identificationTypeId;
        this.name = name;
        this.lastName = lastName;
        this.genderId = genderId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.email = email;
        this.bloodTypeId = bloodTypeId;
        this.createdAt = createdAt;
    }    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public int getIdentificationTypeId() {
        return identificationTypeId;
    }

    public void setIdentificationTypeId(int identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
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

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public int getBloodTypeId() {
        return bloodTypeId;
    }

    public void setBloodTypeId(int bloodTypeId) {
        this.bloodTypeId = bloodTypeId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", identification=" + identification + ", identificationTypeId=" + identificationTypeId + ", name=" + name + ", lastName=" + lastName + ", genderId=" + genderId + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", city=" + city + ", telephone=" + telephone + ", email=" + email + ", bloodTypeId=" + bloodTypeId + ", createdAt=" + createdAt + '}';
    }

}