# Proyecto de Prueba Técnica con Spring Java para bncn

Este repositorio contiene un proyecto de prueba técnica implementado con Spring Framework en Java. El proyecto tiene como objetivo demostrar mis habilidades y conocimientos en el desarrollo de aplicaciones utilizando estas tecnologías.

## Características Clave

- **Clean Code:** He mantenido el código limpio y legible siguiendo las convenciones y estándares de nomenclatura. He utilizado nombres descriptivos para las clases, métodos y variables, facilitando la comprensión del código.

- **Código Sólido:** He aplicado los principios SOLID en el diseño del código. He utilizado la inyección de dependencias para mejorar la modularidad y la escalabilidad. También he buscado minimizar la duplicación de código y mantener una estructura organizada.

- **Arquitectura Hexagonal:** Esta arquitectura se basa en la idea de que una aplicación debe estar organizada en capas, con una clara separación entre la lógica de negocio y las preocupaciones externas, como la interfaz de usuario y las bases de datos.

- **Modelo Actuator:** Utilizo la clase Logger para monitorear a través de los cuales se pueden obtener información sobre la aplicación.

- **H2:**  Utilizo H2 para almacenar los datos en memoria principal, lo que permite un acceso rápido a los datos y es ideal para pruebas y aplicaciones temporales.

- **Excepciones:** Creo bloques para capturar las posibles expeciones.

- **Respuestas HTTP:** Configuro en el controlador las posibles respuestas que devuelve la aplicación. 2XX y 4XX

- **Endpoint REST:** He creado un endpoint REST que devuelve una lista de datos extraidos de una base de datos de comercio electrónico. He utilizado las anotaciones proporcionadas por Spring Boot para definir las rutas y métodos HTTP adecuados.

- **Test JUnit y Mockito:** Se desarrolla test unitario y de integración, de las capa repository, service y controller. Obteniendo más de un 95% de coverage.

- **Jacoco:** Para ver el covegare de la aplicacion sobre los test realizado, añado en el pom.xml el plugins de jacoco. Se genera en la carpeta /target/site/jacoco/index.html

- **Casos de prueba:** Realizo pruebas integradas con postman donde realizo los distintos casos que se puede dar devolviendo la respuesta que se espera, segun diseñod e la aplicación. 

## Posibles mejoras

- **swagger-contract:** La realización de esta aplicación es algo basica, se podría crear un yaml, donde se mejoraria los objectos de entradas y salidas ques como trabajo actualmente profesionalmente.

- **Lógica:** La logica es algo muy basica tambien, he implementado una llamada al repositorio donde realiza una busquedad segun los parametros requerido, con la ordenanción por el campo priority y orden descendente. Al final lo he dejado como si el objecto que devuelve es una lista en vez de una entidad de PRICES.

- **Test:** No se si he entendido bien el DT(Documento tecnico) la información es un poco escueta, realizo un for each donde con la clase StringBuilder voy concatenando la salida por consola obteniendo los datos de la clase Utils. La clase utils la genero para apoyarme en la realización de prueba con H2. No es la mejor manera pero si es efectiva.

## Instrucciones de Ejecución

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu entorno de desarrollo preferido (por ejemplo, IntelliJ IDEA o Eclipse).
3. Ejecuta la aplicación Spring Boot.
4. Se puede realizar la prueba desde cualquier navegador, ya que es una llamada GET. Otra opción que se puede utilizar es postman.
5. Accede al endpoint utilizando: **http://localhost:8080/api/prices?fechaAppStar=2020-06-14T00:00:00.00&fechaAppEnd=2020-12-31T23:59:59.00&idProd=35455&idBrand=1.**

- **JAR:**
1. Para levantar la aplicación con comando en cmd, descargar el proyecto.
2. En mi caso lo tengo el proyecto en C:\DEV\proyectos\GuidanceTest\target> **Aqui donde lo tengais descargado: utilizar comando cd para moveros entre carpeta**
3. Con el comando java -jar GuidanceTest-0.0.1-SNAPSHOT.jar
4. Se puede realizar pruebas sin tener un entorno de desarrollo (IntelliJ IDEA o Eclipse).
5. **IMPORTANTE:** Se tiene que tener el JDK 11 o superior instalado en el PC.

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras mejoras que se pueden realizar en el código o en la estructura del proyecto, no dudes en abrir un pull request.


