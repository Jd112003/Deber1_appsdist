CMP-5001-202520

UNIVERSIDAD SAN FRANCISCO DE QUITO
COLEGIO: CIENCIAS E INGENIERÍAS
Semestre: 202520 - Segundo Semestre 2025/2026

DEBER-1

El objetivo de este deber, y de los que vendrán, es utilizar la inteligencia artificial como apoyo
en el aprendizaje. La idea es que, con una buena comprensión de los conceptos esenciales
relacionados con distintas especificaciones, implementaciones y, en general, con las
tecnologías necesarias para crear aplicaciones distribuidas, podamos usar esta herramienta
para completar los detalles y llevar a cabo los proyectos.

En este deber, en particular, vamos a crear dos aplicaciones sencillas:

1.  Una aplicación usando JSF.
2.  Una aplicación usando REST.

En ambos casos utilizaremos la versión WildFly 37.0.0.Final. Hay versiones más recientes,
pero esta versión ya la he usado antes y sé que funciona.

Una vez que las aplicaciones se hayan probado en el entorno de IntelliJ, utilizando un
navegador como cliente, cada una se colocará en su propio contenedor de Docker.

Cuando ambos contenedores estén en ejecución, el navegador de la máquina anfitriona se
conectará al contenedor que ejecuta la aplicación JSF, la cual mostrará una página con un
botón. Al hacer clic en ese botón:

1.  El CDI bean de la aplicación JSF enviará una petición a la aplicación REST, que

estará corriendo en el otro contenedor de Docker.

2.  La aplicación REST responderá con un mensaje dirigido al CDI bean de la aplicación

JSF.

3.  Finalmente, ese mensaje será mostrado en el navegador donde el usuario hizo clic en

el botón.

4.  El mensaje puede ser cualquier texto, por ejemplo: “Hello World”.

Requisitos adicionales:

•  Utilizen Docker Compose para crear la imagen y para ejecutar los contenedores.
•  El contenedor con la aplicación REST debe iniciarse primero y luego el contenedor

con la aplicación JSF.

•  Las imágenes de ambos contenedores deben subirse a Docker Hub.

1 de 2.

CMP-5001-202520

•  Cada grupo debe entregar en D2L el código del proyecto acompañado de un archivo

readme.txt que incluya:

➢  Los nombres de los integrantes del grupo y cómo colaboró cada uno.
➢  Las instrucciones precisas para descargar las imágenes de Docker y ejecutar

los contenedores correspondientes al Proyecto.

2 de 2.


