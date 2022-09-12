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
public class DatDiferidosCuotasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosCuotasDTO.class);
    private Long anio;
    private Long datDiferidosCuotasId;
    private Date fecha;
    private Long mes;
    private Double valorCuota;
    private Long datDiferidosId_DatDiferidos;

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public Long getDatDiferidosCuotasId() {
        return datDiferidosCuotasId;
    }

    public void setDatDiferidosCuotasId(Long datDiferidosCuotasId) {
        this.datDiferidosCuotasId = datDiferidosCuotasId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    public Double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(Double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public Long getDatDiferidosId_DatDiferidos() {
        return datDiferidosId_DatDiferidos;
    }

    public void setDatDiferidosId_DatDiferidos(Long datDiferidosId_DatDiferidos) {
        this.datDiferidosId_DatDiferidos = datDiferidosId_DatDiferidos;
    }
}
