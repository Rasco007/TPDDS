# Diagrama de clases 

* [diagrama-de-clases](./DiagramaDeClasesEntrega3.mdj)

## Imagen del diagrama 

![imagen-diagrama](./DiagramaDeClasesEntrega3.png)

## Entrega 3 

* [Entrega-3](./Entrega-3)


## Justificacíon

* Los incidentes los obtenemos directamente de la comunidad para evitar el conflicto de mezcla de comunidades a la hora de analizar validez, envío de notificaciones y revisión manual del servicio.
* Para los servicios se decidio usar un patron composite para incluir todas las opciones posibles.
* Comunicamos Comunidad con AdapterEnvioNotificaiones porque en el método CargarNuevoIncidente() o CerrarIncidente() va a llamar al adapter y podrá enviar todas las notificaciones a todos los miembros de esa comunidad
* La configuración de la notificación creímos que debe ser un atributo del usuario(clase “perfil”) ya que es debería ser una configuración del mismo. No tiene nada que ver con el envío en sí de las notificaciones.
* Las notificaciones de “Revision manual de Incidente” la resolvimos de la misma manera que las otras. El envío de la notificación va a ser el mismo, lo que cambiará será su tipo y su texto.

