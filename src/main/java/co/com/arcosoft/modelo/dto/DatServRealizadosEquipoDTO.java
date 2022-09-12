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
public class DatServRealizadosEquipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatServRealizadosEquipoDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datServRealizadosEquipoId;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private Long numFactura;
    private String observacion;
    private String observacionAnularReg;
    private String origenDatos;
    private String serieFactura;
    private Long usuarioDigitacion;
    private Long centCostId_CentCost;
    private Long elemCostoId_ElementoCosto;
    private Long equipoId_Equipo;
    private Long persEmprId_PersEmpr;
    private String nombreEquipo;
    private String estadoTrue;
    
    private Long productoId;
 	private Double cantidadCombustible;
 	private Double sello;
 	private Long almacenId;
 	private Double costoCombustible;
	private String puedeEditarPin;
	private String dobleTanqueo;
	
	private Long indicador_vuelta_medidor;
	
	
		

    public Long getIndicador_vuelta_medidor() {
		return indicador_vuelta_medidor;
	}

	public void setIndicador_vuelta_medidor(Long indicador_vuelta_medidor) {
		this.indicador_vuelta_medidor = indicador_vuelta_medidor;
	}

	
    
	public String getDobleTanqueo() {
		return dobleTanqueo;
	}

	public void setDobleTanqueo(String dobleTanqueo) {
		this.dobleTanqueo = dobleTanqueo;
	}

	public String getPuedeEditarPin() {
		return puedeEditarPin;
	}

	public void setPuedeEditarPin(String puedeEditarPin) {
		this.puedeEditarPin = puedeEditarPin;
	}

	/**
	 * @return the costoCombustible
	 */
	public Double getCostoCombustible() {
		return costoCombustible;
	}

	/**
	 * @param costoCombustible the costoCombustible to set
	 */
	public void setCostoCombustible(Double costoCombustible) {
		this.costoCombustible = costoCombustible;
	}

	/**
	 * @return the productoId
	 */
	public Long getProductoId() {
		return productoId;
	}

	/**
	 * @param productoId the productoId to set
	 */
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

		/**
	 * @return the almacenId
	 */
	public Long getAlmacenId() {
		return almacenId;
	}

	/**
	 * @param almacenId the almacenId to set
	 */
	public void setAlmacenId(Long almacenId) {
		this.almacenId = almacenId;
	}

	

	/**
	 * @return the cantidadCombustible
	 */
	public Double getCantidadCombustible() {
		return cantidadCombustible;
	}

	/**
	 * @param cantidadCombustible the cantidadCombustible to set
	 */
	public void setCantidadCombustible(Double cantidadCombustible) {
		this.cantidadCombustible = cantidadCombustible;
	}

	/**
	 * @return the sello
	 */
	public Double getSello() {
		return sello;
	}

	/**
	 * @param sello the sello to set
	 */
	public void setSello(Double sello) {
		this.sello = sello;
	}

		/**
	 * @return the estadoTrue
	 */
	public String getEstadoTrue() {
		return estadoTrue;
	}

	/**
	 * @param estadoTrue the estadoTrue to set
	 */
	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	/**
	 * @return the nombreEquipo
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	/**
	 * @param nombreEquipo the nombreEquipo to set
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Long getDatServRealizadosEquipoId() {
        return datServRealizadosEquipoId;
    }

    public void setDatServRealizadosEquipoId(Long datServRealizadosEquipoId) {
        this.datServRealizadosEquipoId = datServRealizadosEquipoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(Long numFactura) {
        this.numFactura = numFactura;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacionAnularReg() {
        return observacionAnularReg;
    }

    public void setObservacionAnularReg(String observacionAnularReg) {
        this.observacionAnularReg = observacionAnularReg;
    }

    public String getOrigenDatos() {
        return origenDatos;
    }

    public void setOrigenDatos(String origenDatos) {
        this.origenDatos = origenDatos;
    }

    public String getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Long getCentCostId_CentCost() {
        return centCostId_CentCost;
    }

    public void setCentCostId_CentCost(Long centCostId_CentCost) {
        this.centCostId_CentCost = centCostId_CentCost;
    }

    public Long getElemCostoId_ElementoCosto() {
        return elemCostoId_ElementoCosto;
    }

    public void setElemCostoId_ElementoCosto(Long elemCostoId_ElementoCosto) {
        this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
    }

    public Long getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Long equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public Long getPersEmprId_PersEmpr() {
        return persEmprId_PersEmpr;
    }

    public void setPersEmprId_PersEmpr(Long persEmprId_PersEmpr) {
        this.persEmprId_PersEmpr = persEmprId_PersEmpr;
    }
}
