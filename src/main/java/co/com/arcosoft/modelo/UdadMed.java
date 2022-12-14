package co.com.arcosoft.modelo;

// Generated 05-ago-2015 14:10:19 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UdadMed generated by hbm2java
 */
public class UdadMed implements java.io.Serializable {

	private Long udadMedId;
	private String codigo;
	private String nombre;
	private String sigla;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String estado;
	private Long nroDecimales;
	private String clasificacionUm;
	private Set<Cultivo> cultivosForUdadMedId1 = new HashSet<Cultivo>(0);
	private Set<Cultivo> cultivosForUdadMedId = new HashSet<Cultivo>(0);
	private Set<DatAbastCombustible> datAbastCombustibles = new HashSet<DatAbastCombustible>(0);
	private Set<DatMantenimientoEquipoProd> datMantenimientoEquipoProds = new HashSet<DatMantenimientoEquipoProd>(0);
	private Set<DatMantenimientoEquipoMec> datMantenimientoEquipoMecs = new HashSet<DatMantenimientoEquipoMec>(0);
	private Set<Bascula> basculas = new HashSet<Bascula>(0);
	private Set<DatTransProdTrabajadores> datTransProdTrabajadoreses = new HashSet<DatTransProdTrabajadores>(0);

	private Set<TipoRecursosOtros> tipoRecursosOtroses = new HashSet<TipoRecursosOtros>(0);
	private Set<TipoRecursosInsumos> tipoRecursosInsumoses = new HashSet<TipoRecursosInsumos>(0);
	private Set<TipoRecursosEquipos> tipoRecursosEquiposes = new HashSet<TipoRecursosEquipos>(0);
	private Set<TipoRecursosProfesion> tipoRecursosProfesions = new HashSet<TipoRecursosProfesion>(0);
	private Set<LaborRecursos> laborRecursoses = new HashSet<LaborRecursos>(0);
	private Set<TarifaProfesion> tarifaProfesions = new HashSet<TarifaProfesion>(0);
	private Set<DatPlanillaNominaDet> datPlanillaNominaDetsForUdadMedProd = new HashSet<DatPlanillaNominaDet>(0);
	private Set<CostoRecurso> costoRecursos = new HashSet<CostoRecurso>(0);
	private Set<TarifaEquipProp>  tarifaEquipProps	  = new HashSet<TarifaEquipProp>(0);
	private Set<DatTransProdDet> datTransProdDets = new HashSet<DatTransProdDet>(0);
	private Set<LimiteCeptoNomina> limiteCeptoNominas   = new HashSet<LimiteCeptoNomina>(0);

    private Set<DatHerramienta> datHerramientas = new HashSet<DatHerramienta>(0);
    private Set<FactorConversion> factorConversionsForUndadMedDestId = new HashSet<FactorConversion>(0);
    private Set<DatServicio> datServicios = new HashSet<DatServicio>(0);
    private Set<Producto> productosForUdadMedCosecha = new HashSet<Producto>(0);
    private Set<DatPlanLabor> datPlanLabors = new HashSet<DatPlanLabor>(0);
    private Set<Producto> productosForUdadMedProd = new HashSet<Producto>(0);
    private Set<DatAplicProdDet> datAplicProdDets = new HashSet<DatAplicProdDet>(0);
    private Set<DatServicioDet> datServicioDetsForUdadMedProd = new HashSet<DatServicioDet>(0);
    private Set<TarifaContratista> tarifaContratistas = new HashSet<TarifaContratista>(0);
    private Set<FactorConversion> factorConversionsForUnadMedOrigenId = new HashSet<FactorConversion>(0);
    private Set<DatPlanillaNominaDet> datPlanillaNominaDetsForUdadMedPago = new HashSet<DatPlanillaNominaDet>(0);
    private Set<Labor> laborsForUdadMedPago = new HashSet<Labor>(0);
    private Set<Labor> laborsForUdadMedPlan = new HashSet<Labor>(0);
    private Set<DatServicioDet> datServicioDetsForUdadMedPago = new HashSet<DatServicioDet>(0);
    private Set<DatPlanillaNomina> datPlanillaNominas = new HashSet<DatPlanillaNomina>(0);
    private Set<PlanAsignarRecurso> planAsignarRecursos = new HashSet<PlanAsignarRecurso>(0);
    private Set<Labor> laborsForUdadMedProd = new HashSet<Labor>(0);
    private Set<DatServRealizadosEquipo> datServRealizadosEquipos = new HashSet<DatServRealizadosEquipo>(0);
    
	public UdadMed() {
	}

	public UdadMed(Long udadMedId) {
		this.udadMedId = udadMedId;
	}

	public UdadMed(Long udadMedId, String codigo, String nombre, String sigla, Long compania, String infoAdicional,
			String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, Long nroDecimales,
			String clasificacionUm, Set<Cultivo> cultivosForUdadMedId1, Set<Cultivo> cultivosForUdadMedId,
			Set<DatAbastCombustible> datAbastCombustibles, Set<DatMantenimientoEquipoProd> datMantenimientoEquipoProds,
			Set<DatMantenimientoEquipoMec> datMantenimientoEquipoMecs, Set<Bascula> basculas,
			Set<DatTransProdTrabajadores> datTransProdTrabajadoreses, Set<TipoRecursosOtros> tipoRecursosOtroses,
			Set<TipoRecursosInsumos> tipoRecursosInsumoses, Set<TipoRecursosEquipos> tipoRecursosEquiposes,
			Set<TipoRecursosProfesion> tipoRecursosProfesions, Set<LaborRecursos> laborRecursoses,
			Set<TarifaProfesion> tarifaProfesions,Set<DatPlanillaNominaDet> datPlanillaNominaDetsForUdadMedProd ,
			Set<CostoRecurso> costoRecursos, Set<TarifaEquipProp>  tarifaEquipProps, Set<DatTransProdDet> datTransProdDets ,
			Set<LimiteCeptoNomina> limiteCeptoNominas,
			Set<DatHerramienta> datHerramientas,
			Set<FactorConversion> factorConversionsForUndadMedDestId,
			 Set<DatServicio> datServicios,
			 Set<Producto> productosForUdadMedCosecha, Set<DatPlanLabor> datPlanLabors,
			Set<Producto> productosForUdadMedProd,
			Set<DatAplicProdDet> datAplicProdDets, Set<DatServicioDet> datServicioDetsForUdadMedProd, 
			Set<TarifaContratista> tarifaContratistas, Set<FactorConversion> factorConversionsForUnadMedOrigenId, 
			Set<DatPlanillaNominaDet> datPlanillaNominaDetsForUdadMedPago, Set<Labor> laborsForUdadMedPago,
			Set<Labor> laborsForUdadMedPlan, Set<DatServicioDet> datServicioDetsForUdadMedPago,
			Set<DatPlanillaNomina> datPlanillaNominas, Set<PlanAsignarRecurso> planAsignarRecursos,    
			Set<Labor> laborsForUdadMedProd ,Set<DatServRealizadosEquipo> datServRealizadosEquipos
			) {
		this.udadMedId = udadMedId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.sigla = sigla;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.nroDecimales = nroDecimales;
		this.clasificacionUm = clasificacionUm;
		this.cultivosForUdadMedId1 = cultivosForUdadMedId1;
		this.cultivosForUdadMedId = cultivosForUdadMedId;
		this.datAbastCombustibles = datAbastCombustibles;
		this.datMantenimientoEquipoProds = datMantenimientoEquipoProds;
		this.datMantenimientoEquipoMecs = datMantenimientoEquipoMecs;
		this.basculas = basculas;
		this.datTransProdTrabajadoreses = datTransProdTrabajadoreses;
		this.laborRecursoses = laborRecursoses;
		this.datPlanillaNominaDetsForUdadMedProd  =  datPlanillaNominaDetsForUdadMedProd ;
		this.tipoRecursosOtroses = tipoRecursosOtroses;
		this.tipoRecursosInsumoses = tipoRecursosInsumoses;
		this.tipoRecursosEquiposes = tipoRecursosEquiposes;
		this.tipoRecursosProfesions = tipoRecursosProfesions;
		this.tarifaProfesions = tarifaProfesions;
		this.costoRecursos = costoRecursos;
		this.tarifaEquipProps = tarifaEquipProps;
		this.datTransProdDets = datTransProdDets;
		this.limiteCeptoNominas = limiteCeptoNominas;
		   this.datHerramientas = datHerramientas;
	       this.factorConversionsForUndadMedDestId = factorConversionsForUndadMedDestId;
	       this.datTransProdTrabajadoreses = datTransProdTrabajadoreses;
	       this.tipoRecursosEquiposes = tipoRecursosEquiposes;
	       this.cultivosForUdadMedId = cultivosForUdadMedId;
	       this.datServicios = datServicios;
	       this.basculas = basculas;
	       this.productosForUdadMedCosecha = productosForUdadMedCosecha;
	       this.datPlanLabors = datPlanLabors;
	       this.productosForUdadMedProd = productosForUdadMedProd;
	       this.datAbastCombustibles = datAbastCombustibles;
	       this.datAplicProdDets = datAplicProdDets;
	       this.datServicioDetsForUdadMedProd = datServicioDetsForUdadMedProd;
	       this.tarifaContratistas = tarifaContratistas;
	       this.factorConversionsForUnadMedOrigenId = factorConversionsForUnadMedOrigenId;
	       this.datPlanillaNominaDetsForUdadMedPago = datPlanillaNominaDetsForUdadMedPago;
	       this.laborsForUdadMedPago = laborsForUdadMedPago;
	       this.laborsForUdadMedPlan = laborsForUdadMedPlan;
	       this.datServicioDetsForUdadMedPago = datServicioDetsForUdadMedPago;
	       this.datMantenimientoEquipoMecs = datMantenimientoEquipoMecs;
	       this.datMantenimientoEquipoProds = datMantenimientoEquipoProds;
	       this.datPlanillaNominas = datPlanillaNominas;
	       this.planAsignarRecursos = planAsignarRecursos;
	       this.tipoRecursosProfesions = tipoRecursosProfesions;
	       this.laborsForUdadMedProd = laborsForUdadMedProd;
	   	this.datServRealizadosEquipos = datServRealizadosEquipos;
		
	    
	}
	public Set<DatServRealizadosEquipo> getDatServRealizadosEquipos() {
		return datServRealizadosEquipos;
	}

	public void setDatServRealizadosEquipos(Set<DatServRealizadosEquipo> datServRealizadosEquipos) {
		this.datServRealizadosEquipos = datServRealizadosEquipos;
	}


	
	public Set<DatHerramienta> getDatHerramientas() {
		return datHerramientas;
	}

	public void setDatHerramientas(Set<DatHerramienta> datHerramientas) {
		this.datHerramientas = datHerramientas;
	}

	public Set<FactorConversion> getFactorConversionsForUndadMedDestId() {
		return factorConversionsForUndadMedDestId;
	}

	public void setFactorConversionsForUndadMedDestId(Set<FactorConversion> factorConversionsForUndadMedDestId) {
		this.factorConversionsForUndadMedDestId = factorConversionsForUndadMedDestId;
	}

	public Set<DatServicio> getDatServicios() {
		return datServicios;
	}

	public void setDatServicios(Set<DatServicio> datServicios) {
		this.datServicios = datServicios;
	}

	public Set<Producto> getProductosForUdadMedCosecha() {
		return productosForUdadMedCosecha;
	}

	public void setProductosForUdadMedCosecha(Set<Producto> productosForUdadMedCosecha) {
		this.productosForUdadMedCosecha = productosForUdadMedCosecha;
	}

	public Set<DatPlanLabor> getDatPlanLabors() {
		return datPlanLabors;
	}

	public void setDatPlanLabors(Set<DatPlanLabor> datPlanLabors) {
		this.datPlanLabors = datPlanLabors;
	}

	public Set<Producto> getProductosForUdadMedProd() {
		return productosForUdadMedProd;
	}

	public void setProductosForUdadMedProd(Set<Producto> productosForUdadMedProd) {
		this.productosForUdadMedProd = productosForUdadMedProd;
	}

	public Set<DatAplicProdDet> getDatAplicProdDets() {
		return datAplicProdDets;
	}

	public void setDatAplicProdDets(Set<DatAplicProdDet> datAplicProdDets) {
		this.datAplicProdDets = datAplicProdDets;
	}

	public Set<DatServicioDet> getDatServicioDetsForUdadMedProd() {
		return datServicioDetsForUdadMedProd;
	}

	public void setDatServicioDetsForUdadMedProd(Set<DatServicioDet> datServicioDetsForUdadMedProd) {
		this.datServicioDetsForUdadMedProd = datServicioDetsForUdadMedProd;
	}

	public Set<TarifaContratista> getTarifaContratistas() {
		return tarifaContratistas;
	}

	public void setTarifaContratistas(Set<TarifaContratista> tarifaContratistas) {
		this.tarifaContratistas = tarifaContratistas;
	}

	public Set<FactorConversion> getFactorConversionsForUnadMedOrigenId() {
		return factorConversionsForUnadMedOrigenId;
	}

	public void setFactorConversionsForUnadMedOrigenId(Set<FactorConversion> factorConversionsForUnadMedOrigenId) {
		this.factorConversionsForUnadMedOrigenId = factorConversionsForUnadMedOrigenId;
	}

	public Set<DatPlanillaNominaDet> getDatPlanillaNominaDetsForUdadMedPago() {
		return datPlanillaNominaDetsForUdadMedPago;
	}

	public void setDatPlanillaNominaDetsForUdadMedPago(Set<DatPlanillaNominaDet> datPlanillaNominaDetsForUdadMedPago) {
		this.datPlanillaNominaDetsForUdadMedPago = datPlanillaNominaDetsForUdadMedPago;
	}

	public Set<Labor> getLaborsForUdadMedPago() {
		return laborsForUdadMedPago;
	}

	public void setLaborsForUdadMedPago(Set<Labor> laborsForUdadMedPago) {
		this.laborsForUdadMedPago = laborsForUdadMedPago;
	}

	public Set<Labor> getLaborsForUdadMedPlan() {
		return laborsForUdadMedPlan;
	}

	public void setLaborsForUdadMedPlan(Set<Labor> laborsForUdadMedPlan) {
		this.laborsForUdadMedPlan = laborsForUdadMedPlan;
	}

	public Set<DatServicioDet> getDatServicioDetsForUdadMedPago() {
		return datServicioDetsForUdadMedPago;
	}

	public void setDatServicioDetsForUdadMedPago(Set<DatServicioDet> datServicioDetsForUdadMedPago) {
		this.datServicioDetsForUdadMedPago = datServicioDetsForUdadMedPago;
	}

	public Set<DatPlanillaNomina> getDatPlanillaNominas() {
		return datPlanillaNominas;
	}

	public void setDatPlanillaNominas(Set<DatPlanillaNomina> datPlanillaNominas) {
		this.datPlanillaNominas = datPlanillaNominas;
	}

	public Set<PlanAsignarRecurso> getPlanAsignarRecursos() {
		return planAsignarRecursos;
	}

	public void setPlanAsignarRecursos(Set<PlanAsignarRecurso> planAsignarRecursos) {
		this.planAsignarRecursos = planAsignarRecursos;
	}

	public Set<Labor> getLaborsForUdadMedProd() {
		return laborsForUdadMedProd;
	}

	public void setLaborsForUdadMedProd(Set<Labor> laborsForUdadMedProd) {
		this.laborsForUdadMedProd = laborsForUdadMedProd;
	}

	public Set<LimiteCeptoNomina> getLimiteCeptoNominas() {
		return limiteCeptoNominas;
	}

	public void setLimiteCeptoNominas(Set<LimiteCeptoNomina> limiteCeptoNominas) {
		this.limiteCeptoNominas = limiteCeptoNominas;
	}

	public Set<DatTransProdDet> getDatTransProdDets() {
		return datTransProdDets;
	}

	public void setDatTransProdDets(Set<DatTransProdDet> datTransProdDets) {
		this.datTransProdDets = datTransProdDets;
	}

	public Set<TarifaEquipProp> getTarifaEquipProps() {
		return tarifaEquipProps;
	}

	public void setTarifaEquipProps(Set<TarifaEquipProp> tarifaEquipProps) {
		this.tarifaEquipProps = tarifaEquipProps;
	}

	public Set<CostoRecurso> getCostoRecursos() {
		return costoRecursos;
	}

	public void setCostoRecursos(Set<CostoRecurso> costoRecursos) {
		this.costoRecursos = costoRecursos;
	}

	public Set<DatPlanillaNominaDet> getDatPlanillaNominaDetsForUdadMedProd() {
		return datPlanillaNominaDetsForUdadMedProd;
	}

	public void setDatPlanillaNominaDetsForUdadMedProd(Set<DatPlanillaNominaDet> datPlanillaNominaDetsForUdadMedProd) {
		this.datPlanillaNominaDetsForUdadMedProd = datPlanillaNominaDetsForUdadMedProd;
	}

	public Set<TarifaProfesion> getTarifaProfesions() {
		return tarifaProfesions;
	}

	public void setTarifaProfesions(Set<TarifaProfesion> tarifaProfesions) {
		this.tarifaProfesions = tarifaProfesions;
	}

	public Set<DatTransProdTrabajadores> getDatTransProdTrabajadoreses() {
		return datTransProdTrabajadoreses;
	}

	public void setDatTransProdTrabajadoreses(Set<DatTransProdTrabajadores> datTransProdTrabajadoreses) {
		this.datTransProdTrabajadoreses = datTransProdTrabajadoreses;
	}

	public Set<Bascula> getBasculas() {
		return basculas;
	}

	public void setBasculas(Set<Bascula> basculas) {
		this.basculas = basculas;
	}

	public Long getUdadMedId() {
		return this.udadMedId;
	}

	public void setUdadMedId(Long udadMedId) {
		this.udadMedId = udadMedId;
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

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
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

	public Long getNroDecimales() {
		return this.nroDecimales;
	}

	public void setNroDecimales(Long nroDecimales) {
		this.nroDecimales = nroDecimales;
	}

	public String getClasificacionUm() {
		return this.clasificacionUm;
	}

	public void setClasificacionUm(String clasificacionUm) {
		this.clasificacionUm = clasificacionUm;
	}

	public Set<Cultivo> getCultivosForUdadMedId1() {
		return this.cultivosForUdadMedId1;
	}

	public void setCultivosForUdadMedId1(Set<Cultivo> cultivosForUdadMedId1) {
		this.cultivosForUdadMedId1 = cultivosForUdadMedId1;
	}

	public Set<Cultivo> getCultivosForUdadMedId() {
		return this.cultivosForUdadMedId;
	}

	public void setCultivosForUdadMedId(Set<Cultivo> cultivosForUdadMedId) {
		this.cultivosForUdadMedId = cultivosForUdadMedId;
	}

	public Set<DatAbastCombustible> getDatAbastCombustibles() {
		return this.datAbastCombustibles;
	}

	public void setDatAbastCombustibles(Set<DatAbastCombustible> datAbastCombustibles) {
		this.datAbastCombustibles = datAbastCombustibles;
	}

	public Set<DatMantenimientoEquipoProd> getDatMantenimientoEquipoProds() {
		return this.datMantenimientoEquipoProds;
	}

	public void setDatMantenimientoEquipoProds(Set<DatMantenimientoEquipoProd> datMantenimientoEquipoProds) {
		this.datMantenimientoEquipoProds = datMantenimientoEquipoProds;
	}

	public Set<DatMantenimientoEquipoMec> getDatMantenimientoEquipoMecs() {
		return this.datMantenimientoEquipoMecs;
	}

	public void setDatMantenimientoEquipoMecs(Set<DatMantenimientoEquipoMec> datMantenimientoEquipoMecs) {
		this.datMantenimientoEquipoMecs = datMantenimientoEquipoMecs;
	}

	public Set<TipoRecursosOtros> getTipoRecursosOtroses() {
		return tipoRecursosOtroses;
	}

	public void setTipoRecursosOtroses(Set<TipoRecursosOtros> tipoRecursosOtroses) {
		this.tipoRecursosOtroses = tipoRecursosOtroses;
	}

	public Set<TipoRecursosInsumos> getTipoRecursosInsumoses() {
		return tipoRecursosInsumoses;
	}

	public void setTipoRecursosInsumoses(Set<TipoRecursosInsumos> tipoRecursosInsumoses) {
		this.tipoRecursosInsumoses = tipoRecursosInsumoses;
	}

	public Set<TipoRecursosEquipos> getTipoRecursosEquiposes() {
		return tipoRecursosEquiposes;
	}

	public void setTipoRecursosEquiposes(Set<TipoRecursosEquipos> tipoRecursosEquiposes) {
		this.tipoRecursosEquiposes = tipoRecursosEquiposes;
	}

	public Set<TipoRecursosProfesion> getTipoRecursosProfesions() {
		return tipoRecursosProfesions;
	}

	public void setTipoRecursosProfesions(Set<TipoRecursosProfesion> tipoRecursosProfesions) {
		this.tipoRecursosProfesions = tipoRecursosProfesions;
	}

	public Set<LaborRecursos> getLaborRecursoses() {
		return laborRecursoses;
	}

	public void setLaborRecursoses(Set<LaborRecursos> laborRecursoses) {
		this.laborRecursoses = laborRecursoses;
	}

}
