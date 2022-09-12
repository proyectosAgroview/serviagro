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
public class LaborAdicionalMoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LaborAdicionalMoDTO.class);
    private Long laborAdicionalMoId;
    private Long laborId;
    private Long udadMedId;
    private Date fechaInicial;
    private Date fechaFinal;
    private Double cantidadAdicionalMo;
    private Double tarifaAdicionalMo;
    private Long laborId_Labor;
    private Long udadMedId_UdadMed;

    public Long getLaborAdicionalMoId() {
        return laborAdicionalMoId;
    }

    public void setLaborAdicionalMoId(Long laborAdicionalMoId) {
        this.laborAdicionalMoId = laborAdicionalMoId;
    }

    public Long getLaborId() {
        return laborId;
    }

    public void setLaborId(Long laborId) {
        this.laborId = laborId;
    }

    public Long getUdadMedId() {
        return udadMedId;
    }

    public void setUdadMedId(Long udadMedId) {
        this.udadMedId = udadMedId;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Double getCantidadAdicionalMo() {
        return cantidadAdicionalMo;
    }

    public void setCantidadAdicionalMo(Double cantidadAdicionalMo) {
        this.cantidadAdicionalMo = cantidadAdicionalMo;
    }

    public Double getTarifaAdicionalMo() {
        return tarifaAdicionalMo;
    }

    public void setTarifaAdicionalMo(Double tarifaAdicionalMo) {
        this.tarifaAdicionalMo = tarifaAdicionalMo;
    }

    public Long getLaborId_Labor() {
        return laborId_Labor;
    }

    public void setLaborId_Labor(Long laborId_Labor) {
        this.laborId_Labor = laborId_Labor;
    }

    public Long getUdadMedId_UdadMed() {
        return udadMedId_UdadMed;
    }

    public void setUdadMedId_UdadMed(Long udadMedId_UdadMed) {
        this.udadMedId_UdadMed = udadMedId_UdadMed;
    }
}
