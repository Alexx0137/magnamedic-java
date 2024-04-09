package com.mediatech.magnamedic.servlets.patients;

import com.mediatech.magnamedic.dao.PatientDAO;
import com.mediatech.magnamedic.models.Patient;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patients/form/*")
public class UpdatePatientServlet extends HttpServlet {

    private PatientDAO patientDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        patientDAO = new PatientDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] urlParts = request.getPathInfo().split("/");
        if (urlParts.length > 1) {
            try {
                int patientId = Integer.parseInt(urlParts[1]);
                Patient patient = patientDAO.getPatientById(patientId); 
                if (patient != null) {
                    request.setAttribute("patient", patient);
                    request.getRequestDispatcher("/patients/form.jsp").forward(request, response);
                } else {
                    System.out.println("Patient not found");
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Paciente no encontrado");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de paciente inválido");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "URL inválida");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String identification = request.getParameter("identification");
        int identificationTypeId = Integer.parseInt(request.getParameter("identificationTypeId"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        int genderId = Integer.parseInt(request.getParameter("genderId"));
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        int bloodTypeId = Integer.parseInt(request.getParameter("bloodTypeId"));

        // Obtener el paciente actual de la base de datos
        Patient existingPatient = patientDAO.getPatientById(id);
        if (existingPatient == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Paciente no encontrado");
            return;
        }

        // Establecer los nuevos valores en el paciente existente
        existingPatient.setIdentification(identification);
        existingPatient.setIdentificationTypeId(identificationTypeId);
        existingPatient.setName(name);
        existingPatient.setLastName(lastName);
        existingPatient.setGenderId(genderId);
        existingPatient.setDateOfBirth(dateOfBirth);
        existingPatient.setAddress(address);
        existingPatient.setCity(city);
        existingPatient.setTelephone(telephone);
        existingPatient.setEmail(email);
        existingPatient.setBloodTypeId(bloodTypeId);
        
        System.out.println(existingPatient);

        // Actualizar el paciente en la base de datos
        int rowsAffected = patientDAO.updatePatient(existingPatient);

        // Redirigir de vuelta a la lista de pacientes
        if (rowsAffected > 0) {
            response.sendRedirect(request.getContextPath() + "/patients/list");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el paciente");
        }
    }
}
