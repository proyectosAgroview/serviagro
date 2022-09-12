package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class CompaniaDTO {

	private Long companiaId;
	private Long entBanc;
	private Long ciudad;
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String pbx;
	private String rut;
	private Float longitud;
	private Float latitud;
	private Float precision;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private String estado_kml;
	private String url_kml;

	public CompaniaDTO() {
	}

	public CompaniaDTO(Long companiaId) {
		this.companiaId = companiaId;
	}

	public CompaniaDTO(Long companiaId, Long entBanc, Long ciudad, String codigo, String nombre, String direccion,
			String telefono, String pbx, String rut, Float longitud, Float latitud, Float precision,
			String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			String estado_kml, String url_kml) {
		this.companiaId = companiaId;
		this.entBanc = entBanc;
		this.ciudad = ciudad;
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pbx = pbx;
		this.rut = rut;
		this.longitud = longitud;
		this.latitud = latitud;
		this.precision = precision;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.estado_kml = estado_kml;
		this.url_kml = url_kml;
	}

	public Long getCompaniaId() {
		return this.companiaId;
	}

	public void setCompaniaId(Long companiaId) {
		this.companiaId = companiaId;
	}

	public Long getEntBanc() {
		return this.entBanc;
	}

	public void setEntBanc(Long entBanc) {
		this.entBanc = entBanc;
	}

	public Long getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Long ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPbx() {
		return this.pbx;
	}

	public void setPbx(String pbx) {
		this.pbx = pbx;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Float getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getPrecision() {
		return this.precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado_kml() {
		return estado_kml;
	}

	public String getUrl_kml() {
		return url_kml;
	}

	public void setEstado_kml(String estado_kml) {
		this.estado_kml = estado_kml;
	}

	public void setUrl_kml(String url_kml) {
		this.url_kml = url_kml;
	}

}
