package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ListadoPinesMaquinariaDTO {

	private	BigInteger	equipo_id	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	BigInteger	pin	;
	private	BigDecimal	horometro_inicial	;
	private	BigDecimal	horometro_final	;
	private	BigInteger	dat_serv_realizados_equipo_id	;
	public BigInteger getEquipo_id() {
		return equipo_id;
	}
	public void setEquipo_id(BigInteger equipo_id) {
		this.equipo_id = equipo_id;
	}
	public String getCod_equipo() {
		return cod_equipo;
	}
	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}
	public String getNom_equipo() {
		return nom_equipo;
	}
	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}
	public BigInteger getPin() {
		return pin;
	}
	public void setPin(BigInteger pin) {
		this.pin = pin;
	}
	public BigDecimal getHorometro_inicial() {
		return horometro_inicial;
	}
	public void setHorometro_inicial(BigDecimal horometro_inicial) {
		this.horometro_inicial = horometro_inicial;
	}
	public BigDecimal getHorometro_final() {
		return horometro_final;
	}
	public void setHorometro_final(BigDecimal horometro_final) {
		this.horometro_final = horometro_final;
	}
	public BigInteger getDat_serv_realizados_equipo_id() {
		return dat_serv_realizados_equipo_id;
	}
	public void setDat_serv_realizados_equipo_id(BigInteger dat_serv_realizados_equipo_id) {
		this.dat_serv_realizados_equipo_id = dat_serv_realizados_equipo_id;
	}

}
