package co.com.arcosoft.presentation.backingBeans;

import java.io.IOException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;

@ManagedBean(name = "navegacion")
@ApplicationScoped
public class NavegacionView {

	private CommandButton btnAtras;
	private CommandButton btnCerrarSesion;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public NavegacionView() {
		super();
	}

	public void action_atras() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		Object contextPath = origRequest.getContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/XHTML/tmp_inicio.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

		context.getExternalContext().getSessionMap().remove("menuService");
		context.getExternalContext().getSessionMap().remove("treeEventsView");

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void cerrarSession() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();
		HttpServletResponse respuest = (HttpServletResponse) ctx.getExternalContext().getResponse();
		Object contextPath = peticion.getContextPath();

		Cookie[] cookies = peticion.getCookies();

		for (Cookie cookie2 : cookies) {
			if ((cookie2.getName()).equals("modulo")) {
				cookie2.setPath(contextPath.toString());
				cookie2.setValue(null);
				cookie2.setMaxAge(0);
				respuest.addCookie(cookie2);
			}
		}

		peticion.getSession().invalidate();
		ctx.getExternalContext().getSessionMap().remove("menuService");
		ctx.getExternalContext().getSessionMap().remove("treeEventsView");

	}

	public CommandButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(CommandButton btnAtras) {
		this.btnAtras = btnAtras;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	/**
	 * @return the btnCerrarSesion
	 */
	public CommandButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	/**
	 * @param btnCerrarSesion the btnCerrarSesion to set
	 */
	public void setBtnCerrarSesion(CommandButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	
	
}
