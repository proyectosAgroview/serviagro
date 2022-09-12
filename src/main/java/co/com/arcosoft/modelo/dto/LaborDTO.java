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
public class LaborDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LaborDTO.class);
	private String claseLabor;
	private String codigo;
	private String color;
	private String formaPago;
	private Long compania;
	private String digitaLinea;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private Long laborId;
	private String nombre;
	private Long restriCicloCosecha;
	private Long restriSecuencia;
	private String tipoLabor;
	private Long grpLaborId_GrpLabor;
	private Long udadMedId_UdadMed_Plan;
	private Long udadMedId_UdadMed_Pago;
	private Long udadMedId_UdadMed_Prod;
	private Double rendimientoMo;
	private Double rendimientoMq;
	private Double consumoAcpm;
	private String trabajarConAreaPlantas;
	private String grupoLabor;
	private Long cuentaContable;
	
    private Double pagoPorArea;
    private Double tarifaEstandar;
	private Double tarifaEstandar2;
	private Double tarifaEstandar3;
	private Double tarifaEstandar4;
	private Double tarifaEstandar5;
	private Double tarifaEstandar6;
	private Double tarifaEstandar7;
	private Double tarifaEstandar8;
	private Double tarifaEstandar9;
	private Double tarifaEstandar10;
    
    private String tipoParada;
    
    

	public String getTipoParada() {
		return tipoParada;
	}

	public void setTipoParada(String tipoParada) {
		this.tipoParada = tipoParada;
	}

	public Double getPagoPorArea() {
		return pagoPorArea;
	}

	public void setPagoPorArea(Double pagoPorArea) {
		this.pagoPorArea = pagoPorArea;
	}

	public Double getTarifaEstandar() {
		return tarifaEstandar;
	}

	public void setTarifaEstandar(Double tarifaEstandar) {
		this.tarifaEstandar = tarifaEstandar;
	}

	public Long getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(Long cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public String getGrupoLabor() {
	return grupoLabor;
}

public void setGrupoLabor(String grupoLabor) {
	this.grupoLabor = grupoLabor;
}

	public String getTrabajarConAreaPlantas() {
		return trabajarConAreaPlantas;
	}

	public void setTrabajarConAreaPlantas(String trabajarConAreaPlantas) {
		this.trabajarConAreaPlantas = trabajarConAreaPlantas;
	}

	public Double getConsumoAcpm() {
		return consumoAcpm;
	}

	public void setConsumoAcpm(Double consumoAcpm) {
		this.consumoAcpm = consumoAcpm;
	}

	public Double getRendimientoMo() {
		return rendimientoMo;
	}

	public void setRendimientoMo(Double rendimientoMo) {
		this.rendimientoMo = rendimientoMo;
	}

	public Double getRendimientoMq() {
		return rendimientoMq;
	}

	public void setRendimientoMq(Double rendimientoMq) {
		this.rendimientoMq = rendimientoMq;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getClaseLabor() {
		return claseLabor;
	}

	public void setClaseLabor(String claseLabor) {
		this.claseLabor = claseLabor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getDigitaLinea() {
		return digitaLinea;
	}

	public void setDigitaLinea(String digitaLinea) {
		this.digitaLinea = digitaLinea;
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

	public Long getLaborId() {
		return laborId;
	}

	public void setLaborId(Long laborId) {
		this.laborId = laborId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getRestriCicloCosecha() {
		return restriCicloCosecha;
	}

	public void setRestriCicloCosecha(Long restriCicloCosecha) {
		this.restriCicloCosecha = restriCicloCosecha;
	}

	public Long getRestriSecuencia() {
		return restriSecuencia;
	}

	public void setRestriSecuencia(Long restriSecuencia) {
		this.restriSecuencia = restriSecuencia;
	}

	public String getTipoLabor() {
		return tipoLabor;
	}

	public void setTipoLabor(String tipoLabor) {
		this.tipoLabor = tipoLabor;
	}

	public Long getGrpLaborId_GrpLabor() {
		return grpLaborId_GrpLabor;
	}

	public void setGrpLaborId_GrpLabor(Long grpLaborId_GrpLabor) {
		this.grpLaborId_GrpLabor = grpLaborId_GrpLabor;
	}

	public Long getUdadMedId_UdadMed_Plan() {
		return udadMedId_UdadMed_Plan;
	}

	public void setUdadMedId_UdadMed_Plan(Long udadMedId_UdadMed_Plan) {
		this.udadMedId_UdadMed_Plan = udadMedId_UdadMed_Plan;
	}

	public Long getUdadMedId_UdadMed_Pago() {
		return udadMedId_UdadMed_Pago;
	}

	public void setUdadMedId_UdadMed_Pago(Long udadMedId_UdadMed_Pago) {
		this.udadMedId_UdadMed_Pago = udadMedId_UdadMed_Pago;
	}

	public Long getUdadMedId_UdadMed_Prod() {
		return udadMedId_UdadMed_Prod;
	}

	public void setUdadMedId_UdadMed_Prod(Long udadMedId_UdadMed_Prod) {
		this.udadMedId_UdadMed_Prod = udadMedId_UdadMed_Prod;
	}

	public Double getTarifaEstandar2() {
		return tarifaEstandar2;
	}

	public void setTarifaEstandar2(Double tarifaEstandar2) {
		this.tarifaEstandar2 = tarifaEstandar2;
	}

	public Double getTarifaEstandar3() {
		return tarifaEstandar3;
	}

	public void setTarifaEstandar3(Double tarifaEstandar3) {
		this.tarifaEstandar3 = tarifaEstandar3;
	}

	public Double getTarifaEstandar4() {
		return tarifaEstandar4;
	}

	public void setTarifaEstandar4(Double tarifaEstandar4) {
		this.tarifaEstandar4 = tarifaEstandar4;
	}

	public Double getTarifaEstandar5() {
		return tarifaEstandar5;
	}

	public void setTarifaEstandar5(Double tarifaEstandar5) {
		this.tarifaEstandar5 = tarifaEstandar5;
	}

	public Double getTarifaEstandar6() {
		return tarifaEstandar6;
	}

	public void setTarifaEstandar6(Double tarifaEstandar6) {
		this.tarifaEstandar6 = tarifaEstandar6;
	}

	public Double getTarifaEstandar7() {
		return tarifaEstandar7;
	}

	public void setTarifaEstandar7(Double tarifaEstandar7) {
		this.tarifaEstandar7 = tarifaEstandar7;
	}

	public Double getTarifaEstandar8() {
		return tarifaEstandar8;
	}

	public void setTarifaEstandar8(Double tarifaEstandar8) {
		this.tarifaEstandar8 = tarifaEstandar8;
	}

	public Double getTarifaEstandar9() {
		return tarifaEstandar9;
	}

	public void setTarifaEstandar9(Double tarifaEstandar9) {
		this.tarifaEstandar9 = tarifaEstandar9;
	}

	public Double getTarifaEstandar10() {
		return tarifaEstandar10;
	}

	public void setTarifaEstandar10(Double tarifaEstandar10) {
		this.tarifaEstandar10 = tarifaEstandar10;
	}
}
