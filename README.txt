================================================================================
DEBER 1 - APLICACIONES DISTRIBUIDAS
UNIVERSIDAD SAN FRANCISCO DE QUITO
Semestre: 202520 - Segundo Semestre 2025/2026
================================================================================

INTEGRANTES DEL GRUPO:
----------------------
- Matias Jaramillo (00326063) - Desarrollo de la aplicación REST (backend)
- Juan Diego Chicaiza (00328175) - Desarrollo de la aplicación JSF (frontend) y configuración de Docker

DESCRIPCIÓN DEL PROYECTO:
-------------------------
Este proyecto consiste en dos aplicaciones desplegadas en contenedores Docker:

1. REST-APP: Aplicación REST que proporciona un endpoint /api/hello que retorna "Hello World"
2. JSF-APP: Aplicación JSF con un botón que consume el servicio REST y muestra el mensaje

Ambas aplicaciones corren en WildFly 37.0.0.Final y se comunican a través de una red Docker.

REQUISITOS PREVIOS:
------------------
- Docker instalado (versión 20.10 o superior)
- Docker Compose instalado (versión 1.29 o superior)
- Conexión a internet para descargar las imágenes

INSTRUCCIONES PARA DESCARGAR Y EJECUTAR:
-----------------------------------------

OPCIÓN 1: Construir localmente desde el código fuente
------------------------------------------------------

1. Clonar el repositorio:
   git clone [URL_DEL_REPOSITORIO]
   cd Deber1_appsdist

2. Compilar ambas aplicaciones con Maven:
   
   # Compilar la aplicación REST
   cd rest-app
   mvn clean package
   cd ..
   
   # Compilar la aplicación JSF
   cd jsf-app
   mvn clean package
   cd ..

3. Construir y ejecutar los contenedores con Docker Compose:
   docker-compose up --build

4. Acceder a la aplicación:
   - Abrir el navegador en: http://localhost:8082/jsf-app/
   - Hacer clic en el botón "Obtener Mensaje del Servidor REST"
   - El mensaje "Hello World" aparecerá en la página


OPCIÓN 2: Descargar desde Docker Hub
-------------------------------------

1. Descargar las imágenes desde Docker Hub:
   docker pull matjaramillo/rest-app:latest
   docker pull matjaramillo/jsf-app:latest

2. Crear una red Docker:
   docker network create app-network

3. Ejecutar el contenedor REST primero:
   docker run -d --name rest-app-container --network app-network -p 8081:8080 matjaramillo/rest-app:latest

4. Esperar a que el contenedor REST esté listo (aprox. 30-40 segundos), luego ejecutar el contenedor JSF:
   docker run -d --name jsf-app-container --network app-network -p 8082:8080 matjaramillo/jsf-app:latest

5. Acceder a la aplicación:
   - Abrir el navegador en: http://localhost:8082/jsf-app/
   - Hacer clic en el botón "Obtener Mensaje del Servidor REST"
   - El mensaje "Hello World" aparecerá en la página


PARA DETENER LOS CONTENEDORES:
-------------------------------

Si usaste Docker Compose:
  docker-compose down

Si ejecutaste los contenedores manualmente:
  docker stop jsf-app-container rest-app-container
  docker rm jsf-app-container rest-app-container


ESTRUCTURA DEL PROYECTO:
------------------------
Deber1_appsdist/
├── rest-app/                    # Aplicación REST (Backend)
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── usfq/rest/
│   │               ├── RestApplication.java
│   │               └── HelloResource.java
│   ├── pom.xml
│   └── Dockerfile
├── jsf-app/                     # Aplicación JSF (Frontend)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── usfq/jsf/
│   │   │   │       └── HelloBean.java
│   │   │   └── webapp/
│   │   │       ├── WEB-INF/
│   │   │       │   ├── web.xml
│   │   │       │   └── beans.xml
│   │   │       └── index.xhtml
│   ├── pom.xml
│   └── Dockerfile
├── docker-compose.yml
└── README.txt


ENDPOINTS DISPONIBLES:
---------------------
- Aplicación JSF: http://localhost:8082/jsf-app/
- API REST: http://localhost:8081/rest-app/api/hello


ROLES Y CONTRIBUCIONES DEL EQUIPO:
---------------------------------

Matías Jaramillo (00326063) – Backend (REST) y Documentación
	•	Diseño e implementación de la aplicación REST utilizando Jakarta EE 10.
	•	Creación del endpoint /api/hello que retorna el mensaje "Hello World 123".
	•	Configuración de RestApplication.java y HelloResource.java.
	•	Configuración del proyecto Maven (estructura WAR y dependencias).
	•	Contenerización de la aplicación REST con Docker (WildFly 37.0.0.Final).
	•	Verificación de compatibilidad multi-arquitectura (ARM64 y AMD64).
	•	Publicación de la imagen Docker en Docker Hub.
	•	Pruebas de funcionamiento del servicio REST tanto localmente como en contenedor.
	•	Incluir datos del archivo README.txt.

Juan Diego Chicaiza (00328175) – Frontend (JSF) y Orquestación con Docker
	•	Diseño e implementación de la aplicación JSF utilizando Jakarta EE 10.
	•	Desarrollo de la interfaz index.xhtml.
	•	Implementación del HelloBean para consumir el servicio REST mediante petición HTTP.
	•	Configuración de CDI (beans.xml) y web.xml.
	•	Contenerización de la aplicación JSF con Docker (WildFly 37.0.0.Final).
	•	Configuración de docker-compose.yml para orquestar ambos contenedores.
	•	Implementación de depends_on, red Docker compartida y healthcheck.
	•	Pruebas de integración entre contenedor REST y contenedor JSF.


NOTAS TÉCNICAS:
--------------
- La aplicación REST se inicia primero gracias a la configuración de depends_on y healthcheck
- Los contenedores se comunican a través de la red Docker "app-network"
- El bean CDI en la aplicación JSF hace una petición HTTP al contenedor rest-app
- Se usa WildFly 37.0.0.Final como servidor de aplicaciones
- Las aplicaciones usan Jakarta EE 10


TROUBLESHOOTING:
---------------
Si la aplicación JSF no puede conectarse al servicio REST:
  1. Verificar que ambos contenedores estén corriendo: docker ps
  2. Verificar los logs: docker logs rest-app-container
  3. Asegurarse de que el contenedor REST esté completamente iniciado antes de acceder a JSF
  4. Verificar que ambos contenedores estén en la misma red: docker network inspect app-network


ENLACES DE DOCKER HUB:
----------------------
- REST Application: https://hub.docker.com/repository/docker/matjaramillo/rest-app/general
- JSF Application: https://hub.docker.com/repository/docker/matjaramillo/jsf-app/general

================================================================================
