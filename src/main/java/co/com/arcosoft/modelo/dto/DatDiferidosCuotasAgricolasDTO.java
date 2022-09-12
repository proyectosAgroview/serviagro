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
public class DatDiferidosCuotasAgricolasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosCuotasAgricolasDTO.class);
    private Long anio;
    private Long datDiferidosCuotasAgricolasId;
    private Date fecha;
    private Long mes;
    private Double valorCuota;
    private Long datDiferidosAgricolaId_DatDiferidosAgricola;

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }

    public Long getDatDiferidosCuotasAgricolasId() {
        return datDiferidosCuotasAgricolasId;
    }

    public void setDatDiferidosCuotasAgricolasId(
        Long datDiferidosCuotasAgricolasId) {
        this.datDiferidosCuotasAgricolasId = datDiferidosCuotasAgricolasId;
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

    public Long getDatDiferidosAgricolaId_DatDiferidosAgricola() {
        return datDiferidosAgricolaId_DatDiferidosAgricola;
    }

    public void setDatDiferidosAgricolaId_DatDiferidosAgricola(
        Long datDiferidosAgricolaId_DatDiferidosAgricola) {
        this.datDiferidosAgricolaId_DatDiferidosAgricola = datDiferidosAgricolaId_DatDiferidosAgricola;
    }
}
