# Spring Boot to-do app challenge



## Explicación

#### Principal

El control de errores se ha hecho con Excepciones customizadas:

- **TaskNotFoundException** 
- **TaskAlreadyExistsException** 

Gestionadas mediante un @ControllerAdvice:

- **CustomGlobalExceptionHandler** 


#### Optional

1. Improve the request that returns a list of tasks by adding the possibility to order and filter the results:

	- Los resultados se pueden filtrar por campo mediante el operador & (implementado mediante Specifications). Por ejemplo:
    
    
    ```
    http://localhost:8443/task/?description=[cadena]&priority=LOW&completed=false
	```
	
	
	 
	- Para el filtrado:
    
    
    ```
    http://localhost:8443/task/?sort=priority,asc
    ```
    
    
2. Create a new entity called *SubtaskEntity* that allows one task to have multiple subtasks:
 
	- Se ha creado la entidad *SubtaskEntity* y mediante las respectivas anotaciones @OneToMany y @ManyToOne es posible añadir subtasks a una task a través de las peticiones con la entidad TaskEntity