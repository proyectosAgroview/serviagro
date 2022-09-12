package co.com.arcosoft.presentation.backingBeans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@ManagedBean(name = "initialMenuView")
@SessionScoped
public class InitialMenuView implements Serializable {

	private static final long serialVersionUID = 2985639918423438706L;
	
	private String moduloSeleccionado;
	private String menuModuloSeleccionado;
	private String usuario;
	private String tituloModulo;
	private String rol;	
	
	@PostConstruct
	public void init(){
	}
	
	public void postLoad() throws IOException{
		
	  mostrarMenuModuloSeleccionado();
	  crearCookieSesion();
	}
	
	public void crearCookieSesion() {
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest peticion = (HttpServletRequest) ctx.getExternalContext().getRequest();
		HttpServletResponse respuest = (HttpServletResponse) ctx.getExternalContext().getResponse();
		Object contextPath = peticion.getContextPath();
		
        //?reload
		String str = moduloSeleccionado;
		String[] aux = null;
	    int resultado = str.indexOf("?");
	    if(resultado != -1) {
	    	aux =str.split("\\?");
			Cookie cookie = new Cookie("modulo",aux[0]);
			cookie.setPath(contextPath.toString());
			cookie.setMaxAge(-1);
			respuest.addCookie(cookie);
	    }


	}
	
	public void crearPreferenciasUsuario() {
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletResponse respuest = (HttpServletResponse) ctx.getExternalContext().getResponse();
		
		HttpSession session = ((HttpServletRequest) respuest).getSession();
		session.setAttribute("username", getUsuario());
		
	}
	
	private void mostrarMenuModuloSeleccionado() throws IOException{

		if (moduloSeleccionado.equals("mantenimiento_maquinaria")) {
			setTituloModulo("Mantenimiento de Maquinaria");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/mantenimiento_maquinaria.xhtml";
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}

		if (moduloSeleccionado.equals("sgu")) {
			setTituloModulo("Gestión de Usuarios");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/sgu.xhtml";
			PrimeFaces.current().executeScript("handleRefreshPage()");			
		}
		
		/** -------------------------------------------------------------------------------------------------- **/	

		if (moduloSeleccionado.equals("suministros")) {
			setTituloModulo("Suministros");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/suministros.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}
		
		if (moduloSeleccionado.equals("prog_labores")) {
			setTituloModulo("Programador de labores");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/prog_labores.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}
		
		if (moduloSeleccionado.equals("servicios")) {
			setTituloModulo("Servicios");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/servicios.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}

		if (moduloSeleccionado.equals("gastos")) {
			setTituloModulo("Gastos");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/gastos.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}

		if (moduloSeleccionado.equals("herramientas")) {
			setTituloModulo("Herramientas");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/herramientas.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}

		if (moduloSeleccionado.equals("auditoria")) {
			setTituloModulo("Auditoría");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/auditoria.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}

		if (moduloSeleccionado.equals("agro_analytics")) {
			setTituloModulo("Indicadores gerenciales");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/agro_analytics.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}
		
		if (moduloSeleccionado.equals("integraciones")) {
			setTituloModulo("Integraciones");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/integraciones.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}
		
		if (moduloSeleccionado.equals("facturacion")) {
			setTituloModulo("Facturación");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/facturacion.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}
		
		if (moduloSeleccionado.equals("nomina")) {
			setTituloModulo("Nómina");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/nomina.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}
		
		if (moduloSeleccionado.equals("cartera")) {
			setTituloModulo("Cartera");
			menuModuloSeleccionado = "/WEB-INF/template/menus_template/cartera.xhtml";			
			PrimeFaces.current().executeScript("handleRefreshPage()");
		}
	}
	
	public void reset() {
	        PrimeFaces.current().resetInputs("principal");
	}

	private String getPrincipal() {
		String userName = null;

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	

	public String getUsuario() {
		this.usuario = getPrincipal();
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getModuloSeleccionado() {
		return moduloSeleccionado;
	}

	public void setModuloSeleccionado(String moduloSeleccionado) {
		this.moduloSeleccionado = moduloSeleccionado;
	}

	public String getMenuModuloSeleccionado() {
		return menuModuloSeleccionado;
	}

	public void setMenuModuloSeleccionado(String menuModuloSeleccionado) {
		this.menuModuloSeleccionado = menuModuloSeleccionado;
	}

	public String getTituloModulo() {
		return tituloModulo;
	}

	public void setTituloModulo(String tituloModulo) {
		this.tituloModulo = tituloModulo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}