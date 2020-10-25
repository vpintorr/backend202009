# Spring Boot to-do app challenge



## Explicación

#### Principal

El control de errores se ha hecho con Excepciones customizadas:

- **TaskNotFoundException** 
- **TaskAlreadyExistsException** 

Gestionadas mediante un @ControllerAdvice:

- **CustomGlobalExceptionHandler**

El proyecto tiene un fichero para cargar datos en la base de datos por si os es útil para probar el funcionamiento:

- **src/main/resources/data.sql**



#### Optional

1. Improve the request that returns a list of tasks by adding the possibility to order and filter the results:

	- Los resultados se pueden filtrar por campos concatenando con el operador & (la implementación se ha realizado mediante Specifications). Por ejemplo:
    
    
    ```
    http://localhost:8443/task/?description=[cadena]&priority=LOW&completed=false
	```
	
	
	 
	- Para el ordenado:
    
    
    ```
    http://localhost:8443/task/?sort=priority,asc
    ```
    
    
2. Create a new entity called *SubtaskEntity* that allows one task to have multiple subtasks:
 
	- Se ha creado la entidad *SubtaskEntity* y mediante las respectivas anotaciones @OneToMany y @ManyToOne es posible añadir, actualizar y eliminar subtasks a través del endpoint para la entidad TaskEntity. Por ejemplo con una petición post con el siguiente contenido:
	
	
```
	{
 "id":15,
 "description":"Esta es la description de la task 1",
 "completed":false,
 "priority":"HIGH",
  "subTasks": [{
    "id":15,
 	"description":"Subtask 1 de la task 1 ",
 	"completed":false,
 	"priority":"HIGH"
  },
  {
    "id":16,
 	"description":"Subtask 1 de la task 1 ",
 	"completed":true,
 	"priority":"LOW"
  }]
}
```
