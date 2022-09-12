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
public class ModeloEquipoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ModeloEquipoDTO.class);
	private String codigo;
	private Long compania;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String infoAdicional;
	private String infoAdicional2;
	private Long modeloEquipoId;
	private String nombre;
	private Double velocidadPromedio;
	private Long categEquipId_CategoriaEquipo;
	private Long fabricEquipId_FabricanteEquipo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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

	public Long getModeloEquipoId() {
		return modeloEquipoId;
	}

	public void setModeloEquipoId(Long modeloEquipoId) {
		this.modeloEquipoId = modeloEquipoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getVelocidadPromedio() {
		return velocidadPromedio;
	}

	public void setVelocidadPromedio(Double velocidadPromedio) {
		this.velocidadPromedio = velocidadPromedio;
	}

	public Long getCategEquipId_CategoriaEquipo() {
		return categEquipId_CategoriaEquipo;
	}

	public void setCategEquipId_CategoriaEquipo(Long categEquipId_CategoriaEquipo) {
		this.categEquipId_CategoriaEquipo = categEquipId_CategoriaEquipo;
	}

	public Long getFabricEquipId_FabricanteEquipo() {
		return fabricEquipId_FabricanteEquipo;
	}

	public void setFabricEquipId_FabricanteEquipo(Long fabricEquipId_FabricanteEquipo) {
		this.fabricEquipId_FabricanteEquipo = fabricEquipId_FabricanteEquipo;
	}
}
