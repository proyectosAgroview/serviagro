package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class Nivel2ClientesmqDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(Nivel2ClientesmqDTO.class);
    private String barrio;
    private String codigo;
    private String codigoAlternativo;
    private Long compania;
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
    private Long nivel2ClientesmqId;
    private String nombre;
    private String observacion;
    private String pbx;
    private Float precision1;
    private String telefono;
    private String tipoPropiedad;
    private Long vereda;
    private Long centCostId_CentCost;
    private Long ciudadId_Ciudad;
    private Long persEmprId_PersEmpr;
    private String nomCliente;
    
    
    
    /**
	 * @return the nomCliente
	 */
	public String getNomCliente() {
		return nomCliente;
	}

	/**
	 * @param nomCliente the nomCliente to set
	 */
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
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

    public String getCodigoAlternativo() {
        return codigoAlternativo;
    }

    public void setCodigoAlternativo(String codigoAlternativo) {
        this.codigoAlternativo = codigoAlternativo;
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

    public Long getNivel2ClientesmqId() {
        return nivel2ClientesmqId;
    }

    public void setNivel2ClientesmqId(Long nivel2ClientesmqId) {
        this.nivel2ClientesmqId = nivel2ClientesmqId;
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

    public Float getPrecision1() {
        return precision1;
    }

    public void setPrecision1(Float precision1) {
        this.precision1 = precision1;
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

    public Long getVereda() {
        return vereda;
    }

    public void setVereda(Long vereda) {
        this.vereda = vereda;
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

    public Long getPersEmprId_PersEmpr() {
        return persEmprId_PersEmpr;
    }

    public void setPersEmprId_PersEmpr(Long persEmprId_PersEmpr) {
        this.persEmprId_PersEmpr = persEmprId_PersEmpr;
    }
}
