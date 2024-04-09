/*
 * redirige a la pagina de lista de pacientes.
 * 
 */    
function cancelar() {
    window.location.href = "/Magnamedic2/patients/list";
}

/**
 * Establece la acción del formulario en función del estado del paciente.
 * Si el paciente está vacío, la acción del formulario será para crear un nuevo registro.
 * Si el paciente no está vacío, la acción del formulario será para actualizar un registro existente.
 */
function setFormAction() {
    var form = document.getElementById("myForm");
    var action = "${pageContext.request.contextPath}/patients/form";
    if (patientIsNotEmpty()) {
        action = "${pageContext.request.contextPath}/patients/form/update";
    }
    form.action = action;
}

/**
 * Verifica si el paciente no está vacío.
 * @returns {boolean} True si el paciente no está vacío, false si está vacío.
 */
function patientIsNotEmpty() {
    if (typeof patient !== 'undefined' && patient.id !== null && patient.id !== '') {
        return true;
    } else {
        return false;
    }
}

function confirmDelete() {
    if (confirm("¿Estás seguro de que deseas eliminar este registro?")) {
        document.getElementById("deleteForm").submit();
    }
}
//function confirmDelete() {
//    if (confirm("¿Estás seguro de que deseas eliminar este registro?")) {
//        document.getElementById("deleteForm").submit();
//        }
//    }
