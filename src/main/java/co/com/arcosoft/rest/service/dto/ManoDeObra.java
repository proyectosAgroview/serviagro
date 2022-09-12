package co.com.arcosoft.rest.service.dto;

public class ManoDeObra {

	// Campos con Datos

	private String fechaRegistro;
	private Long compania;
	private String laborId_Labor;
	private Long nivel1Id;
	private Long nivel2Id;
	private Long nivel3Id;
	private Long nivel4Id_Nivel4;
	private Long usuarioDigitacion;
	private Double cantidadPago;
	private Long udadMedIdPago;
	private Double cantidadProd;// este campo guarda el valor unitario de los
								// apuntamientos de mano de obra
	private Double udadMedProd; // este campo guarda el costo total de los
								// apuntamientos de mano de obra
	private String trabId_Trabajador;
	private Long persEmprId_PersEmpr;
	private String ceptoNominaId_ConceptoNomina;
	private Long ordenTrabajo;
	private String observacion;
	
	

	/*
	 * private Double valorUnitario; private Long NPases; private Long anio;
	 * private Long consecutivo; private Double edadEjecucion; private String
	 * estado; private Long etapaId; private Date fechaCreacion; private Date
	 * fechaModificacion; private String idMobile; private String infoAdicional;
	 * private String infoAdicional2; private Float latitud; private Float
	 * longitud; private String observacion; private String
	 * observacionAnularReg; private String ordenTrabajo; private Long
	 * planillaNominaId; private Float precision; private Long variedId; private
	 * String estadoTrue; private Long numeroTiquete; private Double
	 * pesoPromedio ; private Long colorIdentificador; private Double
	 * costoTotal; private Long detPlanillaNominaId; private Double
	 * cantidadDescontar; private Long idPlanLaborDet;
	 */
	
	

	/**
	 * @return the ordenTrabajo
	 */
	public Long getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @param ordenTrabajo the ordenTrabajo to set
	 */
	public void setOrdenTrabajo(Long ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(String laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public Long getNivel1Id() {
		return nivel1Id;
	}

	public void setNivel1Id(Long nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	public Long getNivel2Id() {
		return nivel2Id;
	}

	public void setNivel2Id(Long nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	public Long getNivel3Id() {
		return nivel3Id;
	}

	public void setNivel3Id(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public Long getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNivel4Id_Nivel4(Long nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}

	public Double getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(Double cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public Double getCantidadProd() {
		return cantidadProd;
	}

	public void setCantidadProd(Double cantidadProd) {
		this.cantidadProd = cantidadProd;
	}

	public Long getUdadMedIdPago() {
		return udadMedIdPago;
	}

	public void setUdadMedIdPago(Long udadMedIdPago) {
		this.udadMedIdPago = udadMedIdPago;
	}

	public Double getUdadMedProd() {
		return udadMedProd;
	}

	public void setUdadMedProd(Double udadMedProd) {
		this.udadMedProd = udadMedProd;
	}

	public String getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(String trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public Long getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(Long persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public String getCeptoNominaId_ConceptoNomina() {
		return ceptoNominaId_ConceptoNomina;
	}

	public void setCeptoNominaId_ConceptoNomina(String ceptoNominaId_ConceptoNomina) {
		this.ceptoNominaId_ConceptoNomina = ceptoNominaId_ConceptoNomina;
	}
}
