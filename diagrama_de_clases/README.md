# Diagrama de clases 

* Se hizo clase Madre de Transporte por si en el futuro se agregan más transportes al sistema.
Se consideró que cualquier tipo de transporte se basa en una línea con estaciones, por lo tanto el ferrocarril como el subte implementan linea, asi tmb futuros transportes.
La línea dispone de su nombre, un listado de estaciones y las estaciones de origen y destino.
Las estaciones conocen su nombre, su ubicación, latitud y longitud, y un listado de los servicios que ofrece.
Los servicios conocen su estado, su tipo y la estación en la que están.
Decidimos usar el patrón de comportamiento patrón state en el estado del servicio. Los servicios van a actuar de manera diferente dependiendo de su estado y deben poder cambiarlo de manera acorde a su estado actual.
Ante la necesidad de modelar el verificador de contraseñas dentro del sistema se usó el patrón adapter para representarlo y poder integrarlo a futuro.
Para modelar a los usuarios de la plataforma se decidió agruparlos a todos como miembros. Se usó el patrón state para poder implementar cada uno debido a la posibilidad de cambiar el tipo de usuario. Un usuario puede volverse administrador y un administrador puede volver a ser usuario por un motivo X.
Se modelaron las comunidades como un listado de usuarios y un listado de administradores, las comunidades también cuentan con un nombre.
Los miembros conocen los servicios, pudiendo hacer cambios en su estado, notificando al sistema. Y los administradores pueden crear y eliminar servicios.


