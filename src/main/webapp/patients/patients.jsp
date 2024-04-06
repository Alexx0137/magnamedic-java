<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tu aplicación médica</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
              rel="stylesheet">
        <link href="../css/styles.css" rel="stylesheet">
    </head>
    <%@include file="../layouts/sidebar.jsp" %>
    <%@include file="../layouts/topbar.jsp" %>

    <main>
        <!-- inicio contenido principal -->
        <div class="container-fluid">

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <div class="d-sm-flex align-items-center justify-content-between mb-2">
                        <h2>Pacientes</h2>
                        <a href="${pageContext.request.contextPath}/patients/form" class="btn btn-primary btn-sm btn-icon-split">
                            <i class="fas fa-plus fa-sm"></i>
                            Crear paciente
                        </a>
                    </div>
                </div>

                <div class="card-body">

                    <div class="search-container">
                        <input type="text" class="search-input" placeholder="Buscar...">
                        <button class="search-button">Buscar</button>
                    </div>
                    <div class="table-responsive">
                        <table class="styled-table" id="patientsTable">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Documento</th>
                                    <th>Nombres</th>
                                    <th style="width: 100px;">Correo</th>
                                    <th>Dirección</th>
                                    <th>Teléfono</th>
                                    <th>Fecha Registro</th>
                                    <th style="width: 120px;">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="patient" items="${patients}">
                                    <tr>
                                        <td>${patient.id}</td>
                                        <td>${patient.identification}</td>
                                        <td>${patient.name} ${patient.lastName}</td>
                                        <td>${patient.email}</td>
                                        <td>${patient.address}</td>
                                        <td>${patient.telephone}</td>
                                        <td>${patient.createdAt}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/patients/form/${patient.id}" class="btn btn-warning btn-sm" title="Editar">
                                                <i class="fas fa-edit fa-lg fa-lg"></i>
                                            </a>
                                            <a href="#" class="btn btn-danger btn-sm" title="Eliminar">
                                                <i class="fas fa-trash fa-lg fa-lg"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <%@include file="../layouts/footer.jsp" %>

    <!-- Agregar el script JavaScript aquí -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $.getJSON('${pageContext.request.contextPath}/patients/list', function (data) {
                // Procesar la respuesta JSON y mostrarla en la página
                // Por ejemplo, podrías construir una tabla HTML con los datos de los pacientes
                // y luego agregarla al DOM
            });
        });
    </script>
</html>
