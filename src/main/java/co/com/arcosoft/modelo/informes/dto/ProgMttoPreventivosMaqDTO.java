package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;

public class ProgMttoPreventivosMaqDTO {

	private	BigInteger	id_mtto	;
	private	BigInteger	id_programa	;
	private	Date	fecha_entrada_taller	;
	private	Date	fecha_salida_taller	;
	private	BigInteger	consecutivo	;
	private	BigInteger	id_equipo	;
	private	String	cod_equipo	;
	private	String	nom_equipo	;
	private	BigDecimal	horo_odo_entrada	;
	private	BigInteger	id_plan_revision	;
	private	String	id_plan_revision2	;
	private	String	cod_plan_revision	;
	private	String	nom_plan_revision	;
	private	String	cod_solicitante	;
	private	String	solicitante	;
	private	BigInteger	responsable_mtto	;
	private	String	cod_responsable_tto	;
	private	String	nom_responsable_mtto	;
	private	BigInteger	id_usuario_responsable	;
	private	BigInteger	id_producto	;
	private	String	nom_producto	;
	private	String	um_producto	;
	private	BigDecimal	cantidad	;
	private BigInteger idAlmacen;
	private BigInteger idUbicacion;
	private String tipoMovimiento;
	
	private BigInteger  conceptoKardexId;
	private String descripcion_solicitud	;
	private String descripcion_ot ;
	private BigDecimal cantidadReal;
	private String reporteTecnico;
	
	private String cod_producto;
	private String	codAlmacen	;
	
	private String nomAlmacen;
	private String	nomUbicacion	;
	
	
	private String estadoTrue;
	private String estadoTrue2;
	private String tituloCierreOt;
	private String iconCierreOt;
	
	private String estado;
	private String cierreOt;
	
	private String datosMatto;
	private BigDecimal horOdoActual;
	private String cierreOt2;
	private String tipoProcedimiento;
	
	private String horKmAnterior;
	private String horasParaMtto;

	private String fechaUltimoServicio;
	
	private Double horOdoDifMtto;
	private String foto;
	
	
	
	
	
	
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getFechaUltimoServicio() {
		return fechaUltimoServicio;
	}
	public void setFechaUltimoServicio(String fechaUltimoServicio) {
		this.fechaUltimoServicio = fechaUltimoServicio;
	}
	public Double getHorOdoDifMtto() {
		return horOdoDifMtto;
	}
	public void setHorOdoDifMtto(Double horOdoDifMtto) {
		this.horOdoDifMtto = horOdoDifMtto;
	}
	public String getHorKmAnterior() {
		return horKmAnterior;
	}
	public void setHorKmAnterior(String horKmAnterior) {
		this.horKmAnterior = horKmAnterior;
	}
	public String getHorasParaMtto() {
		return horasParaMtto;
	}
	public void setHorasParaMtto(String horasParaMtto) {
		this.horasParaMtto = horasParaMtto;
	}
	public String getTipoProcedimiento() {
		return tipoProcedimiento;
	}
	public void setTipoProcedimiento(String tipoProcedimiento) {
		this.tipoProcedimiento = tipoProcedimiento;
	}
	public String getCierreOt2() {
		return cierreOt2;
	}
	public void setCierreOt2(String cierreOt2) {
		this.cierreOt2 = cierreOt2;
	}
	public BigDecimal getHorOdoActual() {
		return horOdoActual;
	}
	public void setHorOdoActual(BigDecimal horOdoActual) {
		this.horOdoActual = horOdoActual;
	}
	public String getDatosMatto() {
		return datosMatto;
	}
	public void setDatosMatto(String datosMatto) {
		this.datosMatto = datosMatto;
	}
	public String getCierreOt() {
		return cierreOt;
	}
	public void setCierreOt(String cierreOt) {
		this.cierreOt = cierreOt;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstadoTrue() {
		return estadoTrue;
	}
	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}
	public String getEstadoTrue2() {
		return estadoTrue2;
	}
	public void setEstadoTrue2(String estadoTrue2) {
		this.estadoTrue2 = estadoTrue2;
	}
	public String getTituloCierreOt() {
		return tituloCierreOt;
	}
	public void setTituloCierreOt(String tituloCierreOt) {
		this.tituloCierreOt = tituloCierreOt;
	}
	public String getIconCierreOt() {
		return iconCierreOt;
	}
	public void setIconCierreOt(String iconCierreOt) {
		this.iconCierreOt = iconCierreOt;
	}
	public String getId_plan_revision2() {
		return id_plan_revision2;
	}
	public void setId_plan_revision2(String id_plan_revision2) {
		this.id_plan_revision2 = id_plan_revision2;
	}
	public String getNomAlmacen() {
		return nomAlmacen;
	}
	public void setNomAlmacen(String nomAlmacen) {
		this.nomAlmacen = nomAlmacen;
	}
	public String getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}
	public String getCodAlmacen() {
		return codAlmacen;
	}
	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}
	
	public String getNomUbicacion() {
		return nomUbicacion;
	}
	public void setNomUbicacion(String nomUbicacion) {
		this.nomUbicacion = nomUbicacion;
	}
	public String getReporteTecnico() {
		return reporteTecnico;
	}
	public void setReporteTecnico(String reporteTecnico) {
		this.reporteTecnico = reporteTecnico;
	}
	public BigDecimal getCantidadReal() {
		return cantidadReal;
	}
	public void setCantidadReal(BigDecimal cantidadReal) {
		this.cantidadReal = cantidadReal;
	}
	public String getDescripcion_solicitud() {
		return descripcion_solicitud;
	}
	public void setDescripcion_solicitud(String descripcion_solicitud) {
		this.descripcion_solicitud = descripcion_solicitud;
	}
	public String getDescripcion_ot() {
		return descripcion_ot;
	}
	public void setDescripcion_ot(String descripcion_ot) {
		this.descripcion_ot = descripcion_ot;
	}
	public BigInteger getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(BigInteger idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public BigInteger getIdUbicacion() {
		return idUbicacion;
	}
	public void setIdUbicacion(BigInteger idUbicacion) {
		this.idUbicacion = idUbicacion;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public BigInteger getConceptoKardexId() {
		return conceptoKardexId;
	}
	public void setConceptoKardexId(BigInteger conceptoKardexId) {
		this.conceptoKardexId = conceptoKardexId;
	}
	public BigInteger getId_mtto() {
		return id_mtto;
	}
	public void setId_mtto(BigInteger id_mtto) {
		this.id_mtto = id_mtto;
	}
	public BigInteger getId_programa() {
		return id_programa;
	}
	public void setId_programa(BigInteger id_programa) {
		this.id_programa = id_programa;
	}
	public Date getFecha_entrada_taller() {
		return fecha_entrada_taller;
	}
	public void setFecha_entrada_taller(Date fecha_entrada_taller) {
		this.fecha_entrada_taller = fecha_entrada_taller;
	}
	public Date getFecha_salida_taller() {
		return fecha_salida_taller;
	}
	public void setFecha_salida_taller(Date fecha_salida_taller) {
		this.fecha_salida_taller = fecha_salida_taller;
	}
	public BigInteger getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(BigInteger consecutivo) {
		this.consecutivo = consecutivo;
	}
	public BigInteger getId_equipo() {
		return id_equipo;
	}
	public void setId_equipo(BigInteger id_equipo) {
		this.id_equipo = id_equipo;
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
	public BigDecimal getHoro_odo_entrada() {
		return horo_odo_entrada;
	}
	public void setHoro_odo_entrada(BigDecimal horo_odo_entrada) {
		this.horo_odo_entrada = horo_odo_entrada;
	}
	public BigInteger getId_plan_revision() {
		return id_plan_revision;
	}
	public void setId_plan_revision(BigInteger id_plan_revision) {
		this.id_plan_revision = id_plan_revision;
	}
	public String getCod_plan_revision() {
		return cod_plan_revision;
	}
	public void setCod_plan_revision(String cod_plan_revision) {
		this.cod_plan_revision = cod_plan_revision;
	}
	public String getNom_plan_revision() {
		return nom_plan_revision;
	}
	public void setNom_plan_revision(String nom_plan_revision) {
		this.nom_plan_revision = nom_plan_revision;
	}
	public String getCod_solicitante() {
		return cod_solicitante;
	}
	public void setCod_solicitante(String cod_solicitante) {
		this.cod_solicitante = cod_solicitante;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public BigInteger getResponsable_mtto() {
		return responsable_mtto;
	}
	public void setResponsable_mtto(BigInteger responsable_mtto) {
		this.responsable_mtto = responsable_mtto;
	}
	public String getCod_responsable_tto() {
		return cod_responsable_tto;
	}
	public void setCod_responsable_tto(String cod_responsable_tto) {
		this.cod_responsable_tto = cod_responsable_tto;
	}
	public String getNom_responsable_mtto() {
		return nom_responsable_mtto;
	}
	public void setNom_responsable_mtto(String nom_responsable_mtto) {
		this.nom_responsable_mtto = nom_responsable_mtto;
	}
	public BigInteger getId_usuario_responsable() {
		return id_usuario_responsable;
	}
	public void setId_usuario_responsable(BigInteger id_usuario_responsable) {
		this.id_usuario_responsable = id_usuario_responsable;
	}
	public BigInteger getId_producto() {
		return id_producto;
	}
	public void setId_producto(BigInteger id_producto) {
		this.id_producto = id_producto;
	}
	public String getNom_producto() {
		return nom_producto;
	}
	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}
	public String getUm_producto() {
		return um_producto;
	}
	public void setUm_producto(String um_producto) {
		this.um_producto = um_producto;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	
	

}
