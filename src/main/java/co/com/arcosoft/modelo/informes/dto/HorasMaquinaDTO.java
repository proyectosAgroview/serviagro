package co.com.arcosoft.modelo.informes.dto;

/**
 * @author Arcosoft1
 *
 */
public class HorasMaquinaDTO {

	private String codEquipo;
	private String nomEquipo;
	private Integer horas;

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNomEquipo() {
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
