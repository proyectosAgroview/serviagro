package co.com.arcosoft.modelo;
// Generated 13-abr-2018 9:41:11 by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DatAnaLaboratorio generated by hbm2java
 */
public class DatAnaLaboratorio  implements java.io.Serializable {


     private Long datAnaLabId;
     private AnaLaboratorio anaLaboratorio;
     private Long consecutivo;
     private Long compania;
     private String infoAdicional;
     private String infoAdicional2;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estado;
     private Date fechaAnalisis;
     private String observacion;
     private String mobileId;
     private Long usuarioDigitacion;
     private String observacionAnularReg;
     private Set<DatAnaLaboratorioDet> datAnaLaboratorioDets = new HashSet<DatAnaLaboratorioDet>(0);
     private Nivel4 nivel4Id;
     private Nivel2 nivel2Id;
     private Long nivel1Id;
     private Long nivel3Id;
     
     private Long nroTicket;
     private String horaDigitacion;
     private PersEmpr clienteId;
     private Equipo equipo;
     
    public DatAnaLaboratorio() {
    	
    }

    public DatAnaLaboratorio(AnaLaboratorio anaLaboratorio, Long consecutivo, Long compania, String infoAdicional, 
    		
    		String infoAdicional2, Date fechaCreacion, Date fechaModificacion, String estado, Date fechaAnalisis, 
    		String observacion, String mobileId, Long usuarioDigitacion, String observacionAnularReg, 
    		Set<DatAnaLaboratorioDet> datAnaLaboratorioDets,
    		Nivel4 nivel4Id, Nivel2 nivel2Id, Long nroTicket,
    		Long nivel1Id, Long nivel3Id, String horaDigitacion, PersEmpr clienteId, Equipo equipo
    		
    		) {
    	this.clienteId=clienteId;
       this.anaLaboratorio = anaLaboratorio;
       this.consecutivo = consecutivo;
       this.compania = compania;
       this.infoAdicional = infoAdicional;
       this.infoAdicional2 = infoAdicional2;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estado = estado;
       this.fechaAnalisis = fechaAnalisis;
       this.observacion = observacion;
       this.mobileId = mobileId;
       this.usuarioDigitacion = usuarioDigitacion;
       this.observacionAnularReg = observacionAnularReg;
       this.datAnaLaboratorioDets = datAnaLaboratorioDets;
       this.nivel2Id = nivel2Id;
       this.nivel4Id = nivel4Id;
       this.nroTicket = nroTicket;
       this.nivel3Id = nivel3Id;
       this.nivel1Id = nivel1Id;
       this.horaDigitacion= horaDigitacion;
       this.equipo=equipo;
       
    }
   
    
    
    public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public PersEmpr getClienteId() {
		return clienteId;
	}

	public void setClienteId(PersEmpr clienteId) {
		this.clienteId = clienteId;
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

	public Long getDatAnaLabId() {
        return this.datAnaLabId;
    }
    
    public void setDatAnaLabId(Long datAnaLabId) {
        this.datAnaLabId = datAnaLabId;
    }
    public AnaLaboratorio getAnaLaboratorio() {
        return this.anaLaboratorio;
    }
    
    public void setAnaLaboratorio(AnaLaboratorio anaLaboratorio) {
        this.anaLaboratorio = anaLaboratorio;
    }
    public Long getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
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
    public Date getFechaAnalisis() {
        return this.fechaAnalisis;
    }
    
    public void setFechaAnalisis(Date fechaAnalisis) {
        this.fechaAnalisis = fechaAnalisis;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getMobileId() {
        return this.mobileId;
    }
    
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }
    public Long getUsuarioDigitacion() {
        return this.usuarioDigitacion;
    }
    
    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }
    public String getObservacionAnularReg() {
        return this.observacionAnularReg;
    }
    
    public void setObservacionAnularReg(String observacionAnularReg) {
        this.observacionAnularReg = observacionAnularReg;
    }
    public Set<DatAnaLaboratorioDet> getDatAnaLaboratorioDets() {
        return this.datAnaLaboratorioDets;
    }
    
    public void setDatAnaLaboratorioDets(Set<DatAnaLaboratorioDet> datAnaLaboratorioDets) {
        this.datAnaLaboratorioDets = datAnaLaboratorioDets;
    }




}


