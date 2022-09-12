package co.com.arcosoft.rest.service.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

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
	private String cierre_ot;
	private BigInteger  conceptoKardexId;
	private String descripcion_solicitud	;
	private String descripcion_ot ;
	private BigDecimal cantidadReal;
	private String reporteTecnico;
	private String foto;
	private String nombre_foto;
	//private String rutaImagen;
	
	
	
	public String getFoto() {
		return foto;
	}
	public String getNombre_foto() {
		return nombre_foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public void setNombre_foto(String nombre_foto) {
		this.nombre_foto = nombre_foto;
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
	public String getCierre_ot() {
		return cierre_ot;
	}
	public void setCierre_ot(String cierre_ot) {
		this.cierre_ot = cierre_ot;
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
