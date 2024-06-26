<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tu aplicaci�n m�dica</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
              rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

    </head>
    <body>
        <div id="wrapper">
            <div class="sidebar">
                <div class="logo">
                    <a href="#">
                        <img src="images/magnamedic_gray.png" alt="Logo de Mi Empresa">
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
                        <a href="#"><span>Citas m�dicas</span></a>
                    </li>
                    <li>
                        <i class="fas fa-fw fa-users"></i>
                        <a href="${pageContext.request.contextPath}/patients/list"><span>Pacientes</span></a>
                    </li>
                    <hr>

                    <li>
                        <i class="fas fa-fw fa-stethoscope"></i>
                        <a href="#"><span>M�dicos</span></a>
                    </li>
                    <li>
                        <i class="fas fa-fw fa-kit-medical"></i>
                        <a href="#"><span>Especialidades m�dicas</span></a>
                    </li>
                    <hr>

                    <li>
                        <i class="fas fa-fw fa-chart-area"></i>
                        <a href="#"><span>Reportes</span></a>
                    </li>
                </ul>
            </div>

            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <header>
                        <nav class="dashboard-navbar">
                            <div class="user-profile">
                                <span>Nelson Garc�a</span>
                                <a href="login.html">
                                    <img src="images/undraw_profile.svg" alt="Tu imagen de usuario">
                                </a>
                            </div>
                        </nav>
                    </header>

                    <main>
                        <!-- Contenido principal -->
                        <div class="container-fluid">

                            <!-- Tarjeta principal -->
                            <div class="card shadow mb-4">
                                <!-- Contenido de la tarjeta -->
                            </div>
                        </div>
                    </main>
                </div>

                <footer class="footer">
                    <span>Copyright &copy; Magnamedic 2023</span>
                </footer>
            </div>
        </div>
    </body>
</html>
