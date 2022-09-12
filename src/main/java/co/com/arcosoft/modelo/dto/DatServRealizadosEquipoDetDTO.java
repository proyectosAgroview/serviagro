package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.omg.CORBA.DATA_CONVERSION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatServRealizadosEquipoDetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatServRealizadosEquipoDetDTO.class);
    private Long datServRealizadosEquipoDetId;
    private Long datServRealizadosEquipoId;
    private Date horaFinal;
    private Date horaInicial;
    private Double horasTotal;
    private Double horometroFinal;
    private Double horometroInicial;
    private Double horometroTotal;
    private Double ingresoTotal;
    private Double valorUnitario;
    private Labor laborId_Labor;
    private UdadMed udadMedId_UdadMed;
    private String nombreLabor;
    private String nombreUdadMed;
    private Nivel2 nivel2;
    private Nivel4 nivel4;
    private String nombreNivel2;
    private String nombreNivel4;
    private Double cantidad;
    
 	private PersEmpr persEmpr;
 	private Equipo implemento;
 	private Double bonificacionTrabajador;
 	private Trabajador trabajador;    
 	private Nivel2Clientesmq nivel2ClientesId;
 	
 	private String nomCliente;
 	private String codImplemento;
 	private String codProducto;
 	private String codTrabajador;
 	private String nomNivel2ClientesId;
 	private String turno;
 	private ConceptoNomina conceptoNominaId;
 	private String nomConceptoNomina;
 	
 	
 	private  Date fechaValidacion;
 	private Long usuarioValidacion;
 	private String estadoFactura;
 	private String numFactura;
 	private Nivel4Clientesmq nivel4ClientesId;
    private Long consecutivoPrefactura;
	private Producto productoId;
 	private Double cantidadCombustible;
 	private Double sello;
 	private Almacen  almacenId;
 	private Double costoCombustible;

 	private Double auxilioTransporte;
 	private DatPlanServiciosMqdet	dat_plan_servicios_mqdet_id ;
 	private  Double valor_unitario_trabajador;
 	private  Double  valor_total_trabajador;
 	private Long idProgramaMaqDet;
 
 	
 	
 	private Date fechaPrefactura;
 	private Date fechaFactura;
 	private Long  usuarioPrefactura;
 	private Long  usuarioFactura;
 	
 	private String observacion;
 	private String reportarNovedadParada;

	private Double cantidadTrabajador;
	private Long usuarioDigitacion;
	private Long unidadMedidaTrabajador;
	
	private String tipoMttoTexto;
	private Double horometroMtto;
	
 	 
 	
	public String getTipoMttoTexto() {
		return tipoMttoTexto;
	}



	public Double getHorometroMtto() {
		return horometroMtto;
	}



	public void setTipoMttoTexto(String tipoMttoTexto) {
		this.tipoMttoTexto = tipoMttoTexto;
	}



	public void setHorometroMtto(Double horometroMtto) {
		this.horometroMtto = horometroMtto;
	}



	public Long getUnidadMedidaTrabajador() {
		return unidadMedidaTrabajador;
	}



	public void setUnidadMedidaTrabajador(Long unidadMedidaTrabajador) {
		this.unidadMedidaTrabajador = unidadMedidaTrabajador;
	}



	public Long getUsuarioDigitacion() {
		return usuarioDigitacion;
	}

 

	public void setUsuarioDigitacion(Long usuarioDigitacion) {
		this.usuarioDigitacion = usuarioDigitacion;
	}
 
	public Double getCantidadTrabajador() {
		return cantidadTrabajador;
	}

	public void setCantidadTrabajador(Double cantidadTrabajador) {
		this.cantidadTrabajador = cantidadTrabajador;
	}

	public String getReportarNovedadParada() {
		return reportarNovedadParada;
	}

	public void setReportarNovedadParada(String reportarNovedadParada) {
		this.reportarNovedadParada = reportarNovedadParada;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaPrefactura() {
		return fechaPrefactura;
	}

	public void setFechaPrefactura(Date fechaPrefactura) {
		this.fechaPrefactura = fechaPrefactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Long getUsuarioPrefactura() {
		return usuarioPrefactura;
	}

	public void setUsuarioPrefactura(Long usuarioPrefactura) {
		this.usuarioPrefactura = usuarioPrefactura;
	}

	public Long getUsuarioFactura() {
		return usuarioFactura;
	}

	public void setUsuarioFactura(Long usuarioFactura) {
		this.usuarioFactura = usuarioFactura;
	}

	public Long getIdProgramaMaqDet() {
		return idProgramaMaqDet;
	}

	public void setIdProgramaMaqDet(Long idProgramaMaqDet) {
		this.idProgramaMaqDet = idProgramaMaqDet;
	}

	public DatPlanServiciosMqdet getDat_plan_servicios_mqdet_id() {
		return dat_plan_servicios_mqdet_id;
	}

	public void setDat_plan_servicios_mqdet_id(DatPlanServiciosMqdet dat_plan_servicios_mqdet_id) {
		this.dat_plan_servicios_mqdet_id = dat_plan_servicios_mqdet_id;
	}

	public Double getValor_unitario_trabajador() {
		return valor_unitario_trabajador;
	}

	public void setValor_unitario_trabajador(Double valor_unitario_trabajador) {
		this.valor_unitario_trabajador = valor_unitario_trabajador;
	}

	public Double getValor_total_trabajador() {
		return valor_total_trabajador;
	}

	public void setValor_total_trabajador(Double valor_total_trabajador) {
		this.valor_total_trabajador = valor_total_trabajador;
	}

	
	public Double getAuxilioTransporte() {
		return auxilioTransporte;
	}

	public void setAuxilioTransporte(Double auxilioTransporte) {
		this.auxilioTransporte = auxilioTransporte;
	}

	public Producto getProductoId() {
		return productoId;
	}

	public void setProductoId(Producto productoId) {
		this.productoId = productoId;
	}

	public Double getCantidadCombustible() {
		return cantidadCombustible;
	}

	public void setCantidadCombustible(Double cantidadCombustible) {
		this.cantidadCombustible = cantidadCombustible;
	}

	public Double getSello() {
		return sello;
	}

	public void setSello(Double sello) {
		this.sello = sello;
	}

	public Almacen getAlmacenId() {
		return almacenId;
	}

	public void setAlmacenId(Almacen almacenId) {
		this.almacenId = almacenId;
	}

	public Double getCostoCombustible() {
		return costoCombustible;
	}

	public void setCostoCombustible(Double costoCombustible) {
		this.costoCombustible = costoCombustible;
	}

	public Long getConsecutivoPrefactura() {
		return consecutivoPrefactura;
	}

	public void setConsecutivoPrefactura(Long consecutivoPrefactura) {
		this.consecutivoPrefactura = consecutivoPrefactura;
	}

	/**
	 * @return the fechaValidacion
	 */
	public Date getFechaValidacion() {
		return fechaValidacion;
	}

	/**
	 * @param fechaValidacion the fechaValidacion to set
	 */
	public void setFechaValidacion(Date fechaValidacion) {
		this.fechaValidacion = fechaValidacion;
	}

	/**
	 * @return the usuarioValidacion
	 */
	public Long getUsuarioValidacion() {
		return usuarioValidacion;
	}

	/**
	 * @param usuarioValidacion the usuarioValidacion to set
	 */
	public void setUsuarioValidacion(Long usuarioValidacion) {
		this.usuarioValidacion = usuarioValidacion;
	}

	/**
	 * @return the estadoFactura
	 */
	public String getEstadoFactura() {
		return estadoFactura;
	}

	/**
	 * @param estadoFactura the estadoFactura to set
	 */
	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}

	/**
	 * @return the numFactura
	 */
	public String getNumFactura() {
		return numFactura;
	}

	/**
	 * @param numFactura the numFactura to set
	 */
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	/**
	 * @return the nivel4ClientesId
	 */
	public Nivel4Clientesmq getNivel4ClientesId() {
		return nivel4ClientesId;
	}

	/**
	 * @param nivel4ClientesId the nivel4ClientesId to set
	 */
	public void setNivel4ClientesId(Nivel4Clientesmq nivel4ClientesId) {
		this.nivel4ClientesId = nivel4ClientesId;
	}

	/**
	 * @return the nomConceptoNomina
	 */
	public String getNomConceptoNomina() {
		return nomConceptoNomina;
	}

	/**
	 * @param nomConceptoNomina the nomConceptoNomina to set
	 */
	public void setNomConceptoNomina(String nomConceptoNomina) {
		this.nomConceptoNomina = nomConceptoNomina;
	}

	/**
	 * @return the conceptoNominaId
	 */
	public ConceptoNomina getConceptoNominaId() {
		return conceptoNominaId;
	}

	/**
	 * @param conceptoNominaId the conceptoNominaId to set
	 */
	public void setConceptoNominaId(ConceptoNomina conceptoNominaId) {
		this.conceptoNominaId = conceptoNominaId;
	}

	/**
	 * @return the turno
	 */
	public String getTurno() {
		return turno;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}

	/**
	 * @return the nomCliente
	 */
	public String getNomCliente() {
		return nomCliente;
	}

	/**
	 * @param nomCliente the nomCliente to set
	 */
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	/**
	 * @return the codImplemento
	 */
	public String getCodImplemento() {
		return codImplemento;
	}

	/**
	 * @param codImplemento the codImplemento to set
	 */
	public void setCodImplemento(String codImplemento) {
		this.codImplemento = codImplemento;
	}

	/**
	 * @return the codProducto
	 */
	public String getCodProducto() {
		return codProducto;
	}

	/**
	 * @param codProducto the codProducto to set
	 */
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	/**
	 * @return the codTrabajador
	 */
	public String getCodTrabajador() {
		return codTrabajador;
	}

	/**
	 * @param codTrabajador the codTrabajador to set
	 */
	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	/**
	 * @return the nomNivel2ClientesId
	 */
	public String getNomNivel2ClientesId() {
		return nomNivel2ClientesId;
	}

	/**
	 * @param nomNivel2ClientesId the nomNivel2ClientesId to set
	 */
	public void setNomNivel2ClientesId(String nomNivel2ClientesId) {
		this.nomNivel2ClientesId = nomNivel2ClientesId;
	}

	/**
	 * @return the nivel2ClientesId
	 */
	public Nivel2Clientesmq getNivel2ClientesId() {
		return nivel2ClientesId;
	}

	/**
	 * @param nivel2ClientesId the nivel2ClientesId to set
	 */
	public void setNivel2ClientesId(Nivel2Clientesmq nivel2ClientesId) {
		this.nivel2ClientesId = nivel2ClientesId;
	}

	/**
	 * @return the trabajador
	 */
	public Trabajador getTrabajador() {
		return trabajador;
	}

	/**
	 * @param trabajador the trabajador to set
	 */
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	/**
	 * @return the persEmpr
	 */
	public PersEmpr getPersEmpr() {
		return persEmpr;
	}

	/**
	 * @param persEmpr the persEmpr to set
	 */
	public void setPersEmpr(PersEmpr persEmpr) {
		this.persEmpr = persEmpr;
	}

	/**
	 * @return the implemento
	 */
	public Equipo getImplemento() {
		return implemento;
	}

	/**
	 * @param implemento the implemento to set
	 */
	public void setImplemento(Equipo implemento) {
		this.implemento = implemento;
	}

	
	/**
	 * @return the bonificacionTrabajador
	 */
	public Double getBonificacionTrabajador() {
		return bonificacionTrabajador;
	}

	/**
	 * @param bonificacionTrabajador the bonificacionTrabajador to set
	 */
	public void setBonificacionTrabajador(Double bonificacionTrabajador) {
		this.bonificacionTrabajador = bonificacionTrabajador;
	}

	/**
	 * @return the cantidad
	 */
	public Double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the nombreNivel2
	 */
	public String getNombreNivel2() {
		return nombreNivel2;
	}

	/**
	 * @param nombreNivel2 the nombreNivel2 to set
	 */
	public void setNombreNivel2(String nombreNivel2) {
		this.nombreNivel2 = nombreNivel2;
	}

	
	/**
	 * @return the nombreNivel4
	 */
	public String getNombreNivel4() {
		return nombreNivel4;
	}

	/**
	 * @param nombreNivel4 the nombreNivel4 to set
	 */
	public void setNombreNivel4(String nombreNivel4) {
		this.nombreNivel4 = nombreNivel4;
	}

	/**
	 * @return the nivel2
	 */
	public Nivel2 getNivel2() {
		return nivel2;
	}

	/**
	 * @param nivel2 the nivel2 to set
	 */
	public void setNivel2(Nivel2 nivel2) {
		this.nivel2 = nivel2;
	}

	/**
	 * @return the nivel4
	 */
	public Nivel4 getNivel4() {
		return nivel4;
	}

	/**
	 * @param nivel4 the nivel4 to set
	 */
	public void setNivel4(Nivel4 nivel4) {
		this.nivel4 = nivel4;
	}

	/**
	 * @return the nombreLabor
	 */
	public String getNombreLabor() {
		return nombreLabor;
	}

	/**
	 * @param nombreLabor the nombreLabor to set
	 */
	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}

	/**
	 * @return the nombreUdadMed
	 */
	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	/**
	 * @param nombreUdadMed the nombreUdadMed to set
	 */
	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	
	public Long getDatServRealizadosEquipoDetId() {
        return datServRealizadosEquipoDetId;
    }

    public void setDatServRealizadosEquipoDetId(
        Long datServRealizadosEquipoDetId) {
        this.datServRealizadosEquipoDetId = datServRealizadosEquipoDetId;
    }

    public Long getDatServRealizadosEquipoId() {
        return datServRealizadosEquipoId;
    }

    public void setDatServRealizadosEquipoId(Long datServRealizadosEquipoId) {
        this.datServRealizadosEquipoId = datServRealizadosEquipoId;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Double getHorasTotal() {
        return horasTotal;
    }

    public void setHorasTotal(Double horasTotal) {
        this.horasTotal = horasTotal;
    }

    public Double getHorometroFinal() {
        return horometroFinal;
    }

    public void setHorometroFinal(Double horometroFinal) {
        this.horometroFinal = horometroFinal;
    }

    public Double getHorometroInicial() {
        return horometroInicial;
    }

    public void setHorometroInicial(Double horometroInicial) {
        this.horometroInicial = horometroInicial;
    }

    public Double getHorometroTotal() {
        return horometroTotal;
    }

    public void setHorometroTotal(Double horometroTotal) {
        this.horometroTotal = horometroTotal;
    }

    public Double getIngresoTotal() {
        return ingresoTotal;
    }

    public void setIngresoTotal(Double ingresoTotal) {
        this.ingresoTotal = ingresoTotal;
    }

	/**
	 * @return the valorUnitario
	 */
	public Double getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/**
	 * @return the laborId_Labor
	 */
	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}

	/**
	 * @param laborId_Labor the laborId_Labor to set
	 */
	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	/**
	 * @return the udadMedId_UdadMed
	 */
	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	/**
	 * @param udadMedId_UdadMed the udadMedId_UdadMed to set
	 */
	public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}

    
    
}
