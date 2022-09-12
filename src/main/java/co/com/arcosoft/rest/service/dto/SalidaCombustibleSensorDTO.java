package co.com.arcosoft.rest.service.dto;

import java.io.Serializable;
import java.lang.Character.UnicodeBlock;
import java.util.Date;

import org.apache.poi.hssf.record.common.UnicodeString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class SalidaCombustibleSensorDTO {
	private UnicodeString codigoUsuario;
	private UnicodeString cargo;
	private UnicodeString estatus;
	 private UnicodeString codigoSurtidor;
	 private UnicodeString codigoMaquina;
	 private Float  horometroAbastecimiento; 
	 private Float cantidadCombustible;
	 private Float cantidadCombustibleSurtidor;
	 private Float errorPorcentual;
	 private Float saldoSensor;
	 private Float saldoFacturado;
	 private UnicodeString fecha;
	 private UnicodeString id_registro;
	 
	public UnicodeString getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(UnicodeString codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public UnicodeString getCargo() {
		return cargo;
	}
	public void setCargo(UnicodeString cargo) {
		this.cargo = cargo;
	}
	public UnicodeString getEstatus() {
		return estatus;
	}
	public void setEstatus(UnicodeString estatus) {
		this.estatus = estatus;
	}
	public UnicodeString getCodigoSurtidor() {
		return codigoSurtidor;
	}
	public void setCodigoSurtidor(UnicodeString codigoSurtidor) {
		this.codigoSurtidor = codigoSurtidor;
	}
	public UnicodeString getCodigoMaquina() {
		return codigoMaquina;
	}
	public void setCodigoMaquina(UnicodeString codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	public Float getHorometroAbastecimiento() {
		return horometroAbastecimiento;
	}
	public void setHorometroAbastecimiento(Float horometroAbastecimiento) {
		this.horometroAbastecimiento = horometroAbastecimiento;
	}
	public Float getCantidadCombustible() {
		return cantidadCombustible;
	}
	public void setCantidadCombustible(Float cantidadCombustible) {
		this.cantidadCombustible = cantidadCombustible;
	}
	public Float getCantidadCombustibleSurtidor() {
		return cantidadCombustibleSurtidor;
	}
	public void setCantidadCombustibleSurtidor(Float cantidadCombustibleSurtidor) {
		this.cantidadCombustibleSurtidor = cantidadCombustibleSurtidor;
	}
	public Float getErrorPorcentual() {
		return errorPorcentual;
	}
	public void setErrorPorcentual(Float errorPorcentual) {
		this.errorPorcentual = errorPorcentual;
	}
	public Float getSaldoSensor() {
		return saldoSensor;
	}
	public void setSaldoSensor(Float saldoSensor) {
		this.saldoSensor = saldoSensor;
	}
	public Float getSaldoFacturado() {
		return saldoFacturado;
	}
	public void setSaldoFacturado(Float saldoFacturado) {
		this.saldoFacturado = saldoFacturado;
	}
	public UnicodeString getFecha() {
		return fecha;
	}
	public void setFecha(UnicodeString fecha) {
		this.fecha = fecha;
	}
	public UnicodeString getId_registro() {
		return id_registro;
	}
	public void setId_registro(UnicodeString id_registro) {
		this.id_registro = id_registro;
	}
	
	
	 
	 
	 

	 
	
	
    
   
    
}
