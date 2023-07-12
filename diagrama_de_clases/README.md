# Diagrama de clases 

* [diagrama-de-clases](DiagramaDeClasesEntrega3.mdj)

## Imagen del diagrama 

![imagen-diagrama](DiagramaDeClasesEntrega3.png)

## Justificacíon

# Entrega 1

* Se hizo clase Madre de Transporte por si en el futuro se agregan más transportes al sistema.
* Se consideró que cualquier tipo de transporte se basa en una línea con estaciones, por lo tanto el ferrocarril como el subte implementan linea, asi tmb futuros transportes.
* La línea dispone de su nombre, un listado de estaciones y las estaciones de origen y destino.
* Las estaciones conocen su nombre, su ubicación, latitud y longitud, y un listado de los servicios que ofrece.
* Los servicios conocen su estado, su tipo y la estación en la que están.
* Decidimos usar el patrón de comportamiento patrón state en el estado del servicio. Los servicios van a actuar de manera diferente dependiendo de su estado y deben poder cambiarlo de manera acorde a su estado actual.
* Ante la necesidad de modelar el verificador de contraseñas dentro del sistema se usó el patrón adapter para representarlo y poder integrarlo a futuro.
* Para modelar a los usuarios de la plataforma se decidió agruparlos a todos como miembros. Se usó el patrón state para poder implementar cada uno debido a la posibilidad de cambiar el tipo de usuario. Un usuario puede volverse administrador y un administrador puede volver a ser usuario por un motivo X.
* Se modelaron las comunidades como un listado de usuarios y un listado de administradores, las comunidades también cuentan con un nombre.
* Los miembros conocen los servicios, pudiendo hacer cambios en su estado, notificando al sistema. Y los administradores pueden crear y eliminar servicios.

# Entrega 2

* Se establece la clase ServicioPublico para la integracion de futuros servicios.
* Los transporte implementa servicio publico.
* Se establece la clase entidad que representa a las empresas prestadoras del servicio. Las entidades conocen el servicio publico que brindan, el area(localidad) donde operan, sus sucursales(establecimientos) y sus usuarios asociados. La entidad conoce los usuarios y no al revés para no tener que buscar a qué usuarios mandar información.
* Se establece la clase organismo de control.
* Organismo de control y entidad conocen un usuario receptor de informacion.
* Las estaciones pasan a ser establecimientos.
* Se agregó la clase localidad para las áreas de interés. Se agrega esta clase para obtener consistencia de datos. No utilizamos la clase ubicación ya que esta se usa para obtener la ubicación precisa de un establecimiento y no para un área.
* Cambia la estructura usada para los usuarios. Cada usuario tendrá asociado un perfil(data class) y a su vez, perfil tendrá asociado un rol con sus determinados permisos. 
* Se eliminan las clases con roles dentro de la aplicación(Administrador, miembro proveedor). Se agrega la clase rol que contiene la lista de permisos para cada rol. Por ejemplo, administrador será una instancia de rol de un perfil asociado a un usuario quien tendrá sus respectivos métodos en la capa de Controlador.
* La clase usuario conoce los roles.
* En Comunidad la lista de miembros y de administradores pasan a ser de tipo usuario para corresponder con los cambios mencionados.

# Entrega 3
  
* Los incidentes los obtenemos directamente de la comunidad para evitar el conflicto de mezcla de comunidades a la hora de analizar validez, envío de notificaciones y revisión manual del servicio.
* Implementamos Patron Composite para el tipo de servicio
* Para los servicios se decidio usar un patron composite para incluir todas las opciones posibles.
* Comunicamos Comunidad con AdapterEnvioNotificaiones porque en el método CargarNuevoIncidente() o CerrarIncidente() va a llamar al adapter y podrá enviar todas las notificaciones a todos los miembros de esa comunidad
* La configuración de la notificación creímos que debe ser un atributo del usuario(clase “perfil”) ya que es debería ser una configuración del mismo. No tiene nada que ver con el envío en sí de las notificaciones.
* Las notificaciones de “Revision manual de Incidente” la resolvimos de la misma manera que las otras. El envío de la notificación va a ser el mismo, lo que cambiará será su tipo y su texto.

