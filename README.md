# INVENTARIO DE VACUNACION DE EMPLEADOS

Microservicio para gestionar el historial de vacunación de empleados 

# Requisitos
- Spring Boot 3.0.4
- Java 17

# Construcción del proyecto
1. Creación de Entidades.
2. Creación de DTO (Data trasnfer Object)
3. Creación de repositorios.
4. Creación de Evento cuando se crea un Empleado
5. Creación de Observador del evento Empleado creado . Este observador genera las credenciales de un Usuario
6. Creación de Capa para el mapeo de las entidades y los DTO
7. Creación de Contratos (interfaces) de los servicios de la aplicacion
8. Implementacion de logica de los servicios de la aplicacion (implementacion de interfaces)
9. Creación de Event handler global para el manejo de excepciones en la aplicacion
10. Creación de controlador de con recursos (rutas) que disponibiliza la aplicacion .

# Documentacion:

Para revisar la documentacion oficicial del microservicio puede acceder a la siguiente url:
- http://localhost:8000/api/swagger-ui/index.html

# Modo de uso:
- El microservicio disponibiliza las siguientes rutas:

**HTTP Method GET:**


a.	http://localhost:8080/api/employee : Obtencion de todos los empleados.


b.	http://localhost:8080/api/employee/{id} : obtener empleados por el id.


c.	http://localhost:8080/api/by-vaccination-type : obtener empleados por el tipo de vacuna.


d.	http://localhost:8080/api/by-vaccination-status : obtener empleados por su estado de vacunacion.


e.  http://localhost:8080/api/by-vaccination-at?startDate=1996-03-11&endDate=1996-03-11 : obtener empleados por fecha de vacunacion.

**HTTP Method POST:**

f.	http://localhost:8080/api/employee : Creacion de empleados.

**HTTP Method PUT:**


g.	http://localhost:8080/api/employee/{id} : Actualizacion de empleados.

**HTTP Method DELETE:**


h.	http://localhost:8080/api/employee/{id} : Eliminacion de empleados.

# Pendientes

- El microservicio no cuenta actualmente con mecanismo de autenticacion 
para restringir los recursos disponibles.
