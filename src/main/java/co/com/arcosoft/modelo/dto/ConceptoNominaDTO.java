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
public class ConceptoNominaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ConceptoNominaDTO.class);
	private Long ceptoNominaId;
	private String codigo;
	private Long compania;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private Long elemCostoId_ElementoCosto;
	private Double factorPrestacional;
	private String excluyeInteface;
	private String excluyeDominical;
	private String excluyeAuxilio;
	private String excluyeAdmon;
	private Long cuentaContable;
	private String esAusentismo;
	private Long cuentaContable2;
	private Long udadMedId;
	    
	 private String tipoConcepto;
	 
	 
	  
	public String getTipoConcepto() {
		return tipoConcepto;
	}

	public void setTipoConcepto(String tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}

	/**
		 * @return the cuentaContable2
		 */
		public Long getCuentaContable2() {
			return cuentaContable2;
		}

		/**
		 * @param cuentaContable2 the cuentaContable2 to set
		 */
		public void setCuentaContable2(Long cuentaContable2) {
			this.cuentaContable2 = cuentaContable2;
		}

		/**
		 * @return the udadMedId
		 */
		public Long getUdadMedId() {
			return udadMedId;
		}

		/**
		 * @param udadMedId the udadMedId to set
		 */
		public void setUdadMedId(Long udadMedId) {
			this.udadMedId = udadMedId;
		}

	/**
	 * @return the esAusentismo
	 */
	public String getEsAusentismo() {
		return esAusentismo;
	}

	/**
	 * @param esAusentismo the esAusentismo to set
	 */
	public void setEsAusentismo(String esAusentismo) {
		this.esAusentismo = esAusentismo;
	}

	/**
	 * @return the cuentaContable
	 */
	public Long getCuentaContable() {
		return cuentaContable;
	}

	/**
	 * @param cuentaContable the cuentaContable to set
	 */
	public void setCuentaContable(Long cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public String getExcluyeAdmon() {
		return excluyeAdmon;
	}

	public void setExcluyeAdmon(String excluyeAdmon) {
		this.excluyeAdmon = excluyeAdmon;
	}

	public String getExcluyeInteface() {
		return excluyeInteface;
	}

	public void setExcluyeInteface(String excluyeInteface) {
		this.excluyeInteface = excluyeInteface;
	}

	public String getExcluyeDominical() {
		return excluyeDominical;
	}

	public void setExcluyeDominical(String excluyeDominical) {
		this.excluyeDominical = excluyeDominical;
	}

	public String getExcluyeAuxilio() {
		return excluyeAuxilio;
	}

	public void setExcluyeAuxilio(String excluyeAuxilio) {
		this.excluyeAuxilio = excluyeAuxilio;
	}

	public Double getFactorPrestacional() {
		return factorPrestacional;
	}

	public void setFactorPrestacional(Double factorPrestacional) {
		this.factorPrestacional = factorPrestacional;
	}

	public Long getCeptoNominaId() {
		return ceptoNominaId;
	}

	public void setCeptoNominaId(Long ceptoNominaId) {
		this.ceptoNominaId = ceptoNominaId;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(Long elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}
}
