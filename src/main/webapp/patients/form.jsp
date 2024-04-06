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
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">

        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    </head>
    <%@include file="../layouts/sidebar.jsp" %>
    <%@include file="../layouts/topbar.jsp" %>

    <main>
        <!-- inicio contenido principal -->
        <div class="container-fluid">                         

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h2>${empty patient ? 'Crear paciente' : 'Editar paciente'}</h2>
                </div>

                <div class="card-body">
                    <form class="form"action="${pageContext.request.contextPath}/patients/form" method="POST">
                        <c:if test="${!empty patient}">
                            <input type="hidden" name="id" value="${patient.id}">
                        </c:if>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="name">Nombres:</label>
                                <input type="text" class="form-control"id="name" name="name" placeholder="" required value="${empty patient ? '' : patient.name}">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="lastName">Apellidos:</label>
                                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" required value="${empty patient ? '' : patient.lastName}">
                            </div>
                        </div>                        
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="identificationTypeId">Tipo de documento:</label>
                                <select class="form-control" id="identificationTypeId" name="identificationTypeId" required>
                                    <option value="" disabled selected>Seleccione una opción</option>
                                    <option value="1" ${empty patient || patient.identificationTypeId != 1 ? '' : 'selected'}>Registro civil</option>
                                    <option value="2" ${empty patient || patient.identificationTypeId != 2 ? '' : 'selected'}>Tarjeta de identidad</option>
                                    <option value="3" ${empty patient || patient.identificationTypeId != 3 ? '' : 'selected'}>Cédula de ciudadanía</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="identification">Número de documento:</label>
                                <input type="text" class="form-control" id="identification" name="identification" placeholder="" required value="${empty patient ? '' : patient.identification}">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="genderId">Género:</label>
                                <select class="form-control" id="genderId" name="genderId" required>
                                    <option value="" disabled selected>Seleccione una opción</option>
                                    <option value="1" ${empty patient || patient.genderId != 1 ? '' : 'selected'}>Femenino</option>
                                    <option value="2" ${empty patient || patient.genderId != 2 ? '' : 'selected'}>Masculino</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="bloodTypeId">Tipo de sangre:</label>
                                <select class="form-control" id="bloodTypeId" name="bloodTypeId" required>
                                    <option value="" disabled selected>Seleccione una opción</option>
                                    <option value="1" ${empty patient || patient.bloodTypeId != 1 ? '' : 'selected'}>Tipo A</option>
                                    <option value="2" ${empty patient || patient.bloodTypeId != 2 ? '' : 'selected'}>Tipo B</option>
                                    <option value="3" ${empty patient || patient.bloodTypeId != 3 ? '' : 'selected'}>Tipo AB</option>
                                    <option value="4" ${empty patient || patient.bloodTypeId != 4 ? '' : 'selected'}>Tipo O</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="city">Ciudad:</label>
                                <input type="text" class="form-control" id="city" name="city" placeholder="" required value="${empty patient ? '' : patient.city}">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="address">Dirección:</label>
                                <input type="text" class="form-control" id="address" name="address" placeholder="" required value="${empty patient ? '' : patient.address}">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="telephone">Teléfono:</label>
                                <input type="text" class="form-control" id="telephone" name="telephone" placeholder="" required value="${empty patient ? '' : patient.telephone}">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="email">Correo:</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="" required value="${empty patient ? '' : patient.email}">
                            </div>
                        </div>
                        <div class="form-row mt-2">
                            <div class="form-group col-md-6">
                                <label for="dateOfBirth">Fecha de nacimiento:</label>
                                <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required value="${empty patient ? '' : patient.dateOfBirth}">
                            </div>                            
                        </div>
                        <div class="form-row">
                            <div class="col-md-6">
                                <button type="button" class="btn btn-secondary btn-sm mt-2 mx-1" onclick="cancelar()">
                                    <i class="fas fa-arrow-left"></i>
                                    Cancelar
                                </button>
                                <button type="submit" class="btn btn-primary btn-sm mt-2 mx-1">
                                    Guardar
                                </button>             
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <%@include file="../layouts/footer.jsp" %>
</html>