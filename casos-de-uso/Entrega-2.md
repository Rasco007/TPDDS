# Entrega 2 

## Entidades 

* Usuario 
* Administrador 
* Admin-Desarollador-Proveedor 


### Nuevas entidades 

* Usuario-Empresa
* Usuario-Organismo-control
* Usuario-Entidad 


## Explicaciones 

El Usuario Empresa como el usuario de organismos de control son los que asignaran una persona en el caso de que haya algun inconveniente en alguna servicio.
Designaran a un usuario dentro de la platarforma para que los solucione. 

Estos usuario tambien tendran que crear las cuentas como usuarios normales para pertenecer.

Al usuario Normal se le asigna un nuevo caso de uso que es la notificacion de problemas, para que las demas puedan ser notificados del mismo 

Por ultimo usuario Entidad ( que seria el "propietario" duenio del lugar) es el que tendria que cargar el establecimiento para que pueda figurar en el mismo sistema,
Este establecimiento agregado tiene que ser validado, para que sea correcto y cumpla con los requisitos para poder incorporarse , la cual es un Caso de uso para el administrador.

Se agrega un caso de uso que sera la carga del csv , que hara referencia para el administrador haga la carga masiva del mismo 
 
Por ultimo tenemos el caso de uso de recibir informacion el cual seria notificar a los usuarios que corresponde que el usuario notifico de algun error.


## Diagrama 

![Diagrama](./UseCaseDiagram2.jpg)
