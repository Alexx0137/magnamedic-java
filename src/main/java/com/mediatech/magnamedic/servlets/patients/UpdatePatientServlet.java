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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] urlParts = request.getPathInfo().split("/");
        if (urlParts.length > 1) {
            try {
                int patientId = Integer.parseInt(urlParts[1]);
                Patient patient = patientDAO.search(patientId); // Recuperar el paciente de la base de datos
                if (patient != null) {
                    request.setAttribute("patient", patient); // Agregar el paciente al request
                    request.getRequestDispatcher("/patients/form.jsp").forward(request, response); // Redirigir al formulario de edición
                } else {
                    System.out.println("Patient not found"); // Mensaje de depuración
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
        int identification = Integer.parseInt(request.getParameter("identification"));
        int identificationTypeId = Integer.parseInt(request.getParameter("identification_type_id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("last_name");
        int genderId = Integer.parseInt(request.getParameter("gender_id"));
        Date dateOfBirth = Date.valueOf(request.getParameter("date_of_birth"));
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        int bloodTypeId = Integer.parseInt(request.getParameter("blood_type_id"));

        // Crear un objeto Patient con los datos actualizados
        Patient patient = new Patient(id);

        // Actualizar el paciente en la base de datos
        int rowsAffected = patientDAO.update(patient);

        // Redirigir de vuelta a la lista de pacientes
        if (rowsAffected > 0) {
            response.sendRedirect(request.getContextPath() + "/patients");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el paciente");
        }
    }
}
