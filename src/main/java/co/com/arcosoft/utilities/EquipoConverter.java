package co.com.arcosoft.utilities;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.com.arcosoft.modelo.Equipo;

@FacesConverter("equipoConverter")
public class EquipoConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		return value;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Equipo) object).getEquipoId());
		} else {
			return null;
		}
	}
}