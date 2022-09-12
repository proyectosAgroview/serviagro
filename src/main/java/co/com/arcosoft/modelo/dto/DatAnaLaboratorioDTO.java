package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatAnaLaboratorioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatAnaLaboratorioDTO.class);
    private Long compania;
    private Long consecutivo;
    private Long datAnaLabId;
    private String estado;
    private Date fechaAnalisis;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String infoAdicional;
    private String infoAdicional2;
    private String mobileId;
    private String observacion;
    private String observacionAnularReg;
    private Long usuarioDigitacion;
    private Long anaLabId_AnaLaboratorio;
    private String nombreAnalisis;
    private String estadoTrue;
    private Nivel4 nivel4Id;
    private Nivel2 nivel2Id;
    private Long nroTicket;
    private String nomNivel4;
    private String nomNivel2;
    
    private Long nivel1Id;
    private Long nivel3Id;
    
    private String horaDigitacion;
    
    private Long clienteId;
    private String nomCliente;
    private Long equipo;
    private String codEquipo;
    
    
    
    
    
    public Long getEquipo() {
		return equipo;
	}

	public void setEquipo(Long equipo) {
		this.equipo = equipo;
	}

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	/**
	 * @return the horaDigitacion
	 */
	public String getHoraDigitacion() {
		return horaDigitacion;
	}

	/**
	 * @param horaDigitacion the horaDigitacion to set
	 */
	public void setHoraDigitacion(String horaDigitacion) {
		this.horaDigitacion = horaDigitacion;
	}

	/**
	 * @return the nivel1Id
	 */
	public Long getNivel1Id() {
		return nivel1Id;
	}

	/**
	 * @param nivel1Id the nivel1Id to set
	 */
	public void setNivel1Id(Long nivel1Id) {
		this.nivel1Id = nivel1Id;
	}

	/**
	 * @return the nivel3Id
	 */
	public Long getNivel3Id() {
		return nivel3Id;
	}

	/**
	 * @param nivel3Id the nivel3Id to set
	 */
	public void setNivel3Id(Long nivel3Id) {
		this.nivel3Id = nivel3Id;
	}

	/**
	 * @return the nomNivel4
	 */
	public String getNomNivel4() {
		return nomNivel4;
	}

	/**
	 * @param nomNivel4 the nomNivel4 to set
	 */
	public void setNomNivel4(String nomNivel4) {
		this.nomNivel4 = nomNivel4;
	}

	/**
	 * @return the nomNivel2
	 */
	public String getNomNivel2() {
		return nomNivel2;
	}

	/**
	 * @param nomNivel2 the nomNivel2 to set
	 */
	public void setNomNivel2(String nomNivel2) {
		this.nomNivel2 = nomNivel2;
	}

	/**
	 * @return the nivel4Id
	 */
	public Nivel4 getNivel4Id() {
		return nivel4Id;
	}

	/**
	 * @param nivel4Id the nivel4Id to set
	 */
	public void setNivel4Id(Nivel4 nivel4Id) {
		this.nivel4Id = nivel4Id;
	}

	/**
	 * @return the nivel2Id
	 */
	public Nivel2 getNivel2Id() {
		return nivel2Id;
	}

	/**
	 * @param nivel2Id the nivel2Id to set
	 */
	public void setNivel2Id(Nivel2 nivel2Id) {
		this.nivel2Id = nivel2Id;
	}

	/**
	 * @return the nroTicket
	 */
	public Long getNroTicket() {
		return nroTicket;
	}

	/**
	 * @param nroTicket the nroTicket to set
	 */
	public void setNroTicket(Long nroTicket) {
		this.nroTicket = nroTicket;
	}

	/**
	 * @return the estadoTrue
	 */
	public String getEstadoTrue() {
		return estadoTrue;
	}

	/**
	 * @param estadoTrue the estadoTrue to set
	 */
	public void setEstadoTrue(String estadoTrue) {
		this.estadoTrue = estadoTrue;
	}

	/**
	 * @return the nombreAnalisis
	 */
	public String getNombreAnalisis() {
		return nombreAnalisis;
	}

	/**
	 * @param nombreAnalisis the nombreAnalisis to set
	 */
	public void setNombreAnalisis(String nombreAnalisis) {
		this.nombreAnalisis = nombreAnalisis;
	}

	public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Long getDatAnaLabId() {
        return datAnaLabId;
    }

    public void setDatAnaLabId(Long datAnaLabId) {
        this.datAnaLabId = datAnaLabId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAnalisis() {
        return fechaAnalisis;
    }

    public void setFechaAnalisis(Date fechaAnalisis) {
        this.fechaAnalisis = fechaAnalisis;
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

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public String getInfoAdicional2() {
        return infoAdicional2;
    }

    public void setInfoAdicional2(String infoAdicional2) {
        this.infoAdicional2 = infoAdicional2;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacionAnularReg() {
        return observacionAnularReg;
    }

    public void setObservacionAnularReg(String observacionAnularReg) {
        this.observacionAnularReg = observacionAnularReg;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Long getAnaLabId_AnaLaboratorio() {
        return anaLabId_AnaLaboratorio;
    }

    public void setAnaLabId_AnaLaboratorio(Long anaLabId_AnaLaboratorio) {
        this.anaLabId_AnaLaboratorio = anaLabId_AnaLaboratorio;
    }
}
