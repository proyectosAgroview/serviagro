package co.com.arcosoft.modelo.informes.dto;

import java.math.BigInteger;

public class ListadoRecursosDTO
{

	private BigInteger tpRecursoId;
	private BigInteger recursoId;
	private String codigoRecurso;
	private String nombreRecurso;

	public BigInteger getTpRecursoId() {
		return tpRecursoId;
	}

	public void setTpRecursoId(BigInteger tpRecursoId) {
		this.tpRecursoId = tpRecursoId;
	}

	public BigInteger getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(BigInteger recursoId) {
		this.recursoId = recursoId;
	}

	public String getCodigoRecurso() {
		return codigoRecurso;
	}

	public void setCodigoRecurso(String codigoRecurso) {
		this.codigoRecurso = codigoRecurso;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

}
