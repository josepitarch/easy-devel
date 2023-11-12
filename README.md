# Prueba técnica EasyDevel

## Descripción
Implementar un API para la entidad `Section`

### Requisitos
* [Java 21](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)
* [Maven](https://maven.apache.org/)

### Requisitos entorno de desarrollo
* [Docker](https://www.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/)

### Levantar el proyecto
1. Compila el proyecto con el siguiente comando en la raíz del proyecto:
```console
jopimi@easydevel:~$ mvn clean install
```
2. Para levantar el proyecto con el entorno de producción ejecuta el siguiente comando en la raíz del proyecto:
```console
jopimi@easydevel:~$ mvn spring-boot:run
```
3. Para levantar el proyecto con el entorno de desarrollo ejecuta los siguientes comandos en la raíz del proyecto:
```console
jopimi@easydevel:~$ docker-compose up
```
```console
jopimi@easydevel:~$ mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Notas
* Para el entorno de desarrollo se ha optado por dockerizar tanto la base de datos PostgreSQL como la de Redis.
* Para el entorno de producción se ha optado por externalizar la base de datos PostgreSQL y Redis en los siguientes proveedores:
    * PostgreSQL: `https://www.fl0.com/`
    * Redis: `https://redis.io/`

---
Desarrollado por [Jose Luis Pitarch Miravete](https://www.linkedin.com/in/jopimi/)
