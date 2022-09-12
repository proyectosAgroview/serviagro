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
public class DatAbastCombustibleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatAbastCombustibleDTO.class);
    private Double cantidad;
    private String cierreOt;
    private Long compania;
    private Double conductor;
    private Long consecutivo;
    private Double costoTotal;
    private Long datAbastCombustibleId;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCierreOt;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaReaperturaOt;
    private Date fechaRegistro;
    private Double medidor;
    private Long numeroPlanillaFisica;
    private String observacion;
    private String observacionAnularReg;
    private Long turnoCampoId;
    private Long usuarioDigitacion;
    private Double valorUnitario;
    private Long bombaAbastecimientoId_BombaAbastecimiento;
    private Long centCostId_CentCost;
    private Long equipoId_Equipo;
    private Long productoId_Producto;
    private Long tipoAbastecimientoId_TipoAbastecimiento;
    private Long trabId_Trabajador;
    private Long udadMedId_UdadMed;
    private String estadoTrue;
	private Long almacenId;
	private String nombreEquipo;
	

    public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Long getAlmacenId() {
		return almacenId;
	}

	public void setAlmacenId(Long almacenId) {
		this.almacenId = almacenId;
	}

	public String getEstadoTrue() {
		return estadoTrue;
	}

	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getCierreOt() {
        return cierreOt;
    }

    public void setCierreOt(String cierreOt) {
        this.cierreOt = cierreOt;
    }

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Double getConductor() {
        return conductor;
    }

    public void setConductor(Double conductor) {
        this.conductor = conductor;
    }

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Long getDatAbastCombustibleId() {
        return datAbastCombustibleId;
    }

    public void setDatAbastCombustibleId(Long datAbastCombustibleId) {
        this.datAbastCombustibleId = datAbastCombustibleId;
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

    public Date getFechaCierreOt() {
        return fechaCierreOt;
    }

    public void setFechaCierreOt(Date fechaCierreOt) {
        this.fechaCierreOt = fechaCierreOt;
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

    public Date getFechaReaperturaOt() {
        return fechaReaperturaOt;
    }

    public void setFechaReaperturaOt(Date fechaReaperturaOt) {
        this.fechaReaperturaOt = fechaReaperturaOt;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getMedidor() {
        return medidor;
    }

    public void setMedidor(Double medidor) {
        this.medidor = medidor;
    }

    public Long getNumeroPlanillaFisica() {
        return numeroPlanillaFisica;
    }

    public void setNumeroPlanillaFisica(Long numeroPlanillaFisica) {
        this.numeroPlanillaFisica = numeroPlanillaFisica;
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

    public Long getTurnoCampoId() {
        return turnoCampoId;
    }

    public void setTurnoCampoId(Long turnoCampoId) {
        this.turnoCampoId = turnoCampoId;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getBombaAbastecimientoId_BombaAbastecimiento() {
        return bombaAbastecimientoId_BombaAbastecimiento;
    }

    public void setBombaAbastecimientoId_BombaAbastecimiento(
        Long bombaAbastecimientoId_BombaAbastecimiento) {
        this.bombaAbastecimientoId_BombaAbastecimiento = bombaAbastecimientoId_BombaAbastecimiento;
    }

    public Long getCentCostId_CentCost() {
        return centCostId_CentCost;
    }

    public void setCentCostId_CentCost(Long centCostId_CentCost) {
        this.centCostId_CentCost = centCostId_CentCost;
    }

    public Long getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Long equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public Long getProductoId_Producto() {
        return productoId_Producto;
    }

    public void setProductoId_Producto(Long productoId_Producto) {
        this.productoId_Producto = productoId_Producto;
    }

    public Long getTipoAbastecimientoId_TipoAbastecimiento() {
        return tipoAbastecimientoId_TipoAbastecimiento;
    }

    public void setTipoAbastecimientoId_TipoAbastecimiento(
        Long tipoAbastecimientoId_TipoAbastecimiento) {
        this.tipoAbastecimientoId_TipoAbastecimiento = tipoAbastecimientoId_TipoAbastecimiento;
    }

    public Long getTrabId_Trabajador() {
        return trabId_Trabajador;
    }

    public void setTrabId_Trabajador(Long trabId_Trabajador) {
        this.trabId_Trabajador = trabId_Trabajador;
    }

    public Long getUdadMedId_UdadMed() {
        return udadMedId_UdadMed;
    }

    public void setUdadMedId_UdadMed(Long udadMedId_UdadMed) {
        this.udadMedId_UdadMed = udadMedId_UdadMed;
    }
}
