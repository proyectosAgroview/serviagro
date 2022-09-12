package co.com.arcosoft.modelo;
// Generated 19-oct-2018 9:33:36 by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DatDiferidos generated by hbm2java
 */
public class DatDiferidos  implements java.io.Serializable {


     private Long datDiferidosId;
     private Long consecutivo;
     private Labor laborId;
     private Long compania;
     private Date fechaRegistro;
     private Double valorInicial;
     private Double valorCuota;
     private Double valorSaldo;
     private Long periodos;
     private Long npReset;
     private String detalleNota;
     private Long anioAplicacion;
     private Long mesAplicacion;
     private String detalleAplicacion;
     private Long usuarioDigitacion;
     private Date fechaCreacion;
     private String estado;
     private String observacionAnularReg;
     private Date fechaAnulacion;
     private String observacion;
     private Date fechaModificacion;
     private Set<DatDiferidosDet> datDiferidosDets = new HashSet<DatDiferidosDet>(0);
     private String numeroFactura;
     private Long categEquipId;
     private String tipoTransaccion;
     private PersEmpr persEmpr;
     private Long centCostId;
     
    public DatDiferidos() {
    }

    public DatDiferidos(Long consecutivo, Labor laborId, Long compania, Date fechaRegistro, Double valorInicial, Double valorCuota, Double valorSaldo, Long periodos, Long npReset, String detalleNota, Long anioAplicacion, Long mesAplicacion, String detalleAplicacion, Long usuarioDigitacion, Date fechaCreacion, String estado, String observacionAnularReg, Date fechaAnulacion, String observacion, Date fechaModificacion, Set<DatDiferidosDet> datDiferidosDets,
    		String numeroFactura, String  tipoTransaccion, Long categEquipId, PersEmpr persEmpr	, Long  centCostId) {
       this.consecutivo = consecutivo;
       this.laborId = laborId;
       this.compania = compania;
       this.fechaRegistro = fechaRegistro;
       this.valorInicial = valorInicial;
       this.valorCuota = valorCuota;
       this.valorSaldo = valorSaldo;
       this.periodos = periodos;
       this.npReset = npReset;
       this.detalleNota = detalleNota;
       this.anioAplicacion = anioAplicacion;
       this.mesAplicacion = mesAplicacion;
       this.detalleAplicacion = detalleAplicacion;
       this.usuarioDigitacion = usuarioDigitacion;
       this.fechaCreacion = fechaCreacion;
       this.estado = estado;
       this.observacionAnularReg = observacionAnularReg;
       this.fechaAnulacion = fechaAnulacion;
       this.observacion = observacion;
       this.fechaModificacion = fechaModificacion;
       this.datDiferidosDets = datDiferidosDets;
       this.numeroFactura=numeroFactura;
       this.tipoTransaccion= tipoTransaccion;
       this.categEquipId=categEquipId;
       this.persEmpr=persEmpr;
       this.centCostId=centCostId;
    }
   
    
    
    public Long getCentCostId() {
		return centCostId;
	}

	public void setCentCostId(Long centCostId) {
		this.centCostId = centCostId;
	}

	public PersEmpr getPersEmpr() {
		return persEmpr;
	}

	public void setPersEmpr(PersEmpr persEmpr) {
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

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Long getDatDiferidosId() {
        return this.datDiferidosId;
    }
    
    public void setDatDiferidosId(Long datDiferidosId) {
        this.datDiferidosId = datDiferidosId;
    }
    public Long getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Labor getLaborId() {
        return this.laborId;
    }
    
    public void setLaborId(Labor laborId) {
        this.laborId = laborId;
    }
    public Long getCompania() {
        return this.compania;
    }
    
    public void setCompania(Long compania) {
        this.compania = compania;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Double getValorInicial() {
        return this.valorInicial;
    }
    
    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }
    public Double getValorCuota() {
        return this.valorCuota;
    }
    
    public void setValorCuota(Double valorCuota) {
        this.valorCuota = valorCuota;
    }
    public Double getValorSaldo() {
        return this.valorSaldo;
    }
    
    public void setValorSaldo(Double valorSaldo) {
        this.valorSaldo = valorSaldo;
    }
    public Long getPeriodos() {
        return this.periodos;
    }
    
    public void setPeriodos(Long periodos) {
        this.periodos = periodos;
    }
    public Long getNpReset() {
        return this.npReset;
    }
    
    public void setNpReset(Long npReset) {
        this.npReset = npReset;
    }
    public String getDetalleNota() {
        return this.detalleNota;
    }
    
    public void setDetalleNota(String detalleNota) {
        this.detalleNota = detalleNota;
    }
    public Long getAnioAplicacion() {
        return this.anioAplicacion;
    }
    
    public void setAnioAplicacion(Long anioAplicacion) {
        this.anioAplicacion = anioAplicacion;
    }
    public Long getMesAplicacion() {
        return this.mesAplicacion;
    }
    
    public void setMesAplicacion(Long mesAplicacion) {
        this.mesAplicacion = mesAplicacion;
    }
    public String getDetalleAplicacion() {
        return this.detalleAplicacion;
    }
    
    public void setDetalleAplicacion(String detalleAplicacion) {
        this.detalleAplicacion = detalleAplicacion;
    }
    public Long getUsuarioDigitacion() {
        return this.usuarioDigitacion;
    }
    
    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getObservacionAnularReg() {
        return this.observacionAnularReg;
    }
    
    public void setObservacionAnularReg(String observacionAnularReg) {
        this.observacionAnularReg = observacionAnularReg;
    }
    public Date getFechaAnulacion() {
        return this.fechaAnulacion;
    }
    
    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public Set<DatDiferidosDet> getDatDiferidosDets() {
        return this.datDiferidosDets;
    }
    
    public void setDatDiferidosDets(Set<DatDiferidosDet> datDiferidosDets) {
        this.datDiferidosDets = datDiferidosDets;
    }




}

