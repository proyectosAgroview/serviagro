package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class LogBasculaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LogBasculaDTO.class);
    private Long compania;
    private Date fecha;
    private Long logBasculaId;
    private String observacion;
    private Long tiquete;
    private Long usuarioModificacion;
    private String codUsuario;
    
    

    /**
	 * @return the codUsuario
	 */
	public String getCodUsuario() {
		return codUsuario;
	}

	/**
	 * @param codUsuario the codUsuario to set
	 */
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getLogBasculaId() {
        return logBasculaId;
    }

    public void setLogBasculaId(Long logBasculaId) {
        this.logBasculaId = logBasculaId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getTiquete() {
        return tiquete;
    }

    public void setTiquete(Long tiquete) {
        this.tiquete = tiquete;
    }

    public Long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Long usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
