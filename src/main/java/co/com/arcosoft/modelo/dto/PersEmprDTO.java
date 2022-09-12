package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class PersEmprDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PersEmprDTO.class);
	private String apartadoPostal;
	private String codigo;
	private String codigoPostal;
	private Long compania;
	private String direccion;
	private String email;
	private String estado;
	private String estadoCivil;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String identificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private String numeroCuenta;
	private String pbx;
	private Long persEmprId;
	private String representanteLegal;
	private String sitioWeb;
	private String telefono;
	private String telefono2;
	private String tipoEmpresa;
	private String tipoIdentificacion;
	private String tipoPersona;
	private Long ciudadId_Ciudad;
	private Long entBancId_EntBanc;
	private Long profId_Profesion;
	private Double porcentajePagoFruto;
	private String certificacion;	
	private String tablaPrecios;
	
	private String esArlEpsPension;
	
	/**
	 * @return the porcentajePagoFruto
	 */
	public Double getPorcentajePagoFruto() {
		return porcentajePagoFruto;
	}

	/**
	 * @param porcentajePagoFruto the porcentajePagoFruto to set
	 */
	public void setPorcentajePagoFruto(Double porcentajePagoFruto) {
		this.porcentajePagoFruto = porcentajePagoFruto;
	}

	public String getApartadoPostal() {
		return apartadoPostal;
	}

	public void setApartadoPostal(String apartadoPostal) {
		this.apartadoPostal = apartadoPostal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getPbx() {
		return pbx;
	}

	public void setPbx(String pbx) {
		this.pbx = pbx;
	}

	public Long getPersEmprId() {
		return persEmprId;
	}

	public void setPersEmprId(Long persEmprId) {
		this.persEmprId = persEmprId;
	}

	public String getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Long getCiudadId_Ciudad() {
		return ciudadId_Ciudad;
	}

	public void setCiudadId_Ciudad(Long ciudadId_Ciudad) {
		this.ciudadId_Ciudad = ciudadId_Ciudad;
	}

	public Long getEntBancId_EntBanc() {
		return entBancId_EntBanc;
	}

	public void setEntBancId_EntBanc(Long entBancId_EntBanc) {
		this.entBancId_EntBanc = entBancId_EntBanc;
	}

	public Long getProfId_Profesion() {
		return profId_Profesion;
	}

	public void setProfId_Profesion(Long profId_Profesion) {
		this.profId_Profesion = profId_Profesion;
	}

	public String getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}

	public String getTablaPrecios() {
		return tablaPrecios;
	}

	public void setTablaPrecios(String tablaPrecios) {
		this.tablaPrecios = tablaPrecios;
	}

	public String getEsArlEpsPension() {
		return esArlEpsPension;
	}

	public void setEsArlEpsPension(String esArlEpsPension) {
		this.esArlEpsPension = esArlEpsPension;
	}
}
