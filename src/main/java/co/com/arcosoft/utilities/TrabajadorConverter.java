package co.com.arcosoft.utilities;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.arcosoft.modelo.Trabajador;

@FacesConverter("trabajadorConverter")
public class TrabajadorConverter implements Converter { 

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Trabajador) object).getTrabId());
        }
        else {
            return null;
        }
    }

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		return value;
	}
}