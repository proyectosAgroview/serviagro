package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CompartimientosEquipo;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.SistemasEquipo;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.UdadMed;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatMantenimientoEquipoProdDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoProdDTO.class);
	private Almacen almacenId;
	private Double cantidad;
	private Double costoTotal;
	private Long datMantenimientoEquipoProdId;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Double valorUnitario;
	private Long datMantenimientoEquipoId_DatMantenimientoEquipo;
	private Producto productoId_Producto;
	private Trabajador trabId_Trabajador;
	private UdadMed udadMedId_UdadMed;

	private String codAlmacen;
	private String codProducto;
	private String codUdadMed;
	private String codTrabajador;
	private String tipoSuministro;
	private CompartimientosEquipo compartimientosEquipo;
	private SistemasEquipo sistemasEquipo;
	private Date fechaRegistro;
	private String codCompartimientosEquipo;
	private String codSistemasEquipo;
	private String nomProducto;

	private UbicacionesAlmacen ubicacionesAlmacen;

	private Long idAlmacen;
	private Long idUbicacion;
	private Long idCompartimiento;
	private Long idUdadMed;
	private Long idProducto;
	private ConceptoKardex conceptoKardexId;

	private String nomConceptoKardexId;
	private String pendienteImportacion;
	private String colorImportacion;
	private String descargaInventario;
	
	
	public String getDescargaInventario() {
		return descargaInventario;
	}

	public void setDescargaInventario(String descargaInventario) {
		this.descargaInventario = descargaInventario;
	}

	public String getColorImportacion() {
		return colorImportacion;
	}

	public void setColorImportacion(String colorImportacion) {
		this.colorImportacion = colorImportacion;
	}

	public String getPendienteImportacion() {
		return pendienteImportacion;
	}

	public void setPendienteImportacion(String pendienteImportacion) {
		this.pendienteImportacion = pendienteImportacion;
	}

	public ConceptoKardex getConceptoKardexId() {
		return conceptoKardexId;
	}

	public String getNomConceptoKardexId() {
		return nomConceptoKardexId;
	}

	public void setConceptoKardexId(ConceptoKardex conceptoKardexId) {
		this.conceptoKardexId = conceptoKardexId;
	}

	public void setNomConceptoKardexId(String nomConceptoKardexId) {
		this.nomConceptoKardexId = nomConceptoKardexId;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(Long idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public Long getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Long idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Long getIdCompartimiento() {
		return idCompartimiento;
	}

	public void setIdCompartimiento(Long idCompartimiento) {
		this.idCompartimiento = idCompartimiento;
	}

	public Long getIdUdadMed() {
		return idUdadMed;
	}

	public void setIdUdadMed(Long idUdadMed) {
		this.idUdadMed = idUdadMed;
	}

	private String nomUbAlmacen;

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	/**
	 * @return the codSistemasEquipo
	 */
	public String getCodSistemasEquipo() {
		return codSistemasEquipo;
	}

	/**
	 * @param codSistemasEquipo the codSistemasEquipo to set
	 */
	public void setCodSistemasEquipo(String codSistemasEquipo) {
		this.codSistemasEquipo = codSistemasEquipo;
	}

	/**
	 * @return the compartimientosEquipo
	 */
	public CompartimientosEquipo getCompartimientosEquipo() {
		return compartimientosEquipo;
	}

	/**
	 * @return the codCompartimientosEquipo
	 */
	public String getCodCompartimientosEquipo() {
		return codCompartimientosEquipo;
	}

	/**
	 * @param codCompartimientosEquipo the codCompartimientosEquipo to set
	 */
	public void setCodCompartimientosEquipo(String codCompartimientosEquipo) {
		this.codCompartimientosEquipo = codCompartimientosEquipo;
	}

	/**
	 * @param compartimientosEquipo the compartimientosEquipo to set
	 */
	public void setCompartimientosEquipo(CompartimientosEquipo compartimientosEquipo) {
		this.compartimientosEquipo = compartimientosEquipo;
	}

	/**
	 * @return the sistemasEquipo
	 */
	public SistemasEquipo getSistemasEquipo() {
		return sistemasEquipo;
	}

	/**
	 * @param sistemasEquipo the sistemasEquipo to set
	 */
	public void setSistemasEquipo(SistemasEquipo sistemasEquipo) {
		this.sistemasEquipo = sistemasEquipo;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTipoSuministro() {
		return tipoSuministro;
	}

	public void setTipoSuministro(String tipoSuministro) {
		this.tipoSuministro = tipoSuministro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Almacen getAlmacenId() {
		return almacenId;
	}

	public void setAlmacenId(Almacen almacenId) {
		this.almacenId = almacenId;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Long getDatMantenimientoEquipoProdId() {
		return datMantenimientoEquipoProdId;
	}

	public void setDatMantenimientoEquipoProdId(Long datMantenimientoEquipoProdId) {
		this.datMantenimientoEquipoProdId = datMantenimientoEquipoProdId;
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

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Long getDatMantenimientoEquipoId_DatMantenimientoEquipo() {
		return datMantenimientoEquipoId_DatMantenimientoEquipo;
	}

	public void setDatMantenimientoEquipoId_DatMantenimientoEquipo(
			Long datMantenimientoEquipoId_DatMantenimientoEquipo) {
		this.datMantenimientoEquipoId_DatMantenimientoEquipo = datMantenimientoEquipoId_DatMantenimientoEquipo;
	}

	public Producto getProductoId_Producto() {
		return productoId_Producto;
	}

	public void setProductoId_Producto(Producto productoId_Producto) {
		this.productoId_Producto = productoId_Producto;
	}

	public Trabajador getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Trabajador trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}

	public String getCodAlmacen() {
		return codAlmacen;
	}

	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public UbicacionesAlmacen getUbicacionesAlmacen() {
		return ubicacionesAlmacen;
	}

	public void setUbicacionesAlmacen(UbicacionesAlmacen ubicacionesAlmacen) {
		this.ubicacionesAlmacen = ubicacionesAlmacen;
	}

	public String getNomUbAlmacen() {
		return nomUbAlmacen;
	}

	public void setNomUbAlmacen(String nomUbAlmacen) {
		this.nomUbAlmacen = nomUbAlmacen;
	}

}
