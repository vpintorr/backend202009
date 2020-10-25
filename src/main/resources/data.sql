insert into demo.task_entity(id, completed, description, priority) values 
(1, 0, "Esta es la descripcion de la tarea 1", 2),
(2, 0, "Esta es la descripcion de la tarea 2", 0),
(3, 1, "Esta es la descripcion de la tarea 3", 1),
(4, 0, "Esta es la descripcion de la tarea 4", 1),
(5, 0, "Esta es la descripcion de la tarea 5", 0),
(6, 1, "Esta es la descripcion de la tarea 6", 0),
(7, 1, "Esta es la descripcion de la tarea 7", 0),
(8, 1, "Esta es la descripcion de la tarea 8", 2),
(9, 0, "Esta es la descripcion de la tarea 9", 1),
(10, 1, "Esta es la descripcion de la tarea 10", 2),
(11, 0, "Esta es la descripcion de la tarea 11", 2),
(12, 0, "Esta es la descripcion de la tarea 12", 2);


insert into demo.subtask_entity(id, completed, description, priority, task_id) values
(1, 0, "Esta es la descripcion de la subtarea 1 de la tarea 1", 2, 1),
(2, 0, "Esta es la descripcion de la subtarea 2 de la tarea 1", 1, 1),
(3, 1, "Esta es la descripcion de la subtarea 3 de la tarea 1", 0, 1),
(4, 0, "Esta es la descripcion de la subtarea 1 de la tarea 2", 2, 2),
(5, 1, "Esta es la descripcion de la subtarea 1 de la tarea 3", 2, 3),
(6, 1, "Esta es la descripcion de la subtarea 2 de la tarea 3", 1, 3),
(7, 0, "Esta es la descripcion de la subtarea 1 de la tarea 5", 0, 5),
(8, 0, "Esta es la descripcion de la subtarea 1 de la tarea 6", 2, 6),
(9, 1, "Esta es la descripcion de la subtarea 2 de la tarea 6", 1, 6),
(10, 0, "Esta es la descripcion de la subtarea 3 de la tarea 6", 1, 6),
(11, 1, "Esta es la descripcion de la subtarea 4 de la tarea 6", 0, 6),
(12, 1, "Esta es la descripcion de la subtarea 1 de la tarea 10", 0, 10),
(13, 0, "Esta es la descripcion de la subtarea 1 de la tarea 11", 2, 11),
(14, 0, "Esta es la descripcion de la subtarea 2 de la tarea 11", 2, 11);

