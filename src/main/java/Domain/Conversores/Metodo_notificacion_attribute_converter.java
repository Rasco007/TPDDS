package Domain.Conversores;

import Domain.Notificaciones.Email;
import Domain.Notificaciones.Metodo_Notificacion;
import Domain.Notificaciones.Whatsapp;

import javax.persistence.AttributeConverter;

public class Metodo_notificacion_attribute_converter implements AttributeConverter <Metodo_Notificacion,String> {

    @Override
    public String convertToDatabaseColumn(Metodo_Notificacion metodoNotificacion) {
        String metodo = null;
        if(metodoNotificacion.getClass()== Email.class){
            metodo="Email";
        }
        if(metodoNotificacion.getClass()== Whatsapp.class){
            metodo="Whatsapp";
        }
        return metodo;
    }

    @Override
    public Metodo_Notificacion convertToEntityAttribute(String s) {
        switch (s){
            case "Email":
                return new Email();
            case "Whatsapp":
                return new Whatsapp();
        }
        return null;
    }
}
