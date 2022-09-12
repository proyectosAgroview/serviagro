package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.TablaAnalitica;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class TablaAnaliticaDetalleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TablaAnaliticaDetalleDTO.class);
    private Long tablaAnaliticaDetalleId;
    private Double valorVariableEntrada1;
    private Double valorVariableEntrada2;
    private Double valorVariableEntrada3;
    private Double valorVariableSalida1;
    private Double valorVariableSalida2;
    private TablaAnalitica tablaAnaliticaId_TablaAnalitica;

    public Long getTablaAnaliticaDetalleId() {
        return tablaAnaliticaDetalleId;
    }

    public void setTablaAnaliticaDetalleId(Long tablaAnaliticaDetalleId) {
        this.tablaAnaliticaDetalleId = tablaAnaliticaDetalleId;
    }

    public Double getValorVariableEntrada1() {
        return valorVariableEntrada1;
    }

    public void setValorVariableEntrada1(Double valorVariableEntrada1) {
        this.valorVariableEntrada1 = valorVariableEntrada1;
    }

    public Double getValorVariableEntrada2() {
        return valorVariableEntrada2;
    }

    public void setValorVariableEntrada2(Double valorVariableEntrada2) {
        this.valorVariableEntrada2 = valorVariableEntrada2;
    }

    public Double getValorVariableEntrada3() {
        return valorVariableEntrada3;
    }

    public void setValorVariableEntrada3(Double valorVariableEntrada3) {
        this.valorVariableEntrada3 = valorVariableEntrada3;
    }

    public Double getValorVariableSalida1() {
        return valorVariableSalida1;
    }

    public void setValorVariableSalida1(Double valorVariableSalida1) {
        this.valorVariableSalida1 = valorVariableSalida1;
    }

    public Double getValorVariableSalida2() {
        return valorVariableSalida2;
    }

    public void setValorVariableSalida2(Double valorVariableSalida2) {
        this.valorVariableSalida2 = valorVariableSalida2;
    }

    public TablaAnalitica getTablaAnaliticaId_TablaAnalitica() {
        return tablaAnaliticaId_TablaAnalitica;
    }

    public void setTablaAnaliticaId_TablaAnalitica(
        TablaAnalitica tablaAnaltica) {
        this.tablaAnaliticaId_TablaAnalitica = tablaAnaltica;
    }
}
