package com.mediatech.magnamedic.dao;

import com.mediatech.magnamedic.jdbc.Conexion;
import com.mediatech.magnamedic.models.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM patients";
    private static final String SQL_SELECT_BY_ID = "SELECT * WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO patients(identification, identification_type_id, name, last_name, gender_id, date_of_birth, address, city, telephone, email, blood_type_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE patients SET identification=?, identification_type_id=?, name=?, last_name=?,gender_id=?, date_of_birth=?, address=?, city=?, telephone=?, email=?, blood_type_id=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM patients WHERE id=?";

    public List<Patient> fetch() {
        List<Patient> patients = new ArrayList<>();
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_SELECT_ALL); ResultSet rs = st.executeQuery()) {
            System.out.println("Conexión establecida correctamente.");
            while (rs.next()) {
                patients.add(mapResultSetToPatient(rs));
            }
            System.out.println("Datos de pacientes recuperados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public Patient search(int id) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_SELECT_BY_ID)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPatient(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int create(Patient patient) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_INSERT)) {
            setPatientParams(st, patient);
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Patient patient) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_UPDATE)) {
            setPatientParams(st, patient);
            st.setInt(10, patient.getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int id) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_DELETE)) {
            st.setInt(1, id);
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private Patient mapResultSetToPatient(ResultSet rs) throws SQLException {
        return new Patient(
                rs.getInt("id"),
                rs.getString("identification"),
                rs.getInt("identification_type_id"),
                rs.getString("name"),
                rs.getString("last_name"),
                rs.getInt("gender_id"),
                rs.getDate("date_of_birth"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("telephone"),
                rs.getString("email"),
                rs.getInt("blood_type_id"),
                rs.getDate("created_at")
        );

    }

    private void setPatientParams(PreparedStatement st, Patient patient) throws SQLException {
        st.setString(1, patient.getIdentification());
        st.setInt(2, patient.getIdentificationTypeId());
        st.setString(3, patient.getName());
        st.setString(4, patient.getLastName());
        st.setInt(5, patient.getGenderId());
        st.setDate(6, patient.getDateOfBirth());
        st.setString(7, patient.getAddress());
        st.setString(8, patient.getCity());
        st.setString(9, patient.getTelephone());
        st.setString(10, patient.getEmail());
        st.setInt(11, patient.getBloodTypeId());        
    }
}
