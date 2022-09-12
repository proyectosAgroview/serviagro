package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class EquipoImplementoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EquipoImplementoDTO.class);
    private Long equipoImplementoId;
    private Long implementoId;
    private Long equipoId_Equipo;

    public Long getEquipoImplementoId() {
        return equipoImplementoId;
    }

    public void setEquipoImplementoId(Long equipoImplementoId) {
        this.equipoImplementoId = equipoImplementoId;
    }

    public Long getImplementoId() {
        return implementoId;
    }

    public void setImplementoId(Long implementoId) {
        this.implementoId = implementoId;
    }

    public Long getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Long equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }
}
