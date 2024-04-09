package com.mediatech.magnamedic.servlets.patients;

import com.mediatech.magnamedic.dao.PatientDAO;
import com.mediatech.magnamedic.models.Patient;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patients/form")
public class CreatePatientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/patients/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = request.getParameter(paramName);
                System.out.println(paramName + " : " + paramValue);
            }

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
            int  bloodTypeId = Integer.parseInt(request.getParameter("bloodTypeId"));          

            Patient patient = new Patient(0, identification, identificationTypeId, name, lastName, genderId, dateOfBirth, address, city, telephone, email, bloodTypeId, null);
            int rowsAffected = new PatientDAO().insertPatient(patient);

            if (rowsAffected > 0) {
                response.sendRedirect(request.getContextPath() + "/patients/list");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al crear el paciente");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error de formato en un número: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error en los datos del paciente: " + e.getMessage());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error desconocido al crear el paciente: " + e.getMessage());
        }
    }
}
