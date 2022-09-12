package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.CompartimientosEquipo;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.SistemasEquipo;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatMantenimientoEquipoMecDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoMecDTO.class);
    private Double cantidad;
    private Double costoTotal;
    private Labor laborId_Labor;
    private Long datMantenimientoEquipoMecId;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaRegistro;
    private Double valorUnitario;
    private ConceptoNomina ceptoNominaId_ConceptoNomina;
    private Long datMantenimientoEquipoId_DatMantenimientoEquipo;
    private Trabajador trabId_Trabajador;
    private UdadMed udadMedId_UdadMed;
    private String codTrabajador;
    private String codConcepto;
    private String codUdadMed;
    private String codLabor;
    private String codSistema;
    private String codCompartimiento;
    private Date horaIniMec;
    private Date horaFinMec;
    private Long sistemasEquipoId_SistemasEquipo;
    private Long compartimientosEquipoId_CompartimientosEquipo;
    private SistemasEquipo sistema;
    private CompartimientosEquipo compartimiento;
    private PersEmpr contratistaId;
    private String tipoPersonal;
    private String nomProveedor;
    private String numFactura;
    
    private String observacion;
    
    
    
    
    
    public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public PersEmpr getContratistaId() {
		return contratistaId;
	}

	public void setContratistaId(PersEmpr contratistaId) {
		this.contratistaId = contratistaId;
	}

	public String getTipoPersonal() {
		return tipoPersonal;
	}

	public void setTipoPersonal(String tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
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

    public Long getDatMantenimientoEquipoMecId() {
        return datMantenimientoEquipoMecId;
    }

    public void setDatMantenimientoEquipoMecId(Long datMantenimientoEquipoMecId) {
        this.datMantenimientoEquipoMecId = datMantenimientoEquipoMecId;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public ConceptoNomina getCeptoNominaId_ConceptoNomina() {
        return ceptoNominaId_ConceptoNomina;
    }

    public void setCeptoNominaId_ConceptoNomina(
    		ConceptoNomina ceptoNominaId_ConceptoNomina) {
        this.ceptoNominaId_ConceptoNomina = ceptoNominaId_ConceptoNomina;
    }

    public Long getDatMantenimientoEquipoId_DatMantenimientoEquipo() {
        return datMantenimientoEquipoId_DatMantenimientoEquipo;
    }

    public void setDatMantenimientoEquipoId_DatMantenimientoEquipo(
        Long datMantenimientoEquipoId_DatMantenimientoEquipo) {
        this.datMantenimientoEquipoId_DatMantenimientoEquipo = datMantenimientoEquipoId_DatMantenimientoEquipo;
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

	public String getCodTrabajador() {
		return codTrabajador;
	}

	public void setCodTrabajador(String codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getCodConcepto() {
		return codConcepto;
	}

	public void setCodConcepto(String codConcepto) {
		this.codConcepto = codConcepto;
	}

	public String getCodUdadMed() {
		return codUdadMed;
	}

	public void setCodUdadMed(String codUdadMed) {
		this.codUdadMed = codUdadMed;
	}


	public Date getHoraIniMec() {
		return horaIniMec;
	}

	public Date getHoraFinMec() {
		return horaFinMec;
	}


	public void setHoraIniMec(Date horaIniMec) {
		this.horaIniMec = horaIniMec;
	}

	public void setHoraFinMec(Date horaFinMec) {
		this.horaFinMec = horaFinMec;
	}

	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public String getCodLabor() {
		return codLabor;
	}

	public void setCodLabor(String codLabor) {
		this.codLabor = codLabor;
	}

	public Long getSistemasEquipoId_SistemasEquipo() {
		return sistemasEquipoId_SistemasEquipo;
	}

	public void setSistemasEquipoId_SistemasEquipo(Long sistemasEquipoId_SistemasEquipo) {
		this.sistemasEquipoId_SistemasEquipo = sistemasEquipoId_SistemasEquipo;
	}

	public Long getCompartimientosEquipoId_CompartimientosEquipo() {
		return compartimientosEquipoId_CompartimientosEquipo;
	}

	public void setCompartimientosEquipoId_CompartimientosEquipo(Long compartimientosEquipoId_CompartimientosEquipo) {
		this.compartimientosEquipoId_CompartimientosEquipo = compartimientosEquipoId_CompartimientosEquipo;
	}

	public SistemasEquipo getSistema() {
		return sistema;
	}

	public void setSistema(SistemasEquipo sistema) {
		this.sistema = sistema;
	}

	public CompartimientosEquipo getCompartimiento() {
		return compartimiento;
	}

	public void setCompartimiento(CompartimientosEquipo compartimiento) {
		this.compartimiento = compartimiento;
	}

	public String getCodSistema() {
		return codSistema;
	}

	public void setCodSistema(String codSistema) {
		this.codSistema = codSistema;
	}

	public String getCodCompartimiento() {
		return codCompartimiento;
	}

	public void setCodCompartimiento(String codCompartimiento) {
		this.codCompartimiento = codCompartimiento;
	}
	
	
	
	

    
}
