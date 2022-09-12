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
public class Nivel2DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Nivel2DTO.class);
	private String barrio;
	private String codigo;
	private Long compania;
	private Long vereda;
	private String direccion;
	private Double distanciaOficina;
	private Double distanciaPlanta;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private Float latitud;
	private Float longitud;
	private Long nivel2Id;
	private String nombre;
	private String observacion;
	private String pbx;
	private Float precision;
	private String telefono;
	private String tipoPropiedad;
	private Long centCostId_CentCost;
	private Long ciudadId_Ciudad;
	private Long frtCosId_FrenteCos;
	private Long grpTenId_GrpTenen;
	private Long nivel1Id_Nivel1;
	private Long proveId_Proveedor;
	private Long trabId_Trabajador;
	private Long zonaGeograficaId_ZonaGeografica;
	private String nombreNivel1;
	private Double pesoPromedio;
	private Long pluvioId;
	
	
	/**
	 * @return the pluvioId
	 */
	public Long getPluvioId() {
		return pluvioId;
	}

	/**
	 * @param pluvioId the pluvioId to set
	 */
	public void setPluvioId(Long pluvioId) {
		this.pluvioId = pluvioId;
	}

	private String codigoAlternativo;

	public String getCodigoAlternativo() {
		return codigoAlternativo;
	}

	public void setCodigoAlternativo(String codigoAlternativo) {
		this.codigoAlternativo = codigoAlternativo;
	}

	public Long getVereda() {
		return vereda;
	}

	public void setVereda(Long vereda) {
		this.vereda = vereda;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(Double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getDistanciaOficina() {
		return distanciaOficina;
	}

	public void setDistanciaOficina(Double distanciaOficina) {
		this.distanciaOficina = distanciaOficina;
	}

	public Double getDistanciaPlanta() {
		return distanciaPlanta;
	}

	public void setDistanciaPlanta(Double distanciaPlanta) {
		this.distanciaPlanta = distanciaPlanta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Long getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Long nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPbx() {
		return pbx;
	}

	public void setPbx(String pbx) {
		this.pbx = pbx;
	}

	public Float getPrecision() {
		return precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoPropiedad() {
		return tipoPropiedad;
	}

	public void setTipoPropiedad(String tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}

	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}

	public Long getCiudadId_Ciudad() {
		return ciudadId_Ciudad;
	}

	public void setCiudadId_Ciudad(Long ciudadId_Ciudad) {
		this.ciudadId_Ciudad = ciudadId_Ciudad;
	}

	public Long getFrtCosId_FrenteCos() {
		return frtCosId_FrenteCos;
	}

	public void setFrtCosId_FrenteCos(Long frtCosId_FrenteCos) {
		this.frtCosId_FrenteCos = frtCosId_FrenteCos;
	}

	public Long getGrpTenId_GrpTenen() {
		return grpTenId_GrpTenen;
	}

	public void setGrpTenId_GrpTenen(Long grpTenId_GrpTenen) {
		this.grpTenId_GrpTenen = grpTenId_GrpTenen;
	}

	public Long getNivel1Id_Nivel1() {
		return nivel1Id_Nivel1;
	}

	public void setNivel1Id_Nivel1(Long nivel1Id_Nivel1) {
		this.nivel1Id_Nivel1 = nivel1Id_Nivel1;
	}

	public Long getProveId_Proveedor() {
		return proveId_Proveedor;
	}

	public void setProveId_Proveedor(Long proveId_Proveedor) {
		this.proveId_Proveedor = proveId_Proveedor;
	}

	public Long getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Long trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public Long getZonaGeograficaId_ZonaGeografica() {
		return zonaGeograficaId_ZonaGeografica;
	}

	public void setZonaGeograficaId_ZonaGeografica(Long zonaGeograficaId_ZonaGeografica) {
		this.zonaGeograficaId_ZonaGeografica = zonaGeograficaId_ZonaGeografica;
	}

	public String getNombreNivel1() {
		return nombreNivel1;
	}

	public void setNombreNivel1(String nombreNivel1) {
		this.nombreNivel1 = nombreNivel1;
	}

}
