package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatPlanServiciosMqdetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatPlanServiciosMqdetDTO.class);
    private Double cantidadPlan;
    private String concluido;
    private Long datPlanServiciosMqdetId;
    private String detalleNota;
    private Nivel4Clientesmq nivel4ClientesmqId;
    private String nivel4mqTexto;
    private Double valorEstTotal;
    private Double valorEstUnitario;
    private Long datPlanServiciosMqId_DatPlanServiciosMq;
    private Equipo equipoId_Equipo;
    private Labor laborId_Labor;
    private Nivel2Clientesmq nivel2ClientesmqId_Nivel2Clientesmq;
    private PersEmpr persEmprId_PersEmpr;
    private UdadMed udadMedId_UdadMed;

    private String nombreCliente;
    private String nombreHacienda;
    private String codigoLote;
    private String codigoEquipo;
    private String nombreUdadMed;
    private String nombreLabor;
    
    private Double cantidadRealizada;
    private Double cantidadPendiente;
    private String facturado;
    private String codOperario;
    private Trabajador operario;
    private Long numPases;
    
    private Date periodoInicial;
    private Double areaProgramada;
    
    private Double cantidadPresupuesto;
    
    
	public Double getCantidadPresupuesto() {
		return cantidadPresupuesto;
	}

	public void setCantidadPresupuesto(Double cantidadPresupuesto) {
		this.cantidadPresupuesto = cantidadPresupuesto;
	}

	public Double getAreaProgramada() {
		return areaProgramada;
	}

	public void setAreaProgramada(Double areaProgramada) {
		this.areaProgramada = areaProgramada;
	}

  


	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Long getNumPases() {
		return numPases;
	}

	public void setNumPases(Long numPases) {
		this.numPases = numPases;
	}

	public String getCodOperario() {
		return codOperario;
	}

	public void setCodOperario(String codOperario) {
		this.codOperario = codOperario;
	}

	public Trabajador getOperario() {
		return operario;
	}

	public void setOperario(Trabajador operario) {
		this.operario = operario;
	}

	public Double getCantidadRealizada() {
		return cantidadRealizada;
	}

	public void setCantidadRealizada(Double cantidadRealizada) {
		this.cantidadRealizada = cantidadRealizada;
	}

	public Double getCantidadPendiente() {
		return cantidadPendiente;
	}

	public void setCantidadPendiente(Double cantidadPendiente) {
		this.cantidadPendiente = cantidadPendiente;
	}

	public String getFacturado() {
		return facturado;
	}

	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}

	public Double getCantidadPlan() {
        return cantidadPlan;
    }

    public void setCantidadPlan(Double cantidadPlan) {
        this.cantidadPlan = cantidadPlan;
    }

    public String getConcluido() {
        return concluido;
    }

    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }

    public Long getDatPlanServiciosMqdetId() {
        return datPlanServiciosMqdetId;
    }

    public void setDatPlanServiciosMqdetId(Long datPlanServiciosMqdetId) {
        this.datPlanServiciosMqdetId = datPlanServiciosMqdetId;
    }

    public String getDetalleNota() {
        return detalleNota;
    }

    public void setDetalleNota(String detalleNota) {
        this.detalleNota = detalleNota;
    }

  

    public String getNivel4mqTexto() {
        return nivel4mqTexto;
    }

    public void setNivel4mqTexto(String nivel4mqTexto) {
        this.nivel4mqTexto = nivel4mqTexto;
    }

    public Double getValorEstTotal() {
        return valorEstTotal;
    }

    public void setValorEstTotal(Double valorEstTotal) {
        this.valorEstTotal = valorEstTotal;
    }

    public Double getValorEstUnitario() {
        return valorEstUnitario;
    }

    public void setValorEstUnitario(Double valorEstUnitario) {
        this.valorEstUnitario = valorEstUnitario;
    }

    public Long getDatPlanServiciosMqId_DatPlanServiciosMq() {
        return datPlanServiciosMqId_DatPlanServiciosMq;
    }

    public void setDatPlanServiciosMqId_DatPlanServiciosMq(
        Long datPlanServiciosMqId_DatPlanServiciosMq) {
        this.datPlanServiciosMqId_DatPlanServiciosMq = datPlanServiciosMqId_DatPlanServiciosMq;
    }

	public Nivel4Clientesmq getNivel4ClientesmqId() {
		return nivel4ClientesmqId;
	}

	public void setNivel4ClientesmqId(Nivel4Clientesmq nivel4ClientesmqId) {
		this.nivel4ClientesmqId = nivel4ClientesmqId;
	}

	public Equipo getEquipoId_Equipo() {
		return equipoId_Equipo;
	}

	public void setEquipoId_Equipo(Equipo equipoId_Equipo) {
		this.equipoId_Equipo = equipoId_Equipo;
	}

	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public Nivel2Clientesmq getNivel2ClientesmqId_Nivel2Clientesmq() {
		return nivel2ClientesmqId_Nivel2Clientesmq;
	}

	public void setNivel2ClientesmqId_Nivel2Clientesmq(Nivel2Clientesmq nivel2ClientesmqId_Nivel2Clientesmq) {
		this.nivel2ClientesmqId_Nivel2Clientesmq = nivel2ClientesmqId_Nivel2Clientesmq;
	}

	public PersEmpr getPersEmprId_PersEmpr() {
		return persEmprId_PersEmpr;
	}

	public void setPersEmprId_PersEmpr(PersEmpr persEmprId_PersEmpr) {
		this.persEmprId_PersEmpr = persEmprId_PersEmpr;
	}

	public UdadMed getUdadMedId_UdadMed() {
		return udadMedId_UdadMed;
	}

	public void setUdadMedId_UdadMed(UdadMed udadMedId_UdadMed) {
		this.udadMedId_UdadMed = udadMedId_UdadMed;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreHacienda() {
		return nombreHacienda;
	}

	public void setNombreHacienda(String nombreHacienda) {
		this.nombreHacienda = nombreHacienda;
	}

	public String getCodigoLote() {
		return codigoLote;
	}

	public void setCodigoLote(String codigoLote) {
		this.codigoLote = codigoLote;
	}

	

	public String getCodigoEquipo() {
		return codigoEquipo;
	}

	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public String getNombreUdadMed() {
		return nombreUdadMed;
	}

	public void setNombreUdadMed(String nombreUdadMed) {
		this.nombreUdadMed = nombreUdadMed;
	}

	public String getNombreLabor() {
		return nombreLabor;
	}

	public void setNombreLabor(String nombreLabor) {
		this.nombreLabor = nombreLabor;
	}


}
