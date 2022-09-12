package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VehiculosTransp generated by hbm2java
 */
public class VehiculosTransp implements java.io.Serializable {

	private Long vehiTranspId;
	private Transportadora transportadora;
	private NumeroEje numeroEje;
	private Conductor conductor;
	private FabricanteEquipo fabricanteEquipo;
	private String codigo;
	public Long compania;
	private String nombre;
	private String placa;
	private String foto;
	private String color;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private String infoAdicional;
	private String infoAdicional2;
	private Set<DatTransProd> datTransProds = new HashSet<DatTransProd>(0);

	public VehiculosTransp() {
	}

	public VehiculosTransp(Long vehiTranspId) {
		this.vehiTranspId = vehiTranspId;
	}

	public VehiculosTransp(Long vehiTranspId, Transportadora transportadora, NumeroEje numeroEje, Conductor conductor,
			FabricanteEquipo fabricanteEquipo, String codigo, Long compania, String nombre, String placa, String foto,
			String color, Date fechaCreacion, Date fechaModificacion, String estado, String infoAdicional,
			String infoAdicional2, Set<DatTransProd> datTransProds) {
		this.vehiTranspId = vehiTranspId;
		this.transportadora = transportadora;
		this.numeroEje = numeroEje;
		this.conductor = conductor;
		this.fabricanteEquipo = fabricanteEquipo;
		this.codigo = codigo;
		this.compania = compania;
		this.nombre = nombre;
		this.placa = placa;
		this.foto = foto;
		this.color = color;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.datTransProds = datTransProds;
	}

	public Long getVehiTranspId() {
		return this.vehiTranspId;
	}

	public void setVehiTranspId(Long vehiTranspId) {
		this.vehiTranspId = vehiTranspId;
	}

	public Transportadora getTransportadora() {
		return this.transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public NumeroEje getNumeroEje() {
		return this.numeroEje;
	}

	public void setNumeroEje(NumeroEje numeroEje) {
		this.numeroEje = numeroEje;
	}

	public Conductor getConductor() {
		return this.conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public FabricanteEquipo getFabricanteEquipo() {
		return this.fabricanteEquipo;
	}

	public void setFabricanteEquipo(FabricanteEquipo fabricanteEquipo) {
		this.fabricanteEquipo = fabricanteEquipo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public Set<DatTransProd> getDatTransProds() {
		return this.datTransProds;
	}

	public void setDatTransProds(Set<DatTransProd> datTransProds) {
		this.datTransProds = datTransProds;
	}

}