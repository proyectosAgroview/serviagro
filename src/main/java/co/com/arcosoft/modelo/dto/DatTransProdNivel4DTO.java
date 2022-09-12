package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.ModalidadCosecha;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Variedad;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class DatTransProdNivel4DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(DatTransProdNivel4DTO.class);
	private Long ciclo;
	private Long datTransProdNivel4Id;
	private Double edadNivel4;
	private Etapa etapaNivel4;
	private ModalidadCosecha modalidadCosId;
	private Long nivel1Id;
	private Long nivel3Id;
	private Variedad variedNivel4;
	private Long datTransProdId_DatTransProd;
	private Nivel2 nivel2Id_Nivel2;
	private Nivel4 nivel4Id_Nivel4;
	private Long compania;
	private String nombreNivel2;
	private String nombreNivel4;
	private String codigoNivel4;
	private String nombreModCos;
	private String finCosecha;
	private Double areaCosechada;
	private Double cantidadRacimos;
	private Double pesoPromedio;
	private String indicadorDistribuccion;
	private String nombreVariedad;
	private String nombreEtapa;
	private Double cantidadCosechada;
	private Double porcMateriaExtrana;
	private Double porcSacarosa;
	private Double kilosPorTonelada;
	private Double porcRendimiento;
	private Double cantidadCosechadaHa;
	private Date fechaInicioCosecha;
	private Date fechaFinCosecha;
	private String nombreProducto;
	private Producto producto;
	private PersEmpr clienteId;
	private Ciudad ciudadId;
	private Equipo vagonId;	
	private String nombreVagon;	
	private Double numeroViajes;
	private Double cantidadCosechadaHaMes;
	private Double tonAzucarHaMes;
	private String nomClienteId;	
	private String destinoProduccion;	
	private Double valorUnitario;
	private Double ingresoBruto;
	private Double kilogramosAzucarTonelada;
	private Double valorKilogramosAzucar;	
	private Double ajusteLiquidacion;
	private Double bonificacion;
	private Double otrosIngresos;
	private Double retenciones;
	private Double descuentos;
	  private Double fondoAgroIndustriaPorcentaje;
	    private Double descuentoAdicional1Porcentaje;
	    private Double descuentoAdicional2Porcentaje;
	private String estadoRegistro;
	
	
	    
	    
	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Double getFondoAgroIndustriaPorcentaje() {
			return fondoAgroIndustriaPorcentaje;
		}

		public void setFondoAgroIndustriaPorcentaje(Double fondoAgroIndustriaPorcentaje) {
			this.fondoAgroIndustriaPorcentaje = fondoAgroIndustriaPorcentaje;
		}

		public Double getDescuentoAdicional1Porcentaje() {
			return descuentoAdicional1Porcentaje;
		}

		public void setDescuentoAdicional1Porcentaje(Double descuentoAdicional1Porcentaje) {
			this.descuentoAdicional1Porcentaje = descuentoAdicional1Porcentaje;
		}

		public Double getDescuentoAdicional2Porcentaje() {
			return descuentoAdicional2Porcentaje;
		}

		public void setDescuentoAdicional2Porcentaje(Double descuentoAdicional2Porcentaje) {
			this.descuentoAdicional2Porcentaje = descuentoAdicional2Porcentaje;
		}

	/**
	 * @return the destinoProduccion
	 */
	public String getDestinoProduccion() {
		return destinoProduccion;
	}

	/**
	 * @param destinoProduccion the destinoProduccion to set
	 */
	public void setDestinoProduccion(String destinoProduccion) {
		this.destinoProduccion = destinoProduccion;
	}

	/**
	 * @return the nomClienteId
	 */
	public String getNomClienteId() {
		return nomClienteId;
	}

	/**
	 * @param nomClienteId the nomClienteId to set
	 */
	public void setNomClienteId(String nomClienteId) {
		this.nomClienteId = nomClienteId;
	}

	/**
	 * @return the numeroViajes
	 */
	public Double getNumeroViajes() {
		return numeroViajes;
	}

	/**
	 * @param numeroViajes the numeroViajes to set
	 */
	public void setNumeroViajes(Double numeroViajes) {
		this.numeroViajes = numeroViajes;
	}

	/**
	 * @return the cantidadCosechadaHaMes
	 */
	public Double getCantidadCosechadaHaMes() {
		return cantidadCosechadaHaMes;
	}

	/**
	 * @param cantidadCosechadaHaMes the cantidadCosechadaHaMes to set
	 */
	public void setCantidadCosechadaHaMes(Double cantidadCosechadaHaMes) {
		this.cantidadCosechadaHaMes = cantidadCosechadaHaMes;
	}

	/**
	 * @return the tonAzucarHaMes
	 */
	public Double getTonAzucarHaMes() {
		return tonAzucarHaMes;
	}

	/**
	 * @param tonAzucarHaMes the tonAzucarHaMes to set
	 */
	public void setTonAzucarHaMes(Double tonAzucarHaMes) {
		this.tonAzucarHaMes = tonAzucarHaMes;
	}

	/**
	 * @return the nombreVagon
	 */
	public String getNombreVagon() {
		return nombreVagon;
	}

	/**
	 * @param nombreVagon the nombreVagon to set
	 */
	public void setNombreVagon(String nombreVagon) {
		this.nombreVagon = nombreVagon;
	}

	/**
	 * @return the clienteId
	 */
	public PersEmpr getClienteId() {
		return clienteId;
	}

	/**
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(PersEmpr clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * @return the ciudadId
	 */
	public Ciudad getCiudadId() {
		return ciudadId;
	}

	/**
	 * @param ciudadId the ciudadId to set
	 */
	public void setCiudadId(Ciudad ciudadId) {
		this.ciudadId = ciudadId;
	}

	/**
	 * @return the vagonId
	 */
	public Equipo getVagonId() {
		return vagonId;
	}

	/**
	 * @param vagonId the vagonId to set
	 */
	public void setVagonId(Equipo vagonId) {
		this.vagonId = vagonId;
	}

	public Date getFechaInicioCosecha() {
		return fechaInicioCosecha;
	}

	public void setFechaInicioCosecha(Date fechaInicioCosecha) {
		this.fechaInicioCosecha = fechaInicioCosecha;
	}

	public Date getFechaFinCosecha() {
		return fechaFinCosecha;
	}

	public void setFechaFinCosecha(Date fechaFinCosecha) {
		this.fechaFinCosecha = fechaFinCosecha;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getCantidadCosechada() {
		return cantidadCosechada;
	}

	public void setCantidadCosechada(Double cantidadCosechada) {
		this.cantidadCosechada = cantidadCosechada;
	}

	public Double getPorcMateriaExtrana() {
		return porcMateriaExtrana;
	}

	public void setPorcMateriaExtrana(Double porcMateriaExtrana) {
		this.porcMateriaExtrana = porcMateriaExtrana;
	}

	public Double getPorcSacarosa() {
		return porcSacarosa;
	}

	public void setPorcSacarosa(Double porcSacarosa) {
		this.porcSacarosa = porcSacarosa;
	}

	public Double getKilosPorTonelada() {
		return kilosPorTonelada;
	}

	public void setKilosPorTonelada(Double kilosPorTonelada) {
		this.kilosPorTonelada = kilosPorTonelada;
	}

	public Double getPorcRendimiento() {
		return porcRendimiento;
	}

	public void setPorcRendimiento(Double porcRendimiento) {
		this.porcRendimiento = porcRendimiento;
	}

	public Double getCantidadCosechadaHa() {
		return cantidadCosechadaHa;
	}

	public void setCantidadCosechadaHa(Double cantidadCosechadaHa) {
		this.cantidadCosechadaHa = cantidadCosechadaHa;
	}

	public String getNombreVariedad() {
		return nombreVariedad;
	}

	public void setNombreVariedad(String nombreVariedad) {
		this.nombreVariedad = nombreVariedad;
	}

	public String getNombreEtapa() {
		return nombreEtapa;
	}

	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public Double getCantidadRacimos() {
		return cantidadRacimos;
	}

	public void setCantidadRacimos(Double cantidadRacimos) {
		this.cantidadRacimos = cantidadRacimos;
	}

	public Double getPesoPromedio() {
		return pesoPromedio;
	}

	public void setPesoPromedio(Double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}

	public String getIndicadorDistribuccion() {
		return indicadorDistribuccion;
	}

	public void setIndicadorDistribuccion(String indicadorDistribuccion) {
		this.indicadorDistribuccion = indicadorDistribuccion;
	}

	public Double getAreaCosechada() {
		return areaCosechada;
	}

	public void setAreaCosechada(Double areaCosechada) {
		this.areaCosechada = areaCosechada;
	}

	public String getNombreNivel2() {
		return nombreNivel2;
	}

	public String getFinCosecha() {
		return finCosecha;
	}

	public void setFinCosecha(String finCosecha) {
		this.finCosecha = finCosecha;
	}

	public ModalidadCosecha getModalidadCosId() {
		return modalidadCosId;
	}

	public Nivel2 getNivel2Id_Nivel2() {
		return nivel2Id_Nivel2;
	}

	public Nivel4 getNivel4Id_Nivel4() {
		return nivel4Id_Nivel4;
	}

	public void setNombreNivel2(String nombreNivel2) {
		this.nombreNivel2 = nombreNivel2;
	}

	public String getNombreNivel4() {
		return nombreNivel4;
	}

	public void setNombreNivel4(String nombreNivel4) {
		this.nombreNivel4 = nombreNivel4;
	}

	public String getCodigoNivel4() {
		return codigoNivel4;
	}

	public void setCodigoNivel4(String codigoNivel4) {
		this.codigoNivel4 = codigoNivel4;
	}

	public Long getCiclo() {
		return ciclo;
	}

	public void setCiclo(Long ciclo) {
		this.ciclo = ciclo;
	}

	public Long getDatTransProdNivel4Id() {
		return datTransProdNivel4Id;
	}

	public void setDatTransProdNivel4Id(Long datTransProdNivel4Id) {
		this.datTransProdNivel4Id = datTransProdNivel4Id;
	}

	public Double getEdadNivel4() {
		return edadNivel4;
	}

	public void setEdadNivel4(Double edadNivel4) {
		this.edadNivel4 = edadNivel4;
	}

	public Etapa getEtapaNivel4() {
		return etapaNivel4;
	}

	public void setEtapaNivel4(Etapa etapaNivel4) {
		this.etapaNivel4 = etapaNivel4;
	}

	public Long getNivel1Id() {
		return nivel1Id;
	}

	public void setNivel1Id(Long nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	public Long getNivel3Id() {
		return nivel3Id;
	}

	public void setNivel3Id(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	public Variedad getVariedNivel4() {
		return variedNivel4;
	}

	public void setVariedNivel4(Variedad variedNivel4) {
		this.variedNivel4 = variedNivel4;
	}

	public Long getDatTransProdId_DatTransProd() {
		return datTransProdId_DatTransProd;
	}

	public void setDatTransProdId_DatTransProd(Long datTransProdId_DatTransProd) {
		this.datTransProdId_DatTransProd = datTransProdId_DatTransProd;
	}

	public String getNombreModCos() {
		return nombreModCos;
	}

	public void setNombreModCos(String nombreModCos) {
		this.nombreModCos = nombreModCos;
	}

	public void setModalidadCosId(ModalidadCosecha modalidadCosId) {
		this.modalidadCosId = modalidadCosId;
	}

	public void setNivel2Id_Nivel2(Nivel2 nivel2Id_Nivel2) {
		this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
	}

	public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
		this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getIngresoBruto() {
		return ingresoBruto;
	}

	public void setIngresoBruto(Double ingresoBruto) {
		this.ingresoBruto = ingresoBruto;
	}

	public Double getKilogramosAzucarTonelada() {
		return kilogramosAzucarTonelada;
	}

	public void setKilogramosAzucarTonelada(Double kilogramosAzucarTonelada) {
		this.kilogramosAzucarTonelada = kilogramosAzucarTonelada;
	}

	public Double getValorKilogramosAzucar() {
		return valorKilogramosAzucar;
	}

	public void setValorKilogramosAzucar(Double valorKilogramosAzucar) {
		this.valorKilogramosAzucar = valorKilogramosAzucar;
	}

	public Double getAjusteLiquidacion() {
		return ajusteLiquidacion;
	}

	public void setAjusteLiquidacion(Double ajusteLiquidacion) {
		this.ajusteLiquidacion = ajusteLiquidacion;
	}

	public Double getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(Double bonificacion) {
		this.bonificacion = bonificacion;
	}

	public Double getOtrosIngresos() {
		return otrosIngresos;
	}

	public void setOtrosIngresos(Double otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}

	public Double getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(Double retenciones) {
		this.retenciones = retenciones;
	}

	public Double getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(Double descuentos) {
		this.descuentos = descuentos;
	}
}
