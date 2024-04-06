package com.mediatech.magnamedic.servlets.patients;

import com.mediatech.magnamedic.dao.PatientDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patients/delete")
public class DeletePatientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int rowsAffected = new PatientDAO().delete(id);
            
            if (rowsAffected > 0) {
                response.sendRedirect(request.getContextPath() + "/patients");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el paciente");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El ID del paciente es inválido");
        }
    }
}