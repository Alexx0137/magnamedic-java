package com.mediatech.magnamedic.servlets.patients;

import com.mediatech.magnamedic.dao.PatientDAO;
import com.mediatech.magnamedic.models.Patient;
import java.sql.Date;

public class Test {

    public static void main(String[] args) {
        // Crear una instancia de PatientDAO
        PatientDAO patientDAO = new PatientDAO();

        // Crear un objeto Patient con los datos del paciente
        Patient patient = new Patient();
        patient.setIdentification("123456789");
        patient.setIdentificationTypeId(1);
        patient.setName("Juan");
        patient.setLastName("Pérez");
        patient.setGenderId(1);
        patient.setDateOfBirth(Date.valueOf("1990-01-01"));
        patient.setAddress("Calle 123");
        patient.setCity("Ciudad");
        patient.setTelephone("1234567890");
        patient.setEmail("juan@example.com");
        patient.setBloodTypeId(1);

        // Llamar al método create(patient) de PatientDAO para insertar el registro
        int insertedRows = patientDAO.create(patient);
        
        // Verificar si la inserción fue exitosa
        if (insertedRows > 0) {
            System.out.println("Registro insertado correctamente en la base de datos.");
        } else {
            System.out.println("Error al insertar el registro en la base de datos.");
        }
    }
}
