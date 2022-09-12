package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AnalisisDiatraeaDTO {

	Date fechaEvaluacion;
	Integer mes;
	Integer anio;
	String codZona;
	String codFinca;
	String nomFinca;
	String codBloque;
	String codLote;
	String nomLote;
	BigDecimal edadMuestra;
	BigDecimal area;
	String nomVariedad;
	String nomEtapa;
	Date fechaUltimoCorte;
	String evaluador;
	BigDecimal numeroCanaAnal;
	BigDecimal totalEntrenudos;
	BigDecimal totalEntreDiatraea;
	BigDecimal canasConDiatrea;
	BigDecimal intenInfesDiatraea;
	BigDecimal porcInfesDiatrea;
	BigDecimal canasConValentina;
	BigDecimal totalEntrenudosValentina;
	BigDecimal intenInfestValentina;
	BigDecimal porcInfestacionValentina;

	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getCodZona() {
		return codZona;
	}

	public void setCodZona(String codZona) {
		this.codZona = codZona;
	}

	public String getCodFinca() {
		return codFinca;
	}

	public void setCodFinca(String codFinca) {
		this.codFinca = codFinca;
	}

	public String getNomFinca() {
		return nomFinca;
	}

	public void setNomFinca(String nomFinca) {
		this.nomFinca = nomFinca;
	}

	public String getCodBloque() {
		return codBloque;
	}

	public void setCodBloque(String codBloque) {
		this.codBloque = codBloque;
	}

	public String getCodLote() {
		return codLote;
	}

	public void setCodLote(String codLote) {
		this.codLote = codLote;
	}

	public String getNomLote() {
		return nomLote;
	}

	public void setNomLote(String nomLote) {
		this.nomLote = nomLote;
	}

	public BigDecimal getEdadMuestra() {
		return edadMuestra;
	}

	public void setEdadMuestra(BigDecimal edadMuestra) {
		this.edadMuestra = edadMuestra;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getNomVariedad() {
		return nomVariedad;
	}

	public void setNomVariedad(String nomVariedad) {
		this.nomVariedad = nomVariedad;
	}

	public String getNomEtapa() {
		return nomEtapa;
	}

	public void setNomEtapa(String nomEtapa) {
		this.nomEtapa = nomEtapa;
	}

	public Date getFechaUltimoCorte() {
		return fechaUltimoCorte;
	}

	public void setFechaUltimoCorte(Date fechaUltimoCorte) {
		this.fechaUltimoCorte = fechaUltimoCorte;
	}

	public String getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(String evaluador) {
		this.evaluador = evaluador;
	}

	public BigDecimal getNumeroCanaAnal() {
		return numeroCanaAnal;
	}

	public void setNumeroCanaAnal(BigDecimal numeroCanaAnal) {
		this.numeroCanaAnal = numeroCanaAnal;
	}

	public BigDecimal getTotalEntrenudos() {
		return totalEntrenudos;
	}

	public void setTotalEntrenudos(BigDecimal totalEntrenudos) {
		this.totalEntrenudos = totalEntrenudos;
	}

	public BigDecimal getTotalEntreDiatraea() {
		return totalEntreDiatraea;
	}

	public void setTotalEntreDiatraea(BigDecimal totalEntreDiatraea) {
		this.totalEntreDiatraea = totalEntreDiatraea;
	}

	public BigDecimal getCanasConDiatrea() {
		return canasConDiatrea;
	}

	public void setCanasConDiatrea(BigDecimal canasConDiatrea) {
		this.canasConDiatrea = canasConDiatrea;
	}

	public BigDecimal getIntenInfesDiatraea() {
		return intenInfesDiatraea;
	}

	public void setIntenInfesDiatraea(BigDecimal intenInfesDiatraea) {
		this.intenInfesDiatraea = intenInfesDiatraea;
	}

	public BigDecimal getPorcInfesDiatrea() {
		return porcInfesDiatrea;
	}

	public void setPorcInfesDiatrea(BigDecimal porcInfesDiatrea) {
		this.porcInfesDiatrea = porcInfesDiatrea;
	}

	public BigDecimal getCanasConValentina() {
		return canasConValentina;
	}

	public void setCanasConValentina(BigDecimal canasConValentina) {
		this.canasConValentina = canasConValentina;
	}

	public BigDecimal getTotalEntrenudosValentina() {
		return totalEntrenudosValentina;
	}

	public void setTotalEntrenudosValentina(BigDecimal totalEntrenudosValentina) {
		this.totalEntrenudosValentina = totalEntrenudosValentina;
	}

	public BigDecimal getIntenInfestValentina() {
		return intenInfestValentina;
	}

	public void setIntenInfestValentina(BigDecimal intenInfestValentina) {
		this.intenInfestValentina = intenInfestValentina;
	}

	public BigDecimal getPorcInfestacionValentina() {
		return porcInfestacionValentina;
	}

	public void setPorcInfestacionValentina(BigDecimal porcInfestacionValentina) {
		this.porcInfestacionValentina = porcInfestacionValentina;
	}

}
