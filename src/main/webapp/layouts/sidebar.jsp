<%-- 
    Document   : sidebar
    Created on : 4 abr. 2024, 8:41:10
    Author     : alexx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <div id="wrapper">
        <div class="sidebar">
            <div class="logo">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/images/magnamedic_gray.png" alt="Logo de Mi Empresa">
                </a>
                <hr>
            </div>
            <ul>
                <li>
                    <i class="fas fa-fw fa-home"></i>
                    <a href="#"><span>Inicio</span></a>
                </li>
                <hr>

                <li>
                    <i class="fas fa-fw fa-calendar"></i>
                    <a href="#"><span>Citas médicas</span></a>
                </li>
                <li>
                    <i class="fas fa-fw fa-users"></i>
                    <a href="${pageContext.request.contextPath}/patients/list"><span>Pacientes</span></a>
                </li>
                <hr>

                <li>
                    <i class="fas fa-fw fa-stethoscope"></i>
                    <a href="#"><span>Médicos</span></a>
                </li>
                <li>
                    <i class="fas fa-fw fa-kit-medical"></i>
                    <a href="#"><span>Especialidades médicas</span></a>
                </li>
                <hr>

                <li>
                    <i class="fas fa-fw fa-chart-area"></i>
                    <a href="#"><span>Reportes</span></a>
                </li>
            </ul>
        </div>

