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
public class VehiculosTranspDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(VehiculosTranspDTO.class);
	private String codigo;
	private String color;
	private Long compania;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String foto;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private String placa;
	private Long vehiTranspId;
	private Long conductorId_Conductor;
	private Long fabricEquipId_FabricanteEquipo;
	private Long numEjeId_NumeroEje;
	private Long transpId_Transportadora;

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getVehiTranspId() {
		return vehiTranspId;
	}

	public void setVehiTranspId(Long vehiTranspId) {
		this.vehiTranspId = vehiTranspId;
	}

	public Long getConductorId_Conductor() {
		return conductorId_Conductor;
	}

	public void setConductorId_Conductor(Long conductorId_Conductor) {
		this.conductorId_Conductor = conductorId_Conductor;
	}

	public Long getFabricEquipId_FabricanteEquipo() {
		return fabricEquipId_FabricanteEquipo;
	}

	public void setFabricEquipId_FabricanteEquipo(Long fabricEquipId_FabricanteEquipo) {
		this.fabricEquipId_FabricanteEquipo = fabricEquipId_FabricanteEquipo;
	}

	public Long getNumEjeId_NumeroEje() {
		return numEjeId_NumeroEje;
	}

	public void setNumEjeId_NumeroEje(Long numEjeId_NumeroEje) {
		this.numEjeId_NumeroEje = numEjeId_NumeroEje;
	}

	public Long getTranspId_Transportadora() {
		return transpId_Transportadora;
	}

	public void setTranspId_Transportadora(Long transpId_Transportadora) {
		this.transpId_Transportadora = transpId_Transportadora;
	}
}
