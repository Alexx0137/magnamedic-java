package com.mediatech.magnamedic.dao;

import com.mediatech.magnamedic.jdbc.Conexion;
import com.mediatech.magnamedic.models.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private static final String SQL_SELECT_ALL = "SELECT id, identification, name, last_name, date_of_birth, address, telephone, email, especiality, professional_card FROM doctors";
    private static final String SQL_SELECT_BY_ID = "SELECT id, identification, name, last_name, date_of_birth, address, telephone, email, especiality, professional_card FROM doctors WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO doctors(identification, name, last_name, date_of_birth, address, telephone, email, especiality, professional_card) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE doctors SET identification=?, name=?, last_name=?, date_of_birth=?, address=?, telephone=?, email=?, especiality=?, professional_card=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM doctors WHERE id=?";

    public List<Doctor> fetch() {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_SELECT_ALL); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                doctors.add(mapResultSetToDoctor(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public Doctor search(int id) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_SELECT_BY_ID)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDoctor(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int create(Doctor doctor) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_INSERT)) {
            setDoctorParams(st, doctor);
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Doctor doctor) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_UPDATE)) {
            setDoctorParams(st, doctor);
            st.setInt(10, doctor.getId());
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

    private Doctor mapResultSetToDoctor(ResultSet rs) throws SQLException {
        return new Doctor(
                rs.getInt("id"),
                rs.getInt("identification"),
                rs.getString("name"),
                rs.getString("last_name"),
                rs.getDate("date_of_birth"),
                rs.getString("address"),
                rs.getString("telephone"),
                rs.getString("email"),
                rs.getString("especiality"),
                rs.getString("professional_card")  
    
        );
    }

    private void setDoctorParams(PreparedStatement st, Doctor doctor) throws SQLException {
        st.setInt(1, doctor.getIdentification());
        st.setString(2, doctor.getName());
        st.setString(3, doctor.getLastName());
        st.setDate(5, doctor.getDateOfBirth());
        st.setString(6, doctor.getAddress());
        st.setString(7, doctor.getTelephone());
        st.setString(8, doctor.getEmail());
        st.setString(9, doctor.getEspeciality());
        st.setString(10, doctor.getProfessionalCard());
    }
}

