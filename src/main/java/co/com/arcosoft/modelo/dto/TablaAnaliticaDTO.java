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
public class TablaAnaliticaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TablaAnaliticaDTO.class);
    private String codigo;
    private Long compania;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String infoAdicional;
    private String infoAdicional2;
    private String nombre;
    private Long tablaAnaliticaId;
    private Long usuario;
    private String variableEntrada1;
    private String variableEntrada2;
    private String variableEntrada3;
    private String variableSalida1;
    private String variableSalida2;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getCompania() {
        return compania;
    }

    public void setCompania(Long compania) {
        this.compania = compania;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTablaAnaliticaId() {
        return tablaAnaliticaId;
    }

    public void setTablaAnaliticaId(Long tablaAnaliticaId) {
        this.tablaAnaliticaId = tablaAnaliticaId;
    }

    public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public String getVariableEntrada1() {
        return variableEntrada1;
    }

    public void setVariableEntrada1(String variableEntrada1) {
        this.variableEntrada1 = variableEntrada1;
    }

    public String getVariableEntrada2() {
        return variableEntrada2;
    }

    public void setVariableEntrada2(String variableEntrada2) {
        this.variableEntrada2 = variableEntrada2;
    }

    public String getVariableEntrada3() {
        return variableEntrada3;
    }

    public void setVariableEntrada3(String variableEntrada3) {
        this.variableEntrada3 = variableEntrada3;
    }

    public String getVariableSalida1() {
        return variableSalida1;
    }

    public void setVariableSalida1(String variableSalida1) {
        this.variableSalida1 = variableSalida1;
    }

    public String getVariableSalida2() {
        return variableSalida2;
    }

    public void setVariableSalida2(String variableSalida2) {
        this.variableSalida2 = variableSalida2;
    }
}
