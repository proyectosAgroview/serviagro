package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatCajaMenorDetDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatCajaMenorDetDTO.class);
	private Long datCajaMenordetId;
	private String detalleNota;
	private Double valor;
	private Long datCajaMenorId_DatCajaMenor;
	private Equipo equipoId_Equipo;
	private Labor laborId_Labor;
	private String nombreLabor;
	private String codigoEquipo;
	private String nomProveedor;
	private PersEmpr persEmpr;
	private Long idProveedor;
	private Long implementoId;
	private String codImplemento;
    private String numFactura;
    
	private Long centCostId_CentCost;
    private String 	nombreCentroCosto;
    
    
    
	
	public String getNombreCentroCosto() {
		return nombreCentroCosto;
	}

	public void setNombreCentroCosto(String nombreCentroCosto) {
		this.nombreCentroCosto = nombreCentroCosto;
	}

	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}

	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public Long getImplementoId() {
		return implementoId;
	}

	public String getCodImplemento() {
		return codImplemento;
	}

	public void setImplementoId(Long implementoId) {
		this.implementoId = implementoId;
	}

	public void setCodImplemento(String codImplemento) {
		this.codImplemento = codImplemento;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public PersEmpr getPersEmpr() {
		return persEmpr;
	}

	public void setPersEmpr(PersEmpr persEmpr) {
		this.persEmpr = persEmpr;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getCodigoEquipo() {
		return codigoEquipo;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public void setEquipoId_Equipo(Equipo equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
	}

	public Long getDatCajaMenordetId() {
		return datCajaMenordetId;
	}

	public void setDatCajaMenordetId(Long datCajaMenordetId) {
		this.datCajaMenordetId = datCajaMenordetId;
	}

	public String getDetalleNota() {
		return detalleNota;
	}

	public void setDetalleNota(String detalleNota) {
		this.detalleNota = detalleNota;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getDatCajaMenorId_DatCajaMenor() {
		return datCajaMenorId_DatCajaMenor;
	}

	public void setDatCajaMenorId_DatCajaMenor(Long datCajaMenorId_DatCajaMenor) {
		this.datCajaMenorId_DatCajaMenor = datCajaMenorId_DatCajaMenor;
	}

	public Equipo getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

}
