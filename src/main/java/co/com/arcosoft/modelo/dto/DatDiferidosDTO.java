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
public class DatDiferidosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosDTO.class);
    private Long anioAplicacion;
    private Long compania;
    private Long consecutivo;
    private Long datDiferidosId;
    private String detalleAplicacion;
    private String detalleNota;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private Long laborId;
    private Long mesAplicacion;
    private Long npReset;
    private String observacion;
    private String observacionAnularReg;
    private Long periodos;
    private Long usuarioDigitacion;
    private Double valorCuota;
    private Double valorInicial;
    private Double valorSaldo;
    private String numeroFactura;
    
    private String nombreLabor;
    
    private Long categEquipId;
    private String tipoTransaccion;
    private Long persEmpr;
private Long centCostId;
    
    
    
    
    

    public Long getCentCostId() {
		return centCostId;
	}

	public void setCentCostId(Long centCostId) {
		this.centCostId = centCostId;
	}

    
    
    public Long getPersEmpr() {
		return persEmpr;
	}

	public void setPersEmpr(Long persEmpr) {
		this.persEmpr = persEmpr;
	}

	public Long getCategEquipId() {
		return categEquipId;
	}

	public void setCategEquipId(Long categEquipId) {
		this.categEquipId = categEquipId;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Long getAnioAplicacion() {
        return anioAplicacion;
    }

    public void setAnioAplicacion(Long anioAplicacion) {
        this.anioAplicacion = anioAplicacion;
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

    public Long getDatDiferidosId() {
        return datDiferidosId;
    }

    public void setDatDiferidosId(Long datDiferidosId) {
        this.datDiferidosId = datDiferidosId;
    }

    public String getDetalleAplicacion() {
        return detalleAplicacion;
    }

    public void setDetalleAplicacion(String detalleAplicacion) {
        this.detalleAplicacion = detalleAplicacion;
    }

    public String getDetalleNota() {
        return detalleNota;
    }

    public void setDetalleNota(String detalleNota) {
        this.detalleNota = detalleNota;
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

    public Long getLaborId() {
        return laborId;
    }

    public void setLaborId(Long laborId) {
        this.laborId = laborId;
    }

    public Long getMesAplicacion() {
        return mesAplicacion;
    }

    public void setMesAplicacion(Long mesAplicacion) {
        this.mesAplicacion = mesAplicacion;
    }

    public Long getNpReset() {
        return npReset;
    }

    public void setNpReset(Long npReset) {
        this.npReset = npReset;
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

    public Long getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Long periodos) {
        this.periodos = periodos;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(Double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(Double valorSaldo) {
        this.valorSaldo = valorSaldo;
    }
}
