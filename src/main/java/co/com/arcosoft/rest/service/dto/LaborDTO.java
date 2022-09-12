package co.com.arcosoft.rest.service.dto;

import java.util.Date;

public class LaborDTO {
	public Long compania;
	private Long laborId;
	private String codigo;
	private String nombre;
	private Long udadMedByUdadMedPago;
	private Long grpLabor;
	private String tipoLabor;
	private String rendimientoMq;
	private String claseLabor;
	
	
	
	
	public String getClaseLabor() {
		return claseLabor;
	}
	public void setClaseLabor(String claseLabor) {
		this.claseLabor = claseLabor;
	}
	public String getRendimientoMq() {
		return rendimientoMq;
	}
	public void setRendimientoMq(String rendimientoMq) {
		this.rendimientoMq = rendimientoMq;
	}
	public String getTipoLabor() {
		return tipoLabor;
	}
	public void setTipoLabor(String tipoLabor) {
		this.tipoLabor = tipoLabor;
	}
	public Long getCompania() {
		return compania;
	}
	public void setCompania(Long compania) {
		this.compania = compania;
	}
	public Long getLaborId() {
		return laborId;
	}
	public void setLaborId(Long laborId) {
		this.laborId = laborId;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getUdadMedByUdadMedPago() {
		return udadMedByUdadMedPago;
	}
	public void setUdadMedByUdadMedPago(Long udadMedByUdadMedPago) {
		this.udadMedByUdadMedPago = udadMedByUdadMedPago;
	}
	public Long getGrpLabor() {
		return grpLabor;
	}
	public void setGrpLabor(Long grpLabor) {
		this.grpLabor = grpLabor;
	}

	
	
	
}
