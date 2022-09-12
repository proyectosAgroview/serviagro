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
public class DatPlanAnualFabricaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatPlanAnualFabricaDTO.class);
    private Long anio;
    private Long compania;
    private Long consecutivo;
    private Long datPlanAnualFabricaId;
    private String estado;
    private Date fechaAnulacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Double horasArranque;
    private Double horasMttoNoProgEjec;
    private Double horasMttoNoProgEst;
    private Double horasMttoProgEjec;
    private Double horasMttoProgEst;
    private Double horasPlantaEjec;
    private Double horasPlantaEst;
    private Double horasProcesoEjec;
    private Double horasProcesoEst;
    private String observacion;
    private String observacionAnularReg;
    private String origenDatos;
    private Double produccionAbril;
    private Double produccionAgosto;
    private Double produccionDiciembre;
    private Double produccionEnero;
    private Double produccionEstAbril;
    private Double produccionEstAgosto;
    private Double produccionEstDiciembre;
    private Double produccionEstEnero;
    private Double produccionEstFebrero;
    private Double produccionEstJulio;
    private Double produccionEstJunio;
    private Double produccionEstMarzo;
    private Double produccionEstMayo;
    private Double produccionEstNoviembre;
    private Double produccionEstOctubre;
    private Double produccionEstSeptiembre;
    private Double produccionEstTotal;
    private Double produccionFebrero;
    private Double produccionJulio;
    private Double produccionJunio;
    private Double produccionMarzo;
    private Double produccionMayo;
    private Double produccionNoviembre;
    private Double produccionOctubre;
    private Double produccionSeptiembre;
    private Double produccionTotal;
    private Long usuarioDigitacion;
    private Double valorPromedioHrDia;
    private Double velocidadEstandar;

    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
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

    public Long getDatPlanAnualFabricaId() {
        return datPlanAnualFabricaId;
    }

    public void setDatPlanAnualFabricaId(Long datPlanAnualFabricaId) {
        this.datPlanAnualFabricaId = datPlanAnualFabricaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
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

    /**
	 * @return the horasArranque
	 */
	public Double getHorasArranque() {
		return horasArranque;
	}

	/**
	 * @param horasArranque the horasArranque to set
	 */
	public void setHorasArranque(Double horasArranque) {
		this.horasArranque = horasArranque;
	}

	public Double getHorasMttoNoProgEjec() {
        return horasMttoNoProgEjec;
    }

    public void setHorasMttoNoProgEjec(Double horasMttoNoProgEjec) {
        this.horasMttoNoProgEjec = horasMttoNoProgEjec;
    }

    public Double getHorasMttoNoProgEst() {
        return horasMttoNoProgEst;
    }

    public void setHorasMttoNoProgEst(Double horasMttoNoProgEst) {
        this.horasMttoNoProgEst = horasMttoNoProgEst;
    }

    public Double getHorasMttoProgEjec() {
        return horasMttoProgEjec;
    }

    public void setHorasMttoProgEjec(Double horasMttoProgEjec) {
        this.horasMttoProgEjec = horasMttoProgEjec;
    }

    public Double getHorasMttoProgEst() {
        return horasMttoProgEst;
    }

    public void setHorasMttoProgEst(Double horasMttoProgEst) {
        this.horasMttoProgEst = horasMttoProgEst;
    }

    public Double getHorasPlantaEjec() {
        return horasPlantaEjec;
    }

    public void setHorasPlantaEjec(Double horasPlantaEjec) {
        this.horasPlantaEjec = horasPlantaEjec;
    }

    public Double getHorasPlantaEst() {
        return horasPlantaEst;
    }

    public void setHorasPlantaEst(Double horasPlantaEst) {
        this.horasPlantaEst = horasPlantaEst;
    }

    public Double getHorasProcesoEjec() {
        return horasProcesoEjec;
    }

    public void setHorasProcesoEjec(Double horasProcesoEjec) {
        this.horasProcesoEjec = horasProcesoEjec;
    }

    public Double getHorasProcesoEst() {
        return horasProcesoEst;
    }

    public void setHorasProcesoEst(Double horasProcesoEst) {
        this.horasProcesoEst = horasProcesoEst;
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

    public String getOrigenDatos() {
        return origenDatos;
    }

    public void setOrigenDatos(String origenDatos) {
        this.origenDatos = origenDatos;
    }

    public Double getProduccionAbril() {
        return produccionAbril;
    }

    public void setProduccionAbril(Double produccionAbril) {
        this.produccionAbril = produccionAbril;
    }

    public Double getProduccionAgosto() {
        return produccionAgosto;
    }

    public void setProduccionAgosto(Double produccionAgosto) {
        this.produccionAgosto = produccionAgosto;
    }

    public Double getProduccionDiciembre() {
        return produccionDiciembre;
    }

    public void setProduccionDiciembre(Double produccionDiciembre) {
        this.produccionDiciembre = produccionDiciembre;
    }

    public Double getProduccionEnero() {
        return produccionEnero;
    }

    public void setProduccionEnero(Double produccionEnero) {
        this.produccionEnero = produccionEnero;
    }

    public Double getProduccionEstAbril() {
        return produccionEstAbril;
    }

    public void setProduccionEstAbril(Double produccionEstAbril) {
        this.produccionEstAbril = produccionEstAbril;
    }

    public Double getProduccionEstAgosto() {
        return produccionEstAgosto;
    }

    public void setProduccionEstAgosto(Double produccionEstAgosto) {
        this.produccionEstAgosto = produccionEstAgosto;
    }

    public Double getProduccionEstDiciembre() {
        return produccionEstDiciembre;
    }

    public void setProduccionEstDiciembre(Double produccionEstDiciembre) {
        this.produccionEstDiciembre = produccionEstDiciembre;
    }

    public Double getProduccionEstEnero() {
        return produccionEstEnero;
    }

    public void setProduccionEstEnero(Double produccionEstEnero) {
        this.produccionEstEnero = produccionEstEnero;
    }

    public Double getProduccionEstFebrero() {
        return produccionEstFebrero;
    }

    public void setProduccionEstFebrero(Double produccionEstFebrero) {
        this.produccionEstFebrero = produccionEstFebrero;
    }

    public Double getProduccionEstJulio() {
        return produccionEstJulio;
    }

    public void setProduccionEstJulio(Double produccionEstJulio) {
        this.produccionEstJulio = produccionEstJulio;
    }

    public Double getProduccionEstJunio() {
        return produccionEstJunio;
    }

    public void setProduccionEstJunio(Double produccionEstJunio) {
        this.produccionEstJunio = produccionEstJunio;
    }

    public Double getProduccionEstMarzo() {
        return produccionEstMarzo;
    }

    public void setProduccionEstMarzo(Double produccionEstMarzo) {
        this.produccionEstMarzo = produccionEstMarzo;
    }

    public Double getProduccionEstMayo() {
        return produccionEstMayo;
    }

    public void setProduccionEstMayo(Double produccionEstMayo) {
        this.produccionEstMayo = produccionEstMayo;
    }

    public Double getProduccionEstNoviembre() {
        return produccionEstNoviembre;
    }

    public void setProduccionEstNoviembre(Double produccionEstNoviembre) {
        this.produccionEstNoviembre = produccionEstNoviembre;
    }

    public Double getProduccionEstOctubre() {
        return produccionEstOctubre;
    }

    public void setProduccionEstOctubre(Double produccionEstOctubre) {
        this.produccionEstOctubre = produccionEstOctubre;
    }

    public Double getProduccionEstSeptiembre() {
        return produccionEstSeptiembre;
    }

    public void setProduccionEstSeptiembre(Double produccionEstSeptiembre) {
        this.produccionEstSeptiembre = produccionEstSeptiembre;
    }

    public Double getProduccionEstTotal() {
        return produccionEstTotal;
    }

    public void setProduccionEstTotal(Double produccionEstTotal) {
        this.produccionEstTotal = produccionEstTotal;
    }

    public Double getProduccionFebrero() {
        return produccionFebrero;
    }

    public void setProduccionFebrero(Double produccionFebrero) {
        this.produccionFebrero = produccionFebrero;
    }

    public Double getProduccionJulio() {
        return produccionJulio;
    }

    public void setProduccionJulio(Double produccionJulio) {
        this.produccionJulio = produccionJulio;
    }

    public Double getProduccionJunio() {
        return produccionJunio;
    }

    public void setProduccionJunio(Double produccionJunio) {
        this.produccionJunio = produccionJunio;
    }

    public Double getProduccionMarzo() {
        return produccionMarzo;
    }

    public void setProduccionMarzo(Double produccionMarzo) {
        this.produccionMarzo = produccionMarzo;
    }

    public Double getProduccionMayo() {
        return produccionMayo;
    }

    public void setProduccionMayo(Double produccionMayo) {
        this.produccionMayo = produccionMayo;
    }

    public Double getProduccionNoviembre() {
        return produccionNoviembre;
    }

    public void setProduccionNoviembre(Double produccionNoviembre) {
        this.produccionNoviembre = produccionNoviembre;
    }

    public Double getProduccionOctubre() {
        return produccionOctubre;
    }

    public void setProduccionOctubre(Double produccionOctubre) {
        this.produccionOctubre = produccionOctubre;
    }

    public Double getProduccionSeptiembre() {
        return produccionSeptiembre;
    }

    public void setProduccionSeptiembre(Double produccionSeptiembre) {
        this.produccionSeptiembre = produccionSeptiembre;
    }

    public Double getProduccionTotal() {
        return produccionTotal;
    }

    public void setProduccionTotal(Double produccionTotal) {
        this.produccionTotal = produccionTotal;
    }

    public Long getUsuarioDigitacion() {
        return usuarioDigitacion;
    }

    public void setUsuarioDigitacion(Long usuarioDigitacion) {
        this.usuarioDigitacion = usuarioDigitacion;
    }

    public Double getValorPromedioHrDia() {
        return valorPromedioHrDia;
    }

    public void setValorPromedioHrDia(Double valorPromedioHrDia) {
        this.valorPromedioHrDia = valorPromedioHrDia;
    }

    public Double getVelocidadEstandar() {
        return velocidadEstandar;
    }

    public void setVelocidadEstandar(Double velocidadEstandar) {
        this.velocidadEstandar = velocidadEstandar;
    }
}
