package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Eventos;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class EquipoEventoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EquipoEventoDTO.class);
    private Date fechaFinal;
    private Date fechaInicial;
    private Long id;
    private Equipo equipoId_Equipo;
    private Eventos eventosId_Eventos;
    private String codigoEvento;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long diasNotificacion;
    private Long cuentaEventos;
    private String observacion;
    private String registraPago;
    private Long persEmprId;
    private Double valorEvento;
    private Date fechaPago;

    public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getRegistraPago() {
		return registraPago;
	}

	public void setRegistraPago(String registraPago) {
		this.registraPago = registraPago;
	}

	public Long getPersEmprId() {
		return persEmprId;
	}

	public void setPersEmprId(Long persEmprId) {
		this.persEmprId = persEmprId;
	}

	public Double getValorEvento() {
		return valorEvento;
	}

	public void setValorEvento(Double valorEvento) {
		this.valorEvento = valorEvento;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Equipo equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public Eventos getEventosId_Eventos() {
        return eventosId_Eventos;
    }

    public void setEventosId_Eventos(Eventos eventosId_Eventos) {
        this.eventosId_Eventos = eventosId_Eventos;
    }

	public String getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(String codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

		public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public Long getDiasNotificacion() {
		return diasNotificacion;
	}

	public void setDiasNotificacion(Long diasNotificacion) {
		this.diasNotificacion = diasNotificacion;
	}

	public Long getCuentaEventos() {
		return cuentaEventos;
	}

	public void setCuentaEventos(Long cuentaEventos) {
		this.cuentaEventos = cuentaEventos;
	}
    
	
    
}
