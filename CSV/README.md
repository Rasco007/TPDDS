# Documento de CSV 

> Estado\_Servicios.csv

La idea del documento es que se exporte como un archivo csv del estado del servicio, de como se encuentra y si hay alguna persona designada
esta es por que si se encuentra en estado de reparacion o de control tiene que tener una persona designada

## Atributos 

* Id 
	* Se asigna un id para saber cual es el numero de solicitud
* Lugar 
	* Donde estaria ocurriendo el problema o donde hubo algun inconveniente
	* Provincia, localidad, calle
* Servicio
	* Cual de todos de los servicios que se encuentran en ese lugar 
* Estado 
	* Pueden haber varios estados en los cuales registraremos 
		* En reparacion
		* Reparado
		* Otros 
* Usuario\_designado
	* Es la persona/usuario que este identificado la cual se realizara cargo del problema 
* Comentarios 
	* Comentarios del cliente, y podria agregarse los comentarios de las personas designadas 



## Mejoras

* Para proximas entregas la idea es poder mejorar y checkear bien que no haya ninguna vulnerabilidad el openCSV  por que algunos sitios dicen que tiene algunas lo cual hay que revisar bien, y en caso de haber tendremos que cambiar y agregar otras 
* Mejorar la expresividad y declaratividad de las funciones
* Realizar test ( con los ejemplos ) y realizar unos archivos de ejemplos para verificar correcto funcionamiento 
* Agregar Algun campo en el caso de ser necesario 
