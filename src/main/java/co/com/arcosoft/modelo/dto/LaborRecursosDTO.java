package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.TipoRecurso;
import co.com.arcosoft.modelo.TipoRecursosEquipos;
import co.com.arcosoft.modelo.TipoRecursosInsumos;
import co.com.arcosoft.modelo.TipoRecursosOtros;
import co.com.arcosoft.modelo.TipoRecursosProfesion;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class LaborRecursosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LaborRecursosDTO.class);
	private Long laborRecursosId;
	private Long recursoId;
	private Double rendimientoRecurso;
	private UdadMed udadMedId;
	private Long laborId_Labor;
	private TipoRecurso tpRecursoId_TipoRecurso;
	private String nombreUm;
	private String nombreTipoRecurso;
	private String nombreRecurso;
	private TipoRecursosProfesion tpRecursoPf;
	private TipoRecursosEquipos tpRecursoEq;
	private TipoRecursosInsumos tpRecursoIn;
	private TipoRecursosOtros tpRecursoOt;

	public TipoRecursosProfesion getTpRecursoPf() {
		return tpRecursoPf;
	}

	public void setTpRecursoPf(TipoRecursosProfesion tpRecursoPf) {
		this.tpRecursoPf = tpRecursoPf;
	}

	public TipoRecursosEquipos getTpRecursoEq() {
		return tpRecursoEq;
	}

	public void setTpRecursoEq(TipoRecursosEquipos tpRecursoEq) {
		this.tpRecursoEq = tpRecursoEq;
	}

	public TipoRecursosInsumos getTpRecursoIn() {
		return tpRecursoIn;
	}

	public void setTpRecursoIn(TipoRecursosInsumos tpRecursoIn) {
		this.tpRecursoIn = tpRecursoIn;
	}

	public TipoRecursosOtros getTpRecursoOt() {
		return tpRecursoOt;
	}

	public void setTpRecursoOt(TipoRecursosOtros tpRecursoOt) {
		this.tpRecursoOt = tpRecursoOt;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public String getNombreUm() {
		return nombreUm;
	}

	public void setNombreUm(String nombreUm) {
		this.nombreUm = nombreUm;
	}

	public String getNombreTipoRecurso() {
		return nombreTipoRecurso;
	}

	public void setNombreTipoRecurso(String nombreTipoRecurso) {
		this.nombreTipoRecurso = nombreTipoRecurso;
	}

	public Long getLaborRecursosId() {
		return laborRecursosId;
	}

	public void setLaborRecursosId(Long laborRecursosId) {
		this.laborRecursosId = laborRecursosId;
	}

	public Long getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(Long recursoId) {
		this.recursoId = recursoId;
	}

	public Double getRendimientoRecurso() {
		return rendimientoRecurso;
	}

	public void setRendimientoRecurso(Double rendimientoRecurso) {
		this.rendimientoRecurso = rendimientoRecurso;
	}

	public UdadMed getUdadMedId() {
		return udadMedId;
	}

	public void setUdadMedId(UdadMed udadMedId) {
		this.udadMedId = udadMedId;
	}

	public Long getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Long laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public TipoRecurso getTpRecursoId_TipoRecurso() {
		return tpRecursoId_TipoRecurso;
	}

	public void setTpRecursoId_TipoRecurso(TipoRecurso tpRecursoId_TipoRecurso) {
		this.tpRecursoId_TipoRecurso = tpRecursoId_TipoRecurso;
	}
}
