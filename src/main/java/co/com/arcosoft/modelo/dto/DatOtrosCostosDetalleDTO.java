package co.com.arcosoft.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatOtrosCostosDetalleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosDetalleDTO.class);
	private Long ccontableId;
	private Long datOtrosCostosDetId;
	private String numFactura;
	private String observacion;
	private String serieFactura;
	private Double valorTotal;
	private Long datOtrosCostosId_DatOtrosCostos;
	private ElementoCosto elemCostoId_ElementoCosto;
	private Labor laborId_Labor;
	private PersEmpr persEmprId_PersEmpr;
	
	private String nombreElementoCosto;
	private String nombreLabor;
	private String nomPersEmpr;

	public Long getCcontableId() {
		return ccontableId;
	}

	public void setCcontableId(Long ccontableId) {
		this.ccontableId = ccontableId;
	}

	public Long getDatOtrosCostosDetId() {
		return datOtrosCostosDetId;
	}

	public void setDatOtrosCostosDetId(Long datOtrosCostosDetId) {
		this.datOtrosCostosDetId = datOtrosCostosDetId;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getSerieFactura() {
		return serieFactura;
	}

	public void setSerieFactura(String serieFactura) {
		this.serieFactura = serieFactura;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getDatOtrosCostosId_DatOtrosCostos() {
		return datOtrosCostosId_DatOtrosCostos;
	}

	public void setDatOtrosCostosId_DatOtrosCostos(Long datOtrosCostosId_DatOtrosCostos) {
		this.datOtrosCostosId_DatOtrosCostos = datOtrosCostosId_DatOtrosCostos;
	}

	public ElementoCosto getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(ElementoCosto elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}

	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public PersEmpr getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(PersEmpr persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public String getNombreElementoCosto() {
		return nombreElementoCosto;
	}

	public void setNombreElementoCosto(String nombreElementoCosto) {
		this.nombreElementoCosto = nombreElementoCosto;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getNomPersEmpr() {
		return nomPersEmpr;
	}

	public void setNomPersEmpr(String nomPersEmpr) {
		this.nomPersEmpr = nomPersEmpr;
	}
}
