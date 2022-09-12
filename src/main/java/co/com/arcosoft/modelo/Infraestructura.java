package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Infraestructura generated by hbm2java
 */
public class Infraestructura implements java.io.Serializable {

	private Long infraId;
	private TipoInfraestructura tipoInfraestructura;
	private String codigo;
	private String nombre;
	public Long compania;
	private String foto;
	private String abastecimiento;
	private Float longitud;
	private Float latitud;
	private Float precision;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Set<DatRiego> datRiegos = new HashSet<DatRiego>(0);
	private Set<TarifaInfraestructura> tarifaInfraestructuras = new HashSet<TarifaInfraestructura>(0);
	private Set<DatProgramaRiegoDet>  datProgramaRiegoDets = new HashSet<DatProgramaRiegoDet>(0);
	public Infraestructura() {
	}

	public Infraestructura(Long infraId) {
		this.infraId = infraId;
	}

	public Infraestructura(Long infraId, TipoInfraestructura tipoInfraestructura, String codigo, String nombre,
			Long compania, String abastecimiento, Float longitud, Float latitud, Float precision, String foto,
			String infoAdicional, String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado,
			Set<DatRiego> datRiegos, Set<TarifaInfraestructura> tarifaInfraestructuras,
			 Set<DatProgramaRiegoDet>  datProgramaRiegoDets) {
		this.infraId = infraId;
		this.tipoInfraestructura = tipoInfraestructura;
		this.codigo = codigo;
		this.nombre = nombre;
		this.foto = foto;
		this.compania = compania;
		this.abastecimiento = abastecimiento;
		this.longitud = longitud;
		this.latitud = latitud;
		this.precision = precision;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.datRiegos = datRiegos;
		this.tarifaInfraestructuras = tarifaInfraestructuras;
		this.datProgramaRiegoDets=datProgramaRiegoDets;
	}

	public Set<DatProgramaRiegoDet> getDatProgramaRiegoDets() {
		return datProgramaRiegoDets;
	}

	public void setDatProgramaRiegoDets(Set<DatProgramaRiegoDet> datProgramaRiegoDets) {
		this.datProgramaRiegoDets = datProgramaRiegoDets;
	}

	public Long getInfraId() {
		return this.infraId;
	}

	public void setInfraId(Long infraId) {
		this.infraId = infraId;
	}

	public TipoInfraestructura getTipoInfraestructura() {
		return this.tipoInfraestructura;
	}

	public void setTipoInfraestructura(TipoInfraestructura tipoInfraestructura) {
		this.tipoInfraestructura = tipoInfraestructura;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getAbastecimiento() {
		return this.abastecimiento;
	}

	public void setAbastecimiento(String abastecimiento) {
		this.abastecimiento = abastecimiento;
	}

	public Float getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getPrecision() {
		return this.precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
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

	public Set<DatRiego> getDatRiegos() {
		return this.datRiegos;
	}

	public void setDatRiegos(Set<DatRiego> datRiegos) {
		this.datRiegos = datRiegos;
	}

	public Set<TarifaInfraestructura> getTarifaInfraestructuras() {
		return tarifaInfraestructuras;
	}

	public void setTarifaInfraestructuras(Set<TarifaInfraestructura> tarifaInfraestructuras) {
		this.tarifaInfraestructuras = tarifaInfraestructuras;
	}

}