package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.Nivel4;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class DatDiferidosAgricolaDetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosAgricolaDetDTO.class);
    private Long datDiferidosAgricolaDetId;
    private Double valorFactura;
    private Long datDiferidosAgricolaId_DatDiferidosAgricola;
    private Long nivel2Id_Nivel2;
    private Nivel4 nivel4Id_Nivel4;
    private String codigoNivel4;
	private Long etapaId;
	private Long variedadId;
	private Double areaNeta;

    public Long getDatDiferidosAgricolaDetId() {
        return datDiferidosAgricolaDetId;
    }

    public void setDatDiferidosAgricolaDetId(Long datDiferidosAgricolaDetId) {
        this.datDiferidosAgricolaDetId = datDiferidosAgricolaDetId;
    }

    public Double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(Double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public Long getDatDiferidosAgricolaId_DatDiferidosAgricola() {
        return datDiferidosAgricolaId_DatDiferidosAgricola;
    }

    public void setDatDiferidosAgricolaId_DatDiferidosAgricola(
        Long datDiferidosAgricolaId_DatDiferidosAgricola) {
        this.datDiferidosAgricolaId_DatDiferidosAgricola = datDiferidosAgricolaId_DatDiferidosAgricola;
    }

    public Long getNivel2Id_Nivel2() {
        return nivel2Id_Nivel2;
    }

    public void setNivel2Id_Nivel2(Long nivel2Id_Nivel2) {
        this.nivel2Id_Nivel2 = nivel2Id_Nivel2;
    }

    public Nivel4 getNivel4Id_Nivel4() {
        return nivel4Id_Nivel4;
    }

    public void setNivel4Id_Nivel4(Nivel4 nivel4Id_Nivel4) {
        this.nivel4Id_Nivel4 = nivel4Id_Nivel4;
    }

	public String getCodigoNivel4() {
		return codigoNivel4;
	}

	public void setCodigoNivel4(String codigoNivel4) {
		this.codigoNivel4 = codigoNivel4;
	}

	public Long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(Long etapaId) {
		this.etapaId = etapaId;
	}

	public Long getVariedadId() {
		return variedadId;
	}

	public void setVariedadId(Long variedadId) {
		this.variedadId = variedadId;
	}

	public Double getAreaNeta() {
		return areaNeta;
	}

	public void setAreaNeta(Double areaNeta) {
		this.areaNeta = areaNeta;
	}
}
