package com.mediatech.magnamedic.dao;

import com.mediatech.magnamedic.jdbc.Conexion;
import com.mediatech.magnamedic.models.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM patients";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM patients WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO patients(identification, identification_type_id, name, last_name, gender_id, date_of_birth, address, city, telephone, email, blood_type_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE patients SET identification=?, identification_type_id=?, name=?, last_name=?, gender_id=?, date_of_birth=?, address=?, city=?, telephone=?, email=?, blood_type_id=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM patients WHERE id=?";

    /**
     * Recupera todos los pacientes de la base de datos.
     *
     * @return Lista de objetos Patient que representan a los pacientes
     * recuperados.
     */
    public List<Patient> getAllPatients() {
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

    /**
     * Busca un paciente por su ID en la base de datos.
     * @param id El ID del paciente a buscar.
     * @return El objeto Patient correspondiente al paciente encontrado, o null si no se encuentra ningún paciente con el ID especificado.
     */
    public Patient getPatientById(int id) {
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

    /**
     * Crea un nuevo paciente en la base de datos.
     * @param patient El objeto Patient que representa al paciente a crear.
     * @return El número de filas afectadas en la base de datos (normalmente 1 si la operación fue exitosa, 0 si falló).
     */
    public int insertPatient(Patient patient) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_INSERT)) {
            setPatientParams(st, patient, false);
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    
    /**
     * Actualiza un paciente existente en la base de datos.
     * @param patient El objeto Patient que representa al paciente a actualizar.
     * @return El número de filas afectadas en la base de datos (normalmente 1 si la operación fue exitosa, 0 si falló).
     */
    public int updatePatient(Patient patient) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_UPDATE)) {
            setPatientParams(st, patient, true);
            st.setInt(12, patient.getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Elimina un paciente de la base de datos por su ID.
     * @param id El ID del paciente a eliminar.
     * @return El número de filas afectadas en la base de datos (normalmente 1 si la operación fue exitosa, 0 si falló).
     */
    public int deletePatientById(int id) {
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement st = con.prepareStatement(SQL_DELETE)) {
            st.setInt(1, id);
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    // Métodos auxiliares privados
    
    /**
     * Mapea un ResultSet a un objeto Patient.
     * @param rs El ResultSet que contiene los datos del paciente.
     * @return El objeto Patient mapeado a partir del ResultSet.
     * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
     */
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

    /**
     * Establece los parámetros de un PreparedStatement para la inserción o actualización de un paciente.
     * @param st El PreparedStatement al que se le establecerán los parámetros.
     * @param patient El objeto Patient que contiene los datos a ser insertados o actualizados.
     * @param isUpdate Indica si se está realizando una operación de actualización (true) o inserción (false).
     * @throws SQLException Si ocurre un error al establecer los parámetros en el PreparedStatement.
     */
    private void setPatientParams(PreparedStatement st, Patient patient, boolean isUpdate) throws SQLException {
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
        if (isUpdate) {
            st.setInt(12, patient.getId());
        }
    }
}
